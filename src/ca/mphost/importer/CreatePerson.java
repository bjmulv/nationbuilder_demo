/**
 * 
 */
package ca.mphost.importer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ca.mphost.importer.nationbuilder.Person;

/**
 * Demonstration of creating, updating, and deleting a Person.
 * 
 * @author Bryan Mulvihill
 *
 */
public class CreatePerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		if( args.length < 2 ) {
			System.out.println("Usage: ca.mphost.importer.CreatePerson sandbox apikey");
			System.exit( 1 );
		}
		String sandbox = args[0];
		String apikey = args[1];
		
		NationBuilderAPI api = new NationBuilderAPI();
		api.init(sandbox, null, apikey);
		
		Person person = new Person();
		
		System.out.println("First name:");
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String firstName = reader.readLine();
		
		person.setFirst_name( firstName );
		System.out.println("Last name");
		person.setLast_name( reader.readLine() );
		System.out.println("Email address");
		person.setEmail( reader.readLine() );
		System.out.println("Sex [M/F]");
		person.setSex( reader.readLine() );
		
		//Create the person
		Person ret = api.createPerson(person);
		//Update the person
		System.out.println( "New email address");
		ret.setEmail( reader.readLine() );
		api.updatePerson(ret);
		
		//Cleanup.
		System.out.println( "Cleanup [Y/N]");
		String confirm = reader.readLine();
		if( confirm.equals( "Y" ))
			api.deletePerson(ret);

	}

}
