package be.ictdynamic.oefeningCollections_1_and_2;

import be.ictdynamic.domain.*;

import java.util.*;

/**
 * Created by wvdbrand on 12/09/2017.
 */
public class OefeningCollections {
    public static void demoHashSetVsLinkedHashSetAndEquals_1A() {
        // TODO : to ask how many entries each list will contain
        Set<Employee> uniqueEmployeesWithUnPredictableOrder = new HashSet<>(
                Arrays.asList(  new Employee(1, "wim van den brande", 72, Worker.Gender.MALE, null),
                                new Employee(2, "hillary clinton", 72, Worker.Gender.FEMALE, null),
                                new Employee(3, "bill clinton", 72, Worker.Gender.MALE, null),
                                new Employee(1, "kris van den brande", 50, Worker.Gender.MALE, null)));

        LinkedHashSet<Employee> uniqueEmployeesWithPredictableOrder = new LinkedHashSet<>(
                Arrays.asList(  new Employee(1, "wim van den brande", 49, Worker.Gender.MALE, null),
                                new Employee(2, "hillary clinton", 72, Worker.Gender.FEMALE, null),
                                new Employee(3, "bill clinton", 72, Worker.Gender.MALE, null),
                                new Employee(4, "donald trump", 72, Worker.Gender.MALE, null),
                                new Employee(1, "kris van den brande", 50, Worker.Gender.MALE, null)));

        System.out.println("uniqueEmployeesWithUnPredictableOrder size = " + uniqueEmployeesWithUnPredictableOrder.size());
        System.out.println("uniqueEmployeesWithPredictableOrder size = " + uniqueEmployeesWithPredictableOrder.size());

        System.out.println("uniqueEmployeesWithUnPredictableOrder = " + uniqueEmployeesWithUnPredictableOrder);
        System.out.println("uniqueEmployeesWithPredictableOrder = " + uniqueEmployeesWithPredictableOrder);
    }

    public static void execSorted_111A() {
        String[] words = "this is a a test".split(" ");
        SortedSet<String> wordsSorted = new TreeSet<>();
        for (String word : words) {
            wordsSorted.add(word);
        }
        wordsSorted.stream().forEach(System.out::println);
    }

    public static void execTreeSet_111B() {
        // example of Sorted Set
        // ---------------------

        SortedSet<Employee> employeesSorted = new TreeSet<>();

        Employee employee = new Employee(1, "wim van den brande", 50, Worker.Gender.MALE, null);
        employeesSorted.add(employee);

        Employee employee2 = new Employee(2, "kris van den brande", 48, null, null);
        employeesSorted.add(employee2);

        Employee employee3 = new Employee(6, "michelle obama", 55, Worker.Gender.FEMALE, null);
        employeesSorted.add(employee3);

        Employee employee4 = new Employee(5, "donald trump", 71, Worker.Gender.MALE, null);
        employeesSorted.add(employee4);

        Employee employee5 = new Employee(4, "hilary clinton", 72, Worker.Gender.FEMALE, null);
        employeesSorted.add(employee5);

        Employee employee6 = new Employee(0 ,"jan van den brande", 52, Worker.Gender.MALE, null);
        employeesSorted.add(employee6);

//        System.out.println("employeesSortedDefault: " + employeesSorted);

//        System.out.println("employeesSortedDefault first: " + employeesSorted.first());
//        System.out.println("employeesSortedDefault last: " + employeesSorted.last());
        // comparator will be null since we are using the Comparable
//        System.out.println("employeesSortedDefault: " + employeesSorted.comparator());

        // usage of headset
        // Returns a view of the portion of this set whose elements are strictly less than element
        // Returns employees with age < 55
//        SortedSet headSet = employeesSorted.headSet(employee3);
//        System.out.println("headSet: " + headSet);

        // usage of tailSet
        // Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
        // Returns employees with age >= 55
//        SortedSet tailSet = employeesSorted.tailSet(employee3);
//        System.out.println("tailSet: " + tailSet);

        // usage of subSet
        // return a view of the portion of this set whose elements range from
        //         <tt>fromElement</tt>, inclusive, to <tt>toElement</tt>, exclusive
        // Returns employees with age between 50 and 55
//        SortedSet subSet = employeesSorted.subSet(employee, employee3);
//        System.out.println("subSet: " + subSet);

        Employee employee7 = new Employee(100, "nicole kidman", 50, Worker.Gender.FEMALE, null);
        employeesSorted.add(employee7);

        System.out.println("we lost Nicole Kidman .... call Tom!!!");
        System.out.println("employeesSorted !!!: " + employeesSorted);
    }

    public static void execSet_111C() {
        Set<Employee> employees = new HashSet<>();

        Employee employee = new Employee(1, "wim van den brande", 50, Worker.Gender.MALE, null);
        employees.add(employee);

        Employee employee4 = new Employee(5, "donald trump", 71, Worker.Gender.MALE, null);
        employees.add(employee4);

        Employee employee5 = new Employee(4, "hilary clinton", 72, Worker.Gender.FEMALE, null);
        employees.add(employee5);

        Employee employee7 = new Employee(100, "nicole kidman", 50, Worker.Gender.FEMALE, null);
        employees.add(employee7);

        System.out.println("we haven't lost Nicole Kidman");
        System.out.println("employees !!!: " + employees);
    }

    public static void compareBoxes_113() {
        SortedSet<Box> boxes = new TreeSet<>();
        boxes.add(new Box(3,5,2));
        boxes.add(new Box(4,3,7));
        boxes.add(new Box(1,1,1));

        SortedSet<Box2> boxes2 = new TreeSet<>();
        boxes2.add(new Box2(3,5,2));

        for (Box b: boxes) {
            System.out.println(b);
        }

    }

    public static void compareArrayAndArrayList_112() {
        Integer[] array1 = {10, 20, 30};
        Integer[] array2 = {10, 20, 30};

        System.out.println(array1.equals(array2) ? "arrays are equal" : "arrays are not equal");

        ArrayList<String> strings1 = new ArrayList<String>() {{
            add("Geeks");
            add("for");
            add("Geeks");
        }};
        ArrayList<String> strings2 = new ArrayList<String>() {{
            add("Geeks");
            add("for");
            add("Geeks");
        }};

        System.out.println(strings1.equals(strings2) ? "ArrayLists are equal" : "ArrayLists are not equal");
    }

    public static void demoHashMapVersusLinkedHashMap_2() {
        // a HashMap does NOT support predictable iteration order
        // a LinkedHashMap DOES support predictable iteration order

        // example of a map with capacity
        Map<String, Integer> map1 = new HashMap<>(10);
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

    public static void demoMapOlympicGames_2A() {

        Map<String, Integer> myMap = new HashMap<>();

        // map and iteration : flavor 1

        for (Map.Entry entry : myMap.entrySet()) {
            System.out.println("key = " + entry.getKey() + " ,  value = " + entry.getValue());
        }

        // map and iteration : flavor 2 : forEach

        // problem 1 : x has to be final
        // problem 2 : exception behaves different

        String x = "";
        x = "x";

//        myMap.forEach((k, v) -> {
//            if (k.equals(x)) {
//                System.out.println("key = " + "k" );
//            }
//        });

        Map<Integer, Map<String, Integer>> olympicGamesMap = new LinkedHashMap<Integer, Map<String, Integer>>(){{
            put(2016, new LinkedHashMap<String, Integer>() {{
                put("Norway", 39);
                put("Netherlands", 20);
                put("Belgium", 1);
                put("Portugal", 1);
            }});
            put(2018, new LinkedHashMap<String, Integer>() {{
                put("US", 121);
                put("Netherlands", 19);
                put("Belgium", 6);
            }});
        }};

        for (Integer olympicGamesYear : olympicGamesMap.keySet()) {
            Map<String, Integer> olympicGamesbyOccurranceMap = olympicGamesMap.get(olympicGamesYear);
            int total = 0;
            for (String country : olympicGamesbyOccurranceMap.keySet()) {
                total += olympicGamesbyOccurranceMap.get(country);
            }
            System.out.println(String.format("Total number of medals for year %s is %d.", olympicGamesYear, total));
        }

        olympicGamesMap.forEach((olympicGamesYear, olympicGamesbyOccurranceMap) -> {
          final int[] total = {0};
          olympicGamesbyOccurranceMap.forEach((country, numberOfMedalsByyearByCountry) -> {
              total[0] += numberOfMedalsByyearByCountry;
          });
          System.out.println(String.format("Total number of medals for year %s is %d.", olympicGamesYear, total[0]));
        });
    }

    public static void demoAllMatch_2B() {
        List<Employee> employeesOf_EU = new ArrayList<>(
                Arrays.asList(new Employee(1, "wim van den brande", 52, Worker.Gender.MALE, null, "Belgium"),
                        new Employee(2, "merkel", 67, Worker.Gender.FEMALE, null, "Germany"),
                        new Employee(3, "macron", 48, Worker.Gender.MALE, null, "France"),
                        new Employee(4, "floriaan van den brande", 18, Worker.Gender.MALE, null, "Belgium")));

        List<Employee> employeesNotOf_EU = new ArrayList<>(
                Arrays.asList(new Employee(1, "wim van den brande", 52, Worker.Gender.MALE, null, "Belgium"),
                        new Employee(2, "Johnsons", 67, Worker.Gender.MALE, null, "UK"),
                        new Employee(4, "floriaan van den brande", 18, Worker.Gender.MALE, null, "Belgium")));

        List<String> euCountries = new ArrayList<>(Arrays.asList("Belgium", "Netherlands", "Luxembourg", "France", "Germany", "Spain"));

        if (employeesOf_EU.stream().allMatch(employee -> euCountries.contains(employee.getCountry()))) {
            System.out.println("All employeesOf_EU are of EU.");
        }

        if (!employeesNotOf_EU.stream().allMatch(employee -> euCountries.contains(employee.getCountry()))) {
            System.out.println("Not all employeesNotOf_EU are of EU.");
        }
    }

    public static void demoQueue_9() {
        // Second Occurrence of our LinkedList (LinkedList implements List) !!!
        Queue<Employee> employees = new LinkedList<>(
                Arrays.asList(  new Employee(1, "wim van den brande", 49, Worker.Gender.MALE, null),
                        new Employee(2, "hillary clinton", 72, Worker.Gender.FEMALE, null),
                        new Employee(3, "bill clinton", 72, Worker.Gender.MALE, null),
                        new Employee(4, "floriaan van den brande", 50, Worker.Gender.MALE, null)));

        if (employees.peek() != null) {
            Employee firstEmployee = employees.remove();
            System.out.println("firstEmployee = " + firstEmployee);
        }

        System.out.println("Number of entries in queue = " + employees.size());

        if (employees.peek() != null) {
            Employee secondEmployee = employees.remove();
            System.out.println("secondEmployee = " + secondEmployee);
        }

        System.out.println("Number of entries in queue = " + employees.size());

        // The remove and poll methods differ in their behavior only when the queue is empty.
        // Under these circumstances, remove throws NoSuchElementException , while poll returns null .

        while (employees.peek() != null) {
            Employee nextEmployee = employees.remove();
            System.out.println("nextEmployee = " + nextEmployee);
        }

    }

    public static void demoLinkedList_1B() {
        ArrayList arrayListOfIntegers = new ArrayList();
        arrayListOfIntegers.add(1);
        // ArrayList is a dynamic array (hence usage of get by index)
        arrayListOfIntegers.get(0);

        LinkedList<String> linkedListOfIntegers = new LinkedList<>();

        linkedListOfIntegers.add("this");
        linkedListOfIntegers.add("is");
        linkedListOfIntegers.add(2, "something ");
        linkedListOfIntegers.add(3, "we cannot do with an ArrayList");
        linkedListOfIntegers.add("test");

        // addFirst, addLast methods don't exist for ArrayList
        linkedListOfIntegers.addFirst("Ho Ho Ho");

        System.out.println("iteratie na gebruik van addFirst");
        for (String string : linkedListOfIntegers) {
            System.out.println(string);
        }

        // descendingIterator doesn't exist for ArrayList
        Iterator iterator = linkedListOfIntegers.descendingIterator();
        System.out.println("iteratie na gebruik van descendingIterator");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // TO DO : to elaborate on random - access = we do a get but
        // because of impl, an iteration will occur
        // linked list : ADD = FASTER but GET[index] is SLOWER
        linkedListOfIntegers.get(0);
    }

    public static void demoListOfLists_1C() {
        // TODO : do we need the ? ( we don't)
        List<List<? extends Worker>> listOfLists = new ArrayList<>();

        listOfLists.add(Arrays.asList(
                              new Employee(1, "wim van den brande", 49, Worker.Gender.MALE, null)
                            , new Employee(2, "hillary clinton", 72, Worker.Gender.FEMALE, null)
                            , new Employee(3, "floriaan van den brande", 16, Worker.Gender.MALE, null)
                            , new Employee(4, "leo van den brande", 80, Worker.Gender.MALE, null)));

        listOfLists.add(Arrays.asList(
                              new Manager(5, "wim van den brande", 49, Worker.Gender.MALE, null)
                            , new Manager(6, "hillary clinton", 72, Worker.Gender.FEMALE, null)
                            , new Manager(7, "floriaan van den brande", 16, Worker.Gender.MALE, null)
                            , new Manager(8, "leo van den brande", 80, Worker.Gender.MALE, null)));

        for (List list : listOfLists) {
            if (list != null && list.get(0) instanceof Employee) {
                System.out.println("we are dealing with the list of employees.");
                for (Employee employee : (List<Employee>) list) {
                    System.out.println("Employee = " + employee);
                }
            } else if (list != null && list.get(0) instanceof Manager) {
                System.out.println("we are dealing with the list of managers.");
                for (Manager manager : (List<Manager>) list) {
                    System.out.println("Manager = " + manager);
                }
            }
        } /* end for */

    }

    @Deprecated
    public static void demoCollectionAndRemoveUnsafe() {
        List<String> words = new ArrayList<>(10);
        words.add("this");
        words.add("is");
        words.add("a");
        words.add("test");

        for (String word : words ) {
            if (word.length() > 2) {
                words.remove(word);
            }
        }

        System.out.println("number of words = " + words.size());
    }

    public static void demoCollectionAndRemoveSafe() {
        List<String> words = new ArrayList<>();
        words.add("this");
        words.add("is");
        words.add("a");
        words.add("test");

        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.length() > 2) {
                iterator.remove();
            }
        }

        System.out.println("number of words = " + words.size());
    }

}
