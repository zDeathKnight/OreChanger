/**
* File: SortedProperties.java
* created: 14.04.2013 - 19:50:53
* by: RoboMat
*/

package com.Knights.OreChanger.config;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

@SuppressWarnings("serial")
public class SortedProperties extends Properties
{
	/**
	 * Allows any base type to be put into the property file
	 */
	@Override
	public synchronized Object put(Object key, Object value) 
	{
		String temp = String.valueOf(value);
		return super.put(key, temp);
	}

	/**
 	* Sorts the properties in the list.
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Enumeration keys() 
	{
		Enumeration unsortedKeys = super.keys();
		Vector<String> sortedKeys = new Vector<String>();
		/* Copy unsorted keys to vector */
		while (unsortedKeys.hasMoreElements()) 
		{
			sortedKeys.add((String) unsortedKeys.nextElement());
		}
	/* sort the keys */
	Collections.sort(sortedKeys);
	return sortedKeys.elements();
	}
}