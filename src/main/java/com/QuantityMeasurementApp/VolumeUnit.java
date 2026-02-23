package com.QuantityMeasurementApp;

/**
 * Enum representing Volume units.
 * Base unit: Milliliter
 */
public enum VolumeUnit implements Unit {

    MILLILITER(0.001),
    LITER(1.0),
    GALLON(3.78541);

    private final double toBaseFactor;

    VolumeUnit(double toBaseFactor) {
        this.toBaseFactor = toBaseFactor;
    }

    /**
     * Converts given value to base unit (Liter).
     */
    @Override
    public double toBase(double value) {
        return value * toBaseFactor;
    }

    /**
     * Converts base unit (Liter) value to this unit.
     */
    @Override
    public double fromBase(double baseValue) {
        return baseValue / toBaseFactor;
    }

    /**
     * Explicit conversion to base unit (Liter).
     */
    public double convertToBaseUnit(double value) {
        return value * toBaseFactor;
    }

    /**
     * Explicit conversion from base unit (Liter)
     * to this enum unit.
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toBaseFactor;
    }

    /**
     * Returns conversion factor relative to base unit (Liter).
     */
    public double getConversionFactor() {
        return toBaseFactor;
    }
}