package talks;

import java.io.*;
import java.net.*;


public class TalkServer {
	public static void main(String args[]) {
		try {
			ServerSocket server = null;
			try {
				server = new ServerSocket(4700);
			} catch (Exception e) {
				// 出错，打印出错信息
				System.out.println("can not listen to:" + e);
			}
			Socket socket = null;
			try {
				// 使用accept()阻塞等待客户请求，有客户 请求到来则产生一个Socket对象，并继续执行
				socket = server.accept();
			} catch (Exception e) {
				System.out.println("Error." + e);
			}
			// 由Socket对象得到输入流，并构造相应的BufferedReader对象
			BufferedReader is = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// 由Socket对象得到输出流，并构造PrintWriter对象
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			while (true) {
				String rev = is.readLine();
				if(rev.equals("1")){
					boolean res = User.regist();
					if(res == true){
						os.println("创建成功");
						os.flush();
					}
				}
				if(rev.equals("2")){
					boolean res = User.log();
					if(res == true){
						os.println("登陆成功");
						os.flush();
					}
				}
				if(rev.equals("a")){
					boolean res = Time.update();
					if(res == true){
						os.println("更新成功");
						os.flush();
					}
				}
				if(rev.equals("b")){
					boolean res = Time.select();
					if(res == true){
						os.println("查询成功");
						os.flush();
					}
				}
				if(rev.equals("c")){
					boolean res = Time.delete();
					if(res == true){
						os.println("删除成功");
						os.flush();
					}
				}
				if(rev.equals("d")){
					os.println("注销成功");
					os.flush();
				}
				if(rev.equals("bye")){
					boolean res = User.log();
					if(res == true){
						os.println("退出成功");
						os.flush();
					}
					break;
				}
			} 
			os.close(); // 关闭Socket输出流
			is.close(); // 关闭Socket输入流
			socket.close(); // 关闭Socket
			server.close(); // 关闭ServerSocket
		} catch (Exception e) {
			// 出错，打印出错信息
			System.out.println("Error:" + e);
		}
	}
}