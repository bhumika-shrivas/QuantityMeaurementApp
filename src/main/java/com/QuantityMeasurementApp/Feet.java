package com.QuantityMeasurementApp;
/**
 * Represents a measurement in Feet.
 * This class is immutable and supports value-based equality.
 */
public class Feet {

    // Stores the measurement value in feet
    // 'final' ensures immutability
    private final double value;

    /**
     * Constructor to initialize the feet value.
     *
     * @param value measurement in feet
     */
    public Feet(double value) {
        this.value = value;
    }

    /**
     * Getter method to retrieve the feet value.
     *
     * @return value in feet
     */
    public double getValue() {
        return value;
    }

    /**
     * Overrides equals() to compare Feet objects
     * based on value rather than memory reference.
     *
     * @param obj object to compare
     * @return true if both objects have same feet value
     */
    @Override
    public boolean equals(Object obj) {

        // Reflexive check: same reference
        if (this == obj) return true;

        // Null check
        if (obj == null) return false;

        // Type check to ensure only Feet objects are compared
        if (getClass() != obj.getClass()) return false;

        // Safe casting after type check
        Feet other = (Feet) obj;

        // Use Double.compare() for accurate floating-point comparison
        return Double.compare(this.value, other.value) == 0;
    }

    /**
     * Overrides hashCode() to maintain
     * consistency with equals().
     *
     * @return hash code based on feet value
     */
    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}