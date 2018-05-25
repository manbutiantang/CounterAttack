package wang.learn.javanet.ChapterThree;

/**
 * @author ice
 * @date 2018年5月24日
 */
public class BruteForceCoding {
	
	
	
	private final static int BYTEMASK = 0xFF;

	//将bArray转换成无符号整型，其中BYTEMASK的作用是字节数值转换成int类型时，发生符号扩展。
	public static String byteArrayToDecimalString(byte[] bArray){
		StringBuilder rtn = new StringBuilder();
		for(byte b : bArray){
			rtn.append(b & BYTEMASK).append(" ");
		}
		System.out.println("将字节数组转换为无符号整型： "+rtn.toString());
		return rtn.toString();
	}
	
	public static int encodeIntBigEndiam(byte[] dst, long val, int offset,int size){
		for(int i=0;i<size;i++){
			dst[offset++] = (byte)(val >> (size-i-1)*Byte.SIZE);
		}
		return offset;
	}
}
