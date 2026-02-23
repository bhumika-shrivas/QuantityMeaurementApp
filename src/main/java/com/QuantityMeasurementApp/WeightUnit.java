package com.QuantityMeasurementApp;

public enum WeightUnit implements Unit {

    GRAM(1.0),
    KILOGRAM(1000.0),
    TONNE(1000000.0);

    private final double toGramFactor;

    WeightUnit(double toGramFactor) {
        this.toGramFactor = toGramFactor;
    }

    @Override
    public double toBase(double value) {
        return value * toGramFactor;
    }

    @Override
    public double fromBase(double baseValue) {
        return baseValue / toGramFactor;
    }
}