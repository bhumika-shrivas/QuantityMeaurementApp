package com.QuantityMeasurementApp;

/**
 * Represents a length measurement of any supported unit.
 * Supports equals() across units by converting to
 * a common base (feet).
 */
public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

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

    @Override
    public boolean equals(Object obj) {

        // Reflexive
        if (this == obj) return true;

        if (obj == null) return false;

        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        if (other.unit == null || this.unit == null) return false;

        // Convert both values to feet
        double thisInFeet = this.unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        return Double.compare(thisInFeet, otherInFeet) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.toFeet(value));
    }
}