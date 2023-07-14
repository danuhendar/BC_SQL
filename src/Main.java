import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Connection.SQLConnection;
import Controller.Global_function;
import Dao.Implement_ga;
import Dao.Interface_ga;
import Entity.Entity;
import Scheduler.CheckThread;
import Scheduler.ThreadMain;

public class Main {
	
	Entity en = new Entity();
	public void Read_Setting_ini() {
       	try {
   		    JSONParser parser = new JSONParser();
   	        JSONObject obj = null;
   	        FileReader fr = new FileReader("setting.ini");
   	        BufferedReader br = new BufferedReader(fr);
   	        String line = br.readLine();
   	        System.out.println("setting ini : "+line);
   	        try {
   	            obj = (JSONObject) parser.parse(line);
   	        } catch (org.json.simple.parser.ParseException ex) {
   	            ex.printStackTrace();
   	        }
   	        
   	        
   	        en.setIp_broker_primary(obj.get("ip_broker_primary").toString());
   	        en.setPort_broker_primary(obj.get("port_broker_primary").toString());
   	        en.setUsername_broker_primary(obj.get("username_broker_primary").toString());
   	        en.setPassword_broker_primary(obj.get("password_broker_primary").toString());
   	        en.setCleansession_primary(obj.get("cleansession_primary").toString());
   	        en.setKeepalive_primary(obj.get("keepalive_primary").toString());
   	        en.setReconnect_primary(obj.get("reconnect_primary").toString());
   	        en.setWill_retained_primary(obj.get("will_retained_primary").toString());
   	        en.setMax_inflight_primary(obj.get("max_inflight_primary").toString());
   	        
   	        en.setIp_broker_secondary(obj.get("ip_broker_secondary").toString());
	        en.setPort_broker_secondary(obj.get("port_broker_secondary").toString());
	        en.setUsername_broker_secondary(obj.get("username_broker_secondary").toString());
	        en.setPassword_broker_secondary(obj.get("password_broker_secondary").toString());
	        en.setCleansession_secondary(obj.get("cleansession_secondary").toString());
	        en.setKeepalive_secondary(obj.get("keepalive_secondary").toString());
	        en.setReconnect_secondary(obj.get("reconnect_secondary").toString());
	        en.setWill_retained_secondary(obj.get("will_retained_secondary").toString());
	        en.setMax_inflight_secondary(obj.get("max_inflight_secondary").toString());
   	        
   	        
   	        
   	        en.setIs_mongo_db(obj.get("is_mongo_db").toString());
   	        en.setIp_mongodb(obj.get("ip_mongodb").toString());
   	        en.setPort_mongodb(obj.get("port_mongodb").toString());
   	        
   	        en.setIp_database(obj.get("ip_database").toString());
   	        en.setUser_database(obj.get("user_database").toString());
   	        en.setPass_database(obj.get("pass_database").toString());
   	        en.setPort_database(obj.get("port_database").toString());
   	        en.setNama_database(obj.get("nama_database").toString());
   	        en.setId_reporter(obj.get("id_reporter").toString());
   	        en.setCabang(obj.get("cabang").toString());
   	        en.setTopic(obj.get("topic").toString());
   	        en.setTampilkan_query_console(obj.get("tampilkan_query_console").toString());
   	        en.setBatas_menit(obj.get("batas_menit").toString());
   	        en.setTulis_log(obj.get("tulis_log").toString());
   	        System.out.println("Load Setting Sukses");
   	        br.close();
       	}catch(Exception exc) {
       		exc.printStackTrace();
       	}
    }
	
	
	public static void main(String args[]) {
		try {
			Main m = new Main();
			m.Read_Setting_ini();
			SQLConnection sqlcon = new SQLConnection();
			//System.out.println("IP DATABASE : "+Entity.getIp_database());
			Connection con = sqlcon.get_connection_db(Entity.getIp_database(),Entity.getUser_database(),Entity.getPass_database(),Entity.getPort_database(),Entity.getNama_database());
            Interface_ga inter_login  = new Implement_ga(con);
            Entity.setInter_login(inter_login);
            //System.out.println("Status Koneksi DB : "+con.isClosed());
            Global_function gf = new Global_function(false);
          
            
			String tanggal_jam = gf.get_tanggal_curdate_curtime();
			gf.WriteFile("timemessage.txt", "", tanggal_jam, false);
			
			
			
			MqttClient client = gf.get_ConnectionMQtt(1);
			Entity.setClient(client); 
			String branch_code = Entity.getCabang();
			
			if(branch_code.contains(",")) {
				/*
				String sp_branch[] = branch_code.split(",");
				for(int i =0;i<sp_branch.length;i++) {
					String res_branch_code = sp_branch[i];
				
				}
				*/
				ThreadMain t1 = new ThreadMain("");
				t1.start();
			}else{
				ThreadMain t1 = new ThreadMain(branch_code);
				t1.start();
				
				
			}
			
			CheckThread t2 = new CheckThread();
			t2.start();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
