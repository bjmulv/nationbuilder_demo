/**
 * 
 */
package ca.mphost.importer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			System.out.println("Usage: ca.mphost.importer.CreateEvent sandbox site apikey");
			System.exit( 1 );
		}
		String sandbox = args[0];
		String site = args[1];
		String apikey = args[2];
		
		NationBuilderAPI api = new NationBuilderAPI();
		api.init(sandbox, site, apikey);
		Event event = new Event();
		System.out.println("Event name:");
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String eventName = reader.readLine();
		event.setName(eventName);
		System.out.println("Event Intro:");
		String intro = reader.readLine();
		event.setIntro( intro );
		event.setTime_zone( "Eastern Time (US & Canada)" );
		event.setStart_time(new Date());
		event.setEnd_time( new Date( System.currentTimeMillis() + 10*60*1000L));
		event.setStatus("unlisted");
		
		Event ret = api.createEvent(event);
		
	}

}
