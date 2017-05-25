package net.therap.mealplannerspring.enums;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public enum Day {

    SUN("Sunday"),
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday");

    private String label;

    Day(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
