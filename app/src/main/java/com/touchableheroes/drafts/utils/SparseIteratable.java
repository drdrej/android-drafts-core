package com.touchableheroes.drafts.utils;

import android.util.SparseArray;

import java.util.Iterator;

/**
 * Created by asiebert on 21.07.14.
 */
public class SparseIteratable<T> implements Iterable<T> {

    private final SparseArray<T> source;

    SparseIteratable(final SparseArray<T> source) {
        this.source = source;
    }

    @Override
    public Iterator<T> iterator() {
        return new SparseArrayIterator<T>(source);
    }

    public static <K> Iterable<K> iterable( final SparseArray<K> source) {
        return new SparseIteratable<K>(source);
    }

}
