package be.ictdynamic.oefeningCollections_1_and_2;

import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Worker;

import java.util.*;

/**
 * Created by wvdbrand on 12/09/2017.
 */
public class OefeningCollections {
    public static void demoSetVersusList() {
        // ArrayList allows insertion-order iterations
        List<Employee> employees = Arrays.asList(new Employee(1, "wim van den brande", 49, Worker.Gender.MALE, null),
                                                 new Employee(2, "hillary clinton", 72, Worker.Gender.FEMALE, null),
                                                 new Employee(3, "bill clinton", 72, Worker.Gender.MALE, null),
                                                 new Employee(1, "wim van den brande", 49, Worker.Gender.MALE, null));

        // ask which method will be invoked to verify the employee is unique !!!
        // comment out this code and run again

        // When you iterate through a HashSet the order is unpredictable,
        // LinkedHashSet allows insertion-order iterations.

        Set<Employee> uniqueEmployeesWithUnPredictableOrder = new HashSet<>(
                Arrays.asList(  new Employee(1, "wim van den brande", 49, Worker.Gender.MALE, null),
                        new Employee(2, "hillary clinton", 72, Worker.Gender.FEMALE, null),
                        new Employee(3, "bill clinton", 72, Worker.Gender.MALE, null),
                        new Employee(1, "wim van den brande", 50, Worker.Gender.MALE, null)));

        Set<Employee> uniqueEmployeesWithPredictableOrder = new LinkedHashSet<>(
                Arrays.asList(  new Employee(1, "wim van den brande", 49, Worker.Gender.MALE, null),
                                new Employee(2, "hillary clinton", 72, Worker.Gender.FEMALE, null),
                                new Employee(3, "bill clinton", 72, Worker.Gender.MALE, null),
                                new Employee(1, "wim van den brande", 50, Worker.Gender.MALE, null)));

        System.out.println("number of entries in employees = " + employees.size());
        System.out.println("number of entries in uniqueEmployee = " + uniqueEmployeesWithPredictableOrder.size());

        System.out.println("uniqueEmployeesWithPredictableOrder = " + uniqueEmployeesWithPredictableOrder);
        System.out.println("uniqueEmployeesWithUnPredictableOrder = " + uniqueEmployeesWithUnPredictableOrder);
    }

    public static void demoHashMapVersusLinkedHashMap() {
        // a HashMap does NOT support predictable iteration order
        // a LinkedHashMap DOES support predictable iteration order

        Map<String, Integer> map1 = new HashMap<>();
        for (Integer i=0; i<100; i++) {
            map1.put(i.toString(), i);
        }

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println("Entry has key " + entry.getKey() + " and value " + entry.getValue());
        }

        Map<String, Integer> map2 = new LinkedHashMap<>();
        for (Integer i=0; i<100; i++) {
            map2.put(i.toString(), i);
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            System.out.println("Entry has key " + entry.getKey() + " and value " + entry.getValue());
        }
    }

    public static void demoLinkedList() {
//        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();

        list.add("this");
        list.add("is");
        list.add(2, "something ");
        list.add(3, "we cannot do with an ArrayList");

        list.addFirst("Ho Ho Ho");

        for (String string : list) {
            System.out.println(string);
        }

    }

}
