
public class Main {
	public static void main(String args[]) {
		try {
			Global_function gf = new Global_function();
			 
			String branch_code = gf.getCabangSetting();
			//System.err.println(branch_code); 
			
			int qos_message_command = 0;
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
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
