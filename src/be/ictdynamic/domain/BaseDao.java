package be.ictdynamic.domain;

import java.util.List;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class BaseDao<T> {
    private T entity;

    public BaseDao() {
    }

    public List<T> findAll() {
        return null;
    }

    public T findOne() {
        return null;
    }

    public T create() {
        return entity;
    }

    public T update() {
        return entity;
    }

    public void delete(T entity) {
    }
}
