package be.ictdynamic;

import be.ictdynamic.domain.*;
import be.ictdynamic.functional_interfaces.TextUtil;
import be.ictdynamic.functional_interfaces.WordProcessor;
import be.ictdynamic.functional_interfaces.WorldFilter;
import be.ictdynamic.oefeningCollections_1_and_2.OefeningCollections;
import be.ictdynamic.oefeningGenerics_0.OefeningGenerics;
import be.ictdynamic.oefeningStreams_4.OefeningStreams;
import be.ictdynamic.oefeningThreads_11.MyRunnableImpl;
import be.ictdynamic.oefeningThreads_11.OefeningThreads;
import be.ictdynamic.oefening_function_10.ExampleOfAFunction;
import be.ictdynamic.utilities.DateUtility;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.DosFileAttributes;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

public class MyApplication {

    public static final String JSP_PDF_FILE = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\jsp.pdf";
    public static final String COPY_JSP_PDF_FILE = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\copy - jsp.pdf";

    public static final String HANS_DULFER_FILE = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\streetbeats.mp3";
    public static final String COPY_HANS_DULFER_FILE = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\copy - streetbeats.mp3";

    public static final String PROPERTY_FILE_AS_TEXT = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\properties.txt";
    public static final String PROPERTY_FILE_AS_XML = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\properties.xml";

    public static final String SERIALIZED_FILE = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\Test.ser";
    public static final String LARGE_SERIALIZED_FILE_1 = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\LargeTest1.ser";
    public static final String LARGE_SERIALIZED_FILE_2 = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\LargeTest2.ser";

    public static final String TEMP_TXT = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\temp.txt";
    public static final String TEMP_ZIP = "C:\\wim\\oak3 - cronos- training\\cursus_data_input_output\\temp.zip";
    private static final String VERY_LARGE_NAME = "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT" + "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS" + "UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU";

    public static void main()  {

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, ClassNotFoundException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter identifier of the exercise ");
        int oefeningInteger = reader.nextInt();

        switch (oefeningInteger) {
            case 0:
                MyApplication.demoGenericsBasic();
                MyApplication.demoGenericsWorker();

                ProcessEmployeeToBeFired processEmployeeToBeFired = new ProcessEmployeeToBeFired();
                MyApplication.demoGenericsMethod(processEmployeeToBeFired);
                break;
            case 1:
//                MyApplication.demoHashSetVsLinkedHashSetAndEquals_1A();
//                OefeningCollections.demoLinkedList_1B();
                OefeningCollections.demoListOfLists_1C();
                break;
            case 2:
                MyApplication.oefeningCollectionsMap();
                break;
            case 3:
                // A lambda expression represents an anonymous function.
                // It comprises of a set of parameters, a lambda operator (->) and a function body.
                MyApplication.oefeningLambdas_3();
                ExampleOfAFunction exampleOfAFunction = new ExampleOfAFunction();
                exampleOfAFunction.gettingNameOfTheEmployeeVeryFancy_3();
                exampleOfAFunction.gettingNameOfTheEmployeeRegular_3();
                break;
            case 30:
                MyApplication.oefeningMethodReferences_30();
                break;
            case 4:
                OefeningStreams oefeningStreams = new OefeningStreams();
//                oefeningStreams.execBasicStreams_40();
                  oefeningStreams.execStreams_41();
//                oefeningStreams.execSorted_42();
//                oefeningStreams.execOlympicMedalsWithForEach_43();
                break;
            case 5:
//                MyApplication.oefeningFile_50();
//                MyApplication.oefeningFile_PDF_51();
                MyApplication.oefeningFile_MP3_51();
//                MyApplication.oefeningFile_52_wim();
//                MyApplication.oefeningFile_52_noel();
                break;
            case 6:
                MyApplication.oefeningSerialisation_failing_6();
                break;
            case 7:
                MyApplication.oefeningSerialisation_7a();
                MyApplication.oefeningSerialisation_7b();
                break;
            case 8:
                MyApplication.oefeningRead_Properties_8();
                break;
            case 11:
                MyApplication.oefeningThreads_11();
                break;
            case 12:
                System.out.println("Enter aantal chars to print ");
                int numberOfCharsToPrint = reader.nextInt();

                MyApplication.oefeningThreads_12(numberOfCharsToPrint);
                break;
            case 13:
                MyApplication.oefeningThreadsWithLambdas_13();
                break;
            case 14:
                MyApplication.oefeningThreadsWithLambdas_14();
                break;
            case 15:
                MyApplication.oefeningThreadsWithTimer_15();
                break;
            case 16:
                MyApplication myApplication = new MyApplication();
                myApplication.oefeningThreadsWithTimer_increment_16();
                break;
            case 17:
                MyApplication myApplication2 = new MyApplication();
                myApplication2.oefeningThreadsWithTimer_populate_17();
                break;
            case 18:
                MyApplication myApplication3 = new MyApplication();
                myApplication3.oefeningThreadsWithTimer_populate_18();
                break;
            case 19:
                MyApplication myApplication4 = new MyApplication();
                myApplication4.oefeningThreadsCallable_19();
                break;
            default:
                System.err.println("!!!No exercise supported.");
        }

        reader.close();

    }

    private static void oefeningFile_50() {
        Path path = Paths.get(TEMP_TXT);
        byte[] bytes = {1, 2, 3};
        List<String> strings = Arrays.asList("4", "5", "6");

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, bytes);
            Files.write(path, strings, Charset.defaultCharset(), StandardOpenOption.APPEND);
            DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);

            System.out.println("isArchive = " + dosFileAttributes.isArchive());
            System.out.println("isReadOnly = " + dosFileAttributes.isReadOnly());

        } catch (IOException e) {
            // TODO : TO BE AVOIDED
//            e.printStackTrace();
            System.err.println("Aanmaken of schrijven ging fout : exception = " + e);
        }

    }

    private static void oefeningFile_PDF_51() {
        // syntax : try with resources

        try (BufferedInputStream inputStream =
                     new BufferedInputStream(new FileInputStream(JSP_PDF_FILE));
             BufferedOutputStream outputStream =
                     new BufferedOutputStream(new FileOutputStream(COPY_JSP_PDF_FILE))) {

            // get number of bytes available
            int numByte = inputStream.available();

            // ho ho : we allocate a lot of memory at once
            byte[] myByteArray = new byte[numByte];

            // perform actual read (one go)
            int bytesRead = inputStream.read(myByteArray);

//             impl READ and WRITE with blocks of 1024 bytes
//                        while (inputStream.read(myByteArray, 0 , 1024) > 0) {
//                            outputStream.write(myByteArray);
//                        }

            // let's create a corrupt PDF -> explain the importance of correctness of every single byte/bit
//            myByteArray[0] = 0;

            System.out.println("Number of bytes available = " + numByte);
            System.out.println("Number of bytes read = " + bytesRead);

            // perform actual write (one go)
            outputStream.write(myByteArray);

            // remark 1: if we would like to store this in a DBMS we need a BLOB
            // remark 2: with Apache TIKA framework we get additional metadata of the file (mime-type)
            // remark 3: problem HP -> DMS + Wicket : working on Windows, not working on customer-acceptance environment (Unix)
        } catch (IOException e) {
            System.out.println("!!!Something went wrong: " + e.getMessage());
        }
    }

    private static void oefeningFile_MP3_51() {
        try (BufferedInputStream inputStream =
                     new BufferedInputStream(new FileInputStream(HANS_DULFER_FILE));
             BufferedOutputStream outputStream =
                     new BufferedOutputStream(new FileOutputStream(COPY_HANS_DULFER_FILE))) {

            // get number of bytes available
            int numByte = inputStream.available();

            // ho ho : we allocate a lot of memory at once
            byte[] myByteArray = new byte[numByte];

            // perform actual read (one go)
            int bytesRead = inputStream.read(myByteArray);

//             impl READ and WRITE with blocks of 1024 bytes
//                        while (inputStream.read(myByteArray, 0 , 1024) > 0) {
//                            outputStream.write(myByteArray);
//                        }

            // enforce a corrupted MP3 file (one byte randomly chosen)
//            myByteArray[0] = -1;
//            myByteArray[1000] = 0;

            System.out.println("Number of bytes available (can be read) = " + numByte);
            System.out.println("Number of bytes read = " + bytesRead);

            // perform actual write (one go)
            outputStream.write(myByteArray);
        } catch (IOException e) {
            System.out.println("!!!Something went wrong: " + e.getMessage());
        }
    }

    private static void oefeningFile_52_wim() {
        FileOutputStream outputStream = null;
        DeflaterOutputStream deflaterOutputStream = null;
        PrintStream printStream = null;

        try {
            String test = "this is a test";

//            outputStream = new BufferedOutputStream(new FileOutputStream(TEMP_ZIP));
//            deflaterOutputStream = new DeflaterOutputStream(outputStream);
//            printStream = new PrintStream(deflaterOutputStream);

            outputStream = new FileOutputStream(TEMP_ZIP);
            deflaterOutputStream = new DeflaterOutputStream(outputStream);
            printStream = new PrintStream(deflaterOutputStream);

            outputStream.write(test.getBytes());

        } catch (IOException e) {
            System.out.println("!!!Something went wrong: " + e.getMessage());
        }
        finally {
            try {
                if (printStream != null) {
                    printStream.close();
                }
                if (deflaterOutputStream != null) {
                    deflaterOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
            catch (Exception e) {
                System.err.println("error when closing: exception = " + e);
            }
        }
    }

    private static void oefeningFile_52_noel() {
        try (PrintStream printStream = new PrintStream(
                new GZIPOutputStream(
                        new FileOutputStream(TEMP_ZIP)))) {
            for (int i = 0; i < 1_000_000; i++) {
                printStream.println("Hello World");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void oefeningSerialisation_failing_6() throws ClassNotFoundException {
        try (
//                ObjectOutputStream outputStream
//                     = new ObjectOutputStream(new FileOutputStream(SERIALIZED_FILE));
             ObjectInputStream inputStream
                     = new ObjectInputStream(new FileInputStream(SERIALIZED_FILE));
        ) {
//            Project2 project2 = new Project2();
//            project2.setName("dummy");
//            project2.setDummy(new Project2.Dummy());
//            outputStream.writeObject(project2);

            Object myObject = inputStream.readObject();
            System.out.println("ClassName of myObject = " + myObject.getClass().getSimpleName());

//            if (myObject instanceof Project2) {
//                System.out.println("we serialized and de-serialized our object perfectly");
//                System.out.println("name of project = " + ((Project2)myObject).getName());
//            }
        } catch (IOException e) {
            System.out.println("!!!Something went wrong: " + e.getMessage());
            System.out.println("!!!Something went wrong: Message = " + e.getMessage() + ". Type exception = " + e.getClass());
        }
    }

    private static void oefeningSerialisation_7a() {
        try {
            Project project = new Project();
            project.setName(VERY_LARGE_NAME);

            GZIPOutputStream zippedOutputStream = new GZIPOutputStream(new FileOutputStream(LARGE_SERIALIZED_FILE_1));
            ObjectOutputStream outputStream2 = new ObjectOutputStream(zippedOutputStream);
            outputStream2.writeObject(project);

            outputStream2.flush();
            outputStream2.close();

            // remark 1: verify number of bytes -> properties of the file
            // remark 2: recommend dedicated libraries
        } catch (IOException e) {
            System.out.println("!!!Something went wrong: Message = " + e.getMessage() + ". Type exception = " + e.getClass());
        }
    }

    private static void oefeningSerialisation_7b() {
        try {
            Project project = new Project();
            project.setName(VERY_LARGE_NAME);
            project.setProjectStartDate(DateUtility.convertLocalDateToDate(LocalDate.of(2001, 1, 1)));
            project.setProjectEndDate(DateUtility.convertLocalDateToDate(LocalDate.of(2019, 12, 31)));

            ObjectOutputStream outputStream2 = new ObjectOutputStream(new FileOutputStream(LARGE_SERIALIZED_FILE_2));
            outputStream2.writeObject(project);

            outputStream2.flush();
            outputStream2.close();
        } catch (IOException e) {
            System.out.println("!!!Something went wrong: Message = " + e.getMessage() + ". Type exception = " + e.getClass());
        }
    }

    private static void oefeningRead_Properties_8() {
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTY_FILE_AS_TEXT);
             FileInputStream fileInputStream_XML = new FileInputStream(PROPERTY_FILE_AS_XML);
            ) {
            Properties properties1 = new Properties();
            properties1.load(fileInputStream);
            properties1.list(System.out);
            System.out.println("\nValue van dummy = " + properties1.get("dummy") + "\n");

            Properties properties2 = new Properties();
            properties2.loadFromXML(fileInputStream_XML);
            properties2.list(System.out);
        }
        catch (Exception e){
            System.err.println("Exception = " + e);
        }

    }

    private static void demoGenericsBasic() {
        OefeningGenerics.demoGenericsBasic();

        Building<WoodMaterialType> building1 = new Building<>();

        // DOES this work ???

//        Building<String> building2 = new Building<>();
//        Building<Object> building3 = new Building<>();
//        Building building4 = new Building();

//        OefeningGenerics.demoGenerics1();
//        OefeningGenerics.demoGenerics2();
//        OefeningGenerics.demoGenerics3();

        new OefeningGenerics().demoComparable();
    }

    private static void demoGenericsWorker() {
        OefeningGenerics.demoGenericsWorker();
    }

    private static void demoGenericsMethod(ProcessEmployeeToBeFired<? extends Employee> processEmployeeToBeFired) {
        GoodEmployee employee = new GoodEmployee(1, "wim van den brande", 51, Worker.Gender.MALE, null);
        processEmployeeToBeFired.fire(employee);
    }

    private static void demoHashSetVsLinkedHashSetAndEquals_1A() {
        OefeningCollections.demoHashSetVsLinkedHashSetAndEquals_1A();
    }

    private static void oefeningCollectionsMap() {
        OefeningCollections.demoHashMapVersusLinkedHashMap();
        OefeningCollections.demoQueue();
    }

    private static void oefeningLambdas_3() {
        List<Employee> employees = Arrays.asList(new Employee(1, "wim van den brande", 49, Worker.Gender.MALE, null),
                new Employee(2, "hillary clinton", 72, Worker.Gender.FEMALE, null),
                new Employee(3, "floriaan van den brande", 16, Worker.Gender.MALE, null),
                new Employee(4, "leo van den brande", 80, Worker.Gender.MALE, null));

        useEmployeePredicateAndLogResult(employees, getAllMaleEmployeesPredicate(), "All Male");
        useEmployeePredicateAndLogResult(employees, getAllNotRetiredMaleEmployeesPredicate(), "Not Retired");
        useEmployeePredicateAndLogResult(employees, employee -> employee.getGender() == Worker.Gender.FEMALE, "Female employees");
        useEmployeePredicateAndLogResult(employees, getAllMaleEmployeesPredicate().and(getAllNotRetiredMaleEmployeesPredicate()), "Male and not retired");

        List<Integer> myInts = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        usePredicateAndLogResult(myInts, myInteger -> myInteger % 2 == 0, "Integer divisible by 2");

        // We are not invoking the method, we are just referencing its name (method-references)
        usePredicateAndLogResult(myInts, IntPredicates::isEven, "Integer divisible by 2");
    }

    private static void oefeningMethodReferences_30() {
        class Text {
            private String sentence;

            private Text(String sentence) {
                this.sentence = sentence;
            }

            private void printProcessedWords(WordProcessor wordProcessor) {
                for (String word : sentence.replace(".","").split(" ")) {
                    System.out.println(wordProcessor.process(word));
                }
            }

            private void printFilteredWords(WorldFilter wordFilterProcessor) {
                for (String word : sentence.replace(".","").split(" ")) {
                    System.out.println("Word " + word + ":" + wordFilterProcessor.isValid(word));
                }
            }
        }

        Text text = new Text("Study hard. Work harder. Be kind. Stay humble.");

        // ex 0
        System.out.println("Usage 0A of FunctionalInterface");
        text.printFilteredWords(myWord -> myWord.contains("e"));
        System.out.println("Usage 0B of FunctionalInterface");
        text.printFilteredWords(myWord -> myWord.startsWith("S"));
        System.out.println("Usage 0C of FunctionalInterface");
        text.printFilteredWords(myWord -> {
                int count = 0;
                for (char c : myWord.toCharArray()) {
                    if (c == 'r')
                        count++;
                }
                if (count == 2) {
                    return true;
                }
                else {
                    return false;
                }
        });
        /* text.printFilteredWords(myWord -> {
            if (myWord.contains("e") && myWord.contains("a")) {
                return true;
            }
            else {
                return false;
            }
        }); */

        // ex 1
        System.out.println("Usage 1 of FunctionalInterface");
        text.printProcessedWords(myWord -> String.format(">>%s<<", myWord));

        // ex 2
        System.out.println("Usage of method reference");
        text.printProcessedWords(TextUtil::formatQuote);

        // ex 3 (simplified version with streams)
        System.out.println("Usage of a stream");
        List<String> words = Arrays.asList("Study hard. Work harder. Be kind. Stay humble.".split(" "));
        List<String> myConvertedWords = words.stream().map(word -> ">>" + word + "<<").collect(Collectors.toList());

        System.out.println("Another example of method reference");
        myConvertedWords.forEach(System.out::println);

        // of
        for (String myConvertedWord : myConvertedWords) {
            System.out.println(myConvertedWord);
        }

    }

    public static void useEmployeePredicateAndLogResult(List<Employee> employees, Predicate<Employee> predicate, String predicateType) {
        System.out.println("Predicate type = " + predicateType);
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                System.out.println("Our predicated employee = " + employee);
            }
        }
    }

    public static <T> void usePredicateAndLogResult(List<T> items, Predicate<T> predicate, String predicateType) {
        System.out.println("Predicate type = " + predicateType);
        for (T item : items) {
            if (predicate.test(item)) {
                System.out.println("Our predicated item = " + item);
            }
        }
    }

    // Predicate is an example of a functional interfaces

    private static Predicate<Employee> getAllMaleEmployeesPredicate() {
        return employee -> employee.getGender() == Worker.Gender.MALE;
    }

    private static Predicate<Employee> getAllNotRetiredMaleEmployeesPredicate() {
        Predicate<Employee> predicate = employee -> employee.getAge() < 65;
        predicate.and(getAllMaleEmployeesPredicate());
        return predicate;
    }

    // Predicate using Static Method References

    static class IntPredicates {
        public static boolean isOdd(Integer n) {
            return n % 2 != 0;
        }

        public static boolean isEven(Integer n) {
            return n % 2 == 0;
        }

        public static boolean isPositive(Integer n) {
            return n >= 0;
        }
    }

    private static void oefeningThreads_11() {
        System.out.println("Enter number of chars to produce ");
        Scanner reader = new Scanner(System.in);
        int numberOfCharsToProduce = reader.nextInt();

        char[] charactersToPrint = {'!', '?', '*', ':', '='};

        for (char characterToPrint : charactersToPrint) {
            OefeningThreads myThread = new OefeningThreads(characterToPrint, numberOfCharsToProduce);
            if (characterToPrint == '!') {
                myThread.setPriority(Thread.MAX_PRIORITY);
            }
            else {
                myThread.setPriority(Thread.MIN_PRIORITY);
            }
            myThread.start();
        }

//        for (int i = 0; i<charactersToPrint.length; i++) {
//            OefeningThreads myThread = new OefeningThreads(charactersToPrint[i], numberOfCharsToProduce);
//            // TODO : this throws an IAE
////            myThread.setPriority(i);
//            myThread.setPriority(i+1);
//            myThread.start();
//        }

        System.out.println("Done with oefeningThreads_11!");
    }

    private static void oefeningThreads_12(int numberOfCharsToPrint) {
        char[] charactersToPrint = {'!', '?', '*', ':', '='};

        for (char characterToPrint : charactersToPrint) {

            MyRunnableImpl myRunnable = new MyRunnableImpl(characterToPrint, numberOfCharsToPrint);

            Thread myThread = new Thread(myRunnable);
            myThread.start();
        }

        System.out.println("Done with oefeningThreads_12!");
    }

    private static void oefeningThreadsWithLambdas_13() {
        char[] charactersToPrint = {'!', '?', '*', ':', '='};

        // thread with lambda

        for (char characterToPrint : charactersToPrint) {
            Thread thread = new Thread(() -> {
                testMethod(characterToPrint, 60);
            });
            thread.start();
        }

        System.out.println("Done with oefeningThreadsWithLambdas_13!");

        // possible output (the sequence of logging is not predictable)

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

    private static void oefeningThreadsWithLambdas_14() throws InterruptedException {
        char[] charactersToPrint = {'!', '?', '*', ':', '='};

//        System.out.println("Aantal processors = " + Runtime.getRuntime().availableProcessors());

        Thread thread1 = new Thread(() -> myPrintMethod('#', 60));
//        thread1.setDaemon(true);
        Thread thread2 = new Thread(() -> myPrintMethod('*', 1000));
        thread2.setDaemon(true);

        thread1.start();
//        thread1.setPriority(Thread.MIN_PRIORITY);

        thread2.start();
//        thread2.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Done with oefeningThreadsWithLambdas_14!");
    }

    private static void myPrintMethod(char c, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
            Thread.yield();
        }
    }

    private static void testMethod(char c, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
        }
    }

    private static void oefeningThreadsWithTimer_15() {
        TimeOutTask task = new TimeOutTask();
        Timer timer = new Timer(true);
        timer.schedule(task, 10_000);

        System.out.println("Even wachten");
        try {
            Thread.sleep(20_100);
        } catch (InterruptedException e) {
            System.err.println("an interrupted exception occurred: " + e);
        }

    }

    private static class TimeOutTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Tijd is verstreken");
        }
    }

    private void oefeningThreadsWithTimer_increment_16() throws InterruptedException {
        Counter counter = new Counter();

        long startTime = System.currentTimeMillis();

//        Thread thread1 = new Thread(() -> increment(counter, Integer.MAX_VALUE));
//        Thread thread2 = new Thread(() -> increment(counter, Integer.MAX_VALUE));
        Thread thread1 = new Thread(() -> increment(counter, 100_000_000));
        Thread thread2 = new Thread(() -> increment(counter, 100_000_000));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long endTime = System.currentTimeMillis();

        System.out.println("Resultaat = " + counter.getCount() + ", processing time in ms = " + (endTime - startTime));

    }

    private void oefeningThreadsWithTimer_populate_17() throws InterruptedException {
        List<Integer> list = new ArrayList<>();
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> populate(list, 10_000));
        Thread thread2 = new Thread(() -> populate(list, 10_000));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long endTime = System.currentTimeMillis();

        System.out.println("Size of list = " + list.size() + ", processing time in ms = " + (endTime - startTime));

    }

    private void oefeningThreadsWithTimer_populate_18() {
        long startTime = System.currentTimeMillis();

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//        List<Integer> list = new ArrayList<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    list.add(i);
                }
            }
        }).start();

        System.out.println("Size of list = " + list.size());

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    list.add(i);
                }
            }
        }).start();

        long endTime = System.currentTimeMillis();

        System.out.println("Size of list = " + list.size() + ", processing time in ms = " + (endTime - startTime));

    }

    private void oefeningThreadsCallable_19() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        PrimeCalculator primeCalculator = new PrimeCalculator(10_000_000);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<List<Long>> future  = executorService.submit(primeCalculator);

        while (!future.isDone()) {
            System.out.println("waiting");
        }

        List<Long> primes = future.get();

//        long endTime = System.currentTimeMillis();
        System.out.println("Er zijn " + primes.size() + " priemgetallen");

        executorService.shutdown();
    }

    private void populate(List<Integer> list, int count) {
        // TODO : to elaborate on error handling

        for (int i = 0; i < count; i++) {
            try {
                list.add(i);
            } catch (Exception e) {
                System.out.println("Something is going wrong : exception = " + e);
            }
        }

//        try {
//            for (int i = 0; i < count; i++) {
//                list.add(i);
//            }
//        } catch (Exception e) {
//            System.out.println("Something is going wrong : exception = " + e);
//        }
    }

    private static void increment(Counter counter, int number) {
        for (int i=0; i<number; i++) {
            counter.increment();
        }
    }

    public class Counter{
        private long counter = 0;

        public synchronized void increment() {
//        public void increment() {
            counter++;
        }

        public synchronized void decrement() {
            counter--;
        }

        public long getCount() {
            return counter;
        }
    }

}

