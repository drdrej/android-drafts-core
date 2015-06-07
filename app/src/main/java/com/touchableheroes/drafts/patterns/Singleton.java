package com.touchableheroes.drafts.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asiebert on 21.06.14.
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private final Map<Class<?>, Object> cache = new HashMap<Class<?>, Object>(10);

    public static final Singleton instance() {
           return INSTANCE;
    }

    public synchronized <T> T register(final T value) {
        cache.put( value.getClass(), value );

        return value;
    }

    public synchronized void register(final Class<?> key, final Object value) {
        cache.put( key, value );
    }

    public synchronized <T> T byType(final Class<T> type) {
        return byType(type, null);
    }

    public synchronized <T> T byType(final Class<T> type, T value) {
        final Object instance = cache.get(type);

        if( instance == null )
            return value;


        return (T) instance;
    }

    public static synchronized <T> T byMagic(final Class<T> type) {
        final T exists = instance().byType(type);

        if(exists != null) return exists;

        try {
            final T created = type.newInstance();
            instance().register(created);

            return created;
        } catch (final Throwable e) {

            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param type
     * @param useNewInstance
     * @param <T>
     *
     * @return New Instance if instance not cached and usNewInstance is true.
     */
    private synchronized <T> T byType(final Class<T> type, final boolean useNewInstance) {
        final Object instance = cache.get(type);

        if( instance == null ) {
            if( useNewInstance )
                return newInstance(type);
            else
                return null;
        }

        return (T) instance;
    }

    private <T> T newInstance(Class<T> type) {
        try {
            final T inst = type.newInstance();
            cache.put(type, inst);

            return (T) inst;
        } catch (final Throwable t) {
            System.out.println("-- couldn't build instance of type: " + type);
            t.printStackTrace();;
        }

        return null;
    }
}
