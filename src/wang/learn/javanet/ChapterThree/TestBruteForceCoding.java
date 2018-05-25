package wang.learn.javanet.ChapterThree;

/**
 * @author ice
 * @date 2018年5月24日
 */
public class TestBruteForceCoding {
	private final static int BSIZE = Byte.SIZE;
	private final static int SSIZE = Short.SIZE;
	private final static int ISIZE = Integer.SIZE;
	private final static int LSIZE = Long.SIZE;
	
	private static byte byteVal = 101;
	private static short shortVal = 10001;
	private final static int intVal = 100000001;
	private static long longVal = 100000000001L;
	
	private static byte[] bArray = {96,97,98};
	private static byte[] message = new byte[BSIZE+SSIZE+ISIZE+LSIZE];
	
	public static void main(String[] args) {
		BruteForceCoding.byteArrayToDecimalString(bArray);
		BruteForceCoding.encodeIntBigEndiam(message, byteVal, 0, BSIZE);
	}
}
