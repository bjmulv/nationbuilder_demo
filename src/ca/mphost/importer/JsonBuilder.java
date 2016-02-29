/**
 * 
 */
package ca.mphost.importer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
				buffer.append( "\"").append( filter( (String)tuple.value )).append( "\"");
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
						buffer.append( "\"").append( filter( (String)o )).append( "\"");
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
	
	public String filter( String str ) {
		if( str == null )
			return null;
		str = StringUtils.replace( str, "\n", "\\n");
		str = StringUtils.replace( str, "\t", "\\t");
		str = StringUtils.replace( str, "\"", "\\\"");
		str = StringUtils.replace( str, "�", " ");
		str = StringUtils.replace( str, "�", "-");
		str = StringUtils.replace( str, "�", "-");
		str = StringUtils.replace( str, "�", "&#8226;");
		
		str = StringUtils.replace( str, "�", "\\\"");
		str = StringUtils.replace( str, "�", "\\\"");
		str = StringUtils.replace( str, "�", "'");
		str = StringUtils.replace( str, "�", "'");
		str = StringUtils.replace( str, "�", "&trade;");
		str = StringUtils.replace( str, "�", "&reg;");
		str = StringUtils.replace( str, "�", "&copy;");
		str = StringUtils.replace( str, "�", "...");
		str = StringUtils.replace( str, "�", "&agrave;"); //224
		str = StringUtils.replace( str, "�", "&aacute;"); //224
		str = StringUtils.replace( str, "�", "&acirc;"); //224
		str = StringUtils.replace( str, "�", "&egrave;"); //232
		str = StringUtils.replace( str, "�", "&eacute;"); //233		
		str = StringUtils.replace( str, "�", "&ecirc;"); //234
		str = StringUtils.replace( str, "�", "&euml;");
		str = StringUtils.replace( str, String.valueOf( (char)(150)), "-"); //150
		
		str = StringUtils.replace( str, "�", "-"); //191
		str = StringUtils.replace( str, String.valueOf( (char)(8209)), "-"); //8209
		str = StringUtils.replace( str, "�", "&Eacute;"); //201
		str = StringUtils.replace( str, "�", "&Egrave;"); //200
		str = StringUtils.replace( str, "�", "&Ecirc;"); //200
		str = StringUtils.replace( str, "�", "&Aacute;"); //201
		str = StringUtils.replace( str, "�", "&Agrave;"); //200
		str = StringUtils.replace( str, "�", "&Acirc;"); //200
		str = StringUtils.replace( str, "�", "&Auml;"); //196
		
		str = StringUtils.replace( str, "�", "&iuml;"); //239
		str = StringUtils.replace( str, "�", "^icirc;");
		str = StringUtils.replace( str, "�", "&ocirc;"); //244
		str = StringUtils.replace( str, "�", "&ucirc;"); //244
		str = StringUtils.replace( str, "�", "&ugrave;");
		str = StringUtils.replace( str, "�", "&uuml;");
		str = StringUtils.replace( str, "�", "&Ccedil;" );
		str = StringUtils.replace( str, "�", "&oelig;" );
		str = StringUtils.replace( str, "�", "&Ocirc;" );
		str = StringUtils.replace( str, "�", "&plusmn;" );
		str = StringUtils.replace( str, "�", "&ccedil;" );
				
		str = StringUtils.replace( str, "�", "<<" );
		str = StringUtils.replace( str, "�", ">>" );
		
		str = StringUtils.replace( str, "�", "&#254;");
		str = StringUtils.replace( str, "�", "&#183;");
		str = StringUtils.replace( str, "�", "&#189;");
		str = StringUtils.replace( str, "�", "&#167;");
		
		str = StringUtils.replace( str, "�", "&Yacute;");
		str = StringUtils.replace( str, "�", "&thorn;");
		str = StringUtils.replace( str, "�", "&Igrave;");
		str = StringUtils.replace( str, "�", "^igrave;");
		
		str = StringUtils.replace( str, "�", "&Oslash;");
		str = StringUtils.replace( str, "�", "&#162;");
		str = StringUtils.replace( str, "�", "&oacute;");
		str = StringUtils.replace( str, "�", "&Ouml;");
		str = StringUtils.replace( str, "�", "&Oacute;");
		str = StringUtils.replace( str, "�", "&Atilde;");
		str = StringUtils.replace( str, "�", "&#8364;");
		str = StringUtils.replace( str, "�", "&Euml;");
		str = StringUtils.replace( str, "�", "&deg;");
		str = StringUtils.replace( str, "�", "&scaron;");
		str = StringUtils.replace( str, "�", "&#163;");
		str = StringUtils.replace( str, "�", "&ouml;");
		str = StringUtils.replace( str, "�", "&atilde;");
		str = StringUtils.replace( str, "�", "&auml;");
		str = StringUtils.replace( str, "�", ",");
		str = StringUtils.replace( str, "�", "&#8225;");
		str = StringUtils.replace( str, "�", "'");
		str = StringUtils.replace( str, "�", "&szlig;");
		str = StringUtils.replace( str, "�", "&Yuml;");
		str = StringUtils.replace( str, "�", "&yuml;");
		str = StringUtils.replace( str, "�", "&micro;");
		str = StringUtils.replace( str, "�", "");
		str = StringUtils.replace( str, "�", "&ntilde;");
		str = StringUtils.replace( str, "�", ",");
		str = StringUtils.replace( str, "�", "*");
		str = StringUtils.replace( str, "�", "-");
		str = StringUtils.replace( str, "�", "&aelig;");
		str = StringUtils.replace( str, "�", "&iacute;");
		str = StringUtils.replace( str, "�", "'");
		str = StringUtils.replace( str, "�", "");
		char[] chars = str.toCharArray();
		for( int i = 0; i < chars.length; i++ ) {
			if( chars[i] > 127 ) {
				//System.out.println("str = StringUtils.replace( str, \"" + chars[i] + "\", \"\"); Found illegal character \"" + chars[i] + "\" (" + (int)(chars[i]) +") at position " + i + " in \"" + str + "\"");
				System.out.println("str = StringUtils.replace( str, \"" + chars[i] + "\", \"\"); Found illegal character \"" + chars[i] + "\" (" + (int)(chars[i]) +") at position " + i );
			}
			if( chars[i] < 32 && chars[i] != '\n' && chars[i] != '\r' ) {
				str = StringUtils.replace( str, String.valueOf(chars[i]), "");
				//System.out.println("Found illegal character \"" + chars[i] + "\" (" + (int)(chars[i]) +") at position " + i + " in \"" + str + "\"");
			}
		}
		
		return str;
	}
	
}
