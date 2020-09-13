package com.fuseCanteen.canteen.util;

public enum Authority {
    ROLE_ADMIN("ROLE ADMIN"),
    ROLE_EMPLOYEE("ROLE EMPLOYEE");

    public final String value;

    Authority(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public static Authority getEnum(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        for (Authority v : values())
            if (value.equalsIgnoreCase(v.getValue()))
                return v;
        throw new IllegalArgumentException();
    }
}
