package qq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		InputStream is = null;
		BufferedReader bf = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			//��ȡ������
			is = socket.getInputStream();
			//��ӻ���
			bf = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = bf.readLine()) != null){
				System.out.println("���Ƿ���ˣ��ͻ���˵��"+info);
			}
			socket.shutdownInput();
			
			//��ȡ�����
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.print("��ӭ��");
			pw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر���Դ
				try {
					if(bf != null)
					bf.close();
					if(is != null)
						is.close();
					if(pw != null)
						pw.close();
					if(os != null)
						os.close();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
}
