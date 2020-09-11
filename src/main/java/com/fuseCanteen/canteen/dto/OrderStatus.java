package com.fuseCanteen.canteen.dto;

public enum OrderStatus {
    PENDING("PENDING"),
    IN_PROCESS("IN PROCESS"),
    READY("READY"),
    CANCEL("CANCEL"),
    SCHEDULE("SCHEDULE");

    public final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public static OrderStatus getEnum(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        for (OrderStatus v : values())
            if (value.equalsIgnoreCase(v.getValue()))
                return v;
        throw new IllegalArgumentException();
    }
}
