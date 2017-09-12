package be.ictdynamic.oefeningGenerics_0;

import be.ictdynamic.domain.DatabaseEntity;
import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Manager;
import be.ictdynamic.domain.Worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wvdbrand on 11/09/2017.
 */
public class OefeningGenerics {
    public static void demoBasic() {
        // actual problem before Java 1.5 (no generics available)

        List employees = new ArrayList();
        Employee createdEmployee = new Employee(1, "wim van den brande", 49, null, null);
        String string = "dit is een test";

        employees.add(createdEmployee);
        employees.add(string);

        Employee employee1 = (Employee) employees.get(0);

        // throws ClassCastException
        // GENERICS HAVE BEEN DESIGNED TO AVOID RUNTIME ERRORS (and to make java more secure!!!)
//        Employee employee2 = (Employee) employees.get(1);
    }

    public static void demo0() {
        List<Employee> employees = new ArrayList<>();
        List<Employee> managers = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        countNumberOfWorkers1(employees);
        countNumberOfWorkers1(managers);
        // does not compile !!!
//        countNumberOfWorkers1(strings);
        countEntriesInList(strings);

        Map<String, Employee> mapOfEmployees = new HashMap<>();
        Map<String, Manager> mapOfManagers = new HashMap<>();
        Map<String, String> mapOfStrings = new HashMap<>();

        exampleWithAMap(mapOfEmployees);
        exampleWithAMap(mapOfManagers);
        // does not compile !!!
//        exampleWithAMap(mapOfStrings);
    }

    public static void demo1() {
        Employee employee = new Employee(1, "wim van den brande", 49, null, null);
        Worker worker = employee;

        // if Foo is a subtype of Bar, and G is some generic type declaration, it is not the case that G<Foo> is a subtype of G<Bar>

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        // does not compile !!!
        // WHY -> course -> page 271
//        List<Worker> workers = employees;
    }

    public static void demo2() {
        List<Employee> employees = new ArrayList<>();
        List<Employee> managers = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        countNumberOfWorkers2(employees);
        countNumberOfWorkers2(managers);
        countNumberOfWorkers2(strings);
    }

    public static void demo3() {
        Hire hire = new Hire();
        String dummy = "";
        hire.executeHire(dummy);

        HireAndFire hireAndFire = new HireAndFire();
        // does not compile
//        hireAndFire.executeFire(dummy);
    }

    private static int countNumberOfWorkers1(List<? extends Worker> listOfWorkers) {
        return listOfWorkers.size();
    }

    // first example of a GENERIC METHOD
    private static <T> int countNumberOfWorkers2(List<T> genericList) {
        return genericList.size();
    }

    // second example of a GENERIC METHOD - schrijfwijze 1
    // Type Variable can be used within the entire method
    private static <T1, T2 extends DatabaseEntity> int countNumberOfWorkers3A(List<T1> genericList, List<T2> otherList) {
        return genericList.size();
    }

    // second example of a GENERIC METHOD - schrijfwijze 2
    // Type Variable can be used within the entire method
    private static <S, T extends DatabaseEntity> int countNumberOfWorkers3B(List<S> genericList, List<T> otherList) {
        List<S> arrayList1 = new ArrayList<>();
        return genericList.size();
    }

    // ? can be replaced as ???
    private static int countEntriesInList(List<?> genericList) {
        Object object = new Object();
        // does not compile !!!
        // you cannot just shove objects into a collection of unknown type.
        // ? tells the compiler that we�re dealing with a subtype of the type T, but we cannot know which one
        // genericList.add(object);
        return genericList.size();
    }

    // Worker and any of its subtypes will be assignment compatible
    private static int countEntriesInList2(List<? super Worker> genericList) {
        Employee employee = new Employee(1, "wim van den brande", 49, null, null);
        Manager manager = new Manager();
        genericList.add(employee);
        genericList.add(manager);
        // does not compile
//        genericList.add(new String());
        return genericList.size();
    }

    private static int exampleWithAMap(Map<String, ? extends Worker> mapOfWorkers) {
        return mapOfWorkers.size();
    }

}
