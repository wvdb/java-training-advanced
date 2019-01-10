package be.ictdynamic.domain;

import java.util.List;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class DummyGeneric<T extends Number & Comparable> {
    private T entity;

    public DummyGeneric() {
    }

    public List<T> findAll() {
        return null;
    }

    public T findOne() {
        return null;
    }

    public T create() {
        return null;
    }
}
