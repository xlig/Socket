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
			//获取输入流
			is = socket.getInputStream();
			//添加缓冲
			bf = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = bf.readLine()) != null){
				System.out.println("我是服务端，客户端说："+info);
			}
			socket.shutdownInput();
			
			//获取输出流
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.print("欢迎您");
			pw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
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
