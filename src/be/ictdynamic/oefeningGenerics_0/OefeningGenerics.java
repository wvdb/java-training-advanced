package be.ictdynamic.oefeningGenerics_0;

import be.ictdynamic.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wvdbrand on 11/09/2017.
 */
public class OefeningGenerics {
    // DO WE EXTEND OR DO WE IMPLEMENT ???

    // https://stackoverflow.com/questions/976441/java-generics-why-is-extends-t-allowed-but-not-implements-t

    public class MyComparable<E extends Comparable<E>> {
        public E dummy1;
        public E dummy2;

        public MyComparable(E dummy1, E dummy2) {
            this.dummy1 = dummy1;
            this.dummy2 = dummy2;
        }

        public E getHighest() {
            if (dummy1.compareTo(dummy2) > 0 ) {
                return dummy1;
            }
            else {
                return dummy2;
            }
        }
    }

    public static void demoGenericsBasic() {
        // actual problem before Java 1.5 (no generics available)

        // REMARK 0 : List is a dynamic array
        // REMARK 1 : generics are not obligatory
        // REMARK 2 : generics should be ONLY used when truly necessarry (when designing generic things)

        List employees1 = new ArrayList();
        Employee createdEmployee = new Employee(1, "wim van den brande", 49, null, null);
        String string = "this is a test";

        employees1.add(createdEmployee);
        employees1.add(string);

        // TODO : to ask question : is this gonna work

        Employee employee1A = (Employee) employees1.get(0);
        Employee employee1B = (Employee) employees1.get(1);








        // throws ClassCastException
        // GENERICS HAVE BEEN DESIGNED TO AVOID RUNTIME ERRORS (and to make java more secure!!!)

        List<Employee> employees2 = new ArrayList<>();

//         TODO : to ask question : is this gonna work

//        employees2.add(createdEmployee);
//        employees2.add(string);




        List employees3 = new ArrayList();

        employees3.add(createdEmployee);
        employees3.add(string);

        for (Object object : employees3) {
            if (object instanceof Employee)  {
                Employee employee3 = (Employee) object;
            }
            else {
                String dummyString = (String) object;
            }
        }

    }

    public void demoComparable() {
        MyComparable<String> myComparable = new MyComparable<>("ABC", "DEF");
        System.out.println(myComparable.getHighest());

        // DOES THIS WORK ???

        MyComparable<Department> myComparable2 = new MyComparable<>(new Department(1, "dept A", ""), new Department(2, "dept B", ""));
        System.out.println(myComparable2.getHighest());
    }


    public static void demoGenericsWorker() {
        ProcessWorker processWorker = new ProcessWorker();
        processWorker.hire(new Employee(1, "wim van den brande", 51, Worker.Gender.MALE, null));
    }

    public static void demoGenerics1() {
        Employee employee = new Employee(1, "wim van den brande", 49, null, null);
        Worker worker = employee;

        // if Foo is a subtype of Bar, and G is some generic type declaration, it is not the case that G<Foo> is a subtype of G<Bar>

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        // does not compile !!!
        // WHY -> course -> page 271
//        List<Worker> workers = employees;
    }

    public static void demoGenerics2() {
        List<Employee> employees = new ArrayList<>();
        List<Employee> managers = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        countNumberOfWorkers2(employees);
        countNumberOfWorkers2(managers);
        countNumberOfWorkers2(strings);

        countNumberOfWorkers3A(managers, employees);
    }

    private static int countNumberOfWorkers1(List<? extends Worker> listOfWorkers) {
        return listOfWorkers.size();
    }

    // first example of type parameters (17.4.4)
    private static <T> int countNumberOfWorkers2(List<T> genericList) {
        return genericList.size();
    }

    // second example of type parameters (17.4.4)
    // Type Variable can be used within the entire method
    private static <T1 extends DatabaseEntity, T2 extends DatabaseEntity>
    void countNumberOfWorkers3A(  List<T1> genericListOfDatabaseEntities1
                                , List<T2> genericListOfDatabaseEntities2) {
//    private static <DatabaseEntity>
//                void countNumberOfWorkers3A(  List<DatabaseEntity> genericListOfDatabaseEntities1
//                                            , List<DatabaseEntity> genericListOfDatabaseEntities2) {
        if (genericListOfDatabaseEntities1.size() > genericListOfDatabaseEntities2.size()) {
            System.out.println("genericListOfDatabaseEntities1 is de grootste");
        }
        else if (genericListOfDatabaseEntities1.size() < genericListOfDatabaseEntities2.size()) {
            System.out.println("genericListOfDatabaseEntities2 is de grootste");
        } else {
            System.out.println("genericListOfDatabaseEntities zijn gelijk qua grootte");
        }
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
        // ? tells the compiler that we are dealing with a subtype of the type T,
        // but we cannot know which one

//        genericList.add(object);

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
