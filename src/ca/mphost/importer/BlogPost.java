package ca.mphost.importer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a Blog Post.
 * 
 * @author Bryan Mulvihill
 * @date 2014-04-23
 *
 */
public class BlogPost {

    private String slug;
	private String status;
	private String site_slug;
	private String name;
	private String headline;
	private String title;
	private String excerpt;
	private int author_id;
	private long external_id;
	private String[] tags;
	private String published_at;
	private int id;
	private String content_before_flip;
	private String content_after_flip;
	
	private transient String authorLogin;
	private transient Attachment featureImage;
	
	/**
	 * Gets the list of attachments in the Blog Post.
	 * @return
	 */
	public List<Attachment> getAttachments() {
		List<Attachment> attachments = new ArrayList<Attachment>();
		int index = 0;
		int srcIndex = 0;
		String content = content_before_flip + (content_after_flip == null ? "" : content_after_flip);
		while( (srcIndex = content.indexOf( "src=\"", index )) != -1 ) {
			int endIndex = content.indexOf( '"', srcIndex+5 );
			if( endIndex > 0 ) {
				String url = content.substring(srcIndex + 5, endIndex);
				Attachment att = new Attachment();
				att.setUrl(url);
				attachments.add(att);
				index = endIndex;
			}
		}
		return attachments;
	}
	
	/**
	 * Replaces the attachment URLs in the contents. 
	 * @param attachments
	 */
	public void replaceAttachments( List<Attachment> attachments ) {
		for( Attachment att : attachments ) {
			if( content_before_flip != null )
				content_before_flip = StringUtils.replace(content_before_flip, att.getUrl(), att.getFilename() );
			if( content_after_flip != null )
				content_after_flip = StringUtils.replace(content_after_flip, att.getUrl(), att.getFilename() );
		}
	}
	
	
	/**
	 * Filter the content and the name.
	 */
	public void sanitize() {
		name = filter( name );
		content_before_flip = filter( content_before_flip );
		content_after_flip = filter(content_after_flip);
		
	}
	
	private String filter( String str ) {
		if( str == null )
			return null;
		str = StringUtils.replace( str, "’", "'");
		str = StringUtils.replace( str, "–", "-");
		str = StringUtils.replace( str, "è", "&egrave;");
		str = StringUtils.replace( str, "é", "&eacute;");
		return str;
	}
	/*
	"slug": "updating-associations",
    "status": "drafted",
    "name": "Updating Associations",
    "author_id": 0,
    "external_id": 2998,
    "tags": [
        "fac",
        "News &amp; Updates"
    ],
    "published_at": "0000-00-00T00:00:00+00:00",
    "id": 0,
    "content_before_flip": "<a href=\"https://twitter.com/MP_Host\" class=\"twitter-follow-button url\" data-show-count=\"true\" data-size=\"large\">Follow @MP_Host</a>\n<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>"
}
	 */
	public String toJson() {
		JsonBuilder builder = new JsonBuilder();
		builder.addProperty( "slug", slug );
		builder.addProperty( "status", status );
		builder.addProperty( "name", name );
		if( author_id > 0 )
			builder.addProperty( "author_id", author_id );
		//if( external_id > 0 )
		//	builder.addProperty( "external_id", external_id );
		//do tags
		if( tags != null && tags.length > 0 )
			builder.addProperty("tags", tags );
		builder.addProperty( "published_at", published_at );
		builder.addProperty( "content_before_flip", content_before_flip );
		if( StringUtils.isNotEmpty(content_after_flip))
			builder.addProperty( "content_after_flip", content_after_flip );
		
		return builder.toJson();
	}
	
	/**
	 * Sets the list of tags (categories).
	 * @param tags
	 */
	public void setTags( String tags ) {
		if( tags != null ) {
			setTags( tags.split(","));
		}
	}

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the site_slug
	 */
	public String getSite_slug() {
		return site_slug;
	}

	/**
	 * @param site_slug the site_slug to set
	 */
	public void setSite_slug(String site_slug) {
		this.site_slug = site_slug;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}

	/**
	 * @param headline the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the excerpt
	 */
	public String getExcerpt() {
		return excerpt;
	}

	/**
	 * @param excerpt the excerpt to set
	 */
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
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
	 * @return the external_id
	 */
	public long getExternal_id() {
		return external_id;
	}

	/**
	 * @param external_id the external_id to set
	 */
	public void setExternal_id(long external_id) {
		this.external_id = external_id;
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
		this.tags = new String[tags.length];
		for( int i = 0; i < tags.length; i++ ) 
			this.tags[i] = tags[i].trim();
	}

	/**
	 * @return the published_at
	 */
	public String getPublished_at() {
		return published_at;
	}

	/**
	 * @param published_at the published_at to set
	 */
	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}
	
	/**
	 * "published_at": "0000-00-00T00:00:00+00:00",
	 * @param date
	 */
	public void setPublished_at( Date date ) {
		DateFormat nationBuilderDateFormat = new SimpleDateFormat( "yyyy-MM-dd");
		DateFormat nationBuilderTimeFormat = new SimpleDateFormat( "HH:mm:ss");
		
		this.published_at = nationBuilderDateFormat.format(date) + "T" + nationBuilderTimeFormat.format(date) + "+00:00";
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
	 * @return the content_before_flip
	 */
	public String getContent_before_flip() {
		return content_before_flip;
	}

	/**
	 * @param content_before_flip the content_before_flip to set
	 */
	public void setContent_before_flip(String content_before_flip) {
		this.content_before_flip = content_before_flip;
	}

	/**
	 * @return the content_after_flip
	 */
	public String getContent_after_flip() {
		return content_after_flip;
	}

	/**
	 * @param content_after_flip the content_after_flip to set
	 */
	public void setContent_after_flip(String content_after_flip) {
		this.content_after_flip = content_after_flip;
	}

	/**
	 * @return the authorLogin
	 */
	public String getAuthorLogin() {
		return authorLogin;
	}

	/**
	 * @param authorLogin the authorLogin to set
	 */
	public void setAuthorLogin(String authorLogin) {
		this.authorLogin = authorLogin;
	}

	/**
	 * @return the featureImage
	 */
	public Attachment getFeatureImage() {
		return featureImage;
	}

	/**
	 * @param featureImage the featureImage to set
	 */
	public void setFeatureImage(Attachment featureImage) {
		this.featureImage = featureImage;
	}
	
	
}
