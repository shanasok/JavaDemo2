package enums;

public enum AudienceAgeEnum {

    CHILDREN("Children"),
    TEEN("Teen"),
    ADULT("Adult");

    private final String label;

    AudienceAgeEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
