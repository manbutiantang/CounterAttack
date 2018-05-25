package wang.learn.javanet.ChapterThree;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ice
 * @date 2018年5月24日
 * 实现-基于定界符的成帧理论
 */
public class DelimFramer {
	
	private InputStream in;
	private static final byte[] DELDMTTER = "\n".getBytes();
	
	public DelimFramer(InputStream in){
		this.in = in;
	}
	//添加成帧信息，并将指定信息输出到指定流
	public void frameMsg(byte[] message,OutputStream out) throws IOException{
		for(byte b : message){
			if(b == DELDMTTER[0]){
				throw new IOException("Message contains delimiter");
			}
		}
		out.write(message);
		out.write(DELDMTTER[0]);
		out.flush();
	}
	
	//扫描指定流，从中抽取信息
	public byte[] nextMsg() throws IOException, InterruptedException{
		ByteArrayOutputStream messageBuffer = new ByteArrayOutputStream();
		int nextByte;
		while((nextByte = in.read()) != DELDMTTER[0]){
			if(nextByte == -1){
				if(messageBuffer.size() == 0){
					return null;
				}else{
					throw new EOFException("Non - empty message without delimiter");
				}
			}
			messageBuffer.wait(nextByte);
		}
		return messageBuffer.toByteArray();
	}

}
