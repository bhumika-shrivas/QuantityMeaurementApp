package com.QuantityMeasurementApp;

public enum LengthUnit implements Unit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    @Override
    public double toBase(double value) {
        return value * toFeetFactor;
    }

    @Override
    public double fromBase(double baseValue) {
        return baseValue / toFeetFactor;
    }
}