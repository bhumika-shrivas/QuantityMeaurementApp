package com.QuantityMeasurementApp;

/**
 * Base class representing a generic length measurement.
 * Supports equality, conversion, and addition operations.
 * 
 * All calculations are internally normalized to the base unit (Feet).
 */
public class QuantityLength {

    // Measurement value
    protected final double value;

    // Unit of the measurement
    protected final LengthUnit unit;

    /**
     * Protected constructor so only subclasses (Feet, Inch, Yard)
     * can create instances.
     */
    protected QuantityLength(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * Returns numeric value.
     */
    public double getValue() {
        return value;
    }

    /**
     * Returns unit type.
     */
    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Converts current quantity to a specified target unit.
     * 
     * @param targetUnit desired unit
     * @return new QuantityLength in target unit
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {

        // Step 1: Convert current value to base unit (Feet)
        double valueInFeet = unit.toFeet(this.value);

        // Step 2: Convert from Feet to target unit
        double convertedValue = targetUnit.fromFeet(valueInFeet);

        return new QuantityLength(convertedValue, targetUnit);
    }

    /**
     * Adds two quantities and returns result in current object's unit.
     */
    public QuantityLength add(QuantityLength other) {

        if (other == null)
            throw new IllegalArgumentException("Cannot add null");

        // Convert both values to Feet
        double thisInFeet = unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        // Perform addition
        double sumInFeet = thisInFeet + otherInFeet;

        // Convert back to current unit
        double finalValue = unit.fromFeet(sumInFeet);

        return new QuantityLength(finalValue, this.unit);
    }

    /**
     * Adds two quantities and returns result in specified target unit.
     */
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Cannot add null");

        double thisInFeet = unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        double sumInFeet = thisInFeet + otherInFeet;

        // Convert result into target unit
        double finalValue = targetUnit.fromFeet(sumInFeet);

        return new QuantityLength(finalValue, targetUnit);
    }

    /**
     * Equality comparison based on normalized value (Feet).
     */
    @Override
    public boolean equals(Object obj) {

        // Reflexive
        if (this == obj) return true;

        // Null check
        if (obj == null) return false;

        // Type check
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        // Normalize both to Feet before comparing
        double thisInFeet = unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        return Double.compare(thisInFeet, otherInFeet) == 0;
    }

    /**
     * HashCode based on normalized value.
     */
    @Override
    public int hashCode() {
        return Double.hashCode(unit.toFeet(value));
    }
}