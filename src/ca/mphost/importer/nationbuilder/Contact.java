package ca.mphost.importer.nationbuilder;

/**
 * Contains contact information.
 * 
 * @author Bryan Mulvihill
 *
 */
public class Contact {

	private String name;
	private String contact_phone;
	private boolean show_phone;
	private String contact_email;
	private String email;
	private boolean show_email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
	public boolean isShow_phone() {
		return show_phone;
	}
	public void setShow_phone(boolean show_phone) {
		this.show_phone = show_phone;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isShow_email() {
		return show_email;
	}
	public void setShow_email(boolean show_email) {
		this.show_email = show_email;
	}
	
}
