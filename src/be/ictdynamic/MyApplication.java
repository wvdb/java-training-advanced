package be.ictdynamic;

import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Worker;
import be.ictdynamic.oefeningCollections_1_and_2.OefeningCollections;
import be.ictdynamic.oefeningGenerics_0.OefeningGenerics;
import be.ictdynamic.oefeningStreams_4.OefeningStreams;
import be.ictdynamic.oefening_function_10.ExampleOfAFunction;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class MyApplication {

    public static final String JSP_PDF_FILE = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\jsp.pdf";
    public static final String COPY_JSP_PDF_FILE = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\copy - jsp.pdf";

    public static final String HANS_DULFER_FILE = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\streetbeats.mp3";
    public static final String COPY_HANS_DULFER_FILE = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\copy - streetbeats.mp3";

    public static final String TEMP_TXT = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\temp.txt";

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
                OefeningCollections.demoLinkedList();
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
            case 5:
                MyApplication.oefeningFile_5();
                break;
            case 10:
                MyApplication.oefeningThreads();
                break;
            default :
                System.out.println("!!!Geen oefening voorzien.");
        }

        reader.close();

    }

    private static void oefeningFile_5() {
        Path path = Paths.get(TEMP_TXT);
        byte[] bytes = {1,2,3};
//        List<String> strings = Arrays.asList("1", "2", "3");

        try {
            Files.createFile(path);
            Files.write(path, bytes);
//            Files.write(path, strings, Charset.defaultCharset(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            // TO BE AVOIDED
            e.printStackTrace();
        }

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(JSP_PDF_FILE));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(COPY_JSP_PDF_FILE));
            ){
            // get number of bytes available
            int numByte = inputStream.available();

            // ho ho : we allocate a lot of memory at once
            byte[] myByteArray = new byte[numByte];

            // perform actual read (one go)
            int bytesRead = inputStream.read(myByteArray);

            // impl with blocks of 1024 bytes
            //            while (inputStream.read(myByteArray, 0 , 1024) > 0) {
            //                outputStream.write(myByteArray);
            //            }

            // let's create a corrupt PDF -> explain the importance of correctness of every single byte/bit
//            myByteArray[0] = 0;

            System.out.println("Number of bytes available = " + numByte);
            System.out.println("Number of bytes read = " + bytesRead);

            // perform actual write (one go)
            outputStream.write(myByteArray);

            // remark 1: if we would like to store this in a DBMS we need a BLOB
            // remark 2: with Apache TIKA framework we get additional metadata of the file (mime-type)
        }
        catch (IOException e) {
            System.out.println("!!!Something went wrong: " + e.getMessage());
        }
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
        OefeningCollections.demoQueue();
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

    private static void oefeningThreads() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");

        // possible output (volgorde is niet voorspelbaar)

//        Geef identifier van de oefening:
//        10
//        Hello main
//        Done!
//        Hello Thread-0

//        Geef identifier van de oefening:
//        10
//        Hello main
//        Hello Thread-0
//        Done!

    }

}
