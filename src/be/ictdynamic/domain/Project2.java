package be.ictdynamic.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wvdbrand on 6/09/2017.
 */
//public class Project2 {
public class Project2 extends DatabaseEntity {
    private static final long serialVersionUID = -2308207887712196335L;

//    private transient String name;
    private String name;
    private String nameBis;
//    private transient Date projectStartDate;
//    private transient Date projectEndDate;
    private Date projectStartDate;
    private Date projectEndDate;
    private Integer numberOfParticipants;
    private Dummy dummy;

    public Dummy getDummy() {
        return dummy;
    }

    public void setDummy(Dummy dummy) {
        this.dummy = dummy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", projectStartDate=" + projectStartDate +
                ", projectEndDate=" + projectEndDate +
                '}';
    }

    public static class Dummy implements Serializable{
    }
}
