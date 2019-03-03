package be.ictdynamic.domain;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class NumberDuo<E extends Number> {
    private E first;
    private E second;

    public NumberDuo(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(E first) {
        this.first = first;
    }

}
