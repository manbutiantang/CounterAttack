package wang.learn.javanet.ChapterTwo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ice
 * @date 2018年5月23日
 * 基于TCP协议简单的客户端
 */
public class TCPEchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 要连接的服务端IP地址和端口
	    String host = "127.0.0.1"; 
	    int port = 55533;
	    // 与服务端建立连接
	    Socket socket = new Socket(host, port);
	    OutputStream outputStream = socket.getOutputStream();
	    String message="收到 ice";
	    outputStream.write(message.getBytes("UTF-8"));
	    outputStream.close();
	    socket.close();
	}
}
