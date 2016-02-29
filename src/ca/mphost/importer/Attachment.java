/**
 * 
 */
package ca.mphost.importer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;

/**
 * Attachment to replace in a blog post.
 * 
 * @author Bryan Mulvihill
 * @date 2014-04-21
 *
 */
public class Attachment {

	private String url;
	private String filename;
	
	/**
	 * Creates the JSON String to upload to NationBuilder.
	 * @return
	 */
	public String toJson() throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append( "{ \n\"attachment\": {\n")
		.append( "\"filename\": \"").append( filename ).append( "\",\n")
			.append( "\"content_type\": \"").append( getMimeType() ).append( "\",\n")
			.append( "\"updated_at\": \"").append( getTimestamp() ).append( "\",\n")
			.append( "\"content\": \"").append( getContent() ).append( "\"\n}\n}");
		return buffer.toString();
	}
	
	public String getMimeType() {
		if( filename.endsWith( ".jpg" ))
			return "image/jpeg";
		else if( filename.endsWith( ".png" ))
			return "image/png";
		return "";
	}
	
	public String getTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd");
		DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ssZZZ");
		Date date = new Date();
		return dateFormat.format( date ) + "T" + timeFormat.format( date );
	}
	
	public String getContent() throws Exception {
		File f = new File( "cache/" + filename );
		if( !f.exists() ) {
			URL localUrl = new URL( url );
			String path = localUrl.getPath();
			String localFile = path.replace( "/files", "cache/files");
			localFile = localFile.replace( "/wp-content/uploads", "cache/files");
			f = new File( localFile );
		}
			
		if( !f.exists() && !download() ) {
			throw new Exception( "Failed to download " + filename );
		}
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] data = IOUtils.readFully(fis);
			fis.close();
			Base64 base = new Base64();
			byte[] encoded = base.encode(data);
			return new String( encoded );
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * Download the file locally.
	 * @return
	 */
	public boolean download() {
		if( url == null )
			return false;
		try {
			URL imageUrl = new URL( url );
			HttpURLConnection conn = (HttpURLConnection)imageUrl.openConnection();
			byte[] content = IOUtils.readFully(conn.getInputStream());
			FileOutputStream out = new FileOutputStream( new File( "cache/" + filename ));
			out.write(content);
			out.close();
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
		if( url != null ) {
			int lastSlash = url.lastIndexOf( '/' );
			filename = url.substring(lastSlash + 1);
		}
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
