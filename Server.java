package qq;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("***�������������ȴ��ͻ�������***");
		//�����ͻ�������
		int count = 0;
		while(true){
			Socket socket = server.accept();
			ServerThread thread = new ServerThread(socket);
			thread.start();
			InetAddress address = socket.getInetAddress();
			System.out.println("����ͻ�����Ϣ��"+address.getHostAddress());
			count ++;
			System.out.println("���ӿͻ��˸�����"+count);
		}
		
		
	}
}
