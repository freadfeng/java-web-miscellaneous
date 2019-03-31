package org.ffeng.miscellaneous.common.database;

import java.sql.Connection;

public class DatabaseUtil {

	public static void closeIgnoreException(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
