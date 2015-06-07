package com.touchableheroes.drafts.utils;

import android.util.SparseArray;

import java.util.Iterator;

/**
 * Created by asiebert on 21.07.14.
 */
public class SparseArrayIterator<T> implements Iterator<T> {

    private final SparseArray<T> source;

    /**
     * start with 0 element.
     */
    private int key = 0;

    public SparseArrayIterator(final SparseArray<T> source) {
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        final int lastElement = this.source.size() - 1;

        return ( key <= lastElement && lastElement > -1 );
    }

    @Override
    public T next() {
        final T rval = source.valueAt(key);
        key++;
        return rval;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }



}
