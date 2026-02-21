package com.QuantityMeasurementApp;

/**
 * Enum representing supported length units.
 * Each unit defines a conversion factor to the base unit (Feet).
 */
public enum LengthUnit {

    FEET(1.0),          // Base unit
    INCH(1.0 / 12.0),   // 1 Inch = 1/12 Feet
    YARD(3.0);          // 1 Yard = 3 Feet

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    /**
     * Converts the given value to Feet.
     *
     * @param value measurement value
     * @return converted value in feet
     */
    public double toFeet(double value) {
        return value * toFeetFactor;
    }
}