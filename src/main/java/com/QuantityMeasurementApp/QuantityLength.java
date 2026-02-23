package com.QuantityMeasurementApp;

public class QuantityLength extends Quantity {

    protected final LengthUnit unit;

    protected QuantityLength(double value, LengthUnit unit) {
        super(value);
        this.unit = unit;
    }

    public QuantityLength add(QuantityLength other) {

        if (other == null)
            throw new IllegalArgumentException("Cannot add null");

        double thisInFeet = unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        double sumInFeet = thisInFeet + otherInFeet;

        double finalValue = unit.fromFeet(sumInFeet);

        return new QuantityLength(finalValue, this.unit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double thisInFeet = unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        return Double.compare(thisInFeet, otherInFeet) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.toFeet(value));
    }
}