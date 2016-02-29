/**
 * 
 */
package ca.mphost.importer;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.mphost.importer.nationbuilder.APIException;
import ca.mphost.importer.nationbuilder.Event;
import ca.mphost.importer.nationbuilder.Person;
import ca.mphost.importer.nationbuilder.PersonResults;

import com.google.gson.Gson;

/**
 * API for interacting with NationBuilder.
 * 
 * @author Bryan Mulvihill
 * @date 2014-04-05
 *
 */
public class NationBuilderAPI {

	private String nation;
	private String site;
	private String accessToken;
	
	private int blog;

	private static final DateFormat nationBuilderDateFormat = new SimpleDateFormat( "yyyy-MM-dd");
	private static final DateFormat nationBuilderTimeFormat = new SimpleDateFormat( "HH:mm:ss");
	
	public static String formatDate( Date date ) {
		return nationBuilderDateFormat.format(date) + "T" + nationBuilderTimeFormat.format(date) + "+00:00";
	}
	
	/**
	 * Initialize the API.
	 * @param nation
	 * @param site
	 * @param accessToken
	 */
	public void init( String nation, String site, String accessToken ) {
		this.nation = nation;
		this.site = site;
		this.accessToken = accessToken;
	}
	
	/**
	 * Gets a list of blogs for the current nation and site.
	 * @return
	 * @throws APIException
	 */
	public BlogResults getBlogs() throws APIException {
		try {
			HttpResponse response = getRequest("/sites/" + site + "/pages/blogs?page=1&per_page=100&");
			if( response.getCode() == 200 ) {
				Gson gson = new Gson();
				return gson.fromJson( response.getResponse(), BlogResults.class );
			}
			else {
				throw new APIException( response.getResponse() );
			}
		} catch (Exception e) {
			throw new APIException( "Exception calling API", e );
		}
	}
	
	public BlogPostResults getBlogPosts( int blogId ) throws APIException {
		int pageNumber = 1;
		int totalPosts = 0;
		BlogPostResults results = null;
		List<BlogPost> posts = new ArrayList<BlogPost>();
		try {
			do {
				HttpResponse response = getRequest("/sites/" + site + "/pages/blogs/" + blogId + "/posts?per_page=100&page=" + pageNumber++ + "&" );
				if( response.getCode() == 200 ) {
					Gson gson = new Gson();
					BlogPostResults page = gson.fromJson( response.getResponse(), BlogPostResults.class );
					if( results == null ) {
						results = page;
					}
					totalPosts = results.total;
					if( results.getResults() == null )
						return results;
					for( BlogPost post : results.getResults() ) {
						posts.add(post);
					}
				}
				else {
					throw new APIException( "Exception getting blog posts:" + response.getResponse() );
				}	
			} while( posts.size() < totalPosts );
			results.setResults(posts.toArray( new BlogPost[posts.size()]));
			return results;
		} catch (Exception e) {
			throw new APIException( "Exception getting blog posts", e);
		}
	}
	
	private static class BlogPostWrapper {
		public BlogPost blog_post;		
	}
	
	public BlogPost createBlogPost( int blogId, BlogPost post ) throws APIException{
		
		Gson gson = new Gson();
//		String json = gson.toJson(post);
//		json = json.replace("\"author_id\":0,", "");
//		json = json.replace("\"id\":0,", "");
//		

		String json = post.toJson();
		json = "{ \"blog_post\": " + json + "\n}";
		try {
			HttpResponse response = postRequest( "/sites/" + site + "/pages/blogs/" + blogId + "/posts?", json);					
			if( response.getCode() == 200 ) {
				return gson.fromJson( response.getResponse(), BlogPostWrapper.class ).blog_post;			
			}
			else {
				throw new APIException("Failed to create blog post:" + response.getResponse() );
			}
		} catch (Exception e) {
			throw new APIException("Failed to create blog post", e );
		}
	}
	
	public static class EventWrapper {
		public Event event;
	}
	public Event createEvent( Event event ) throws APIException {
		Gson gson = new Gson();		

		String json = event.toJson();
		json = "{ \"event\": " + json + "\n}";
		try {
			HttpResponse response = postRequest( "/sites/" + site + "/pages/events?", json);					
			if( response.getCode() == 200 ) {
				return gson.fromJson( response.getResponse(), EventWrapper.class ).event;			
			}
			else {
				throw new APIException("Failed to create event:" + response.getResponse() );
			}
		} catch (Exception e) {
			throw new APIException("Failed to create event", e );
		}
	}
	
	public HttpResponse destroy( int blogId, BlogPost post ) throws APIException {
		try {
			String urlStr = "https://" + nation + ".nationbuilder.com/api/v1/sites/" + site + "/pages/blogs/" + blogId + "/posts/" + post.getId()+ "?access_token=" + accessToken;
			
			URL url = new URL(urlStr);

			HttpRequest request = new HttpRequest();
			request.setHeader("Accept", "application/json" );
			request.setHeader("Accept-Encoding", "application/json" );
			request.setHeader("Content-Type", "application/json" );
			HttpResponse response = request.delete(url);
			return response;
		} catch (Exception e) {
			throw new APIException( "Failed to destroy", e );
		}
	}
	
	public Attachment createAttachment( String slug, Attachment attachment ) throws APIException{
		try {
			String json = attachment.toJson();
			HttpResponse response = postRequest( "/sites/" + site + "/pages/" + slug + "/attachments?", json);
			if( response.getCode() == 200 ) {
				return new Gson().fromJson( response.getResponse(), Attachment.class );
			}
			else {
				throw new APIException( "Failed to create attachment:" + response.getResponse() );
			}
		} catch (Exception e) {
			throw new APIException( "Failed to create attachment", e );
		}
	}
	
	private static class PersonWrapper {
		public Person person;		
	}
	
	public Person matchPerson( String emailAddress ) throws APIException{
		try {			
			HttpResponse response = getRequest( "/people/match?email=" + emailAddress + "&");
			if( response.getCode() == 200 ) {
				String result = response.getResponse();
				PersonWrapper wrapper = new Gson().fromJson( result, PersonWrapper.class );
				return wrapper.person;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new APIException( "Failed to match person", e );
		}
	}
	
	public PersonResults searchPersons( String lastName ) throws APIException{
		return null;
	}
	
	public Person getPerson( int id ) throws APIException {
		try {
			HttpResponse response = getRequest( "/people/" + id + "?");
			if( response.getCode() == 200 ) {
				String result = response.getResponse();
				PersonWrapper wrapper = new Gson().fromJson( result, PersonWrapper.class );
				return wrapper.person;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new APIException("Unable to get person " + id, e);
		}
	}
	
	public Person createPerson( Person person ) throws APIException {
		Gson gson = new Gson();

		String json = person.toJson();
		json = "{ \"person\": " + json + "\n}";
		try {
			HttpResponse response = postRequest( "/people?", json);
			int code = response.getCode();
			if( code == 200 || code == 201 || code == 409 ) {
				System.out.println( response.getResponse() );
				return gson.fromJson( response.getResponse(), PersonWrapper.class ).person;			
			}
			else {
				throw new APIException("Failed to create person:" + response.getCode() + " " + response.getResponse() );
			}
		} catch (Exception e) {
			throw new APIException("Failed to create person", e );
		}
	}
	
	public Person updatePerson( Person person ) throws APIException {
		try {
			String urlStr = "https://" + nation + ".nationbuilder.com/api/v1/people/" + person.getId() + "?access_token=" + accessToken;			
			URL url = new URL(urlStr);

			String json = "{ \"person\":\n" + person.toJson() + "}";

			HttpRequest request = new HttpRequest();
			request.setHeader("Accept", "application/json" );
			request.setHeader("Content-Type", "application/json" );
			request.setHeader("Authorization", "Bearer "+ accessToken);
			HttpResponse response = request.put(url, json.getBytes());
			System.out.println( response.getCode() );
			System.out.println( response.getResponse() );
			if( response.getCode() == 200 ) {
				String result = response.getResponse();
				PersonWrapper wrapper = new Gson().fromJson( result, PersonWrapper.class );
				return wrapper.person;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new APIException("Unable to get person " + person.getId(), e);
		}
	}
	
	public void deletePerson( Person person ) throws APIException {
		try {
			HttpResponse response = deleteRequest( "/people/" + person.getId() + "?");					
			if( response.getCode() != 204 ) {
				throw new APIException("Failed to delete person:" + response.getResponse() );
			}
		} catch (Exception e) {
			throw new APIException("Failed to create person", e );
		}
	}
	
	private HttpResponse getRequest( String base ) throws Exception {
		//String sitename = slug.getText();
		//String nation = nationSlug.getText();
		String urlStr = "https://" + nation + ".nationbuilder.com/api/v1" + base + "access_token=" + accessToken;
		System.out.println( urlStr );
		URL url = new URL( urlStr );
		HttpRequest request = new HttpRequest();
		request.setHeader( "Accept", "application/json" );
		request.setHeader("Content-Type", "application/json" );
		HttpResponse response = request.get(url);
		System.out.println( response.getResponse() );
		return response;
	}
	
	private HttpResponse postRequest( String base, String json ) throws Exception {
		
		String urlStr = "https://" + nation + ".nationbuilder.com/api/v1" + base + "access_token=" + accessToken;
		System.out.println( json );
		
		URL url = new URL(urlStr);

		HttpRequest request = new HttpRequest();
		request.setHeader("Accept", "application/json" );
		request.setHeader("Content-Type", "application/json" );
		request.setHeader("Authorization", "Bearer "+ accessToken);
		HttpResponse response = request.post(url, json);
		return response;
	}
	
	private HttpResponse deleteRequest( String base ) throws Exception {
		
		String urlStr = "https://" + nation + ".nationbuilder.com/api/v1" + base + "access_token=" + accessToken;
		
		URL url = new URL(urlStr);

		HttpRequest request = new HttpRequest();
		request.setHeader("Accept", "application/json" );
		request.setHeader("Content-Type", "application/json" );
		request.setHeader("Authorization", "Bearer "+ accessToken);
		HttpResponse response = request.delete(url);
		return response;
	}
	
	/**
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the blog
	 */
	public int getBlog() {
		return blog;
	}

	/**
	 * @param blog the blog to set
	 */
	public void setBlog(int blog) {
		this.blog = blog;
	}
	
	

}
