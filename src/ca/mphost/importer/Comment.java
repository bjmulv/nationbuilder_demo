/**
 * 
 */
package ca.mphost.importer;

/**
 * Comment on a Wordpress post.
 * 
 * @author Bryan Mulvihill
 * @date 2014-05-24
 *
 */
public class Comment {

	private int id;
	private String author;
	private String authorEmail;
	private String authorUrl;
	private String date;
	private String date_gmt;
	private String content;
	private int commentApproved;
	
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
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the authorEmail
	 */
	public String getAuthorEmail() {
		return authorEmail;
	}
	/**
	 * @param authorEmail the authorEmail to set
	 */
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	/**
	 * @return the authorUrl
	 */
	public String getAuthorUrl() {
		return authorUrl;
	}
	/**
	 * @param authorUrl the authorUrl to set
	 */
	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the date_gmt
	 */
	public String getDate_gmt() {
		return date_gmt;
	}
	/**
	 * @param date_gmt the date_gmt to set
	 */
	public void setDate_gmt(String date_gmt) {
		this.date_gmt = date_gmt;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the commentApproved
	 */
	public int getCommentApproved() {
		return commentApproved;
	}
	/**
	 * @param commentApproved the commentApproved to set
	 */
	public void setCommentApproved(int commentApproved) {
		this.commentApproved = commentApproved;
	}
	
	
}
