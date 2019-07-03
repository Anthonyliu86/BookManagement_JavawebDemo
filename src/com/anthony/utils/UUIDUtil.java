package com.anthony.utils;

import java.util.UUID;

public class UUIDUtil {
	
	public static String getUUID() {
		return UUID.randomUUID().toString(); // 随机得到一个uuid字符串
	}

}
