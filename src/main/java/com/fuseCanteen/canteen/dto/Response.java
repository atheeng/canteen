package com.fuseCanteen.canteen.dto;

public enum Response {
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE"),
    BAD_REQUEST("BAD REQUEST"),
    NO_INFORMATION("NO INFORMATION"),
    VALIDATION_ERROR("VALIDATION ERROR");

    public final String value;

    Response(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public static Response getEnum(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        for (Response v : values())
            if (value.equalsIgnoreCase(v.getValue()))
                return v;
        throw new IllegalArgumentException();
    }
}
