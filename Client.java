package qq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket client = new Socket(InetAddress.getLocalHost(), 8888);
		OutputStream outputStream = client.getOutputStream();
		//��ӡ��
		PrintWriter pw = new PrintWriter(outputStream);
		pw.print("���ǿͻ��ˣ�����ˣ����!!!!");
		pw.flush();
		client.shutdownOutput();
		//Socket client1 = new Socket(InetAddress.getLocalHost(), 8888);
		InputStream is = client.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String message = null;
		while((message = br.readLine()) != null){
			System.out.println("���ǿͻ��ˣ�������˵��"+message);
		}
		
		br.close();
		isr.close();
		is.close();
		pw.close();
		client.close();
	}
}
