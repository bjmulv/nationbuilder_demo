/**
 * 
 */
package ca.mphost.importer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 000161482
 *
 */
public class HttpResponse {

	private Map<String, String> headers;
	private int statusCode;
	private byte[] content;
	
	public HttpResponse() {
		headers = new HashMap<String, String>();
	}
	
	public void setHeader( String key, String value ) {
		headers.put(key.toLowerCase(), value);
	}
	
	public String getHeader( String key ) {
		return headers.get( key.toLowerCase() );
	}
	
	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public int getCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
	public String getResponse() {
		return new String( content );
	}
	
	public void setResponse( String response ) {
		this.content = response.getBytes();
	}
}
