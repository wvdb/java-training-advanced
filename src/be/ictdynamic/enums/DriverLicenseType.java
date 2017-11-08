package be.ictdynamic.enums;

/**
 * Created by admin on 29/09/2017.
 */
public enum DriverLicenseType {
    MOTOR("Rijbewijs A"),
    AUTO("Rijbewijs B"),
    VRACHTWAGEN("Rijbewijs C");

    private final String description;

    DriverLicenseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
