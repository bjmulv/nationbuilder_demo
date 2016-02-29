package ca.mphost.importer;

public class Blog {
	public String slug;
	public String status;
	public String site_slug;
	public String name;
	public String headline;
	public String title;
	public String excerpt;
	public int author_id;
	public long external_id;
	public String[] tags;
	public int id;
	
	public Blog() {
		
	}
	
	@Override
	public String toString() {
		return name;
	}
}