package be.ictdynamic.oefeningStreams_20;

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

    private Set<Employee> employees = new LinkedHashSet<>(10);

    public OefeningStreams() {
        Employee employee = new Employee(1, "wim van den brande", 50, Worker.Gender.MALE, null);
        Set<Department> departments1 = new LinkedHashSet<>();
        departments1.add(new Department(1, "department 1"));
        departments1.add(new Department(2, "department 2"));
        employee.setDepartment(departments1);
        employees.add(employee);

        employee = new Employee(2, "kris van den brande", 48, null, null);
        Set<Department> departments2 = new LinkedHashSet<>();
        departments2.add(new Department(2, "department 2"));
        departments2.add(new Department(3, "department 3"));
        employee.setDepartment(departments2);
        employees.add(employee);

        employee = new Employee(3 ,"jan van den brande", 52, Worker.Gender.MALE, null);
        employees.add(employee);

        employee = new Employee(4, "hilary clinton", 72, Worker.Gender.FEMALE, null);
        employees.add(employee);

        employee = new Employee(5, "donald trump", 71, Worker.Gender.MALE, null);
        employees.add(employee);

        employee = new Employee(6, "michelle obama", 55, Worker.Gender.FEMALE, null);
        employees.add(employee);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void exec() {
        // possible NPE !!!
        List<Employee> vdbEmployees1 = getEmployees().stream().filter(employee -> employee.getName().toLowerCase().lastIndexOf("van den brande") >= 0).collect(Collectors.toList());
        System.out.println("number of employees = " + vdbEmployees1.size() + ", : " + vdbEmployees1);
        List<Employee> vdbEmployees2 = getEmployees().stream().filter((employee) -> employee.getName() != null && employee.getName().toLowerCase().lastIndexOf("van den brande") >= 0).collect(Collectors.toList());
        System.out.println("number of employees = " + vdbEmployees2.size() + ", : " + vdbEmployees2);

        // filter, sorted, and map, which can be connected together to form a pipeline
        // collect closes the pipeline and returns a result

        List<Employee> femaleEmployees = getEmployees().stream().filter(employee -> employee.getGender() == Worker.Gender.FEMALE).collect(Collectors.toList());
        System.out.println("number of employees = " + femaleEmployees.size() + ", : " + femaleEmployees);

        List<Integer> ages = getEmployees().stream().map(employee -> employee.getAge()).collect(Collectors.toList());
        System.out.println("number of ages = " + femaleEmployees.size() + ", : " + ages);

        // be aware - sorting is expensive
        List<Employee> employeesSortedByAge = getEmployees().stream().sorted(comparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println("employeesSortedByAge: " + employeesSortedByAge);

        // BTW : streams work on Arrays as well
        Employee myEmployeesArray[] = employeesSortedByAge.toArray(new Employee[employeesSortedByAge.size()]);
        List<Employee> employeesSortedByName = Arrays.stream(myEmployeesArray).sorted(comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println("employeesSortedByName: " + employeesSortedByName);

        Boolean anyMatchBoolean = getEmployees().stream().anyMatch(employee -> new Integer(71).equals(employee.getAge()));
        System.out.println("anyMatchBoolean: " + anyMatchBoolean);

        Boolean allMatch = getEmployees().stream().allMatch(employee -> employee.getId() > 0);
        System.out.println("anyMatchBoolean: " + allMatch);

        // example of the flatmap !!! (asked in an interview)
        // NPE als getDepartment geen logica bevat
        List<Department> departments =
                getEmployees()
                        .stream()
                        .map(Employee::getDepartment)
                        .flatMap(Collection::stream)
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println("departments: " + departments);
    }
}
