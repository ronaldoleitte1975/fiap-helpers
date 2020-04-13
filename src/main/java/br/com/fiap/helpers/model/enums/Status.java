package br.com.fiap.helpers.model.enums;

public enum Status {

    NEW(0, "NEW"),  WAITING_RECIPIENT_ACCEPTED(1, "WRA"), ACCEPTED(2, "ACK"), COMPLETED(3, "CMP");

    private int code;
    private String description;

    private Status(int code, String descr) {
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

        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}
