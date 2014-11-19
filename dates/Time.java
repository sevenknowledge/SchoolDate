package dates;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Time {
	public static boolean update()
	{
		System.out.println("信息更新模块");
		boolean res;
		res = true;
		return res;
	}
	public static void s_select(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("查询学生模块");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec;
			rec = is.readLine();
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    ResultSet rs = stmt.executeQuery("select * from student_table where name= '" + rec + "'");
		    if(rs.first()){
		    	os.println(rec);
				os.flush();
		   	}
		   	else{
		    	os.println("no" + rec);
		    	os.flush();
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void w_select(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("查询周次模块");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec1,rec2;
			rec1 = is.readLine();
			rec2 = is.readLine();
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    ResultSet rs = stmt.executeQuery("select * from lesson_table where teacher_id= '" + rec1 + "' and week= " + rec2);
		    if(rs.first()){
		    	os.println(rec2);
		    	os.flush();
		    }
		    else{
		    	os.println("no" + rec2);
		    	os.flush();
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void l_select(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("查询课表模块");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec1,rec2;
			rec1 = is.readLine();
			rec2 = is.readLine();
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    ResultSet rs = stmt.executeQuery("select * from lesson_table where teacher_id= '" + rec1 + "' and week= " + rec2);
		    rs.last();
		    int count = rs.getRow();
		    os.println(count);
		    os.flush();
		    rs.first();
		    for(int i = 0;i < count;i++){
				String send;
		    	os.flush();
		    	send = rs.getString("day");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("lesson");
		    	os.println(send);
		    	os.flush();
		    	rs.next();
			}
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void t_select(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("查询教师模块");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.flush();
			String rec;
			rec = is.readLine();
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    ResultSet rs = stmt.executeQuery("select * from teacher_table where name= '" + rec + "'");
		    if(rs.first()){
		    	os.println(rec);
				os.flush();
		   	}
		   	else{
		    	os.println("no" + rec);
		    	os.flush();
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void t_find(Socket socket,Connection conn,BufferedReader is)
	{
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.flush();
			String rec;
			rec = is.readLine();
			System.out.println("Test:");
			Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
			ResultSet rs = stmt.executeQuery("select * from teacher_table where name= '" + rec + "'");
			rs.last();
			int count = rs.getRow();
			System.out.println(count);
			os.println(count);
			os.flush();
			rs.first();
			for(int i = 0;i < count;i++){
				String send;
				send = rs.getString("logname");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("name");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("course");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("address");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("phone");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("email");
		    	os.println(send);
		    	os.flush();
		    	rs.next();
			}
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void s_find(Socket socket,Connection conn,BufferedReader is)
	{
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.flush();
			String rec;
			rec = is.readLine();
			System.out.println("Test:");
			Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
			ResultSet rs = stmt.executeQuery("select * from student_table where name= '" + rec + "'");
			rs.last();
			int count = rs.getRow();
			System.out.println(count);
			os.println(count);
			os.flush();
			rs.first();
			for(int i = 0;i < count;i++){
				String send;
				send = rs.getString("logname");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("name");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("academy");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("address");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("phone");
		    	os.println(send);
		    	os.flush();
		    	send = rs.getString("email");
		    	os.println(send);
		    	os.flush();
		    	rs.next();
			}
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
}
