package dates;

import java.io.*;
import java.net.*;
import java.sql.*;


public class Server {
	public static void main(String args[]) {
		try {
		    String url="jdbc:mysql://localhost/Time_db";
		    String user="root";
		    String pwd="89npc650a";
		    
		    //加载驱动，这一句也可写为：Class.forName("com.mysql.jdbc.Driver");
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    //建立到MySQL的连接
		    Connection conn = DriverManager.getConnection(url,user, pwd);
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
				while(true){
					socket = server.accept();
					MyThread newthread = new MyThread(socket,conn);
					newthread.start();
				}
			} catch (Exception e) {
				System.out.println("Error." + e);
			}
			System.out.println("aaaaaa");
			socket.close(); // 关闭Socket
			server.close(); // 关闭ServerSocket
		} catch (Exception e) {
			// 出错，打印出错信息
			System.out.println("Error:" + e);
		}
	}
}