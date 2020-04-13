package br.com.fiap.helpers.model.enums;

public enum ServiceType {

    HOUSE_CLEANER(0, "House Cleaner"),  PICKER_UP(1, "Picker up"), DELIVER(2, "Deliver"), CARE_GIVER(3, "Care giver"), OTHERS(4, "Others");

    private int code;
    private String description;

    private ServiceType(int code, String descr) {
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

        throw new IllegalArgumentException("Invalid Service Type Code: " + code);
    }
}
