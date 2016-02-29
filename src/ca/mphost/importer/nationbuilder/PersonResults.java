/**
 * 
 */
package ca.mphost.importer.nationbuilder;

import ca.mphost.importer.APIResult;

/**
 * Contains a list of people.
 * 
 * @author Bryan Mulvihill
 * @date 2014-04-23
 *
 */
public class PersonResults extends APIResult {

	private Person[] persons;

	/**
	 * @return the persons
	 */
	public Person[] getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(Person[] persons) {
		this.persons = persons;
	}
	
	
}
