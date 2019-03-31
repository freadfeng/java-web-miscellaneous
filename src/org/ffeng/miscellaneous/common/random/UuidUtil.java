package org.ffeng.miscellaneous.common.random;

import java.util.UUID;

public class UuidUtil {
	public static String generateUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}

}
