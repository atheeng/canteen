package com.fuseCanteen.canteen.util;

public enum FoodCategory {
    BREAKFAST("BREAKFAST"),
    LUNCH("LUNCH"),
    DINNER("DINNER"),
    SNACK("SNACK");

    public final String value;

    FoodCategory(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }
//    @JsonCreator
    public static FoodCategory getEnum(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        for (FoodCategory v : values())
            if (value.equalsIgnoreCase(v.getValue()))
                return v;
        throw new IllegalArgumentException();
    }
}

