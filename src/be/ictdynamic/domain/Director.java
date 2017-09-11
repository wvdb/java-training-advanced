package be.ictdynamic.domain;

import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Director extends Worker {
    // every sub-class of worker has a hireDate, a worker doesn't
    private Date hireDate;

    public Director(Integer id, String name, Integer age, Gender gender) {
        super(id, name, age, gender);
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public Float calculateSalary(Float... objects) {
        return null;
    }
}
