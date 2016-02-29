/**
 * 
 */
package ca.mphost.importer.nationbuilder;

/**
 * Exception thrown from the NationBuilder API.
 * 
 * @author Bryan Mulvihill
 * @date 2014-04-23
 *
 */
public class APIException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8129820710640065951L;

	/**
	 * Constructor.
	 */
	public APIException() {
		
	}
	
	/**
	 * Constructor with message.
	 * @param message
	 */
	public APIException( String message ) {
		super( message);
	}
	
	/**
	 * Constructor with a message and Throwable.
	 * @param message
	 * @param t
	 */
	public APIException( String message, Throwable t ) {
		super( message, t );
	}
}
