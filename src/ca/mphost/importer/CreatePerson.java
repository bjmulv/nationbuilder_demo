/**
 * 
 */
package ca.mphost.importer;

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
		if( args.length < 3 ) {
			System.out.println("Usage: ca.mphost.importer.CreateEvent name sandbox apikey");
			//System.exit( 1 );
		}
		String sandbox = "bmulvihillsandbox";
		String site = "testeda";
		String apikey = "eb243fcc528ad9720ea0ba451c61500f1cbd85c074c463dbe5a164576d95de17";
		
		NationBuilderAPI api = new NationBuilderAPI();
		api.init(sandbox, site, apikey);
		
		Person person = new Person();
		person.setFirst_name( "Ken");
		person.setLast_name( "Ong" );
		person.setEmail("kenong@test.com");
		person.setSex( "M" );
		
		//Create the person
		Person ret = api.createPerson(person);
		//Update the person
		ret.setEmail( "kenong2@test.com");
		api.updatePerson(ret);
		
		//Cleanup.
		api.deletePerson(ret);

	}

}
