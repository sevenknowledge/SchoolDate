package dates;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Time {
	public static void d_find(Socket socket,Connection conn,BufferedReader is)
	{
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.flush();
			String rec;
			rec = is.readLine();
			System.out.println("�γ̲�ѯģ��");
			Statement stmt = conn.createStatement();//��������������ִ��sql����
			Statement stmt2 = conn.createStatement();
			if(rec.charAt(0) == '1'){
		    	ResultSet rs = stmt.executeQuery("select * from lesson_table where teacher_id= '" + rec + "'");
		    	if(rs.first()){
		    		rs.last();
		    		int count = rs.getRow();
		    		System.out.println(count);
		    		os.println(count);
		    		os.flush();
		    		rs.first();
		    		for(int i = 0;i < count;i++){
		    			String send;
		    			send = rs.getString("week");
		    			os.println(send);
		    			os.flush();
		    			send = rs.getString("day");
		    			os.println(send);
		    			os.flush();
		    			send = rs.getString("lesson");
		    			os.println(send);
		    			os.flush();
		    			send = rs.getString("date_logname");
		    			os.println(send);
		    			os.flush();
		    			ResultSet rs2 = stmt2.executeQuery("select * from student_table where logname = " + send);
		    			rs2.first();
		    			send = rs2.getString("name");
		    			os.println(send);
		    			os.flush();
		    			rs2.close();
		    			rs.next();
		    		}    		
		    	}
		    	else{
		    		int count = 0;
		    		os.println(count);
		    		os.flush();
		    	}
		    }
			if(rec.charAt(0) == '2'){
		    	ResultSet rs = stmt.executeQuery("select * from lesson_table where date_logname= '" + rec + "'");
		    	if(rs.first()){
		    		rs.last();
		    		int count = rs.getRow();
		    		System.out.println(count);
		    		os.println(count);
		    		os.flush();
		    		rs.first();
		    		for(int i = 0;i < count;i++){
		    			String send;
		    			send = rs.getString("week");
		    			os.println(send);
		    			os.flush();
		    			send = rs.getString("day");
		    			os.println(send);
		    			os.flush();
		    			send = rs.getString("lesson");
		    			os.println(send);
		    			os.flush();
		    			send = rs.getString("teacher_id");
		    			os.println(send);
		    			os.flush();
		    			ResultSet rs2 = stmt2.executeQuery("select * from teacher_table where logname = " + send);
		    			rs2.first();
		    			send = rs2.getString("name");
		    			os.println(send);
		    			os.flush();
		    			rs2.close();
		    			rs.next();
		    		}
		    	}
		    	else{
		    		int count = 0;
		    		os.println(count);
		    		os.flush();
		    	}
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void d_sure(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("״̬ȷ��ģ��");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec1,rec2,rec3,rec4;
			rec1 = is.readLine();
			rec2 = is.readLine();
			rec3 = is.readLine();
			rec4 = is.readLine();
		    //ִ��SQL���
		    Statement stmt = conn.createStatement();//��������������ִ��sql����
		    ResultSet rs = stmt.executeQuery("select * from lesson_table where teacher_id= " + rec1 + " and week=" + rec2 + " and day=" + rec3 + " and lesson=" + rec4);
		    if(rs.first()){
		    	os.println(rec1);
				os.flush();
		    }
		    else{
		    	os.println("no"+rec1);
				os.flush();
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void d_td(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("��ʦ�ܾ�ģ��");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec1,rec2,rec3,rec4;
			rec1 = is.readLine();
			rec2 = is.readLine();
			rec3 = is.readLine();
			rec4 = is.readLine();
		    //ִ��SQL���
		    Statement stmt = conn.createStatement();//��������������ִ��sql����
		    ResultSet rs = stmt.executeQuery("select * from lesson_table where teacher_id= " + rec1 + " and week=" + rec2 + " and day=" + rec3 + " and lesson=" + rec4);
		    if(rs.first()){
		    	stmt.executeUpdate("delete from lesson_table where teacher_id= " + rec1 + " and week=" + rec2 + " and day=" + rec3 + " and lesson=" + rec4);
		    	os.println("1");
		    	os.flush();
		    }
		    else{
		    	os.println("2");
		    	os.flush();
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void d_tcon(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("��ʦ״̬����ģ��");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec1,rec2,rec3,rec4;
			rec1 = is.readLine();
			rec2 = is.readLine();
			rec3 = is.readLine();
			rec4 = is.readLine();
		    //ִ��SQL���
		    Statement stmt = conn.createStatement();//��������������ִ��sql����
		    ResultSet rs = stmt.executeQuery("select * from lesson_table where teacher_id= " + rec1 + " and week=" + rec2 + " and day=" + rec3 + " and lesson=" + rec4);
		    if(rs.first()){
		    	stmt.executeUpdate("delete from lesson_table where teacher_id= " + rec1 + " and week=" + rec2 + " and day=" + rec3 + " and lesson=" + rec4);
		    	os.println("����");
		    	os.flush();
		    	os.println("��");
		    	os.flush();
		    }
		    else{
		    	stmt.executeUpdate("insert lesson_table(teacher_id,week,day,lesson) values (" + rec1 + "," + rec2 + "," + rec3 + "," + rec4 + ")");
		    	os.println("��æ");
		    	os.flush();
		    	os.println("��");
		    	os.flush();
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void d_select(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("״̬��ѯģ��");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec1,rec2,rec3,rec4;
			rec1 = is.readLine();
			rec2 = is.readLine();
			rec3 = is.readLine();
			rec4 = is.readLine();
		    //ִ��SQL���
		    Statement stmt = conn.createStatement();//��������������ִ��sql����
		    ResultSet rs = stmt.executeQuery("select * from lesson_table where teacher_id= " + rec1 + " and week=" + rec2 + " and day=" + rec3 + " and lesson=" + rec4);
		    if(rs.first()){
		    	String send;
		    	send = rs.getString("date_logname");
		    	System.out.println("send��ֵ");
		    	if(send != null){
		    		ResultSet rs2 = stmt.executeQuery("select * from student_table where logname = " + send);
		    		rs2.first();
		    		os.println("��Լ");
		    		os.flush();
		    		send = rs2.getString("name");
		    		os.println(send);
		    		os.flush();
		    	}
		    	else{
		    		os.println("��æ");
			    	os.flush();
			    	os.println("��");
			    	os.flush();
		    	}
		    }
		    else{
		    	os.println("����");
		    	os.flush();
		    	os.println("��");
		    	os.flush();
		    }
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	public static void s_select(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("��֤ѧ������ģ��");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec;
			rec = is.readLine();
		    //ִ��SQL���
		    Statement stmt = conn.createStatement();//��������������ִ��sql����
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
	public static void l_select(Socket socket,Connection conn,BufferedReader is)
	{
		System.out.println("��ѯ�α�ģ��");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String rec1,rec2;
			rec1 = is.readLine();
			rec2 = is.readLine();
		    //ִ��SQL���
		    Statement stmt = conn.createStatement();//��������������ִ��sql����
		    ResultSet rs = stmt.executeQuery("select * from lesson_table where teacher_id= '" + rec1 + "' and week= " + rec2);
		    rs.last();
		    int count = rs.getRow();
		    os.println(count);
		    os.flush();
		    rs.first();
		    for(int i = 0;i < count;i++){
				String send;
		    	send = rs.getString("date_logname");
		    	if(send == null)
		    	{
		    		os.println("1");
		    		os.flush();
		    	}
		    	else{
		    		os.println("2");
		    		os.flush();
		    	}
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
		System.out.println("��֤��ʦ����ģ��");
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.flush();
			String rec;
			rec = is.readLine();
		    //ִ��SQL���
		    Statement stmt = conn.createStatement();//��������������ִ��sql����
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
			System.out.println("��ʦ��ѯģ��");
			Statement stmt = conn.createStatement();//��������������ִ��sql����
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
			System.out.println("ѧ����ѯģ��");
			Statement stmt = conn.createStatement();//��������������ִ��sql����
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
