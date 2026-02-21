package com.QuantityMeasurementApp;

/**
 * Represents a generic length measurement.
 * Supports equality, conversion, addition, and target-unit addition.
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
     * Converts this quantity to target unit.
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {

        double valueInFeet = unit.toFeet(this.value);
        double convertedValue = targetUnit.fromFeet(valueInFeet);

        return new QuantityLength(convertedValue, targetUnit);
    }

    /**
     * Adds two quantities and returns result in calling object's unit (UC6).
     */
    public QuantityLength add(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Cannot add null quantity");
        }

        double thisInFeet = this.unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        double sumInFeet = thisInFeet + otherInFeet;

        double finalValue = this.unit.fromFeet(sumInFeet);

        return new QuantityLength(finalValue, this.unit);
    }

    /**
     * Adds two quantities and returns result in specified target unit (UC7).
     */
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Cannot add null quantity");
        }

        double thisInFeet = this.unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        double sumInFeet = thisInFeet + otherInFeet;

        double finalValue = targetUnit.fromFeet(sumInFeet);

        return new QuantityLength(finalValue, targetUnit);
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