package be.ictdynamic.oefeningStreams_4;

import be.ictdynamic.domain.Department;
import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Worker;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by wvdbrand on 8/09/2017.
 */
public class OefeningStreams {

    private Set<Employee> employees;

    public OefeningStreams() {
        employees = this.initEmployees();

        Employee employee = new Employee(1, "wim van den brande", 50, Worker.Gender.MALE, null);
        Set<Department> departments1 = new LinkedHashSet<>();
        departments1.add(new Department(1, "department 1", ""));
        departments1.add(new Department(2, "department 2", ""));
        employee.setDepartment(departments1);
        employees.add(employee);

        employee = new Employee(2, "kris van den brande", 48, null, null);
        Set<Department> departments2 = new LinkedHashSet<>();
        departments2.add(new Department(2, "department 2", ""));
        departments2.add(new Department(3, "department 3", ""));
        employee.setDepartment(departments2);
        employees.add(employee);

        employee = new Employee(6, "michelle obama", 55, Worker.Gender.FEMALE, null);
        employees.add(employee);

        employee = new Employee(5, "donald trump", 71, Worker.Gender.MALE, null);
        employees.add(employee);

        employee = new Employee(4, "hilary clinton", 72, Worker.Gender.FEMALE, null);
        employees.add(employee);

        employee = new Employee(3 ,"jan van den brande", 52, Worker.Gender.MALE, null);
        employees.add(employee);
    }

    public Set<Employee> initEmployees() {
        if (employees == null) {
            employees = new LinkedHashSet<>(10);
        }
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void execBasicStreams_40() {
        System.out.println("usage of iterate and limit");
        IntStream.iterate(0, i -> i + 1).limit(5).forEach(i -> System.out.println(i));
        System.out.println("kwadraat");
        IntStream.rangeClosed(1, 10).forEach((int i)->System.out.println(i*i));
        OptionalInt max = IntStream.rangeClosed(1, 10).max();

        // review question 1
        System.out.println("... review question 1 ");
        Stream<String> stream = Stream.iterate("", s -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));

        // TODO : why stream 2 ???
        // TODO : actual solution
        System.out.println("... review question 1 ");
        Stream<String> stream2 = Stream.iterate("", s -> s + "1");
        stream2.limit(2).map(x -> x + "2").forEach(System.out::print);

        // generate 1
        System.out.println("");
        System.out.println("... generate - dummy");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // generate 2
        System.out.println("... lotto getallen");
        IntStream.generate(() -> ThreadLocalRandom.current().nextInt(45)).limit(6).sorted().forEach(i -> System.out.println(String.format("%02d", i)));

        // reduce
        System.out.println("... reduce ");
        System.out.println("Faculteit van 6 = "
                + IntStream.rangeClosed(1, 6).reduce(10, (acc, el) -> acc * el));

    }

    public void execStreams_41() {
        // possible NPE !!!
        List<Employee> vdbEmployees1 =
                        employees
                        .stream()
                        .filter(employee -> employee.getName().toLowerCase().lastIndexOf("van den brande") >= 0)
                        .collect(Collectors.toList());

        System.out.println("number of employees = " + vdbEmployees1.size() + ", : " + vdbEmployees1);
        List<Employee> vdbEmployees2 = initEmployees().stream().filter((employee) -> employee.getName() != null && employee.getName().toLowerCase().lastIndexOf("van den brande") >= 0).collect(Collectors.toList());
        System.out.println("number of employees = " + vdbEmployees2.size() + ", : " + vdbEmployees2);

        // filter, sorted, and map, which can be connected together to form a pipeline
        // collect closes the pipeline and returns a result

        List<Employee> femaleEmployees = initEmployees().stream().filter(employee -> employee.getGender() == Worker.Gender.FEMALE).collect(Collectors.toList());
        System.out.println("number of female employees = " + femaleEmployees.size() + ", : " + femaleEmployees);

        List<Integer> ages = initEmployees().stream().map(employee -> employee.getAge()).collect(Collectors.toList());
        System.out.println("number of ages = " + femaleEmployees.size() + ", : " + ages);

        List<Employee> otherEmployees = initEmployees().stream().filter(employee -> employee.getGender() == Worker.Gender.OTHER).collect(Collectors.toList());
        System.out.println("number of other employees = " + otherEmployees.size() + ", : " + otherEmployees);

        // example of sort
        // be aware - sorting is expensive
        List<Employee> employeesSortedByAge = initEmployees().stream().sorted(comparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println("employeesSortedByAge: " + employeesSortedByAge);

        // example of Optional
        Optional<Employee> optionalEmployee =
                initEmployees()
                        .stream()
                        .filter(employee -> employee.getGender() == Worker.Gender.FEMALE)
                        .findFirst();
        if (optionalEmployee.isPresent()) {
            System.out.println("Our employees contain multiple genders. A female employee = " + optionalEmployee.get());
        }
        else {
            System.out.println("Our employees doesn't contain multiple genders.");
        }

        // example with array (useful ???)
        String[] words = {"dit", "is", "een", "een", "test"};
        System.out.println("aantal woorden" + Stream.of(words).count());
        System.out.println("aantal woorden (distinct)" + Stream.of(words).distinct().count());

        // example of parallel stream
        // Parallel streams make sense if the collection is large enough and your computer
        // has enough cores!!!
        // Issues ????

        initEmployees().parallelStream().filter(employee -> employee.getGender() == Worker.Gender.OTHER).collect(Collectors.toList());

        Employee myEmployeesArray[] = employeesSortedByAge.toArray(new Employee[employeesSortedByAge.size()]);
        List<Employee> employeesSortedByName =
                Arrays
                        .stream(myEmployeesArray)
                        .sorted(comparing(Employee::getName))
                        .collect(Collectors.toList());
        System.out.println("employeesSortedByName: " + employeesSortedByName);

        Boolean anyMatchBoolean = initEmployees()
                .stream()
                .anyMatch(employee -> new Integer(71).equals(employee.getAge()));
        System.out.println("anyMatchBoolean: " + anyMatchBoolean);

        Boolean allMatch = initEmployees()
                .stream()
                .allMatch(employee -> employee.getId() > 0);
        System.out.println("allMatchBoolean: " + allMatch);

        // example of the flatmap !!!
        // NPE als getDepartment geen lazy initialization bevat
        // TODO : to explain why we need flatmap and distinct
        // The map converts, per employee, to a set of departments (so still a list).
        // The flatMap converts the 2 lists to one list of departments (with 4 entries).
        //      So ALL the departments of ALL the employees.
        // The distinct selects the unique departments (3 out of 4)
        List<Department> departments =
                employees
                        .stream()
//                        example of method reference
//                        .map(Employee::getDepartment)
                        .map(employee -> employee.getDepartment())
                        .peek(department -> System.out.println("department (after map) = " + department))
                        .flatMap(Collection::stream)
                        .peek(department -> System.out.println("department (after flatMap) = " + department))
                        .distinct()
                        .peek(department -> System.out.println("department (after distinct) = " + department))
                        .collect(Collectors.toList());

        System.out.println("departments (collected with a flatMap) : " + departments);

        // streams and sort by Id (using Comparable interface and compareTo method)
        System.out.println("Streams and sort - example 1");
        initEmployees().stream().sorted().forEach(System.out::println);

        // streams and sort by Age (using Comparable interface and compareTo method)
        System.out.println("Streams and sort - example 2");
        initEmployees().stream().sorted(comparing(Worker::getAge)).forEach(System.out::println);
//        initEmployees().stream().sorted(comparing(Employee::getHireDate)).forEach(System.out::println);

        IntStream intStream = IntStream.rangeClosed(0, 10);
        intStream.forEach(myInt -> System.out.println("Result = " + myInt));

        optionalEmployee =
                initEmployees()
                        .stream()
                        .filter(employee -> employee.getGender() == Worker.Gender.FEMALE)
                        .findFirst();

    }

    public void execSorted_42() {
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

        System.out.println("employeesSortedDefault: " + employeesSorted);

        System.out.println("employeesSortedDefault first: " + employeesSorted.first());
        System.out.println("employeesSortedDefault last: " + employeesSorted.last());
        // comparator will be null since we are using the Comparable
        System.out.println("employeesSortedDefault: " + employeesSorted.comparator());

        // usage of headset
        // Returns a view of the portion of this set whose elements are strictly less than element
        // Returns employees with age < 55
        SortedSet headSet = employeesSorted.headSet(employee3);
        System.out.println("headSet: " + headSet);

        // usage of tailSet
        // Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
        // Returns employees with age >= 55
        SortedSet tailSet = employeesSorted.tailSet(employee3);
        System.out.println("tailSet: " + tailSet);

        // usage of subSet
        // return a view of the portion of this set whose elements range from
        //         <tt>fromElement</tt>, inclusive, to <tt>toElement</tt>, exclusive
        // Returns employees with age between 50 and 55
        SortedSet subSet = employeesSorted.subSet(employee, employee3);
        System.out.println("subSet: " + subSet);

        Employee employee7 = new Employee(100, "nicole kidman", 50, Worker.Gender.FEMALE, null);
        employeesSorted.add(employee7);

        // we lost Nicole Kidman .... call Tom!!!
        System.out.println("employeesSorted !!!: " + employeesSorted);
    }

    public String execOptional_43() {
        SortedSet<Employee> employeesSorted = new TreeSet<>();

        Employee employee1 = new Employee(1, "wim van den brande", 50, Worker.Gender.MALE, null);
        employeesSorted.add(employee1);

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

        // Instead of a sequence of if-statements the filter and map methods are combined in a fluent style

        return findMeAWomenOf50YearsOld(employeesSorted)
                .map(employee -> "Me happy")
                .orElse("I'm gonna be lonesome");
    }

    private Optional<Employee> findMeAWomenOf50YearsOld(SortedSet<Employee> employeesSorted) {
        Optional<Employee> myWoman = employeesSorted.stream().filter(employee -> employee.getGender() == Worker.Gender.FEMALE && employee.getAge() == 50).findAny();
        return myWoman;
    }

    public void execOlympicMedalsWithForEach_44() {
        Map<String, Map<String, Integer>> olympicMedalsPerYearPerCountry = new HashMap<>();

        Map<String, Integer> mapOfTotalMedalsByCountry = new HashMap<>();

        Map<String, Integer> mapOfMedals2016 = new HashMap<>();
        mapOfMedals2016.put("NL", 12);
        mapOfMedals2016.put("BE", 4);
        mapOfMedals2016.put("US", 22);
        mapOfMedals2016.put("RUS", 1);

        olympicMedalsPerYearPerCountry.put("2016", mapOfMedals2016);

        Map<String, Integer> mapOfMedals2020 = new HashMap<>();
        mapOfMedals2020.put("NL", 6);
        mapOfMedals2020.put("BE", 40);
        mapOfMedals2020.put("US", 5);
        mapOfMedals2020.put("RUS", 0);

        olympicMedalsPerYearPerCountry.put("2020", mapOfMedals2020);

        // example of a foreach in a foreach

        olympicMedalsPerYearPerCountry.forEach(
                (keyYear, mapMedalsPerCountry) -> {
                    mapMedalsPerCountry.forEach((keyCountry, numberOfMedalsByYearByCountry) -> {
                        System.out.println("Entry : year = " + keyYear + ", country = " + keyCountry + ", number = " + numberOfMedalsByYearByCountry);
                        // do we prefer this

                        if (mapOfTotalMedalsByCountry.get(keyCountry) == null) {
                            mapOfTotalMedalsByCountry.put(keyCountry, numberOfMedalsByYearByCountry);
                        }
                        else {
                            mapOfTotalMedalsByCountry.put(keyCountry, mapOfTotalMedalsByCountry.get(keyCountry) + numberOfMedalsByYearByCountry);
                        }

                        // or do we prefer this ???
//                        mapOfTotalMedalsByCountry.merge(keyCountry, numberOfMedalsByYearByCountry, (a, b) -> a + b);
                    });
                }
        );

        // number of medals per country
        mapOfTotalMedalsByCountry.forEach((keyCountry, value) -> System.out.println("Country = " + keyCountry + ", # of medals: " + value));

    }
}

