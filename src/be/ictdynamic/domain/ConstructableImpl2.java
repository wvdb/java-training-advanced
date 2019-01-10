package be.ictdynamic.domain;

public class ConstructableImpl2 implements Constructable {
    // suddenly or BuildingImpl is a little more flexible
    private ConcreteMaterialType walls;
    private FillingMaterialType ceiling;
    private WoodMaterialType floor;

    @Override
    public void constructBuilding(MaterialType materialType) {
    }

    @Override
    public void tearDownBuilding(MaterialType materialType) {
    }

    @Override
    public void setCost() {
        // since walls|ceilings|floors are of a certain material-type
        // we can use the methods of the MaterialType
        this.walls.getBaseCostPerCubicMeter();
    }

}
