package dates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class MyThread extends Thread
{
	private static Socket socket;
			 Connection conn;
	MyThread(Socket tems,Connection temc){
		socket = tems;
		conn = temc;
 	}
	public void run()
	{
		try {
			// 由Socket对象得到输出流，并构造PrintWriter对象
			PrintWriter os;
			os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			while(true){
				String rev = is.readLine();
				System.out.println(rev);
				if(rev.equals("1")){
					User.log(socket,conn,is);				
				}
				else if(rev.equals("2")){
					User.show(socket, conn,is);
				}
				else if(rev.equals("3")){
					User.namejudge(socket, conn,is);
				}
				else if(rev.equals("4")){
					User.regist(socket, conn,is);
				}
				else if(rev.equals("a1")){
					Time.t_find(socket, conn,is);
				}
				else if(rev.equals("a2")){
					Time.s_find(socket, conn,is);
				}
				else if(rev.equals("b1")){
					Time.t_select(socket,conn,is);
				}
				else if(rev.equals("b2")){
					Time.s_select(socket,conn,is);
				}
				else if(rev.equals("b3")){
					Time.w_select(socket,conn,is);
				}
				else if(rev.equals("b4")){
					Time.l_select(socket,conn,is);
				}
				else if(rev.equals("c")){
					User.delete(socket,conn,is);
				}
				else if(rev.equals("d")){
					os.println("注销成功");
					os.flush();
				}
				else break;
			}
			is.close();
			os.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
