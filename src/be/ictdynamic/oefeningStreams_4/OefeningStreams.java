package be.ictdynamic.oefeningStreams_4;

import be.ictdynamic.domain.Department;
import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Worker;

import java.util.*;
import java.util.stream.Collectors;

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

    public void exec() {
        // possible NPE !!!
        List<Employee> vdbEmployees1 = initEmployees().stream().filter(employee -> employee.getName().toLowerCase().lastIndexOf("van den brande") >= 0).collect(Collectors.toList());
        System.out.println("number of employees = " + vdbEmployees1.size() + ", : " + vdbEmployees1);
        List<Employee> vdbEmployees2 = initEmployees().stream().filter((employee) -> employee.getName() != null && employee.getName().toLowerCase().lastIndexOf("van den brande") >= 0).collect(Collectors.toList());
        System.out.println("number of employees = " + vdbEmployees2.size() + ", : " + vdbEmployees2);

        // filter, sorted, and map, which can be connected together to form a pipeline
        // collect closes the pipeline and returns a result

        List<Employee> femaleEmployees = initEmployees().stream().filter(employee -> employee.getGender() == Worker.Gender.FEMALE).collect(Collectors.toList());
        System.out.println("number of female employees = " + femaleEmployees.size() + ", : " + femaleEmployees);

        List<Integer> ages = initEmployees().stream().map(employee -> employee.getAge()).collect(Collectors.toList());
        System.out.println("number of ages = " + femaleEmployees.size() + ", : " + ages);

        // DO NOT check for nulls

        // Avoid coding a method that returns null
        // The idea is to not force calling code to immediately handle issues
        List<Employee> otherEmployees = initEmployees().stream().filter(employee -> employee.getGender() == Worker.Gender.OTHER).collect(Collectors.toList());
        System.out.println("number of other employees = " + otherEmployees.size() + ", : " + otherEmployees);

        // be aware - sorting is expensive
        List<Employee> employeesSortedByAge = initEmployees().stream().sorted(comparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println("employeesSortedByAge: " + employeesSortedByAge);

        // example of Optional
        Optional<Employee> optionalEmployee = initEmployees().stream().filter(employee -> employee.getGender() == Worker.Gender.FEMALE).findFirst();
        if (optionalEmployee.isPresent()) {
            System.out.println("Our employees contain multiple genders.");
        }
        else {
            System.out.println("No woman across our employees.");
        }

        // example of parallel stream
        // Parallel streams make sense if the collection is large enough and your computer has enough cores!!!
        // Issues ????

        initEmployees().parallelStream().filter(employee -> employee.getGender() == Worker.Gender.OTHER).collect(Collectors.toList());

        // BTW : streams work on Arrays as well
        Employee myEmployeesArray[] = employeesSortedByAge.toArray(new Employee[employeesSortedByAge.size()]);
        List<Employee> employeesSortedByName = Arrays.stream(myEmployeesArray).sorted(comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println("employeesSortedByName: " + employeesSortedByName);

        Boolean anyMatchBoolean = initEmployees().stream().anyMatch(employee -> new Integer(71).equals(employee.getAge()));
        System.out.println("anyMatchBoolean: " + anyMatchBoolean);

        Boolean allMatch = initEmployees().stream().allMatch(employee -> employee.getId() > 0);
        System.out.println("allMatchBoolean: " + allMatch);

        // example of the flatmap !!! (asked in an interview)
        // NPE als getDepartment geen lazy initialization bevat
        List<Department> departments =
                initEmployees()
                        .stream()
                        .map(Employee::getDepartment)
                        .flatMap(Collection::stream)
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println("departments (collected with a flatmap) : " + departments);


        // streams and sort by Id (using Comparable interface and compareTo method)
        System.out.println("Streams and sort - example 1");
        initEmployees().stream().sorted().forEach(System.out::println);

        // streams and sort by Age (using Comparable interface and compareTo method)
        System.out.println("Streams and sort - example 2");
        initEmployees().stream().sorted(comparing(Worker::getAge)).forEach(System.out::println);

        // example of Sorted Set
        // ---------------------

        SortedSet<Employee> employeesSorted = new TreeSet<>();
        Employee employee = new Employee(1, "wim van den brande", 50, Worker.Gender.MALE, null);
        employeesSorted.add(employee);

        Employee employee2 = new Employee(2, "kris van den brande", 48, null, null);
        employeesSorted.add(employee2);

        employee = new Employee(6, "michelle obama", 55, Worker.Gender.FEMALE, null);
        employeesSorted.add(employee);

        employee = new Employee(5, "donald trump", 71, Worker.Gender.MALE, null);
        employeesSorted.add(employee);

        Employee employee4 = new Employee(4, "hilary clinton", 72, Worker.Gender.FEMALE, null);
        employeesSorted.add(employee4);

        employee = new Employee(0 ,"jan van den brande", 52, Worker.Gender.MALE, null);
        employeesSorted.add(employee);

        System.out.println("employeesSortedDefault first: " + employeesSorted.first());
        System.out.println("employeesSortedDefault last: " + employeesSorted.last());
        // comparator will be null as we are using the Comparable
        System.out.println("employeesSortedDefault: " + employeesSorted.comparator());

        // usage of headset
        // Returns a view of the portion of this set whose elements are strictly less than element
        SortedSet headSet = employeesSorted.headSet(employee2);
        System.out.println("headSet: " + headSet);

        // usage of tailSet
        // Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
        SortedSet tailSet = employeesSorted.tailSet(employee4);
        System.out.println("tailSet: " + tailSet);

    }
}
