package be.ictdynamic.domain;

public class Building<E extends MaterialType> {
    // Building exists of walls/ceiling/floor and these are all of a certain Material-Type
    private E walls;
    private E ceiling;
    private E floor;

    public void constructBuilding(E materialType) {
    }

    public void tearDownBuilding(E materialType) {
    }

    public void setCost() {
        // since walls|ceilings|floors are of a certain material-type
        // we can use the methods of the MaterialType
        this.walls.setCostPerCubicMeter(10.00F);
        this.ceiling.setCostPerCubicMeter(20.00F);
        this.floor.setCostPerCubicMeter(30.00F);
    }

}
