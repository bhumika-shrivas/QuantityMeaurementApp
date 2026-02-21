package com.QuantityMeasurementApp;

/**
 * Represents a generic length measurement.
 * Supports cross-unit equality comparison.
 */
public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    /**
     * Constructor to initialize value and unit.
     */
    public QuantityLength(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Compares two QuantityLength objects.
     * Converts both values to Feet before comparison.
     */
    @Override
    public boolean equals(Object obj) {

        // Reflexive check
        if (this == obj) return true;

        // Null check
        if (obj == null) return false;

        // Type check
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        // Convert both to base unit (Feet)
        double thisInFeet = this.unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        // Floating point safe comparison
        return Double.compare(thisInFeet, otherInFeet) == 0;
    }

    /**
     * HashCode based on normalized value (in Feet).
     */
    @Override
    public int hashCode() {
        return Double.hashCode(unit.toFeet(value));
    }
}