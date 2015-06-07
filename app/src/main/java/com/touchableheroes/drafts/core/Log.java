package com.touchableheroes.drafts.core;

/**
 * Created by asiebert on 15.12.14.
 */
public class Log {

    private final String tag;

    public Log(final String tag) {
        this.tag = tag;
    }

    public void debug( final String msg ) {
        android.util.Log.d( this.tag, msg );
    }

    public static Log instance( final String tag ) {
        return new Log(tag);
    }
}
