package wang.learn.javanet.ChapterFour;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ice
 * @date 2018年5月25日
 */
public class EchoProtocol implements Runnable{
	
	private Socket clntSock;
	
	public EchoProtocol(Socket clntSock){
		this.clntSock = clntSock;
	}
	
	public static void handleEchoClient(Socket clntSock) throws IOException{
		InputStream in = clntSock.getInputStream();
		OutputStream out = clntSock.getOutputStream();
		StringBuffer sb = new StringBuffer();
		byte [] echoBUffer = new byte[32];
		int recvMsgSize;
		while((recvMsgSize = in.read(echoBUffer)) != -1){
			sb.append(new String(echoBUffer, 0, recvMsgSize,"UTF-8"));
		}
		System.out.println("EchoProtocol say。。。。"+sb);
		clntSock.close();
	}
	
	public void run(){
		try {
			handleEchoClient(clntSock);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
