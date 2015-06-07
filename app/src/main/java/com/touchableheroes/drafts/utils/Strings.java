package com.touchableheroes.drafts.utils;


/**
 * Simple class to handle Strings and String-checks.
 * 
 * @author A. Siebert / ask@touchableheroes.com
 */
public class Strings {

	public static final boolean isSame(final String str1, final String str2) {
		if (str1 == null)
			throw new NullPointerException("Parameter:str1 is NULL");
		if (str2 == null)
			throw new NullPointerException("Parameter:str2 is NULL");
		
		return str1.equalsIgnoreCase(str2);
	}
	
	public static boolean isEmpty(final String str) {
		return (str == null || str.length() == 0);
	}
}
