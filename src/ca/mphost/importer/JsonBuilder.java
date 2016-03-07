/**
 * 
 */
package ca.mphost.importer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryan Mulvihill
 *
 */
public class JsonBuilder {

	private static class Tuple {
		String name;
		Object value;
		
		public Tuple( String name, Object value ) {
			this.name = name;
			this.value = value;
		}
	}
	
	private List<Tuple> properties;
	
	public JsonBuilder() {
		properties = new ArrayList<JsonBuilder.Tuple>();
	}
	
	public void addProperty( String name, Object property ) {
		if( property == null )
			return;
		if( property.getClass().equals( Class.class ))
			return;
		properties.add( new Tuple( name, property ));
	}
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append( "{");
		for( int i = 0; i < properties.size(); i++ ) {
			Tuple tuple = properties.get( i );
			if( i != 0 )
				buffer.append( "," );
			buffer.append( "\n\t" );
			buffer.append( "\"").append( tuple.name ).append( "\": ");
			if( tuple.value instanceof String ) {
				buffer.append( "\"").append( (String)tuple.value ).append( "\"");
			}
			else if( tuple.value instanceof Integer || tuple.value instanceof Long ) {
				buffer.append( tuple.value );
			}
			else if( tuple.value instanceof Boolean ) {
				buffer.append( tuple.value );
			}
			else if( tuple.value.getClass().isArray() ) {
				Object[] array = (Object[])tuple.value;
				buffer.append( "[");
				for( int j = 0; j < array.length; j++ ) {
					if( j != 0 )
						buffer.append( ",");
					buffer.append( "\n\t\t");
					Object o = array[j];
					if( o instanceof String ) {
						buffer.append( "\"").append( (String)o ).append( "\"");
					}
					else {
						buffer.append( o );
					}
				}
				buffer.append( "\n\t]");
			}
		}
		buffer.append( "\n}");
		return buffer.toString();
	}

	
}
