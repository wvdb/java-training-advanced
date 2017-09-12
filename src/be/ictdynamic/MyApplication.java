package be.ictdynamic;

import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Worker;
import be.ictdynamic.oefeningCollections_1_and_2.OefeningCollections;
import be.ictdynamic.oefeningGenerics_0.OefeningGenerics;
import be.ictdynamic.oefeningStreams_4.OefeningStreams;
import be.ictdynamic.oefening_function_10.ExampleOfAFunction;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class MyApplication {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Geef identifier van de oefening: ");
        int oefeningInteger = reader.nextInt();

        switch (oefeningInteger) {
            case 0:
                MyApplication.oefeningGenerics();
                break;
            case 1:
                MyApplication.oefeningCollectionsList();
                break;
            case 2:
                MyApplication.oefeningCollectionsMap();
                break;
            case 3:
                // A lambda expression represents an anonymous function.
                // It comprises of a set of parameters, a lambda operator (->) and a function body.
                MyApplication.oefeningLambdas();
                ExampleOfAFunction exampleOfAFunction = new ExampleOfAFunction();
                exampleOfAFunction.gettingNameOfTheEmployeeVeryFancy();
                exampleOfAFunction.gettingNameOfTheEmployeeRegular();
                break;
            case 4:
                MyApplication.oefeningStreams();
                break;
            default :
                System.out.println("!!!Geen oefening voorzien.");
        }

        reader.close();

    }

    private static void oefeningGenerics() {
        OefeningGenerics.demoBasic();
        OefeningGenerics.demo0();
        OefeningGenerics.demo1();
        OefeningGenerics.demo2();
        OefeningGenerics.demo3();
    }

    private static void oefeningCollectionsList() {
        OefeningCollections.demoSetVersusList();
    }

    private static void oefeningCollectionsMap() {
        OefeningCollections.demoHashMapVersusLinkedHashMap();
    }

    private static void oefeningLambdas() {
        List<Employee> employees = Arrays.asList(  new Employee(1, "wim van den brande", 49, Worker.Gender.MALE, null)
                                                 , new Employee(2, "hillary clinton", 72, Worker.Gender.FEMALE, null)
                                                 , new Employee(3, "floriaan van den brande", 16, Worker.Gender.MALE, null)
                                                 , new Employee(4, "leo van den brande", 80, Worker.Gender.MALE, null));

        debugEmployees(employees, getAllMaleEmployeesPredicate(), "All Male");
        debugEmployees(employees, getAllNotRetiredMaleEmployeesPredicate(), "Not Retired");
        debugEmployees(employees, employee -> employee.getGender() == Worker.Gender.FEMALE, "Female employees");

        List<Integer> myInts = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        debugGeneric(myInts, myInteger -> myInteger % 2 == 0, "Integer divisible by 2");

        // We are not invoking the method, we are just referencing its name.
        debugGeneric(myInts, IntPredicates::isEven, "Integer divisible by 2");
    }

    public static void debugEmployees(List<Employee> employees, Predicate<Employee> predicate, String predicateType){
        System.out.println("Predicate type = " + predicateType);
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                System.out.println("Our predicated employee = " + employee);
            }
        }
    }

    public static <T> void debugGeneric(List<T> items, Predicate<T> predicate, String predicateType){
        System.out.println("Predicate type = " + predicateType);
        for (T item : items) {
            if (predicate.test(item)) {
                System.out.println("Our predicated item = " + item);
            }
        }
    }

    // Predicate is an example of a functional interfaces

    private static Predicate<Employee> getAllMaleEmployeesPredicate() {
        Predicate<Employee> predicate = employee -> employee.getGender() == Worker.Gender.MALE;
        return predicate;
    }

    private static Predicate<Employee> getAllNotRetiredMaleEmployeesPredicate() {
        Predicate<Employee> predicate = employee -> employee.getAge() < 65;
        predicate.and(getAllMaleEmployeesPredicate());
        return predicate;
    }

    private static void oefeningStreams() {
        OefeningStreams oefeningStreams = new OefeningStreams();
        oefeningStreams.exec();
    }

    // Predicate using Static Method References

    static class IntPredicates {
        public static boolean isOdd(Integer n) { return n % 2 != 0; }
        public static boolean isEven(Integer n) { return n % 2 == 0; }
        public static boolean isPositive(Integer n) { return n >= 0; }
    }
}
