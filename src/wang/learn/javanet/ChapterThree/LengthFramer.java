package wang.learn.javanet.ChapterThree;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ice
 * @date 2018年5月24日
 * 实现-基于长度的成帧理论
 */
public class LengthFramer {
	
	public static final int MAXMESSAGELENGTH = 65535;
	public static final int BYTEMASK = 0xff;
	public static final int SHORIMASK = 0xffff;
	public static final int BYTESHIPT = 8;
	
	private DataInputStream in;
	
	public LengthFramer(InputStream in){
		this.in = new DataInputStream(in);
	}
	
	//添加成帧信息，并将指定信息输出到指定流
	public void frameMsg(byte[] message,OutputStream out) throws IOException{
		if(message.length > MAXMESSAGELENGTH){
			throw new IOException("message too long");
		}
		out.write((message.length >> BYTEMASK) & BYTEMASK);
		out.write(message.length & BYTEMASK);
		out.write(message);
		out.flush();
	}
	
	//扫描指定流，从中抽取信息
	public byte[] nextMsg() throws IOException{
		int length;
		length = in.readUnsignedShort();
		byte[] msg = new byte[length];
		in.readFully(msg);
		return msg;
	}

}
