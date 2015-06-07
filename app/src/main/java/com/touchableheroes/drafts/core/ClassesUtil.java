package com.touchableheroes.drafts.core;

import android.view.View;

/**
 * Created by asiebert on 01.08.14.
 */
public class ClassesUtil {


    public static Class[] getClassesOf(final View[] views) {
        if( views == null )
            throw new NullPointerException();

        if( views.length < 0 )
            return new Class[0];

        final Class[] rval = new Class[views.length];

        int count = 0;
        for (final View view : views ) {
            if( view == null )
                throw new IllegalArgumentException( "Element on position [= " + count + "] is NULL. Can't extract class." );

            rval[count] = view.getClass();
            count++;
        }

        return rval;
    }
}
