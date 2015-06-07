package com.touchableheroes.drafts.patterns;

/**
 * Created by asiebert on 21.07.14.
 */
public class Factory {

    public <T> T create( final Class<T> type) {
        try {
            return type.newInstance();
        } catch (final InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
