package com.QuantityMeasurementApp;

/**
 * Represents a generic length measurement.
 * Supports equality and unit conversion.
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

    /**
     * Converts this quantity to a target unit.
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {

        // Step 1: Convert current value to base unit (Feet)
        double valueInFeet = unit.toFeet(this.value);

        // Step 2: Convert from Feet to target unit
        double convertedValue = targetUnit.fromFeet(valueInFeet);

        return new QuantityLength(convertedValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null) return false;

        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double thisInFeet = this.unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        return Double.compare(thisInFeet, otherInFeet) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.toFeet(value));
    }
}