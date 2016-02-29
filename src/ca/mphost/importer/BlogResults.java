package ca.mphost.importer;
import com.google.gson.Gson;

import java.io.FileReader;


public class BlogResults extends APIResult {

	private Blog[] results;
	
	/**
	 * @return the results
	 */
	public Blog[] getResults() {
		return results;
	}



	/**
	 * @param results the results to set
	 */
	public void setResults(Blog[] results) {
		this.results = results;
	}



	public static final void main( String[] args ) throws Exception {
		Gson gson = new Gson();
		BlogResults results = gson.fromJson( new FileReader( "blogresult.txt"), BlogResults.class );
		System.out.println( results.total );
		
	}
}
