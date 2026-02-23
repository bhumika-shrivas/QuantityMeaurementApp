package com.QuantityMeasurementApp;

/**
 * Generic Quantity class supporting all measurement types.
 */
public class Quantity {

    private final double value;
    private final Unit unit;

    public Quantity(double value, Unit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    public Quantity convertTo(Unit targetUnit) {

        double baseValue = unit.toBase(this.value);
        double convertedValue = targetUnit.fromBase(baseValue);

        return new Quantity(convertedValue, targetUnit);
    }

    public Quantity add(Quantity other) {
        return add(other, this.unit);
    }

    public Quantity add(Quantity other, Unit targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Cannot add null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cannot add different measurement types");

        double thisBase = unit.toBase(this.value);
        double otherBase = other.unit.toBase(other.value);

        double sumBase = thisBase + otherBase;
        double finalValue = targetUnit.fromBase(sumBase);

        return new Quantity(finalValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity other = (Quantity) obj;

        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        double thisBase = unit.toBase(this.value);
        double otherBase = other.unit.toBase(other.value);

        return Math.abs(thisBase - otherBase) < 1e-5;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.toBase(value));
    }
}