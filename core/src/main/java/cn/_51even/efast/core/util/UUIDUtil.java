package cn._51even.efast.core.util;

import java.util.UUID;

/**
 * 自动生成20位的ID
 * @author liubin
 */
public class UUIDUtil {

	private static String[] arr = new String[]{"1","2","3","4","5","6","7","8","9","0"};

	/**
	 * 获得一个UUID
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}

	/**
	 * 获得一个指定位数的UUID
	 * @param number 位数
	 * @return
	 */
	public static String getUUIDNumber(int number){
		StringBuilder stringBuilder = new StringBuilder();
		String uuid = getUUID();
		for (int i = 0; i < number; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			stringBuilder.append(arr[x % 10]);
		}
		return stringBuilder.toString();
	}

}