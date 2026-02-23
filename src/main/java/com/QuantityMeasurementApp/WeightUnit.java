package com.QuantityMeasurementApp;

/**
 * Enum for weight units.
 * Base unit: Gram
 */
public enum WeightUnit {

    GRAM(1.0),
    KILOGRAM(1000.0),
    TONNE(1000000.0);

    private final double toGramFactor;

    WeightUnit(double toGramFactor) {
        this.toGramFactor = toGramFactor;
    }

    public double toGram(double value) {
        return value * toGramFactor;
    }

    public double fromGram(double gramValue) {
        return gramValue / toGramFactor;
    }
}