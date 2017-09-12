package be.ictdynamic.oefeningGenerics_0;

import be.ictdynamic.domain.Employee;
import be.ictdynamic.domain.Manager;

/**
 * Created by wvdbrand on 12/09/2017.
 */
public class Hire<T> {
    public int executeHire(T worker) {
        int numberOfYearlyReviews = 0;

        if (worker instanceof Employee) {
            numberOfYearlyReviews = 2;
        } else if (worker instanceof Manager) {
            numberOfYearlyReviews = 1;
        } else {
            numberOfYearlyReviews = 0;
        }

        return numberOfYearlyReviews;
    }
}
