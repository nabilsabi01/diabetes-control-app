package com.diabetes.control.model;

public enum ActivityType {
    RUNNING("Running"),
    WALKING("Walking"),
    CYCLING("Cycling"),
    SWIMMING("Swimming"),
    YOGA("Yoga"),
    STRENGTH_TRAINING("Strength Training"),
    OTHER("Other");

    private final String displayName;

    ActivityType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
