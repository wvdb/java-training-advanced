package be.ictdynamic.domain;

import be.ictdynamic.enums.TransportType;

import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public abstract class Worker extends DatabaseEntity{
    private String name;
    private Integer age;
    private Gender gender;
    private Set<TransportType> transportTypes;
    private Set<Remuneration> remunerations;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public Worker() {
    }

    public Worker(Integer id, String name, Integer age, Gender gender) {
        super(id);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static void testClassMethod() {
        System.out.println("The static method in Worker");
    }

    public void testInstanceMethod() {
        System.out.println("The instance method in Worker");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // abstract method - the actual impl will be taken care of by the worker's sub-classes
    public abstract Float calculateSalary(Float... objects);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Worker)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Worker worker = (Worker) o;

        if (name != null ? !name.equals(worker.name) : worker.name != null) {
            return false;
        }
        return age != null ? age.equals(worker.age) : worker.age == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
