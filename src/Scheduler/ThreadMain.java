package Scheduler;
import Controller.IDMBC_SQL;

public class ThreadMain extends Thread {
	IDMBC_SQL idm;
     
    public ThreadMain(String kode_cabang){
    	idm = new IDMBC_SQL(kode_cabang);
    }
    
    public void run(){
        for(int l = 0;l<1;l++){
           try{
        	   idm.Run();
           }catch(Exception exc){
               
           }
           
        }
    } 
}
