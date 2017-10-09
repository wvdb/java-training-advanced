package be.ictdynamic.domain;

/**
 * Created by admin on 29/09/2017.
 */
public abstract class Remuneration extends DatabaseEntity {
    public final static int NUMBER_OF_OCCURRANCES = 1;

    private double cost;

    public Remuneration(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
