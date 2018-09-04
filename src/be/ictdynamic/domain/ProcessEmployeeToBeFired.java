package be.ictdynamic.domain;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class ProcessEmployeeToBeFired<E extends Employee> {
    public void fire(Employee e) {
        System.out.println("Employee with name " + e.getName() + " is being fired");
    }
}
