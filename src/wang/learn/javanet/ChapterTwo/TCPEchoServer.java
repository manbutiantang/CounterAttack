package wang.learn.javanet.ChapterTwo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author ice
 * @date 2018年5月23日
 * 基于TCP协议服务端程序
 */
public class TCPEchoServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(55531);
		Socket clnt = serverSocket.accept();//接受连接请求
		InputStream in = clnt.getInputStream();
		byte[] bytes = new byte[1024];
		SocketAddress clientAddress = clnt.getRemoteSocketAddress();
		System.out.println("Handling client at: "+clientAddress);
		StringBuilder sb = new StringBuilder();
		int len;
		while((len = in.read(bytes)) != -1){
			 sb.append(new String(bytes, 0, len,"UTF-8"));
			 
		}
		System.out.println("get message from client: " + sb);
		in.close();
		clnt.close();
		serverSocket.close();
	}
}
