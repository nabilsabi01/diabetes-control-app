package com.diabetes.control.model;

public enum GlucoseLevel {
    HYPOGLYCEMIA("Low"),
    NORMAL("Normal"),
    PREDIABETES("Meduim"),
    DIABETES("High");

    private final String displayName;

    GlucoseLevel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static GlucoseLevel fromLevel(Double level) {
        if (level < 70) {
            return HYPOGLYCEMIA;
        } else if (level >= 70 && level <= 99) {
            return NORMAL;
        } else if (level >= 100 && level <= 125) {
            return PREDIABETES;
        } else if (level >= 126) {
            return DIABETES;
        }
        throw new IllegalArgumentException("Invalid glucose level: " + level);
    }
}
