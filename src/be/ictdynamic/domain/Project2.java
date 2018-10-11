package be.ictdynamic.domain;

import java.util.Date;

/**
 * Created by wvdbrand on 6/09/2017.
 */
//public class Project2 {
public class Project2 extends DatabaseEntity {
    // You should change the serialVersionUID only when you deliberately want to break compatibility with all existing serializations
    // additional details : https://www.oracle.com/technetwork/articles/java/javaserial-1536170.html

    // changing the UID will cause an InvalidClassException
    private static final long serialVersionUID = -2308207887712196336L;

//    private transient String name;
    private String name;
    private String nameBis;
//    private transient Date projectStartDate;
//    private transient Date projectEndDate;
    private Date projectStartDate;
    private Date projectEndDate;
    private Integer numberOfParticipants;

    // changing the property will cause a java.lang.ClassCastException
    private String propertyWeWillChange;

    public String getPropertyWeWillChange() {
        return propertyWeWillChange;
    }

    public void setPropertyWeWillChange(String propertyWeWillChange) {
        this.propertyWeWillChange = propertyWeWillChange;
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

}
