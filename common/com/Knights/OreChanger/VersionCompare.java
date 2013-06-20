package com.Knights.OreChanger;

import java.util.regex.Pattern;
/**
 * Found at
 * http://stackoverflow.com/questions/198431/how-do-you-compare-two-version-strings-in-java
 * Help version checking
 * 
 * '1.0' < '1.1'
 * '1.0.1' < '1.1'
 * '1.9' < '1.10'
 * '1.a' > '1.9'
 *  
 */

public class VersionCompare 
{
	
	/**
	 * Returns 0 if both values are the same
	 * Returns a value > 0 when v1 > v2
	 * 
	 * @param v1 Versionnumber eg "1.0.1" 
	 * @param v2 Versionnumber eg "1.2"
	 * 
	 * @return int
	 */
    public static int compare(String v1, String v2) 
    {
        String s1 = normalisedVersion(v1);
        String s2 = normalisedVersion(v2);
        int cmp = s1.compareTo(s2);
        
        // String cmpStr = cmp < 0 ? "<" : cmp > 0 ? ">" : "==";
        // System.out.printf("'%s' %s '%s'%n", v1, cmpStr, v2);
        
        return cmp;
    }

    public static String normalisedVersion(String version) 
    {
        return normalisedVersion(version, ".", 4);
    }

    public static String normalisedVersion(String version, String sep, int maxWidth) 
    {
        String[] split = Pattern.compile(sep, Pattern.LITERAL).split(version);
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(String.format("%" + maxWidth + 's', s));
        }
        return sb.toString();
    }	
    
    
    

}
