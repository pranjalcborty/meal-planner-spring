package net.therap.mealplannerspring.enums;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public enum Type {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch");

    private String label;

    Type(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
