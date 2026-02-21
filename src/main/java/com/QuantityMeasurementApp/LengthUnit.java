package com.QuantityMeasurementApp;

/**
 * Enum for supported length units.
 * Each unit defines a conversion factor to a base unit (feet).
 */
public enum LengthUnit {
    FEET(1.0),
    INCH(1.0 / 12.0);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    /**
     * Convert a value of this unit to feet.
     *
     * @param value measurement value
     * @return value converted to feet
     */
    public double toFeet(double value) {
        return value * toFeetFactor;
    }
}