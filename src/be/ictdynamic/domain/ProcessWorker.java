package be.ictdynamic.domain;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class ProcessWorker<E extends Worker> extends DatabaseEntity{
    // 3 hire methods without generics
    // this is called ....
    public void hire(Employee e) {
        System.out.println("we are hiring Employee with name " + e.getName());
    }
    public void hire(Director e) {
        System.out.println("we are hiring Employee with name " + e.getName());
    }
    public void hire(Manager e) {
        System.out.println("we are hiring Employee with name " + e.getName());
    }

    // 1 hire method with generics
    // since Type Parameter E extends a worker, we can use all the public methods of a worker
    public void hire(E e) {
        System.out.println("we are hiring Employee/Manager/Director with name " + e.getName());
    }

    public void retire(E e) {
        System.out.println("Employee/Manager/Director with name " + e.getName() + " is retiring");
    }

}
