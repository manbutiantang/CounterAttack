package wang.learn.javanet.ChapterTwo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ice
 * @date 2018年5月24日
 */
public class TCPEchoServer1 {
	public static void main(String[] args) throws IOException {
		
		byte[] bytes = new byte[1024];
		String message = "Hello";
		ServerSocket serverSocket = new ServerSocket(55532);
		Socket socket = serverSocket.accept();
		OutputStream outPutStream = socket.getOutputStream();
		
		outPutStream.write(message.getBytes("UTF-8"));
		socket.shutdownOutput();
		//接收客户端信息
		InputStream inputStream = socket.getInputStream();
		int len;
	    StringBuilder sb = new StringBuilder();
		while((len = inputStream.read(bytes)) != -1){
			 sb.append(new String(bytes, 0, len,"UTF-8"));
		}
		System.out.println("接收客户端信息:"+sb);
		outPutStream.close();
		inputStream.close();
		socket.close();
		serverSocket.close();
	}
}
