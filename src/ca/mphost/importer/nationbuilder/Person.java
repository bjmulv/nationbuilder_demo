package ca.mphost.importer.nationbuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ca.mphost.importer.JsonBuilder;

/**
 * A Person as defined by the NationBuilder API.
 *   
 * @author Bryan Mulvihill
 * @date 2014-04-23
 *
 */
public class Person {


    private String active_customer_expires_at; //the date at which to consider a customer no longer active
    private String active_customer_started_at; //the date from which a customer is considered active
    private int author_id; //the resource ID of the person who created this person in the nation
    private Person author; //an abbreviated person resource representing the person who created this person’s record
    private int auto_import_id; //the ID given to a signup when a person is auto imported
    private String availability; //date and time this person is available (such as for volunteer shifts)
    private String banned_at; //the time and date this person was banned
    private Address billing_address; //an address resource representing this person’s billing address
    private String bio; //the bio information that this person provided on their public profile via the “short bio” field
    private String birthdate; //this person's birth date
    private int call_status_id; //the ID of the call status associated with this person
    private String call_status_name; //the name of the call status associated with this person
    private int capital_amount_in_cents; //the balance of this person’s political or social capital, in cents
    private int children_count; //the number of people assigned to this person
    private String church; //the church that this person goes to
    private String city_district; //district field
    private String city_sub_district; //district field
    private int civicrm_id; //this person’s ID from CiviCRM
    private int closed_invoices_amount_in_cents; //the aggregate amount of all this person’s closed invoices in cents
    private int closed_invoices_count; //the number of closed invoices associated with this person
    private int contact_status_id; //ID of a contact status associated with this person. Possible values: 1: answered, 2: badinfo, 9: inaccessible, 3: leftmessage, 4: meaningfulinteraction, 6: notinterested, 7: noanswer, 8: refused, 5: sendinformation, 0: other
    private String contact_status_name; //name of a contact status associated with this person: Possible values: answered, badinfo, inaccessible, leftmessage, meaningfulinteraction, notinterested, noanswer, refused, sendinformation, other
    private boolean could_vote_status; //boolean indicating if this person could vote in an election or not, derived from their election-related IDs
    private String county_district; //district field
    private String county_file_id; //this person’s ID from a county voter file
    private String created_at; //timestamp representing when this person was created in the nation
    private String demo; //Asian, Black, Hispanic, White, Other, Unknown
    private boolean do_not_call; //this is a boolean flag that lets us know if this person is on a do not call list
    private boolean do_not_contact; //this is a boolean flag that lets us know if this person is on a do not contact list
    private int donations_amount_in_cents; //aggregate amount of all this person’s donations in cents
    private int donations_amount_this_cycle_in_cents; //the aggregate value of the donations this person made this cycle in cents
    private int donations_count_this_cycle; //the number of donations this person made this cycle
    private int donations_count; //the total number of donations made by this person
    private int donations_pledged_amount_in_cents; //the aggregate amount of the donations pledged by this person in cents
    private int donations_raised_amount_in_cents; //the aggregate amount of the donations raised by this person in cents, including their own donations
    private int donations_raised_amount_this_cycle_in_cents; //the aggregate value of all donations raised this cycle by this person, including their own
    private int donations_raised_count_this_cycle; //the number of donations raised this cycle by this person, including their own
    private int donations_raised_count; //the total number of donations raised
    private int donations_to_raise_amount_in_cents; //the goal amount of donations for this person to raise in cents
    private int dw_id; //this person’s ID from Catalist
    private boolean email1_is_bad; //boolean indicating if email1 for this person is bad
    private String email1; //an email address for this person
    private boolean email2_is_bad; //boolean indicating if email2 for this person is bad
    private String email2; //an email address for this person
    private boolean email3_is_bad; //boolean indicating if email3 for this person is bad
    private String email3; //an email address for this person
    private boolean email4_is_bad; //boolean indicating if email4 for this person is bad
    private String email4; //an email address for this person
    private boolean email_opt_in; //boolean representing whether this person has opted-in to email correspondence
    private String email; //the person's email address if reading or writing a single address
    private String employer; //the name of the company for which this person works
    private String ethnicity; //the ethnicity of this person as free text
    private int external_id; //a string representing an external identifier for this person
    private Address facebook_address; //this person’s address based on their Facebook profile
    private String facebook_profile_url; //the URL of this person’s Facebook profile
    private String facebook_updated_at; //the date and time this person's Facebook info was last updated
    private String facebook_username; //this person's Facebook username
    private String fax_number; //the fax number associated with this person
    private String federal_district; //district field
    private boolean federal_donotcall; //boolean value indicating if this user is on the U.S. Federal Do Not Call list
    private String fire_district; //district field
    private String first_donated_at; //date and time of this person's first donation
    private String first_fundraised_at; //date and time that this person first raised donation
    private String first_invoice_at; //date and time of this person's first invoice
    private String first_name; //the person's first name and middle names
    private String first_prospect_at; //date and time that this user first became a prospect
    private String first_recruited_at; //date and time that this user was first recruited
    private String first_supporter_at; //date and time that this user became a supporter for the first time
    private String first_volunteer_at; //date and time that this person first volunteered
    private String full_name; //this person’s full name
    private boolean has_facebook; //a boolean representing whether this person has Facebook information
    private Address home_address; //an address resource representing the home address
    private int id; //the NationBuilder ID of the person, specific to the authorized nation
    private int import_id; //the ID associated with this person when they were imported
    private String inferred_party; //the party the person is believed to be associated with
    private String inferred_support_level; //a possible support level
    private int invoice_payments_amount_in_cents; //total invoice payment amount (cents)
    private int invoice_payments_referred_amount_in_cents; //the aggregate amount of invoice payments made by recruits of this person (cents)
    private int invoices_amount_in_cents; //the aggregate amount of all of this person’s invoices (cents)
    private int invoices_count; //the number of invoices this person has
    private boolean is_deceased; //a boolean field that indicates if the person is alive or not
    private boolean is_donor; //a boolean field that indicates if the person has donated
    private boolean is_fundraiser; //a boolean value that indicates if this person has previously fundraised
    private boolean is_ignore_donation_limits; //a boolean that indicates whether this person is not subject to donation limits associated with the nation
    private boolean is_leaderboardable; //a boolean that tells if this person is allowed to show up on the leaderboard
    private boolean is_mobile_bad; //a boolean reflecting whether this person’s cell number is invalid
    private boolean is_possible_duplicate; //a boolean field that indicates if the NationBuilder matching algorithm thinks this person is a match to someone else in the nation
    private boolean is_profile_private; //a boolean that tells if this person’s profile is private
    private boolean is_profile_searchable; //a boolean that tells if this person’s profile is allowed to show up in search results
    private boolean is_prospect; //a boolean field that indicates if this person is a prospect
    private boolean is_supporter; //a boolean field that indicates if this person is a supporter
    private boolean is_survey_question_private; //a boolean field that indicates if this person’s survey responses are private
    private boolean is_twitter_follower; //whether the person is a Twitter follower of one of the nation’s broadcasters
    private boolean is_volunteer; //a boolean field that indicates whether the person has volunteered
    private String judicial_district; //a district field
    private String labour_region; //a district field
    private String language; //this person’s primary language
    private String last_call_id; //the time and date of the last call to this person
    private String last_contacted_at; //the time and date of the last time this person was contacted
    private Person last_contacted_by; //an abbreviated person resource representing the last user who contacted this person
    private String last_donated_at; //the time and date of this person’s last donation
    private String last_fundraised_at; //the time and date of the last time this person fundraised
    private String last_invoice_at; //the time and date of this person’s last invoice
    private String last_name; //this person's last name
    private String last_rule_violation_at; //the time and date of this person’s last rule violation
    private String legal_name; //the full (legal) name of this person
    private String linkedin_id; //this person’s ID from LinkedIn
    private String locale; //the ISO locale that the user has their administrative account set to (US, ES, FR etc.)
    private Address mailing_address; //an address resource representing the mailing address
    private String marital_status; //the person’s marital status
    private String media_market_name; //the name of this person’s media market
    private Address meetup_address; //an address resource based on this person’s profile in Meetup
    private String membership_expires_at; //the time and date that this user’s membership expires
    private String membership_level_name; //the name of the level of this person’s membership
    private String membership_started_at; //the time and date that this user started a membership
    private String middle_name; //this person’s middle name
    private String mobile_normalized; //this person's cell phone number in normalized form
    private boolean mobile_opt_in; //a boolean representing whether the person has opted-in to mobile correspondence
    private String mobile; //this person's cell phone number
    private int nbec_guid; //this person’s ID from the NationBuilder Election Center
    private String nbec_precinct_code; //the unique identifier assigned to this person in the NationBuilder Election Center
    private String ngp_id; //this person’s ID from NGP
    private String note_updated_at; //the date and time the note attached to this person was updated
    private String note; //a note to attach to the person's profile
    private String occupation; //the type of work this person does
    private int outstanding_invoices_amount_in_cents; //the aggregate value of all this person’s outstanding invoices in cents
    private int outstanding_invoices_count; //the number of outstanding invoices this person has
    private int overdue_invoices_count; //the number of overdue invoices this person has
    private String page_slug; //the page this person first signed up from
    private int parent_id; //the NationBuilder ID of this person’s point person
    private Person parent; //an abbreviated person resource representing this person’s point person
    private boolean party_member; //a boolean that tells if this person is a member of a political party
    private String party; //a one-letter code representing provincial parties for nations
    private int pf_strat_id; //a person’s historical ID from PoliticalForce
    private String phone_normalized; //this person's home phone number in normalized form
    private String phone_time; //the time that has been selected as the best time to call this person
    private String phone; //this person's home phone number
    private String precinct_code; //the code of the precinct that this person lives in
    private Integer precinct_id; //the ID of the precinct associated with this person
    private String precinct_name; //the name of the precinct that this person votes in
    private String prefix; //the name prefix of this person, i.e. Mr., Mrs.
    private String previous_party; //the party this person had selected before their current party selection
    private Address primary_address; //an address resource representing the primary address
    private String primary_email_id; //the resource ID of the primary email address associated with this person
    private String priority_level_changed_at; //the date and time that this person’s priority level changed
    private String priority_level; //the priority level associated with this person
    private String profile_content_html; //the profile content for this person’s public profile in HTML
    private String profile_content; //the content for this person’s public profile
    private String profile_headline; //the headline for this person’s public profile
    private int received_capital_amount_in_cents; //the aggregate amount of political capital ever received by this person
    private int recruiter_id; //the ID of the person who recruited this person
    private Person recruiter; //an abbreviated person resource representing the person who recruited this person
    private int recruits_count; //the number of people that were recruited by this person
    private Address registered_address; //an address resource representing the registered address
    private String registered_at; //the date this person registered to become a voter
    private String religion; //this person’s religion
    private int rnc_id; //this person’s ID from the RNC
    private String rnc_regid; //this person’s registration ID from the RNC
    private int rule_violations_count; //the number of times this person has violated one of the nation’s rules
    private String salesforce_id; //this person’s ID from Salesforce
    private String school_district; //a district field
    private String school_sub_district; //a district field
    private String sex; //this person's gender (M, F or O)
    private int spent_capital_amount_in_cents; //the aggregate amount of capital ever spent by this person (in cents)
    private String state_file_id; //this person’s ID from a state voter file
    private String state_lower_district; //a district field
    private String state_upper_district; //a district field
    private String submitted_address; //the address this person submitted
    private String[] subnations; //an array of subnations that this person belongs to
    private String suffix; //the suffix this person uses w/their name, i.e. Jr., Sr. or III
    private String support_level_changed_at; //the time and date that this person’s support level changed
    private String support_level; //the level of support this person has for your nation, expressed as a number between 1 and 5, 1 being Strong support, 5 meaning strong opposition, and 3 meaning undecided.
    private String support_probability_score; //the likelihood that this person will support you at election time
    private String supranational_district; //district field
    private String[] tags; //the tags assigned to this person, as an array of strings; //setting via this API has been deprecated, use the people tags API
    private String turnout_probability_score; //the probability that this person will turn out to vote
    private Address twitter_address; //this person’s location based on their Twitter profile
    private String twitter_description; //the description that this person provided in their Twitter profile
    private int twitter_followers_count; //the number of followers this person has on Twitter
    private int twitter_friends_count; //the number of friends this person has on Twitter
    private String twitter_id; //this person’s ID from Twitter
    private String twitter_location; //an address resource representing this person’s address based on Twitter’s location data
    private String twitter_login; //this person’s Twitter login name
    private String twitter_name; //this person’s Twitter handle, e.g. FoobarSoftwares
    private String twitter_updated_at; //the last time this person’s Twitter record was updated
    private String twitter_website; //the URL of the website that this person included in their Twitter profile
    private String unsubscribed_at; //the date/time that this person unsubscribed from emails
    private String updated_at; //the timestamp representing when this person was last updated
    
    public String toJson() {
   		JsonBuilder builder = new JsonBuilder();
   		Method[] methods = getClass().getMethods();
   		Integer zero = 0;
   		for( Method method : methods ) {
   			if( method.getName().startsWith( "get" ) && method.getParameterTypes().length == 0 ) {
   				try {
   					Object ret = method.invoke(this);
   					String name = method.getName().toLowerCase();
   					String fieldName = name.charAt( 3 ) + name.substring( 4 );
   					if( ret != null ) {
   						if( ret.getClass().equals( Integer.class ) && ret.equals( zero ) ) 
   							continue;
   						builder.addProperty( fieldName, ret);
   					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
   			}
   		}
   		return builder.toJson();
    }
    /**
	 * @return the active_customer_expires_at
	 */
	public String getActive_customer_expires_at() {
		return active_customer_expires_at;
	}
	/**
	 * @param active_customer_expires_at the active_customer_expires_at to set
	 */
	public void setActive_customer_expires_at(String active_customer_expires_at) {
		this.active_customer_expires_at = active_customer_expires_at;
	}
	/**
	 * @return the active_customer_started_at
	 */
	public String getActive_customer_started_at() {
		return active_customer_started_at;
	}
	/**
	 * @param active_customer_started_at the active_customer_started_at to set
	 */
	public void setActive_customer_started_at(String active_customer_started_at) {
		this.active_customer_started_at = active_customer_started_at;
	}
	/**
	 * @return the author_id
	 */
	public int getAuthor_id() {
		return author_id;
	}
	/**
	 * @param author_id the author_id to set
	 */
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	/**
	 * @return the author
	 */
	public Person getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(Person author) {
		this.author = author;
	}
	/**
	 * @return the auto_import_id
	 */
	public int getAuto_import_id() {
		return auto_import_id;
	}
	/**
	 * @param auto_import_id the auto_import_id to set
	 */
	public void setAuto_import_id(int auto_import_id) {
		this.auto_import_id = auto_import_id;
	}
	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}
	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	/**
	 * @return the banned_at
	 */
	public String getBanned_at() {
		return banned_at;
	}
	/**
	 * @param banned_at the banned_at to set
	 */
	public void setBanned_at(String banned_at) {
		this.banned_at = banned_at;
	}
	/**
	 * @return the billing_address
	 */
	public Address getBilling_address() {
		return billing_address;
	}
	/**
	 * @param billing_address the billing_address to set
	 */
	public void setBilling_address(Address billing_address) {
		this.billing_address = billing_address;
	}
	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}
	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}
	/**
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}
	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	/**
	 * @return the call_status_id
	 */
	public int getCall_status_id() {
		return call_status_id;
	}
	/**
	 * @param call_status_id the call_status_id to set
	 */
	public void setCall_status_id(int call_status_id) {
		this.call_status_id = call_status_id;
	}
	/**
	 * @return the call_status_name
	 */
	public String getCall_status_name() {
		return call_status_name;
	}
	/**
	 * @param call_status_name the call_status_name to set
	 */
	public void setCall_status_name(String call_status_name) {
		this.call_status_name = call_status_name;
	}
	/**
	 * @return the capital_amount_in_cents
	 */
	public int getCapital_amount_in_cents() {
		return capital_amount_in_cents;
	}
	/**
	 * @param capital_amount_in_cents the capital_amount_in_cents to set
	 */
	public void setCapital_amount_in_cents(int capital_amount_in_cents) {
		this.capital_amount_in_cents = capital_amount_in_cents;
	}
	/**
	 * @return the children_count
	 */
	public int getChildren_count() {
		return children_count;
	}
	/**
	 * @param children_count the children_count to set
	 */
	public void setChildren_count(int children_count) {
		this.children_count = children_count;
	}
	/**
	 * @return the church
	 */
	public String getChurch() {
		return church;
	}
	/**
	 * @param church the church to set
	 */
	public void setChurch(String church) {
		this.church = church;
	}
	/**
	 * @return the city_district
	 */
	public String getCity_district() {
		return city_district;
	}
	/**
	 * @param city_district the city_district to set
	 */
	public void setCity_district(String city_district) {
		this.city_district = city_district;
	}
	/**
	 * @return the city_sub_district
	 */
	public String getCity_sub_district() {
		return city_sub_district;
	}
	/**
	 * @param city_sub_district the city_sub_district to set
	 */
	public void setCity_sub_district(String city_sub_district) {
		this.city_sub_district = city_sub_district;
	}
	/**
	 * @return the civicrm_id
	 */
	public int getCivicrm_id() {
		return civicrm_id;
	}
	/**
	 * @param civicrm_id the civicrm_id to set
	 */
	public void setCivicrm_id(int civicrm_id) {
		this.civicrm_id = civicrm_id;
	}
	/**
	 * @return the closed_invoices_amount_in_cents
	 */
	public int getClosed_invoices_amount_in_cents() {
		return closed_invoices_amount_in_cents;
	}
	/**
	 * @param closed_invoices_amount_in_cents the closed_invoices_amount_in_cents to set
	 */
	public void setClosed_invoices_amount_in_cents(
			int closed_invoices_amount_in_cents) {
		this.closed_invoices_amount_in_cents = closed_invoices_amount_in_cents;
	}
	/**
	 * @return the closed_invoices_count
	 */
	public int getClosed_invoices_count() {
		return closed_invoices_count;
	}
	/**
	 * @param closed_invoices_count the closed_invoices_count to set
	 */
	public void setClosed_invoices_count(int closed_invoices_count) {
		this.closed_invoices_count = closed_invoices_count;
	}
	/**
	 * @return the contact_status_id
	 */
	public int getContact_status_id() {
		return contact_status_id;
	}
	/**
	 * @param contact_status_id the contact_status_id to set
	 */
	public void setContact_status_id(int contact_status_id) {
		this.contact_status_id = contact_status_id;
	}
	/**
	 * @return the contact_status_name
	 */
	public String getContact_status_name() {
		return contact_status_name;
	}
	/**
	 * @param contact_status_name the contact_status_name to set
	 */
	public void setContact_status_name(String contact_status_name) {
		this.contact_status_name = contact_status_name;
	}
	/**
	 * @return the could_vote_status
	 */
	public boolean isCould_vote_status() {
		return could_vote_status;
	}
	/**
	 * @param could_vote_status the could_vote_status to set
	 */
	public void setCould_vote_status(boolean could_vote_status) {
		this.could_vote_status = could_vote_status;
	}
	/**
	 * @return the county_district
	 */
	public String getCounty_district() {
		return county_district;
	}
	/**
	 * @param county_district the county_district to set
	 */
	public void setCounty_district(String county_district) {
		this.county_district = county_district;
	}
	/**
	 * @return the county_file_id
	 */
	public String getCounty_file_id() {
		return county_file_id;
	}
	/**
	 * @param county_file_id the county_file_id to set
	 */
	public void setCounty_file_id(String county_file_id) {
		this.county_file_id = county_file_id;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the demo
	 */
	public String getDemo() {
		return demo;
	}
	/**
	 * @param demo the demo to set
	 */
	public void setDemo(String demo) {
		this.demo = demo;
	}
	/**
	 * @return the do_not_call
	 */
	public boolean isDo_not_call() {
		return do_not_call;
	}
	/**
	 * @param do_not_call the do_not_call to set
	 */
	public void setDo_not_call(boolean do_not_call) {
		this.do_not_call = do_not_call;
	}
	/**
	 * @return the do_not_contact
	 */
	public boolean isDo_not_contact() {
		return do_not_contact;
	}
	/**
	 * @param do_not_contact the do_not_contact to set
	 */
	public void setDo_not_contact(boolean do_not_contact) {
		this.do_not_contact = do_not_contact;
	}
	/**
	 * @return the donations_amount_in_cents
	 */
	public int getDonations_amount_in_cents() {
		return donations_amount_in_cents;
	}
	/**
	 * @param donations_amount_in_cents the donations_amount_in_cents to set
	 */
	public void setDonations_amount_in_cents(int donations_amount_in_cents) {
		this.donations_amount_in_cents = donations_amount_in_cents;
	}
	/**
	 * @return the donations_amount_this_cycle_in_cents
	 */
	public int getDonations_amount_this_cycle_in_cents() {
		return donations_amount_this_cycle_in_cents;
	}
	/**
	 * @param donations_amount_this_cycle_in_cents the donations_amount_this_cycle_in_cents to set
	 */
	public void setDonations_amount_this_cycle_in_cents(
			int donations_amount_this_cycle_in_cents) {
		this.donations_amount_this_cycle_in_cents = donations_amount_this_cycle_in_cents;
	}
	/**
	 * @return the donations_count_this_cycle
	 */
	public int getDonations_count_this_cycle() {
		return donations_count_this_cycle;
	}
	/**
	 * @param donations_count_this_cycle the donations_count_this_cycle to set
	 */
	public void setDonations_count_this_cycle(int donations_count_this_cycle) {
		this.donations_count_this_cycle = donations_count_this_cycle;
	}
	/**
	 * @return the donations_count
	 */
	public int getDonations_count() {
		return donations_count;
	}
	/**
	 * @param donations_count the donations_count to set
	 */
	public void setDonations_count(int donations_count) {
		this.donations_count = donations_count;
	}
	/**
	 * @return the donations_pledged_amount_in_cents
	 */
	public int getDonations_pledged_amount_in_cents() {
		return donations_pledged_amount_in_cents;
	}
	/**
	 * @param donations_pledged_amount_in_cents the donations_pledged_amount_in_cents to set
	 */
	public void setDonations_pledged_amount_in_cents(
			int donations_pledged_amount_in_cents) {
		this.donations_pledged_amount_in_cents = donations_pledged_amount_in_cents;
	}
	/**
	 * @return the donations_raised_amount_in_cents
	 */
	public int getDonations_raised_amount_in_cents() {
		return donations_raised_amount_in_cents;
	}
	/**
	 * @param donations_raised_amount_in_cents the donations_raised_amount_in_cents to set
	 */
	public void setDonations_raised_amount_in_cents(
			int donations_raised_amount_in_cents) {
		this.donations_raised_amount_in_cents = donations_raised_amount_in_cents;
	}
	/**
	 * @return the donations_raised_amount_this_cycle_in_cents
	 */
	public int getDonations_raised_amount_this_cycle_in_cents() {
		return donations_raised_amount_this_cycle_in_cents;
	}
	/**
	 * @param donations_raised_amount_this_cycle_in_cents the donations_raised_amount_this_cycle_in_cents to set
	 */
	public void setDonations_raised_amount_this_cycle_in_cents(
			int donations_raised_amount_this_cycle_in_cents) {
		this.donations_raised_amount_this_cycle_in_cents = donations_raised_amount_this_cycle_in_cents;
	}
	/**
	 * @return the donations_raised_count_this_cycle
	 */
	public int getDonations_raised_count_this_cycle() {
		return donations_raised_count_this_cycle;
	}
	/**
	 * @param donations_raised_count_this_cycle the donations_raised_count_this_cycle to set
	 */
	public void setDonations_raised_count_this_cycle(
			int donations_raised_count_this_cycle) {
		this.donations_raised_count_this_cycle = donations_raised_count_this_cycle;
	}
	/**
	 * @return the donations_raised_count
	 */
	public int getDonations_raised_count() {
		return donations_raised_count;
	}
	/**
	 * @param donations_raised_count the donations_raised_count to set
	 */
	public void setDonations_raised_count(int donations_raised_count) {
		this.donations_raised_count = donations_raised_count;
	}
	/**
	 * @return the donations_to_raise_amount_in_cents
	 */
	public int getDonations_to_raise_amount_in_cents() {
		return donations_to_raise_amount_in_cents;
	}
	/**
	 * @param donations_to_raise_amount_in_cents the donations_to_raise_amount_in_cents to set
	 */
	public void setDonations_to_raise_amount_in_cents(
			int donations_to_raise_amount_in_cents) {
		this.donations_to_raise_amount_in_cents = donations_to_raise_amount_in_cents;
	}
	/**
	 * @return the dw_id
	 */
	public int getDw_id() {
		return dw_id;
	}
	/**
	 * @param dw_id the dw_id to set
	 */
	public void setDw_id(int dw_id) {
		this.dw_id = dw_id;
	}
	/**
	 * @return the email1_is_bad
	 */
	public boolean isEmail1_is_bad() {
		return email1_is_bad;
	}
	/**
	 * @param email1_is_bad the email1_is_bad to set
	 */
	public void setEmail1_is_bad(boolean email1_is_bad) {
		this.email1_is_bad = email1_is_bad;
	}
	/**
	 * @return the email1
	 */
	public String getEmail1() {
		return email1;
	}
	/**
	 * @param email1 the email1 to set
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	/**
	 * @return the email2_is_bad
	 */
	public boolean isEmail2_is_bad() {
		return email2_is_bad;
	}
	/**
	 * @param email2_is_bad the email2_is_bad to set
	 */
	public void setEmail2_is_bad(boolean email2_is_bad) {
		this.email2_is_bad = email2_is_bad;
	}
	/**
	 * @return the email2
	 */
	public String getEmail2() {
		return email2;
	}
	/**
	 * @param email2 the email2 to set
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	/**
	 * @return the email3_is_bad
	 */
	public boolean isEmail3_is_bad() {
		return email3_is_bad;
	}
	/**
	 * @param email3_is_bad the email3_is_bad to set
	 */
	public void setEmail3_is_bad(boolean email3_is_bad) {
		this.email3_is_bad = email3_is_bad;
	}
	/**
	 * @return the email3
	 */
	public String getEmail3() {
		return email3;
	}
	/**
	 * @param email3 the email3 to set
	 */
	public void setEmail3(String email3) {
		this.email3 = email3;
	}
	/**
	 * @return the email4_is_bad
	 */
	public boolean isEmail4_is_bad() {
		return email4_is_bad;
	}
	/**
	 * @param email4_is_bad the email4_is_bad to set
	 */
	public void setEmail4_is_bad(boolean email4_is_bad) {
		this.email4_is_bad = email4_is_bad;
	}
	/**
	 * @return the email4
	 */
	public String getEmail4() {
		return email4;
	}
	/**
	 * @param email4 the email4 to set
	 */
	public void setEmail4(String email4) {
		this.email4 = email4;
	}
	/**
	 * @return the email_opt_in
	 */
	public boolean isEmail_opt_in() {
		return email_opt_in;
	}
	/**
	 * @param email_opt_in the email_opt_in to set
	 */
	public void setEmail_opt_in(boolean email_opt_in) {
		this.email_opt_in = email_opt_in;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the employer
	 */
	public String getEmployer() {
		return employer;
	}
	/**
	 * @param employer the employer to set
	 */
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	/**
	 * @return the ethnicity
	 */
	public String getEthnicity() {
		return ethnicity;
	}
	/**
	 * @param ethnicity the ethnicity to set
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	/**
	 * @return the external_id
	 */
	public int getExternal_id() {
		return external_id;
	}
	/**
	 * @param external_id the external_id to set
	 */
	public void setExternal_id(int external_id) {
		this.external_id = external_id;
	}
	/**
	 * @return the facebook_address
	 */
	public Address getFacebook_address() {
		return facebook_address;
	}
	/**
	 * @param facebook_address the facebook_address to set
	 */
	public void setFacebook_address(Address facebook_address) {
		this.facebook_address = facebook_address;
	}
	/**
	 * @return the facebook_profile_url
	 */
	public String getFacebook_profile_url() {
		return facebook_profile_url;
	}
	/**
	 * @param facebook_profile_url the facebook_profile_url to set
	 */
	public void setFacebook_profile_url(String facebook_profile_url) {
		this.facebook_profile_url = facebook_profile_url;
	}
	/**
	 * @return the facebook_updated_at
	 */
	public String getFacebook_updated_at() {
		return facebook_updated_at;
	}
	/**
	 * @param facebook_updated_at the facebook_updated_at to set
	 */
	public void setFacebook_updated_at(String facebook_updated_at) {
		this.facebook_updated_at = facebook_updated_at;
	}
	/**
	 * @return the facebook_username
	 */
	public String getFacebook_username() {
		return facebook_username;
	}
	/**
	 * @param facebook_username the facebook_username to set
	 */
	public void setFacebook_username(String facebook_username) {
		this.facebook_username = facebook_username;
	}
	/**
	 * @return the fax_number
	 */
	public String getFax_number() {
		return fax_number;
	}
	/**
	 * @param fax_number the fax_number to set
	 */
	public void setFax_number(String fax_number) {
		this.fax_number = fax_number;
	}
	/**
	 * @return the federal_district
	 */
	public String getFederal_district() {
		return federal_district;
	}
	/**
	 * @param federal_district the federal_district to set
	 */
	public void setFederal_district(String federal_district) {
		this.federal_district = federal_district;
	}
	/**
	 * @return the federal_donotcall
	 */
	public boolean isFederal_donotcall() {
		return federal_donotcall;
	}
	/**
	 * @param federal_donotcall the federal_donotcall to set
	 */
	public void setFederal_donotcall(boolean federal_donotcall) {
		this.federal_donotcall = federal_donotcall;
	}
	/**
	 * @return the fire_district
	 */
	public String getFire_district() {
		return fire_district;
	}
	/**
	 * @param fire_district the fire_district to set
	 */
	public void setFire_district(String fire_district) {
		this.fire_district = fire_district;
	}
	/**
	 * @return the first_donated_at
	 */
	public String getFirst_donated_at() {
		return first_donated_at;
	}
	/**
	 * @param first_donated_at the first_donated_at to set
	 */
	public void setFirst_donated_at(String first_donated_at) {
		this.first_donated_at = first_donated_at;
	}
	/**
	 * @return the first_fundraised_at
	 */
	public String getFirst_fundraised_at() {
		return first_fundraised_at;
	}
	/**
	 * @param first_fundraised_at the first_fundraised_at to set
	 */
	public void setFirst_fundraised_at(String first_fundraised_at) {
		this.first_fundraised_at = first_fundraised_at;
	}
	/**
	 * @return the first_invoice_at
	 */
	public String getFirst_invoice_at() {
		return first_invoice_at;
	}
	/**
	 * @param first_invoice_at the first_invoice_at to set
	 */
	public void setFirst_invoice_at(String first_invoice_at) {
		this.first_invoice_at = first_invoice_at;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the first_prospect_at
	 */
	public String getFirst_prospect_at() {
		return first_prospect_at;
	}
	/**
	 * @param first_prospect_at the first_prospect_at to set
	 */
	public void setFirst_prospect_at(String first_prospect_at) {
		this.first_prospect_at = first_prospect_at;
	}
	/**
	 * @return the first_recruited_at
	 */
	public String getFirst_recruited_at() {
		return first_recruited_at;
	}
	/**
	 * @param first_recruited_at the first_recruited_at to set
	 */
	public void setFirst_recruited_at(String first_recruited_at) {
		this.first_recruited_at = first_recruited_at;
	}
	/**
	 * @return the first_supporter_at
	 */
	public String getFirst_supporter_at() {
		return first_supporter_at;
	}
	/**
	 * @param first_supporter_at the first_supporter_at to set
	 */
	public void setFirst_supporter_at(String first_supporter_at) {
		this.first_supporter_at = first_supporter_at;
	}
	/**
	 * @return the first_volunteer_at
	 */
	public String getFirst_volunteer_at() {
		return first_volunteer_at;
	}
	/**
	 * @param first_volunteer_at the first_volunteer_at to set
	 */
	public void setFirst_volunteer_at(String first_volunteer_at) {
		this.first_volunteer_at = first_volunteer_at;
	}
	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * @param full_name the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	/**
	 * @return the has_facebook
	 */
	public boolean isHas_facebook() {
		return has_facebook;
	}
	/**
	 * @param has_facebook the has_facebook to set
	 */
	public void setHas_facebook(boolean has_facebook) {
		this.has_facebook = has_facebook;
	}
	/**
	 * @return the home_address
	 */
	public Address getHome_address() {
		return home_address;
	}
	/**
	 * @param home_address the home_address to set
	 */
	public void setHome_address(Address home_address) {
		this.home_address = home_address;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the import_id
	 */
	public int getImport_id() {
		return import_id;
	}
	/**
	 * @param import_id the import_id to set
	 */
	public void setImport_id(int import_id) {
		this.import_id = import_id;
	}
	/**
	 * @return the inferred_party
	 */
	public String getInferred_party() {
		return inferred_party;
	}
	/**
	 * @param inferred_party the inferred_party to set
	 */
	public void setInferred_party(String inferred_party) {
		this.inferred_party = inferred_party;
	}
	/**
	 * @return the inferred_support_level
	 */
	public String getInferred_support_level() {
		return inferred_support_level;
	}
	/**
	 * @param inferred_support_level the inferred_support_level to set
	 */
	public void setInferred_support_level(String inferred_support_level) {
		this.inferred_support_level = inferred_support_level;
	}
	/**
	 * @return the invoice_payments_amount_in_cents
	 */
	public int getInvoice_payments_amount_in_cents() {
		return invoice_payments_amount_in_cents;
	}
	/**
	 * @param invoice_payments_amount_in_cents the invoice_payments_amount_in_cents to set
	 */
	public void setInvoice_payments_amount_in_cents(
			int invoice_payments_amount_in_cents) {
		this.invoice_payments_amount_in_cents = invoice_payments_amount_in_cents;
	}
	/**
	 * @return the invoice_payments_referred_amount_in_cents
	 */
	public int getInvoice_payments_referred_amount_in_cents() {
		return invoice_payments_referred_amount_in_cents;
	}
	/**
	 * @param invoice_payments_referred_amount_in_cents the invoice_payments_referred_amount_in_cents to set
	 */
	public void setInvoice_payments_referred_amount_in_cents(
			int invoice_payments_referred_amount_in_cents) {
		this.invoice_payments_referred_amount_in_cents = invoice_payments_referred_amount_in_cents;
	}
	/**
	 * @return the invoices_amount_in_cents
	 */
	public int getInvoices_amount_in_cents() {
		return invoices_amount_in_cents;
	}
	/**
	 * @param invoices_amount_in_cents the invoices_amount_in_cents to set
	 */
	public void setInvoices_amount_in_cents(int invoices_amount_in_cents) {
		this.invoices_amount_in_cents = invoices_amount_in_cents;
	}
	/**
	 * @return the invoices_count
	 */
	public int getInvoices_count() {
		return invoices_count;
	}
	/**
	 * @param invoices_count the invoices_count to set
	 */
	public void setInvoices_count(int invoices_count) {
		this.invoices_count = invoices_count;
	}
	/**
	 * @return the is_deceased
	 */
	public boolean isIs_deceased() {
		return is_deceased;
	}
	/**
	 * @param is_deceased the is_deceased to set
	 */
	public void setIs_deceased(boolean is_deceased) {
		this.is_deceased = is_deceased;
	}
	/**
	 * @return the is_donor
	 */
	public boolean isIs_donor() {
		return is_donor;
	}
	/**
	 * @param is_donor the is_donor to set
	 */
	public void setIs_donor(boolean is_donor) {
		this.is_donor = is_donor;
	}
	/**
	 * @return the is_fundraiser
	 */
	public boolean isIs_fundraiser() {
		return is_fundraiser;
	}
	/**
	 * @param is_fundraiser the is_fundraiser to set
	 */
	public void setIs_fundraiser(boolean is_fundraiser) {
		this.is_fundraiser = is_fundraiser;
	}
	/**
	 * @return the is_ignore_donation_limits
	 */
	public boolean isIs_ignore_donation_limits() {
		return is_ignore_donation_limits;
	}
	/**
	 * @param is_ignore_donation_limits the is_ignore_donation_limits to set
	 */
	public void setIs_ignore_donation_limits(boolean is_ignore_donation_limits) {
		this.is_ignore_donation_limits = is_ignore_donation_limits;
	}
	/**
	 * @return the is_leaderboardable
	 */
	public boolean isIs_leaderboardable() {
		return is_leaderboardable;
	}
	/**
	 * @param is_leaderboardable the is_leaderboardable to set
	 */
	public void setIs_leaderboardable(boolean is_leaderboardable) {
		this.is_leaderboardable = is_leaderboardable;
	}
	/**
	 * @return the is_mobile_bad
	 */
	public boolean isIs_mobile_bad() {
		return is_mobile_bad;
	}
	/**
	 * @param is_mobile_bad the is_mobile_bad to set
	 */
	public void setIs_mobile_bad(boolean is_mobile_bad) {
		this.is_mobile_bad = is_mobile_bad;
	}
	/**
	 * @return the is_possible_duplicate
	 */
	public boolean isIs_possible_duplicate() {
		return is_possible_duplicate;
	}
	/**
	 * @param is_possible_duplicate the is_possible_duplicate to set
	 */
	public void setIs_possible_duplicate(boolean is_possible_duplicate) {
		this.is_possible_duplicate = is_possible_duplicate;
	}
	/**
	 * @return the is_profile_private
	 */
	public boolean isIs_profile_private() {
		return is_profile_private;
	}
	/**
	 * @param is_profile_private the is_profile_private to set
	 */
	public void setIs_profile_private(boolean is_profile_private) {
		this.is_profile_private = is_profile_private;
	}
	/**
	 * @return the is_profile_searchable
	 */
	public boolean isIs_profile_searchable() {
		return is_profile_searchable;
	}
	/**
	 * @param is_profile_searchable the is_profile_searchable to set
	 */
	public void setIs_profile_searchable(boolean is_profile_searchable) {
		this.is_profile_searchable = is_profile_searchable;
	}
	/**
	 * @return the is_prospect
	 */
	public boolean isIs_prospect() {
		return is_prospect;
	}
	/**
	 * @param is_prospect the is_prospect to set
	 */
	public void setIs_prospect(boolean is_prospect) {
		this.is_prospect = is_prospect;
	}
	/**
	 * @return the is_supporter
	 */
	public boolean isIs_supporter() {
		return is_supporter;
	}
	/**
	 * @param is_supporter the is_supporter to set
	 */
	public void setIs_supporter(boolean is_supporter) {
		this.is_supporter = is_supporter;
	}
	/**
	 * @return the is_survey_question_private
	 */
	public boolean isIs_survey_question_private() {
		return is_survey_question_private;
	}
	/**
	 * @param is_survey_question_private the is_survey_question_private to set
	 */
	public void setIs_survey_question_private(boolean is_survey_question_private) {
		this.is_survey_question_private = is_survey_question_private;
	}
	/**
	 * @return the is_twitter_follower
	 */
	public boolean isIs_twitter_follower() {
		return is_twitter_follower;
	}
	/**
	 * @param is_twitter_follower the is_twitter_follower to set
	 */
	public void setIs_twitter_follower(boolean is_twitter_follower) {
		this.is_twitter_follower = is_twitter_follower;
	}
	/**
	 * @return the is_volunteer
	 */
	public boolean isIs_volunteer() {
		return is_volunteer;
	}
	/**
	 * @param is_volunteer the is_volunteer to set
	 */
	public void setIs_volunteer(boolean is_volunteer) {
		this.is_volunteer = is_volunteer;
	}
	/**
	 * @return the judicial_district
	 */
	public String getJudicial_district() {
		return judicial_district;
	}
	/**
	 * @param judicial_district the judicial_district to set
	 */
	public void setJudicial_district(String judicial_district) {
		this.judicial_district = judicial_district;
	}
	/**
	 * @return the labour_region
	 */
	public String getLabour_region() {
		return labour_region;
	}
	/**
	 * @param labour_region the labour_region to set
	 */
	public void setLabour_region(String labour_region) {
		this.labour_region = labour_region;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the last_call_id
	 */
	public String getLast_call_id() {
		return last_call_id;
	}
	/**
	 * @param last_call_id the last_call_id to set
	 */
	public void setLast_call_id(String last_call_id) {
		this.last_call_id = last_call_id;
	}
	/**
	 * @return the last_contacted_at
	 */
	public String getLast_contacted_at() {
		return last_contacted_at;
	}
	/**
	 * @param last_contacted_at the last_contacted_at to set
	 */
	public void setLast_contacted_at(String last_contacted_at) {
		this.last_contacted_at = last_contacted_at;
	}
	/**
	 * @return the last_contacted_by
	 */
	public Person getLast_contacted_by() {
		return last_contacted_by;
	}
	/**
	 * @param last_contacted_by the last_contacted_by to set
	 */
	public void setLast_contacted_by(Person last_contacted_by) {
		this.last_contacted_by = last_contacted_by;
	}
	/**
	 * @return the last_donated_at
	 */
	public String getLast_donated_at() {
		return last_donated_at;
	}
	/**
	 * @param last_donated_at the last_donated_at to set
	 */
	public void setLast_donated_at(String last_donated_at) {
		this.last_donated_at = last_donated_at;
	}
	/**
	 * @return the last_fundraised_at
	 */
	public String getLast_fundraised_at() {
		return last_fundraised_at;
	}
	/**
	 * @param last_fundraised_at the last_fundraised_at to set
	 */
	public void setLast_fundraised_at(String last_fundraised_at) {
		this.last_fundraised_at = last_fundraised_at;
	}
	/**
	 * @return the last_invoice_at
	 */
	public String getLast_invoice_at() {
		return last_invoice_at;
	}
	/**
	 * @param last_invoice_at the last_invoice_at to set
	 */
	public void setLast_invoice_at(String last_invoice_at) {
		this.last_invoice_at = last_invoice_at;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the last_rule_violation_at
	 */
	public String getLast_rule_violation_at() {
		return last_rule_violation_at;
	}
	/**
	 * @param last_rule_violation_at the last_rule_violation_at to set
	 */
	public void setLast_rule_violation_at(String last_rule_violation_at) {
		this.last_rule_violation_at = last_rule_violation_at;
	}
	/**
	 * @return the legal_name
	 */
	public String getLegal_name() {
		return legal_name;
	}
	/**
	 * @param legal_name the legal_name to set
	 */
	public void setLegal_name(String legal_name) {
		this.legal_name = legal_name;
	}
	/**
	 * @return the linkedin_id
	 */
	public String getLinkedin_id() {
		return linkedin_id;
	}
	/**
	 * @param linkedin_id the linkedin_id to set
	 */
	public void setLinkedin_id(String linkedin_id) {
		this.linkedin_id = linkedin_id;
	}
	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}
	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	/**
	 * @return the mailing_address
	 */
	public Address getMailing_address() {
		return mailing_address;
	}
	/**
	 * @param mailing_address the mailing_address to set
	 */
	public void setMailing_address(Address mailing_address) {
		this.mailing_address = mailing_address;
	}
	/**
	 * @return the marital_status
	 */
	public String getMarital_status() {
		return marital_status;
	}
	/**
	 * @param marital_status the marital_status to set
	 */
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	/**
	 * @return the media_market_name
	 */
	public String getMedia_market_name() {
		return media_market_name;
	}
	/**
	 * @param media_market_name the media_market_name to set
	 */
	public void setMedia_market_name(String media_market_name) {
		this.media_market_name = media_market_name;
	}
	/**
	 * @return the meetup_address
	 */
	public Address getMeetup_address() {
		return meetup_address;
	}
	/**
	 * @param meetup_address the meetup_address to set
	 */
	public void setMeetup_address(Address meetup_address) {
		this.meetup_address = meetup_address;
	}
	/**
	 * @return the membership_expires_at
	 */
	public String getMembership_expires_at() {
		return membership_expires_at;
	}
	/**
	 * @param membership_expires_at the membership_expires_at to set
	 */
	public void setMembership_expires_at(String membership_expires_at) {
		this.membership_expires_at = membership_expires_at;
	}
	/**
	 * @return the membership_level_name
	 */
	public String getMembership_level_name() {
		return membership_level_name;
	}
	/**
	 * @param membership_level_name the membership_level_name to set
	 */
	public void setMembership_level_name(String membership_level_name) {
		this.membership_level_name = membership_level_name;
	}
	/**
	 * @return the membership_started_at
	 */
	public String getMembership_started_at() {
		return membership_started_at;
	}
	/**
	 * @param membership_started_at the membership_started_at to set
	 */
	public void setMembership_started_at(String membership_started_at) {
		this.membership_started_at = membership_started_at;
	}
	/**
	 * @return the middle_name
	 */
	public String getMiddle_name() {
		return middle_name;
	}
	/**
	 * @param middle_name the middle_name to set
	 */
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	/**
	 * @return the mobile_normalized
	 */
	public String getMobile_normalized() {
		return mobile_normalized;
	}
	/**
	 * @param mobile_normalized the mobile_normalized to set
	 */
	public void setMobile_normalized(String mobile_normalized) {
		this.mobile_normalized = mobile_normalized;
	}
	/**
	 * @return the mobile_opt_in
	 */
	public boolean isMobile_opt_in() {
		return mobile_opt_in;
	}
	/**
	 * @param mobile_opt_in the mobile_opt_in to set
	 */
	public void setMobile_opt_in(boolean mobile_opt_in) {
		this.mobile_opt_in = mobile_opt_in;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the nbec_guid
	 */
	public int getNbec_guid() {
		return nbec_guid;
	}
	/**
	 * @param nbec_guid the nbec_guid to set
	 */
	public void setNbec_guid(int nbec_guid) {
		this.nbec_guid = nbec_guid;
	}
	/**
	 * @return the nbec_precinct_code
	 */
	public String getNbec_precinct_code() {
		return nbec_precinct_code;
	}
	/**
	 * @param nbec_precinct_code the nbec_precinct_code to set
	 */
	public void setNbec_precinct_code(String nbec_precinct_code) {
		this.nbec_precinct_code = nbec_precinct_code;
	}
	/**
	 * @return the ngp_id
	 */
	public String getNgp_id() {
		return ngp_id;
	}
	/**
	 * @param ngp_id the ngp_id to set
	 */
	public void setNgp_id(String ngp_id) {
		this.ngp_id = ngp_id;
	}
	/**
	 * @return the note_updated_at
	 */
	public String getNote_updated_at() {
		return note_updated_at;
	}
	/**
	 * @param note_updated_at the note_updated_at to set
	 */
	public void setNote_updated_at(String note_updated_at) {
		this.note_updated_at = note_updated_at;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	/**
	 * @return the outstanding_invoices_amount_in_cents
	 */
	public int getOutstanding_invoices_amount_in_cents() {
		return outstanding_invoices_amount_in_cents;
	}
	/**
	 * @param outstanding_invoices_amount_in_cents the outstanding_invoices_amount_in_cents to set
	 */
	public void setOutstanding_invoices_amount_in_cents(
			int outstanding_invoices_amount_in_cents) {
		this.outstanding_invoices_amount_in_cents = outstanding_invoices_amount_in_cents;
	}
	/**
	 * @return the outstanding_invoices_count
	 */
	public int getOutstanding_invoices_count() {
		return outstanding_invoices_count;
	}
	/**
	 * @param outstanding_invoices_count the outstanding_invoices_count to set
	 */
	public void setOutstanding_invoices_count(int outstanding_invoices_count) {
		this.outstanding_invoices_count = outstanding_invoices_count;
	}
	/**
	 * @return the overdue_invoices_count
	 */
	public int getOverdue_invoices_count() {
		return overdue_invoices_count;
	}
	/**
	 * @param overdue_invoices_count the overdue_invoices_count to set
	 */
	public void setOverdue_invoices_count(int overdue_invoices_count) {
		this.overdue_invoices_count = overdue_invoices_count;
	}
	/**
	 * @return the page_slug
	 */
	public String getPage_slug() {
		return page_slug;
	}
	/**
	 * @param page_slug the page_slug to set
	 */
	public void setPage_slug(String page_slug) {
		this.page_slug = page_slug;
	}
	/**
	 * @return the parent_id
	 */
	public int getParent_id() {
		return parent_id;
	}
	/**
	 * @param parent_id the parent_id to set
	 */
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	/**
	 * @return the parent
	 */
	public Person getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Person parent) {
		this.parent = parent;
	}
	/**
	 * @return the party_member
	 */
	public boolean isParty_member() {
		return party_member;
	}
	/**
	 * @param party_member the party_member to set
	 */
	public void setParty_member(boolean party_member) {
		this.party_member = party_member;
	}
	/**
	 * @return the party
	 */
	public String getParty() {
		return party;
	}
	/**
	 * @param party the party to set
	 */
	public void setParty(String party) {
		this.party = party;
	}
	/**
	 * @return the pf_strat_id
	 */
	public int getPf_strat_id() {
		return pf_strat_id;
	}
	/**
	 * @param pf_strat_id the pf_strat_id to set
	 */
	public void setPf_strat_id(int pf_strat_id) {
		this.pf_strat_id = pf_strat_id;
	}
	/**
	 * @return the phone_normalized
	 */
	public String getPhone_normalized() {
		return phone_normalized;
	}
	/**
	 * @param phone_normalized the phone_normalized to set
	 */
	public void setPhone_normalized(String phone_normalized) {
		this.phone_normalized = phone_normalized;
	}
	/**
	 * @return the phone_time
	 */
	public String getPhone_time() {
		return phone_time;
	}
	/**
	 * @param phone_time the phone_time to set
	 */
	public void setPhone_time(String phone_time) {
		this.phone_time = phone_time;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the precinct_code
	 */
	public String getPrecinct_code() {
		return precinct_code;
	}
	/**
	 * @param precinct_code the precinct_code to set
	 */
	public void setPrecinct_code(String precinct_code) {
		this.precinct_code = precinct_code;
	}
	/**
	 * @return the precinct_id
	 */
	public Integer isPrecinct_id() {
		return precinct_id;
	}
	/**
	 * @param precinct_id the precinct_id to set
	 */
	public void setPrecinct_id(Integer precinct_id) {
		this.precinct_id = precinct_id;
	}
	/**
	 * @return the precinct_name
	 */
	public String getPrecinct_name() {
		return precinct_name;
	}
	/**
	 * @param precinct_name the precinct_name to set
	 */
	public void setPrecinct_name(String precinct_name) {
		this.precinct_name = precinct_name;
	}
	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	/**
	 * @return the previous_party
	 */
	public String getPrevious_party() {
		return previous_party;
	}
	/**
	 * @param previous_party the previous_party to set
	 */
	public void setPrevious_party(String previous_party) {
		this.previous_party = previous_party;
	}
	/**
	 * @return the primary_address
	 */
	public Address getPrimary_address() {
		return primary_address;
	}
	/**
	 * @param primary_address the primary_address to set
	 */
	public void setPrimary_address(Address primary_address) {
		this.primary_address = primary_address;
	}
	/**
	 * @return the primary_email_id
	 */
	public String getPrimary_email_id() {
		return primary_email_id;
	}
	/**
	 * @param primary_email_id the primary_email_id to set
	 */
	public void setPrimary_email_id(String primary_email_id) {
		this.primary_email_id = primary_email_id;
	}
	/**
	 * @return the priority_level_changed_at
	 */
	public String getPriority_level_changed_at() {
		return priority_level_changed_at;
	}
	/**
	 * @param priority_level_changed_at the priority_level_changed_at to set
	 */
	public void setPriority_level_changed_at(String priority_level_changed_at) {
		this.priority_level_changed_at = priority_level_changed_at;
	}
	/**
	 * @return the priority_level
	 */
	public String getPriority_level() {
		return priority_level;
	}
	/**
	 * @param priority_level the priority_level to set
	 */
	public void setPriority_level(String priority_level) {
		this.priority_level = priority_level;
	}
	/**
	 * @return the profile_content_html
	 */
	public String getProfile_content_html() {
		return profile_content_html;
	}
	/**
	 * @param profile_content_html the profile_content_html to set
	 */
	public void setProfile_content_html(String profile_content_html) {
		this.profile_content_html = profile_content_html;
	}
	/**
	 * @return the profile_content
	 */
	public String getProfile_content() {
		return profile_content;
	}
	/**
	 * @param profile_content the profile_content to set
	 */
	public void setProfile_content(String profile_content) {
		this.profile_content = profile_content;
	}
	/**
	 * @return the profile_headline
	 */
	public String getProfile_headline() {
		return profile_headline;
	}
	/**
	 * @param profile_headline the profile_headline to set
	 */
	public void setProfile_headline(String profile_headline) {
		this.profile_headline = profile_headline;
	}
	/**
	 * @return the received_capital_amount_in_cents
	 */
	public int getReceived_capital_amount_in_cents() {
		return received_capital_amount_in_cents;
	}
	/**
	 * @param received_capital_amount_in_cents the received_capital_amount_in_cents to set
	 */
	public void setReceived_capital_amount_in_cents(
			int received_capital_amount_in_cents) {
		this.received_capital_amount_in_cents = received_capital_amount_in_cents;
	}
	/**
	 * @return the recruiter_id
	 */
	public int getRecruiter_id() {
		return recruiter_id;
	}
	/**
	 * @param recruiter_id the recruiter_id to set
	 */
	public void setRecruiter_id(int recruiter_id) {
		this.recruiter_id = recruiter_id;
	}
	/**
	 * @return the recruiter
	 */
	public Person getRecruiter() {
		return recruiter;
	}
	/**
	 * @param recruiter the recruiter to set
	 */
	public void setRecruiter(Person recruiter) {
		this.recruiter = recruiter;
	}
	/**
	 * @return the recruits_count
	 */
	public int getRecruits_count() {
		return recruits_count;
	}
	/**
	 * @param recruits_count the recruits_count to set
	 */
	public void setRecruits_count(int recruits_count) {
		this.recruits_count = recruits_count;
	}
	/**
	 * @return the registered_address
	 */
	public Address getRegistered_address() {
		return registered_address;
	}
	/**
	 * @param registered_address the registered_address to set
	 */
	public void setRegistered_address(Address registered_address) {
		this.registered_address = registered_address;
	}
	/**
	 * @return the registered_at
	 */
	public String getRegistered_at() {
		return registered_at;
	}
	/**
	 * @param registered_at the registered_at to set
	 */
	public void setRegistered_at(String registered_at) {
		this.registered_at = registered_at;
	}
	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}
	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}
	/**
	 * @return the rnc_id
	 */
	public int getRnc_id() {
		return rnc_id;
	}
	/**
	 * @param rnc_id the rnc_id to set
	 */
	public void setRnc_id(int rnc_id) {
		this.rnc_id = rnc_id;
	}
	/**
	 * @return the rnc_regid
	 */
	public String getRnc_regid() {
		return rnc_regid;
	}
	/**
	 * @param rnc_regid the rnc_regid to set
	 */
	public void setRnc_regid(String rnc_regid) {
		this.rnc_regid = rnc_regid;
	}
	/**
	 * @return the rule_violations_count
	 */
	public int getRule_violations_count() {
		return rule_violations_count;
	}
	/**
	 * @param rule_violations_count the rule_violations_count to set
	 */
	public void setRule_violations_count(int rule_violations_count) {
		this.rule_violations_count = rule_violations_count;
	}
	/**
	 * @return the salesforce_id
	 */
	public String getSalesforce_id() {
		return salesforce_id;
	}
	/**
	 * @param salesforce_id the salesforce_id to set
	 */
	public void setSalesforce_id(String salesforce_id) {
		this.salesforce_id = salesforce_id;
	}
	/**
	 * @return the school_district
	 */
	public String getSchool_district() {
		return school_district;
	}
	/**
	 * @param school_district the school_district to set
	 */
	public void setSchool_district(String school_district) {
		this.school_district = school_district;
	}
	/**
	 * @return the school_sub_district
	 */
	public String getSchool_sub_district() {
		return school_sub_district;
	}
	/**
	 * @param school_sub_district the school_sub_district to set
	 */
	public void setSchool_sub_district(String school_sub_district) {
		this.school_sub_district = school_sub_district;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the spent_capital_amount_in_cents
	 */
	public int getSpent_capital_amount_in_cents() {
		return spent_capital_amount_in_cents;
	}
	/**
	 * @param spent_capital_amount_in_cents the spent_capital_amount_in_cents to set
	 */
	public void setSpent_capital_amount_in_cents(int spent_capital_amount_in_cents) {
		this.spent_capital_amount_in_cents = spent_capital_amount_in_cents;
	}
	/**
	 * @return the state_file_id
	 */
	public String getState_file_id() {
		return state_file_id;
	}
	/**
	 * @param state_file_id the state_file_id to set
	 */
	public void setState_file_id(String state_file_id) {
		this.state_file_id = state_file_id;
	}
	/**
	 * @return the state_lower_district
	 */
	public String getState_lower_district() {
		return state_lower_district;
	}
	/**
	 * @param state_lower_district the state_lower_district to set
	 */
	public void setState_lower_district(String state_lower_district) {
		this.state_lower_district = state_lower_district;
	}
	/**
	 * @return the state_upper_district
	 */
	public String getState_upper_district() {
		return state_upper_district;
	}
	/**
	 * @param state_upper_district the state_upper_district to set
	 */
	public void setState_upper_district(String state_upper_district) {
		this.state_upper_district = state_upper_district;
	}
	/**
	 * @return the submitted_address
	 */
	public String getSubmitted_address() {
		return submitted_address;
	}
	/**
	 * @param submitted_address the submitted_address to set
	 */
	public void setSubmitted_address(String submitted_address) {
		this.submitted_address = submitted_address;
	}
	/**
	 * @return the subnations
	 */
	public String[] getSubnations() {
		return subnations;
	}
	/**
	 * @param subnations the subnations to set
	 */
	public void setSubnations(String[] subnations) {
		this.subnations = subnations;
	}
	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}
	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	/**
	 * @return the support_level_changed_at
	 */
	public String getSupport_level_changed_at() {
		return support_level_changed_at;
	}
	/**
	 * @param support_level_changed_at the support_level_changed_at to set
	 */
	public void setSupport_level_changed_at(String support_level_changed_at) {
		this.support_level_changed_at = support_level_changed_at;
	}
	/**
	 * @return the support_level
	 */
	public String getSupport_level() {
		return support_level;
	}
	/**
	 * @param support_level the support_level to set
	 */
	public void setSupport_level(String support_level) {
		this.support_level = support_level;
	}
	/**
	 * @return the support_probability_score
	 */
	public String getSupport_probability_score() {
		return support_probability_score;
	}
	/**
	 * @param support_probability_score the support_probability_score to set
	 */
	public void setSupport_probability_score(String support_probability_score) {
		this.support_probability_score = support_probability_score;
	}
	/**
	 * @return the supranational_district
	 */
	public String getSupranational_district() {
		return supranational_district;
	}
	/**
	 * @param supranational_district the supranational_district to set
	 */
	public void setSupranational_district(String supranational_district) {
		this.supranational_district = supranational_district;
	}
	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	/**
	 * @return the turnout_probability_score
	 */
	public String getTurnout_probability_score() {
		return turnout_probability_score;
	}
	/**
	 * @param turnout_probability_score the turnout_probability_score to set
	 */
	public void setTurnout_probability_score(String turnout_probability_score) {
		this.turnout_probability_score = turnout_probability_score;
	}
	/**
	 * @return the twitter_address
	 */
	public Address getTwitter_address() {
		return twitter_address;
	}
	/**
	 * @param twitter_address the twitter_address to set
	 */
	public void setTwitter_address(Address twitter_address) {
		this.twitter_address = twitter_address;
	}
	/**
	 * @return the twitter_description
	 */
	public String getTwitter_description() {
		return twitter_description;
	}
	/**
	 * @param twitter_description the twitter_description to set
	 */
	public void setTwitter_description(String twitter_description) {
		this.twitter_description = twitter_description;
	}
	/**
	 * @return the twitter_followers_count
	 */
	public int getTwitter_followers_count() {
		return twitter_followers_count;
	}
	/**
	 * @param twitter_followers_count the twitter_followers_count to set
	 */
	public void setTwitter_followers_count(int twitter_followers_count) {
		this.twitter_followers_count = twitter_followers_count;
	}
	/**
	 * @return the twitter_friends_count
	 */
	public int getTwitter_friends_count() {
		return twitter_friends_count;
	}
	/**
	 * @param twitter_friends_count the twitter_friends_count to set
	 */
	public void setTwitter_friends_count(int twitter_friends_count) {
		this.twitter_friends_count = twitter_friends_count;
	}
	/**
	 * @return the twitter_id
	 */
	public String getTwitter_id() {
		return twitter_id;
	}
	/**
	 * @param twitter_id the twitter_id to set
	 */
	public void setTwitter_id(String twitter_id) {
		this.twitter_id = twitter_id;
	}
	/**
	 * @return the twitter_location
	 */
	public String getTwitter_location() {
		return twitter_location;
	}
	/**
	 * @param twitter_location the twitter_location to set
	 */
	public void setTwitter_location(String twitter_location) {
		this.twitter_location = twitter_location;
	}
	/**
	 * @return the twitter_login
	 */
	public String getTwitter_login() {
		return twitter_login;
	}
	/**
	 * @param twitter_login the twitter_login to set
	 */
	public void setTwitter_login(String twitter_login) {
		this.twitter_login = twitter_login;
	}
	/**
	 * @return the twitter_name
	 */
	public String getTwitter_name() {
		return twitter_name;
	}
	/**
	 * @param twitter_name the twitter_name to set
	 */
	public void setTwitter_name(String twitter_name) {
		this.twitter_name = twitter_name;
	}
	/**
	 * @return the twitter_updated_at
	 */
	public String getTwitter_updated_at() {
		return twitter_updated_at;
	}
	/**
	 * @param twitter_updated_at the twitter_updated_at to set
	 */
	public void setTwitter_updated_at(String twitter_updated_at) {
		this.twitter_updated_at = twitter_updated_at;
	}
	/**
	 * @return the twitter_website
	 */
	public String getTwitter_website() {
		return twitter_website;
	}
	/**
	 * @param twitter_website the twitter_website to set
	 */
	public void setTwitter_website(String twitter_website) {
		this.twitter_website = twitter_website;
	}
	/**
	 * @return the unsubscribed_at
	 */
	public String getUnsubscribed_at() {
		return unsubscribed_at;
	}
	/**
	 * @param unsubscribed_at the unsubscribed_at to set
	 */
	public void setUnsubscribed_at(String unsubscribed_at) {
		this.unsubscribed_at = unsubscribed_at;
	}
	/**
	 * @return the updated_at
	 */
	public String getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	/**
	 * @return the user_submitted_address
	 */
	public Address getUser_submitted_address() {
		return user_submitted_address;
	}
	/**
	 * @param user_submitted_address the user_submitted_address to set
	 */
	public void setUser_submitted_address(Address user_submitted_address) {
		this.user_submitted_address = user_submitted_address;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the van_id
	 */
	public String getVan_id() {
		return van_id;
	}
	/**
	 * @param van_id the van_id to set
	 */
	public void setVan_id(String van_id) {
		this.van_id = van_id;
	}
	/**
	 * @return the village_district
	 */
	public String getVillage_district() {
		return village_district;
	}
	/**
	 * @param village_district the village_district to set
	 */
	public void setVillage_district(String village_district) {
		this.village_district = village_district;
	}
	/**
	 * @return the warnings_count
	 */
	public int getWarnings_count() {
		return warnings_count;
	}
	/**
	 * @param warnings_count the warnings_count to set
	 */
	public void setWarnings_count(int warnings_count) {
		this.warnings_count = warnings_count;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * @return the work_address
	 */
	public Address getWork_address() {
		return work_address;
	}
	/**
	 * @param work_address the work_address to set
	 */
	public void setWork_address(Address work_address) {
		this.work_address = work_address;
	}
	/**
	 * @return the work_phone_number
	 */
	public String getWork_phone_number() {
		return work_phone_number;
	}
	/**
	 * @param work_phone_number the work_phone_number to set
	 */
	public void setWork_phone_number(String work_phone_number) {
		this.work_phone_number = work_phone_number;
	}
	private Address user_submitted_address; //an address resource representing the address this person submitted
    private String username; //this person’s NationBuilder username
    private String van_id; //this person’s ID from VAN
    private String village_district; //a district field
    private int warnings_count; //the number of warnings this person has received
    private String website; //the URL of this person’s website
    private Address work_address; //an address resource representing this person’s work address
    private String work_phone_number; //a work phone number for this person

    
    
}
