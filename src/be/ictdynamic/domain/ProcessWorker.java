package be.ictdynamic.domain;

/**
 * Created by wvdbrand on 24/08/2018.
 */
public class ProcessWorker<E extends Worker> extends DatabaseEntity{
    // 3 hire methods without generics
    // this is called ....
    public void hire(Employee worker) {
        System.out.println("we are hiring Employee with name " + worker.getName());
    }
    public void hire(Director worker) {
        System.out.println("we are hiring Employee with name " + worker.getName());
    }
    public void hire(Manager worker) {
        System.out.println("we are hiring Employee with name " + worker.getName());
    }

    // 1 hire method with generics
    // since Type Parameter E extends a worker, we can use all the public methods of a worker

    // NAMING CONVENTIONS !!! e or worker
    public void hire(E e) {
        System.out.println("we are hiring Employee/Manager/Director with name " + e.getName());
    }

    public void retire(E e) {
        System.out.println("Employee/Manager/Director with name " + e.getName() + " is retiring");
    }

}
