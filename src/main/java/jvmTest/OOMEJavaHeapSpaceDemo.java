package jvmTest;

public class OOMEJavaHeapSpaceDemo {

	/**
	 * 
	 * -Xms10m -Xmx10m
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] array = new byte[80 * 1024 * 1024];
	}

}