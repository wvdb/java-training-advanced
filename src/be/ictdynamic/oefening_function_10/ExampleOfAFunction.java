package be.ictdynamic.oefening_function_10;

import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class ExampleOfAFunction {
    public void gettingNameOfTheEmployeeVeryFancy_3() {
        Function<Employee, String> getNameOfEmployeeFunction = Employee::getName;

        List<Employee> employees = getEmployees();

        List<String> empNameList = this.convertEmployeeListToStringWithNamesList(employees, getNameOfEmployeeFunction);

        empNameList.forEach(System.out::println);
    }

    public void gettingNameOfTheEmployeeRegular_3() {
        List<Employee> employees = getEmployees();

        List<String> empNameList = this.convertEmployeeListToStringWithNamesList(employees);

        empNameList.forEach(System.out::println);
    }

    private List<Employee> getEmployees() {
        return Arrays.asList(new Employee(1, "Tom Jones", 45, null, null),
                new Employee(2, "Harry Major", 25, null, null),
                new Employee(3, "Ethan Hardy", 65, null, null),
                new Employee(4, "Nancy Smith", 15, null, null),
                new Employee(5, "Deborah Sprightly", 29, null, null));
    }

    public List<String> convertEmployeeListToStringWithNamesList(List<Employee> employees, Function<Employee, String> funcEmpToString){
        List<String> employeeNames = new ArrayList<>();
        for (Employee employee: employees){
            // apply the actual function (get the name of the employee) on the employee
            employeeNames.add(funcEmpToString.apply(employee));
        }
        return employeeNames;
    }

    public List<String> convertEmployeeListToStringWithNamesList(List<Employee> employees){
//        List<String> employeeNames = new ArrayList<>();
//        for (Employee employee: employees){
//            employeeNames.add(getNameOfEmployee(employee));
//        }
//        return employeeNames;
        return employees.stream().map(Worker::getName).collect(Collectors.toList());
    }

    private String getNameOfEmployee(Employee employee) {
        return employee.getName();
    }
}
