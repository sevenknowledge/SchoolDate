package datec;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;



public class Lesson {
	public static void init(Object[][] lesson)
	{
		for(int i = 1;i < 5;i++){
			for(int j = 1;j < 8;j++){
				lesson[i][j] = "¿ÕÏÐ";
			}
		}
	}
	public static void show(Object[][] lesson,JTextArea t9)
	{
		for (int i = 0; i < lesson.length; i++) {
			for (int j = 0; j < lesson[i].length; j++) {
				t9.append(lesson[i][j].toString() + " ");
			}
			t9.append("\n");
		}
	}
	public static void put(Object[][] lesson,BufferedReader is,int count)
	{
		for(int i = 0;i < count;i++){
			String rev;
			try {
				rev = is.readLine();
				int day = Integer.parseInt(is.readLine());
				int less = Integer.parseInt(is.readLine());
				if(rev.equals("2")){
					lesson[less][day] = "ÓÐÔ¼";
				}
				else{
					lesson[less][day] = "·±Ã¦";
				}
			} catch (Exception e) {
				System.out.println("Error:" + e);
			}		
		}
	}
}
