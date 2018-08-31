package be.ictdynamic.oefeningGenerics_0;

import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Manager;
import be.ictdynamic.domain.Worker;

/**
 * Created by admin on 11/09/2017.
 */
public class HireAndFire<T extends Worker, U extends Number> extends Hire<T> {
    public U executeFire(T worker) {
        Float noticePeriod = 0.0f;
        if (worker instanceof Employee) {
            noticePeriod *= new Float(1.5);
        } else if (worker instanceof Manager) {
            noticePeriod *= new Float(2);
        } else {
            noticePeriod *= new Float(3);
        }
        return (U) noticePeriod;
    }
}
