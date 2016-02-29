/**
 * 
 */
package ca.mphost.importer;

import java.util.Date;

import ca.mphost.importer.nationbuilder.Event;

/**
 * Demo program to create, update, and delete an event.
 * 
 * @author Bryan Mulvihill
 *
 */
public class CreateEvent {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		if( args.length < 3 ) {
			System.out.println("Usage: ca.mphost.importer.CreateEvent name sandbox apikey");
			//System.exit( 1 );
		}
		String eventName = "Test Event";
		String sandbox = "bmulvihillsandbox";
		String site = "testeda";
		String apikey = "eb243fcc528ad9720ea0ba451c61500f1cbd85c074c463dbe5a164576d95de17";
		
		NationBuilderAPI api = new NationBuilderAPI();
		api.init(sandbox, site, apikey);
		Event event = new Event();
		event.setName(eventName);
		event.setIntro( "Intro");
		event.setTime_zone("Eastern Time (US & Canada");
		event.setStart_time(new Date());
		event.setEnd_time( new Date( System.currentTimeMillis() + 10*60*1000L));
		event.setStatus("unlisted");
		
		Event ret = api.createEvent(event);
		
		
		

	}

}
