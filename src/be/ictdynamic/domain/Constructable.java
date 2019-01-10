package be.ictdynamic.domain;

public interface Constructable<E extends MaterialType> {
    public final static int BASIC_COST_OF_CUBE = 55;

    public abstract void constructBuilding(E materialType);

    public abstract void tearDownBuilding(E materialType);

    public abstract void setCost();

    public static int calculateBasicCost(int numberOfCubes) {
        return numberOfCubes * BASIC_COST_OF_CUBE;
    }
}
