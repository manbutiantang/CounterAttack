package wang.learn.javanet.ChapterFour;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ice
 * @date 2018年5月25日
 */
public class TCPEchoServerThread {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket servSocket = new ServerSocket(55533);
		while(true){
			Socket clntSock = servSocket.accept();
			Thread thread = new Thread(new EchoProtocol(clntSock));
			thread.start();
		}
	}
}
