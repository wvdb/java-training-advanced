package be.ictdynamic.domain;

import java.io.Serializable;

/**
 * Created by wvdbrand on 6/09/2017.
 */
public class DatabaseEntity implements Serializable{
    private Integer id;

    public DatabaseEntity() {
    }

    public DatabaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatabaseEntity)) return false;

        DatabaseEntity databaseEntity = (DatabaseEntity) o;

        return id.equals(databaseEntity.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
