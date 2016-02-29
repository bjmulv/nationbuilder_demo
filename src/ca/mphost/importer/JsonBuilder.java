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
		str = StringUtils.replace( str, " ", " ");
		str = StringUtils.replace( str, "—", "-");
		str = StringUtils.replace( str, "–", "-");
		str = StringUtils.replace( str, "•", "&#8226;");
		
		str = StringUtils.replace( str, "“", "\\\"");
		str = StringUtils.replace( str, "”", "\\\"");
		str = StringUtils.replace( str, "’", "'");
		str = StringUtils.replace( str, "‘", "'");
		str = StringUtils.replace( str, "™", "&trade;");
		str = StringUtils.replace( str, "®", "&reg;");
		str = StringUtils.replace( str, "©", "&copy;");
		str = StringUtils.replace( str, "…", "...");
		str = StringUtils.replace( str, "à", "&agrave;"); //224
		str = StringUtils.replace( str, "á", "&aacute;"); //224
		str = StringUtils.replace( str, "â", "&acirc;"); //224
		str = StringUtils.replace( str, "è", "&egrave;"); //232
		str = StringUtils.replace( str, "é", "&eacute;"); //233		
		str = StringUtils.replace( str, "ê", "&ecirc;"); //234
		str = StringUtils.replace( str, "ë", "&euml;");
		str = StringUtils.replace( str, String.valueOf( (char)(150)), "-"); //150
		
		str = StringUtils.replace( str, "¿", "-"); //191
		str = StringUtils.replace( str, String.valueOf( (char)(8209)), "-"); //8209
		str = StringUtils.replace( str, "É", "&Eacute;"); //201
		str = StringUtils.replace( str, "È", "&Egrave;"); //200
		str = StringUtils.replace( str, "Ê", "&Ecirc;"); //200
		str = StringUtils.replace( str, "Á", "&Aacute;"); //201
		str = StringUtils.replace( str, "À", "&Agrave;"); //200
		str = StringUtils.replace( str, "Â", "&Acirc;"); //200
		str = StringUtils.replace( str, "Ä", "&Auml;"); //196
		
		str = StringUtils.replace( str, "ï", "&iuml;"); //239
		str = StringUtils.replace( str, "î", "^icirc;");
		str = StringUtils.replace( str, "ô", "&ocirc;"); //244
		str = StringUtils.replace( str, "û", "&ucirc;"); //244
		str = StringUtils.replace( str, "ù", "&ugrave;");
		str = StringUtils.replace( str, "ü", "&uuml;");
		str = StringUtils.replace( str, "Ç", "&Ccedil;" );
		str = StringUtils.replace( str, "œ", "&oelig;" );
		str = StringUtils.replace( str, "Ô", "&Ocirc;" );
		str = StringUtils.replace( str, "±", "&plusmn;" );
		str = StringUtils.replace( str, "ç", "&ccedil;" );
				
		str = StringUtils.replace( str, "«", "<<" );
		str = StringUtils.replace( str, "»", ">>" );
		
		str = StringUtils.replace( str, "þ", "&#254;");
		str = StringUtils.replace( str, "·", "&#183;");
		str = StringUtils.replace( str, "½", "&#189;");
		str = StringUtils.replace( str, "§", "&#167;");
		
		str = StringUtils.replace( str, "Ý", "&Yacute;");
		str = StringUtils.replace( str, "Þ", "&thorn;");
		str = StringUtils.replace( str, "Ì", "&Igrave;");
		str = StringUtils.replace( str, "ì", "^igrave;");
		
		str = StringUtils.replace( str, "Ø", "&Oslash;");
		str = StringUtils.replace( str, "¢", "&#162;");
		str = StringUtils.replace( str, "ó", "&oacute;");
		str = StringUtils.replace( str, "Ö", "&Ouml;");
		str = StringUtils.replace( str, "Ó", "&Oacute;");
		str = StringUtils.replace( str, "Ã", "&Atilde;");
		str = StringUtils.replace( str, "€", "&#8364;");
		str = StringUtils.replace( str, "Ë", "&Euml;");
		str = StringUtils.replace( str, "°", "&deg;");
		str = StringUtils.replace( str, "š", "&scaron;");
		str = StringUtils.replace( str, "£", "&#163;");
		str = StringUtils.replace( str, "ö", "&ouml;");
		str = StringUtils.replace( str, "ã", "&atilde;");
		str = StringUtils.replace( str, "ä", "&auml;");
		str = StringUtils.replace( str, "¸", ",");
		str = StringUtils.replace( str, "‡", "&#8225;");
		str = StringUtils.replace( str, "´", "'");
		str = StringUtils.replace( str, "ß", "&szlig;");
		str = StringUtils.replace( str, "Ÿ", "&Yuml;");
		str = StringUtils.replace( str, "ÿ", "&yuml;");
		str = StringUtils.replace( str, "µ", "&micro;");
		str = StringUtils.replace( str, "¨", "");
		str = StringUtils.replace( str, "ñ", "&ntilde;");
		str = StringUtils.replace( str, "‚", ",");
		str = StringUtils.replace( str, "×", "*");
		str = StringUtils.replace( str, "­", "-");
		str = StringUtils.replace( str, "æ", "&aelig;");
		str = StringUtils.replace( str, "í", "&iacute;");
		str = StringUtils.replace( str, "¹", "'");
		str = StringUtils.replace( str, "¬", "");
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
