package wang.learn.javanet.ChapterTwo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author ice
 * @date 2018年5月23日
 */
public class UDPEchoServer {

	public static void main(String[] args) throws IOException {
		System.out.println("开始接收数据。。。");
		DatagramSocket socket = new DatagramSocket(55535);
		DatagramPacket packet = new DatagramPacket(new byte[255],255);
		while(true){
			socket.receive(packet);
			System.out.println("发送的端口号："+packet.getPort());
			System.out.println("发送过来的数据："+new String(packet.getData()));
			System.out.println("数据接收完毕");
		}
	}
}
