package qq;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("***服务器启动，等待客户端连接***");
		//侦听客户端连接
		int count = 0;
		while(true){
			Socket socket = server.accept();
			ServerThread thread = new ServerThread(socket);
			thread.start();
			InetAddress address = socket.getInetAddress();
			System.out.println("请求客户端信息："+address.getHostAddress());
			count ++;
			System.out.println("连接客户端个数："+count);
		}
		
		
	}
}
