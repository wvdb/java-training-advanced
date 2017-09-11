package be.ictdynamic.oefeningGenerics_0;

import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Manager;
import be.ictdynamic.domain.Worker;

/**
 * Created by admin on 11/09/2017.
 */
public class HireAndFire<T extends Worker> {
    public float fire(T worker, int noticePeriod) {
        if (worker instanceof Employee) {
            noticePeriod *= 1.5;
        } else if (worker instanceof Manager) {
            noticePeriod *= 2;
        } else {
            noticePeriod *= 3;
        }
        return noticePeriod;
    }
}
