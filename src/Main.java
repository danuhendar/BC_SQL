
public class Main {
	public static void main(String args[]) {
		try {
			Global_function gf = new Global_function(false);
			 
			String branch_code = gf.getCabangSetting();
			//System.err.println(branch_code); 
			String tanggal_jam = gf.get_tanggal_curdate_curtime();
			gf.WriteFile("timemessage.txt", "", tanggal_jam, false);
			//System.err.println("topic : "+branch_code);
			if(branch_code.contains(",")) {
				String sp_branch[] = branch_code.split(",");
				for(int i =0;i<sp_branch.length;i++) {
					String res_branch_code = sp_branch[i];
					ThreadMain t1 = new ThreadMain(res_branch_code);
					t1.start();
				}
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
