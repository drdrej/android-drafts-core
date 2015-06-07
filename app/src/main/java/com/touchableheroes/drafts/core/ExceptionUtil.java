package com.touchableheroes.drafts.core;

/**
 * Created by asiebert on 15.12.14.
 */
public class ExceptionUtil {


    public static final NullPointerException paramNPECheck(final String paramName) {
        return new NullPointerException( "PARAM:" + paramName );
    }
}
