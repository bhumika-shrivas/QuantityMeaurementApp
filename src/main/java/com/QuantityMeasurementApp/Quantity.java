package com.QuantityMeasurementApp;

/**
 * Generic Quantity class supporting all measurement types.
 */
public class Quantity {

    private final double value;
    private final Unit unit;

    public Quantity(double value, Unit unit) {
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

        if (other == null)
            throw new IllegalArgumentException("Cannot add null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cannot add different measurement types");

        double thisBase = unit.toBase(this.value);
        double otherBase = other.unit.toBase(other.value);

        double sumBase = thisBase + otherBase;

        double finalValue = unit.fromBase(sumBase);

        return new Quantity(finalValue, this.unit);
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

        return Double.compare(thisBase, otherBase) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.toBase(value));
    }
}