package wang.learn.javanet.ChapterTwo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ice
 * @date 2018年5月24日
 */
public class TCPEchoClient1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String host = "127.0.0.1"; 
		String message = "hello server";
		int port = 55532;
		byte[] bytes = new byte[1024];
		Socket socket = new Socket(host,port);
		InputStream inputStream = socket.getInputStream();
		
		// 服务器返回信息
		int len;
	    StringBuilder sb = new StringBuilder();
		while((len = inputStream.read(bytes)) != -1){
			 sb.append(new String(bytes, 0, len,"UTF-8"));
		}
		System.out.println("服务器返回信息:"+sb);
		socket.shutdownInput();
		// 给服务器发送信息
		OutputStream outPutStream = socket.getOutputStream();
		outPutStream.write(message.getBytes("UTF-8"));
		
		outPutStream.close();
		inputStream.close();
		socket.close();
	}
}
