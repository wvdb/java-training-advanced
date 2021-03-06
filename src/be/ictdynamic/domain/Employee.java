package be.ictdynamic.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
//public class Employee extends Worker {
public class Employee extends Worker implements Comparable<Employee> {
    // every sub-class of worker has a hireDate, a worker doesn't
    private Date hireDate;
    private Set<Project> projects;
    private Set<Department> department;
    private String country;

    public Employee(Integer id, String name, Integer age, Gender gender, Date hireDate) {
        super(id, name, age, gender);
        this.hireDate = hireDate;
    }

    public Employee(Integer id, String name, Integer age, Gender gender, Date hireDate, String country) {
        this(id, name, age, gender, hireDate);
        this.country = country;
    }

    public Employee() {
    }

    public Employee(Integer id, String name, Integer age) {
        super(id, name, age, null);
    }

    public String getCountry() {
        return country;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Department> getDepartment() {
        if (department == null) {
            department = new LinkedHashSet<>();
        }
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }

    //    @Override
    public static void testClassMethod() {
        System.out.println("The static method in Employee");
    }

    @Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Employee");
    }

    @Override
    public Float calculateSalary(Float... objects) {
//        assert objects != null;
        if (objects == null) {
            throw new IllegalArgumentException("An Employee should have at least one remuneration.");
        }
        if (objects.length > 1) {
            throw new IllegalArgumentException("An Employee cannot have more than one remuneration.");
        }
        return objects[0];
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", age=" + getAge() +
                ", hireDate=" + hireDate +
                ", projects=" + projects +
                ", department=" + department +
                "}";
    }

    @Override
    public int compareTo(Employee employeeOther) {
//        return getId().compareTo(employeeOther.getId());
        return getAge().compareTo(employeeOther.getAge());
//        if getName().compareTo(employeeOther.getName());
    }
}
