/**
 * 
 */
package ca.mphost.importer;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author 000161482
 *
 */
public class HttpRequest {

	private class MyTrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
		
	}
	
	private static final String CRLF = "\r\n";
	
	private Map<String, String> headers;
	
	public HttpRequest( ) {
		headers = new HashMap<String, String>();
	}
	
	public void setHeader( String key, String value ) {
		headers.put(key, value);
	}
	
	public HttpResponse get( URL url ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append( "GET " ).append( url.getPath() ).append( "?" ).append( url.getQuery() ).append( " HTTP/1.1").append( CRLF );
		buffer.append( "Host: ").append( url.getHost() ).append( CRLF );
		for( String key : headers.keySet() ) {
			buffer.append( key ).append( ": " ).append( headers.get(key) ).append( CRLF );
		}
		buffer.append( CRLF );
		
		return sendRequest( url, buffer.toString().getBytes() );
	}
	
	public HttpResponse post( URL url, String postData ) throws Exception {
		try {
			return post( url, postData.getBytes() );
		} catch (Exception e) {
			return post( url, postData.getBytes() );
		}
	}
	
	public HttpResponse delete( URL url ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append( "DELETE " ).append( url.getPath() ).append( "?" ).append( url.getQuery() ).append( " HTTP/1.1").append( CRLF );
		buffer.append( "Host: ").append( url.getHost() ).append( CRLF );
		for( String key : headers.keySet() ) {
			buffer.append( key ).append( ": " ).append( headers.get(key) ).append( CRLF );
		}
		buffer.append( CRLF );
	
		return sendRequest( url, buffer.toString().getBytes() );
	}
	
	public HttpResponse post( URL url, byte[] postData ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append( "POST " ).append( url.getPath() ).append( " HTTP/1.1").append( CRLF );
		buffer.append( "Host: ").append( url.getHost() ).append( CRLF );
		for( String key : headers.keySet() ) {
			buffer.append( key ).append( ": " ).append( headers.get(key) ).append( CRLF );
		}
		buffer.append( "Content-Length: ").append( postData.length ).append( CRLF );
		buffer.append( CRLF );

		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try {
			bytes.write( buffer.toString().getBytes() );
			bytes.write(postData);
			return sendRequest( url, bytes.toByteArray() );
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public HttpResponse put( URL url, byte[] postData ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append( "PUT " ).append( url.getPath() ).append( " HTTP/1.1").append( CRLF );
		buffer.append( "Host: ").append( url.getHost() ).append( CRLF );
		for( String key : headers.keySet() ) {
			buffer.append( key ).append( ": " ).append( headers.get(key) ).append( CRLF );
		}
		buffer.append( "Content-Length: ").append( postData.length ).append( CRLF );
		buffer.append( CRLF );

		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try {
			bytes.write( buffer.toString().getBytes() );
			bytes.write(postData);
			return sendRequest( url, bytes.toByteArray() );
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private HttpResponse sendRequest( URL url, byte[] data ) throws Exception {
		Socket socket = null;
		int port = url.getPort();
		if( port == -1 )
			port = url.getDefaultPort();
		if( url.getProtocol().equalsIgnoreCase( "HTTP" ) ) {
			socket = new Socket( url.getHost(), port );
		}
		else {
			SSLContext context = SSLContext.getInstance( "SSL" );
			context.init(null, new TrustManager[] { new MyTrustManager()}, new SecureRandom() );
			SSLSocketFactory factory = (SSLSocketFactory)context.getSocketFactory();
			socket = factory.createSocket( url.getHost(), port );
		}
		OutputStream out = socket.getOutputStream();
		out.write( data );
		out.flush();
		
		InputStream in = socket.getInputStream();
		StringBuffer responseBuffer = new StringBuffer();
		while( responseBuffer.indexOf( "\r\n\r\n") == -1 ) {
			int c = in.read();
			if( c == -1 )
				break;
			responseBuffer.append( (char)c );
		}

		//parse status line and headers
		HttpResponse response = new HttpResponse();
		BufferedReader headerReader = new BufferedReader( new StringReader( responseBuffer.toString() ));
		//parse status line
		String statusLine = headerReader.readLine();
		String[] tokens = statusLine.split( " " );
		int statusCode = Integer.parseInt( tokens[1] );
		response.setStatusCode(statusCode);
		
		String line = null;
		while( (line = headerReader.readLine() ) != null ) {
						
			if( line.indexOf( ':' ) == -1 )
				continue;
			String key = line.substring( 0, line.indexOf( ':')).trim();
			String value = line.substring( line.indexOf( ':') + 1 ).trim();
			response.setHeader(key, value);
		}
		
		byte[] content = null;
		String contentLengthStr = response.getHeader( "Content-Length");
		if( contentLengthStr != null ) {
			int contentLength = Integer.parseInt(contentLengthStr);
			content = new byte[contentLength];
			int totalRead = 0;
			while( totalRead < contentLength ) {
				totalRead += in.read(content, totalRead, contentLength - totalRead );
			}
		}
		else if( response.getHeader( "transfer-encoding" ).equalsIgnoreCase( "chunked") ){
			StringBuffer lengthBuffer = new StringBuffer();
			boolean done = false;
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			while( !done ) {
				lengthBuffer.setLength( 0 );
				while( lengthBuffer.indexOf( CRLF ) == -1 ) {
					int c = in.read();
					lengthBuffer.append( (char)c );
				}
				String lengthStr = lengthBuffer.toString().trim();
				if( lengthStr.length() == 0 )
					break;
				int chunkLength = Integer.parseInt( lengthStr, 16 );
				if( chunkLength == 0 ) {
					done = true;
				}
				else {
					byte[] chunk = new byte[chunkLength];
					int totalRead = 0;
					while( totalRead < chunkLength ) {
						totalRead += in.read(chunk, totalRead, chunkLength - totalRead );					
					}
					int cr = in.read();
					int lf = in.read();
					bytes.write( chunk );
				}
			}
			content = bytes.toByteArray();
		}
		response.setContent(content);
		return response;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		HttpRequest request = new HttpRequest();
		HttpResponse response = request.get( new URL( "http://localhost:8080/"));
		System.out.println( response.getCode() );
		System.out.println( response.getResponse() );
	}

}
