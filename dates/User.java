package dates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class User {
	public static void date(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("学生预约模块");
		try {
			String rec1,rec2,rec3,rec4,rec5,rec6;
			rec1 = is.readLine();
			rec2 = is.readLine();
			rec3 = is.readLine();
			rec4 = is.readLine();
			rec5 = is.readLine();
			rec6 = is.readLine();
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    stmt.executeUpdate("insert lesson_table() values (" + rec1 + "," + rec2 + "," + rec3+ "," + rec4+ ",'" + rec5+ "'," + rec6 + ")");
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}	
	}
	public static void reset(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("用户更改模块");
		try {
			String rec1,rec2,rec3,rec4,rec5,rec6;
			rec1 = is.readLine();
			rec2 = is.readLine();
			rec3 = is.readLine();
			rec4 = is.readLine();
			rec5 = is.readLine();
			rec6 = is.readLine();
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    if(rec1.charAt(0) == '1'){
		    	stmt.executeUpdate("update teacher_table set name ='" + rec2 + "',course='" + rec3 + "',address='" + rec4 + "',phone='" + rec5 + "',email='" + rec6 + "' where logname=" + rec1 );
		    }
		    if(rec1.charAt(0) == '2'){
		    	stmt.executeUpdate("update student_table set name ='" + rec2 + "',academy='" + rec3 + "',address='" + rec4 + "',phone='" + rec5 + "',email='" + rec6 + "' where logname=" + rec1);
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}	
	}
	public static void namejudge(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("用户查询存在模块");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec;
			rec = is.readLine();
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    if(rec.charAt(0) == '1'){
		    	ResultSet rs = stmt.executeQuery("select * from teacher_table where logname=" + rec);
		    	if(rs.first()){
		    		os.println(rec);
					os.flush();
		    	}
		    	else{
		    		os.println("no" + rec);
		    		os.flush();
		    	}
		    }
		    if(rec.charAt(0) == '2'){
		    	ResultSet rs = stmt.executeQuery("select * from student_table where logname=" + rec);
		    	if(rs.first()){
		    		os.println(rec);
					os.flush();
		    	}
		    	else{
		    		os.println("no" + rec);
		    		os.flush();
		    	}
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}	
	}
	public static void delete(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("用户删除模块");
		try {
			String rec1;
			rec1 = is.readLine();
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    if(rec1.charAt(0) == '1'){
		    	stmt.executeUpdate("delete from teacher_table where logname = " + rec1);
		    }
		    if(rec1.charAt(0) == '2'){
		    	stmt.executeUpdate("delete from student_table where logname = " + rec1);
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}	
	}
	public static void regist(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("用户注册模块");
		try {
			String rec1,rec2;
			rec1 = is.readLine();
			rec2 = is.readLine();
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    if(rec1.charAt(0) == '1'){
		    	stmt.executeUpdate("insert teacher_table(logname,pass) values (" + rec1 + "," + rec2 + ")");
		    }
		    if(rec1.charAt(0) == '2'){
		    	stmt.executeUpdate("insert student_table(logname,pass) values (" + rec1 + "," + rec2 + ")");
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}	
	}
 	public static void show(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("用户信息输出模块");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.flush();
			String rec;
			rec = is.readLine();
			System.out.println("Test:");
			Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
			if(rec.charAt(0) == '1'){
				ResultSet rs = stmt.executeQuery("select * from teacher_table where logname=" + rec);
			    rs.first();
			    String send;
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
			}
			if(rec.charAt(0) == '2'){
				ResultSet rs = stmt.executeQuery("select * from student_table where logname=" + rec);
			    rs.first();
			    String send;
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
			}
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void log(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("用户登陆模块");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.flush();
			String rec;
			rec = is.readLine();
			System.out.println(rec);
		    //执行SQL语句
		    Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
		    if(rec.charAt(0) == '0'){
		    	ResultSet rs = stmt.executeQuery("select * from admin_table where logname=" + rec);
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
		    }
		    if(rec.charAt(0) == '1'){
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
		    }
		    else if(rec.charAt(0) == '2'){
		    	ResultSet rs = stmt.executeQuery("select * from student_table where logname=" + rec);
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
		    }
		    System.out.println("登录模块完成");
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}		
	}
}
