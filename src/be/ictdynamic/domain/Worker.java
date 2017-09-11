package be.ictdynamic.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public abstract class Worker extends DatabaseEntity implements Serializable{
    private String name;
    private Integer age;
    private Gender gender;
    private Map<String, Object> remunerations;

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

    public Map<String, Object> getRemunerations() {
        if (remunerations == null) {
            remunerations = new HashMap<>();
        }
        return remunerations;
    }

    public void setRemunerations(Map<String, Object> remunerations) {
        this.remunerations = remunerations;
    }
}
