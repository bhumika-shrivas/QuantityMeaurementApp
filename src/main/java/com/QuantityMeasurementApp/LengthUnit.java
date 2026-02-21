package com.QuantityMeasurementApp;

/**
 * Enum representing supported length units.
 * All conversions are normalized through base unit (Feet).
 */
public enum LengthUnit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    /**
     * Convert given value to Feet (base unit).
     */
    public double toFeet(double value) {
        return value * toFeetFactor;
    }

    /**
     * Convert from Feet to target unit.
     */
    public double fromFeet(double feetValue) {
        return feetValue / toFeetFactor;
    }
}