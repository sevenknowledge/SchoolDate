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
		    
		    //������������һ��Ҳ��дΪ��Class.forName("com.mysql.jdbc.Driver");
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    //������MySQL������
		    Connection conn = DriverManager.getConnection(url,user, pwd);
			ServerSocket server = null;
			try {
				server = new ServerSocket(4700);
			} catch (Exception e) {
				// ������ӡ������Ϣ
				System.out.println("can not listen to:" + e);
			}
			Socket socket = null;
			try {
				// ʹ��accept()�����ȴ��ͻ������пͻ� �����������һ��Socket���󣬲�����ִ��
				while(true){
					socket = server.accept();
					MyThread newthread = new MyThread(socket,conn);
					newthread.start();
				}
			} catch (Exception e) {
				System.out.println("Error." + e);
			}
			System.out.println("aaaaaa");
			socket.close(); // �ر�Socket
			server.close(); // �ر�ServerSocket
		} catch (Exception e) {
			// ������ӡ������Ϣ
			System.out.println("Error:" + e);
		}
	}
}