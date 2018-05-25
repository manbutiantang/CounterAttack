package wang.learn.javanet.ChapterTwo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author ice
 * @date 2018年5月23日
 */
public class UDPEchoClientTimeout {

	private static final int TIMEOUT = 3000;
	private static final int MAXTRIES = 5;
	
	public static void main(String[] args) throws IOException {
		String d = "Hello ice !";
		byte[] dd = d.getBytes("UTF-8");
		String ip = "127.0.0.1";
		InetAddress ipInet = InetAddress.getByName(ip);
		DatagramSocket socket = new DatagramSocket();
		socket.setSoTimeout(TIMEOUT);//设置延时
		DatagramPacket sendPacket = new DatagramPacket(dd,dd.length,ipInet,55535);
		socket.send(sendPacket);
		System.out.println("数据已经发送。。。。。");
	}
}
