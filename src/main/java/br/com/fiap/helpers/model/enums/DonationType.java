package br.com.fiap.helpers.model.enums;

public enum DonationType {

    MONEY(0, "Money"), CLOTHES(1, "Clothes"), FOODS(2, "Foods"), UTENSILIES(3, "Utensilies"), OTHERS(4, "Others");

    private int code;
    private String description;

    private DonationType(int code, String descr) {
        this.code = code;
        this.description = descr;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Status toEnum(Integer code) {

        if (code == null) {
            return null;
        }

        for (Status status : Status.values()) {
            if (code.equals(status.getCode())) {
                return status;
            }
        }

        throw new IllegalArgumentException("Invalid Donation Type Code: " + code);
    }
}
