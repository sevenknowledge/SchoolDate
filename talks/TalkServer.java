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
				// ������ӡ������Ϣ
				System.out.println("can not listen to:" + e);
			}
			Socket socket = null;
			try {
				// ʹ��accept()�����ȴ��ͻ������пͻ� �����������һ��Socket���󣬲�����ִ��
				socket = server.accept();
			} catch (Exception e) {
				System.out.println("Error." + e);
			}
			// ��Socket����õ�����������������Ӧ��BufferedReader����
			BufferedReader is = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// ��Socket����õ��������������PrintWriter����
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			while (true) {
				String rev = is.readLine();
				if(rev.equals("1")){
					boolean res = User.regist();
					if(res == true){
						os.println("�����ɹ�");
						os.flush();
					}
				}
				if(rev.equals("2")){
					boolean res = User.log();
					if(res == true){
						os.println("��½�ɹ�");
						os.flush();
					}
				}
				if(rev.equals("a")){
					boolean res = Time.update();
					if(res == true){
						os.println("���³ɹ�");
						os.flush();
					}
				}
				if(rev.equals("b")){
					boolean res = Time.select();
					if(res == true){
						os.println("��ѯ�ɹ�");
						os.flush();
					}
				}
				if(rev.equals("c")){
					boolean res = Time.delete();
					if(res == true){
						os.println("ɾ���ɹ�");
						os.flush();
					}
				}
				if(rev.equals("d")){
					os.println("ע���ɹ�");
					os.flush();
				}
				if(rev.equals("bye")){
					boolean res = User.log();
					if(res == true){
						os.println("�˳��ɹ�");
						os.flush();
					}
					break;
				}
			} 
			os.close(); // �ر�Socket�����
			is.close(); // �ر�Socket������
			socket.close(); // �ر�Socket
			server.close(); // �ر�ServerSocket
		} catch (Exception e) {
			// ������ӡ������Ϣ
			System.out.println("Error:" + e);
		}
	}
}