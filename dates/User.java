package dates;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class User {

	public static void regist()
	{
		System.out.println("�û�ע��ģ��");
	}
	public static void log(Socket socket,Connection conn)
	{
		System.out.println("�û���½ģ��");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String rec;
			rec = is.readLine();
		    //ִ��SQL���
		    Statement stmt = conn.createStatement();//��������������ִ��sql����
		    ResultSet rs = stmt.executeQuery("select * from teacher_table where logname=" + rec);
		    if(rs.first()){
		    	os.println(rec);
				os.flush();
		    }
		    else{
		    	os.println("no" + rec);
		    	os.flush();
		    }
			System.out.println(rs.getString("logname"));
			rec = is.readLine();
			if(rs.getString("pass").equals(rec))
			{
				os.println(rec);
				os.flush();
			}
		    else{
		    	os.println("no" + rec);
		    	os.flush();
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
