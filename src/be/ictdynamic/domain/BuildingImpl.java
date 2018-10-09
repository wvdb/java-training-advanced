package be.ictdynamic.domain;

public class BuildingImpl<E extends MaterialType> implements Building<E> {
    // Building exists of walls/ceiling/floor and these are all of a certain Material-Type

    // this is designed by the most linear architect in Belgium (walls in wood/concrete/bricks => everything in wood/concrete/bricks)
    private E walls;
    private E ceiling;
    private E floor;

    @Override
    public void constructBuilding(E materialType) {
    }

    @Override
    public void tearDownBuilding(E materialType) {
    }

    @Override
    public void setCost() {
        // since walls|ceilings|floors are of a certain material-type
        // we can use the methods of the MaterialType
        this.walls.getBaseCostPerCubicMeter();
    }

}
