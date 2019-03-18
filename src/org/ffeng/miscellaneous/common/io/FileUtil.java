package org.ffeng.miscellaneous.common.io;


import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Provides utility methods for file operation, such as close, copy and so on.
 * 
 * @author ffeng
 *
 */
public class FileUtil {
	/**
	 * Close a character input stream identified by Reader
	 * 
	 * @param reader
	 *            The character stream that need to be closed
	 */
	public static void closeIgnoreException(Reader reader) {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * Close a byte input stream identified by Reader
	 * 
	 * @param reader
	 *            The character stream that need to be closed
	 */
	public static void closeIgnoreException(InputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
	}
}
