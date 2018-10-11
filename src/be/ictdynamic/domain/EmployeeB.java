package be.ictdynamic.domain;

import java.util.Date;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class EmployeeB {
    private Long id;
    private String  name;
    private Date hireDate;
    private Set<Project> projects;
    private Set<Department> department;

    // https://stackoverflow.com/questions/10348491/builder-pattern-code-generation-in-intellij

    public static class EmployeeBuilder {
        // Required parameters
        private Long id;
        private String name;

        // Optional parameters
        private Date hireDate;
        private Set<Project> projects;
        private Set<Department> department;

        public EmployeeBuilder(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public EmployeeBuilder withHireDate(Date hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public EmployeeBuilder withProjects(Set<Project> projects) {
            this.projects = projects;
            return this;
        }

        public EmployeeB build() {
            return new EmployeeB(this);
        }
    }

    // constructor is private

    private EmployeeB(EmployeeBuilder employeeBuilder) {
        projects = employeeBuilder.projects;
        id = employeeBuilder.id;
        name = employeeBuilder.name;
        hireDate = employeeBuilder.hireDate;
    }
}
