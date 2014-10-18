package talkc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {
	public static void main(String args[]) {
		UI.init();
		try {
			// �򱾻���4700�˿ڷ����ͻ�����
			Socket socket = new Socket("127.0.0.1", 4700);
			// ��ϵͳ��׼�����豸����BufferedReader����
			BufferedReader sin = new BufferedReader(new InputStreamReader(
					System.in));
			// ��Socket����õ��������������PrintWriter����
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			// ��Socket����õ�����������������Ӧ��BufferedReader����
			BufferedReader is = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String readline;
			String rev;
			// ���ӱ�׼���������ַ���Ϊ "bye"��ֹͣѭ��
			while (true) {
				readline = sin.readLine(); // ��ϵͳ��׼�������һ�ַ���
				// ����ϵͳ��׼���������ַ��������Server
				os.println(readline);				
				// ˢ���������ʹServer�����յ����ַ���
				os.flush();
				// ��ϵͳ��׼����ϴ�ӡ������ַ���
				System.out.println("Client:" + readline);
				// ��Server����һ�ַ���
				rev = is.readLine();
				System.out.println("Server:" + rev);
				if(rev.equals("�����ɹ�"))
				{
					UI.init();
				}
				if(rev.equals("��½�ɹ�"))
				{
					UI.logged();
				}
				if(rev.equals("���³ɹ�"))
				{
					UI.logged();
				}
				if(rev.equals("��ѯ�ɹ�"))
				{
					UI.logged();
				}
				if(rev.equals("ɾ���ɹ�"))
				{
					UI.init();
				}
				if(rev.equals("ע���ɹ�"))
				{
					UI.init();
				}
				if(rev.equals("�˳��ɹ�"))
				{
					break;
				}
			}
			os.close(); // �ر�Socket�����
			is.close(); // �ر�Socket������
			socket.close(); // �ر�Socket
		} catch (Exception e) {
			System.out.println("Error" + e); // �������ӡ������Ϣ
		}
	}
}