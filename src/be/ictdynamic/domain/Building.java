package be.ictdynamic.domain;

public interface Building<E extends MaterialType> {
    void constructBuilding(E materialType);

    void tearDownBuilding(E materialType);

    void setCost();
}
