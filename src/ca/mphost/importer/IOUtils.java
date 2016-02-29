package ca.mphost.importer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Random IO Utility Methods.
 * 
 * @author Bryan Mulvihill
 * @date 2014-04-21
 *
 */
public abstract class IOUtils {

	/**
	 * Reads the entire input stream and returns the data.
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFully(InputStream in)
			throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		boolean done = false;
		byte[] data = new byte[2048];
		
		while( !done ) {
			int numRead = in.read(data);
			if( numRead < 0 ) {
				done = true;
			}
			else {
				out.write(data, 0, numRead );
			}
		}
		return out.toByteArray();
	}
	
	/**
	 * Reads the input stream as a String.
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static String readStringFully(InputStream in)
			throws IOException {
		return new String( readFully(in) );
	}
	
}
