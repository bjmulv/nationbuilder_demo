/**
 * 
 */
package ca.mphost.importer.nationbuilder;

import java.util.Date;

import ca.mphost.importer.JsonBuilder;
import ca.mphost.importer.NationBuilderAPI;

/**
 * Event Object.
 * 
 * @author Bryan Mulvihill
 *
 */
public class Event {

	private String status;
	private String name;
	private String intro;
	private String time_zone;
	private String start_time;
	private String end_time;
	private Contact contact;
	private boolean show_guests;
	private int capacity;
	
	public String toJson() {
		JsonBuilder builder = new JsonBuilder();
		builder.addProperty( "name", name );
		builder.addProperty( "status", status );
		builder.addProperty( "intro", intro);
		builder.addProperty( "time_zone", time_zone );
		builder.addProperty( "start_time", start_time );
		builder.addProperty( "end_time", end_time );
		builder.addProperty( "contact", contact);
		builder.addProperty( "show_guests", show_guests);
		if( capacity > 0 )
			builder.addProperty( "capacity", capacity);
		return builder.toJson();
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getTime_zone() {
		return time_zone;
	}
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	
	public void setStart_time( Date date ) {
		this.start_time = NationBuilderAPI.formatDate(date);
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	public void setEnd_time( Date date ) {
		this.end_time = NationBuilderAPI.formatDate(date);
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public boolean isShow_guests() {
		return show_guests;
	}
	public void setShow_guests(boolean show_guests) {
		this.show_guests = show_guests;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
