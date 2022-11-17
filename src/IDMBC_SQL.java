import java.util.Date;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class IDMBC_SQL {
	MqttClient client_transreport;
	Global_function gf = new Global_function(true);	
	int counter = 1;
	String kode_cabang;
	public IDMBC_SQL(String kode_cabang) {
		this.kode_cabang = kode_cabang;
	}

	String Parser_TASK, Parser_ID, Parser_SOURCE, Parser_COMMAND, Parser_OTP, Parser_TANGGAL_JAM, Parser_VERSI,
			Parser_HASIL, Parser_FROM, Parser_TO, Parser_SN_HDD, Parser_IP_ADDRESS, Parser_STATION, Parser_CABANG,
			Parser_NAMA_FILE, Parser_CHAT_MESSAGE, Parser_REMOTE_PATH, Parser_LOCAL_PATH, Parser_SUB_ID;

	public void UnpackJSON(String json_message) {

		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(json_message);
		} catch (org.json.simple.parser.ParseException ex) {
			System.out.println("message json : " + json_message);
			System.out.println("message error : " + ex.getMessage());
			// ex.printStackTrace();
			// Logger.getLogger(IDMReport.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			Parser_TASK = obj.get("TASK").toString();
		} catch (Exception ex) {
			Parser_TASK = "";
		}
		try {
			Parser_ID = obj.get("ID").toString();
		} catch (Exception exc) {
			Parser_ID = "";
		}
		try {
			Parser_SOURCE = obj.get("SOURCE").toString();
		} catch (Exception exc) {
			Parser_SOURCE = "";
		}
		try {
			Parser_COMMAND = obj.get("COMMAND").toString();
		} catch (Exception exc) {
			Parser_COMMAND = "";
		}
		try {
			Parser_OTP = obj.get("OTP").toString();
		} catch (Exception exc) {
			Parser_OTP = "";
		}

		try {
			Parser_TANGGAL_JAM = obj.get("TANGGAL_JAM").toString();
		} catch (Exception exc) {
			Parser_TANGGAL_JAM = "";
		}
		try {
			Parser_VERSI = obj.get("RESULT").toString().split("_")[7];
		} catch (Exception exc) {
			try {
				Parser_VERSI = obj.get("VERSI").toString();
			} catch (Exception exc1) {
				Parser_VERSI = "";
			}

		}

		try {
			Parser_HASIL = obj.get("HASIL").toString();
			Parser_FROM = obj.get("FROM").toString();
			Parser_TO = obj.get("TO").toString();

		} catch (Exception exc) {
			Parser_HASIL = "";
			Parser_FROM = "";
			Parser_TO = "";
		}

		try {
			Parser_SN_HDD = obj.get("SN_HDD").toString();
		} catch (Exception exc) {
			try {
				Parser_SN_HDD = obj.get("SN_HDD").toString();
			} catch (Exception exc1) {
				Parser_SN_HDD = "";
			}

		}
		try {
			Parser_IP_ADDRESS = obj.get("IP_ADDRESS").toString();
		} catch (Exception exc) {
			try {
				Parser_IP_ADDRESS = obj.get("IP_ADDRESS").toString();
			} catch (Exception exc1) {
				Parser_IP_ADDRESS = "";
			}

		}

		try {
			Parser_STATION = obj.get("STATION").toString();
		} catch (Exception exc) {
			try {
				Parser_STATION = obj.get("STATION").toString();
			} catch (Exception exc1) {
				Parser_STATION = "";
			}

		}

		try {
			Parser_CABANG = obj.get("CABANG").toString();
		} catch (Exception exc) {
			try {
				Parser_CABANG = obj.get("CABANG").toString();
			} catch (Exception exc1) {
				Parser_CABANG = "";
			}
		}

		try {
			Parser_NAMA_FILE = obj.get("NAMA_FILE").toString();
		} catch (Exception exc) {
			Parser_NAMA_FILE = "";
		}
		try {
			Parser_CHAT_MESSAGE = obj.get("CHAT_MESSAGE").toString();
		} catch (Exception exc) {
			Parser_CHAT_MESSAGE = "";
		}
		try {
			Parser_REMOTE_PATH = obj.get("REMOTE_PATH").toString();
		} catch (Exception exc) {
			Parser_REMOTE_PATH = "";
		}
		try {
			Parser_LOCAL_PATH = obj.get("LOCAL_PATH").toString();
		} catch (Exception exc) {
			Parser_LOCAL_PATH = "";
		}
		try {
			Parser_SUB_ID = obj.get("SUB_ID").toString();
		} catch (Exception exc) {
			Parser_SUB_ID = "";
		}

	}
	
	public void BC_SQL(int qos_message_command,String kode_cabang,boolean res_show_insert,String res_topic) {
		try {
			client_transreport = gf.get_ConnectionMQtt();
			// ---------------------------- COMMAND -----------------------//
			String rtopic_command = res_topic;
			 
			System.out.println("SUBS : "+rtopic_command);
			Date HariSekarang_run = new Date();
			client_transreport.subscribe(rtopic_command, qos_message_command, new IMqttMessageListener() {
				@Override
				public void messageArrived(final String topic, final MqttMessage message) throws Exception {
					// ----------------------------- FILTER TOPIC NOT CONTAINS
					// -------------------------------//
						String payload = new String(message.getPayload());
	
						String msg_type = "";
						String message_ADT_Decompress = "";
						try {
							message_ADT_Decompress = gf.ADTDecompress(message.getPayload());
							msg_type = "json";
						} catch (Exception exc) {
							message_ADT_Decompress = payload;
							msg_type = "non json";
						}
	
						counter++;
						UnpackJSON(message_ADT_Decompress);
						//System.out.println(message_ADT_Decompress);
						
						//System.out.println("Parser_TO : "+Parser_TO);
						//System.out.println("Parser_SOURCE : "+Parser_SOURCE);
						boolean is_monitoring_Pos_Realtime = Parser_TO.contains("MonitoringPosRealtime");
						//System.out.println("is_monitoring_Pos_Realtime : "+is_monitoring_Pos_Realtime);
						
						System.out.println("===================================================");
						if(Parser_SOURCE.equals("IDMCommandListeners") && is_monitoring_Pos_Realtime == false  ){
							gf.PrintMessage2("RECV > BC_SQL/"+kode_cabang+"/", counter, msg_type, topic, Parser_TASK, Parser_FROM,
									Parser_TO, null, HariSekarang_run);
							gf.InsTransReport(Parser_TASK, Parser_ID, Parser_SOURCE, Parser_COMMAND, Parser_OTP,
									Parser_TANGGAL_JAM, Parser_VERSI, Parser_HASIL, Parser_TO, Parser_FROM, Parser_SN_HDD,
									Parser_IP_ADDRESS, Parser_STATION, Parser_CABANG, Parser_NAMA_FILE, Parser_CHAT_MESSAGE,
									Parser_REMOTE_PATH, Parser_LOCAL_PATH, Parser_SUB_ID, res_show_insert, "INSERT", "transreport");
							String tanggal_jam = gf.get_tanggal_curdate_curtime();
							gf.WriteFile("timemessage.txt", "", tanggal_jam, false);
							//System.out.println("=============================================================");
						}else if(Parser_SOURCE.equals("IDMCommandListeners") && is_monitoring_Pos_Realtime == true) {
							
							gf.PrintMessage2("RECV > BC_MONITORING_POSREALTIME/"+kode_cabang+"/", counter, msg_type, topic, Parser_TASK, Parser_FROM,
									Parser_TO, null, HariSekarang_run);
							gf.InsTransReport(Parser_TASK, Parser_ID, Parser_SOURCE, Parser_COMMAND, Parser_OTP,
									Parser_TANGGAL_JAM, Parser_VERSI, Parser_HASIL, Parser_TO, Parser_FROM, Parser_SN_HDD,
									Parser_IP_ADDRESS, Parser_STATION, Parser_CABANG, Parser_NAMA_FILE, Parser_CHAT_MESSAGE,
									Parser_REMOTE_PATH, Parser_LOCAL_PATH, Parser_SUB_ID, res_show_insert, "REPLACE", "transaksi_posrealtime_nok");
							String tanggal_jam = gf.get_tanggal_curdate_curtime();
							gf.WriteFile("timemessage.txt", "", tanggal_jam, false);
						}else{
							gf.PrintMessage2("SEND > BC_SQL/"+kode_cabang+"/", counter, msg_type, topic, Parser_TASK, Parser_FROM,
									Parser_TO, null, HariSekarang_run);
//							gf.InsTransReport(Parser_TASK, Parser_ID, Parser_SOURCE, Parser_COMMAND, Parser_OTP,
//									Parser_TANGGAL_JAM, Parser_VERSI, Parser_HASIL, Parser_TO, Parser_FROM, Parser_SN_HDD,
//									Parser_IP_ADDRESS, Parser_STATION, Parser_CABANG, Parser_NAMA_FILE, Parser_CHAT_MESSAGE,
//									Parser_REMOTE_PATH, Parser_LOCAL_PATH, Parser_SUB_ID, res_show_insert, "INSERT", "transreport");
							//System.out.println("=============================================================");
						}
						
						//System.gc();
			            //System.runFinalization();
						
					}
				
				});
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

	public void Run() {
		System.out.println("=================================          START         ==================================");
		try {
			int qos_message_command = 0;
			String show_insert =  gf.getTampilkan_query_consoleSetting();
			boolean res_show_insert = Boolean.parseBoolean(show_insert);
			String res_topic = "BC_SQL/"+kode_cabang+"/#";
			BC_SQL(qos_message_command,kode_cabang,res_show_insert,res_topic);
			/*
			String cabang[] = gf.getCabang().split(",");
			String topic[] = gf.getTopic().split(",");
			for(int i = 0;i<cabang.length;i++) {
				String res_topic = topic[i];
				BC_SQL(qos_message_command,cabang[i],res_show_insert,res_topic);
			}
			*/
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
}
