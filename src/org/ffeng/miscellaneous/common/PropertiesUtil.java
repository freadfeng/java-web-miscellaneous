package org.ffeng.miscellaneous.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.ffeng.miscellaneous.common.io.FileUtil;

public class PropertiesUtil {
	/**
	 * Load a file as a Properties
	 * 
	 * @param propertiesPath File path of the Properties
	 * @return the Properties loaded from propertiesPath
	 * @throws Exception IOException or IllegalArgumentException
	 */
	public static Properties loadProperties(String propertiesPath) throws Exception {
		Properties properties = new Properties();
		InputStream in = null;
		try {
			in = new FileInputStream(propertiesPath);
			properties.load(in);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			FileUtil.closeIgnoreException(in);
		}
		return properties;
	}
}
