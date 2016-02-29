package ca.mphost.importer;

import com.google.gson.Gson;

import java.io.FileReader;

public class BlogPostResults extends APIResult {

	public BlogPost[] results;
	
	public static final void main( String[] args ) throws Exception {
		Gson gson = new Gson();
		BlogPostResults results = gson.fromJson( new FileReader( "blogpostlist.txt"), BlogPostResults.class );
		System.out.println( results.total );
		
	}

	/**
	 * @return the results
	 */
	public BlogPost[] getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(BlogPost[] results) {
		this.results = results;
	}
	
	
}
