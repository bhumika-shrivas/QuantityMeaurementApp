package com.QuantityMeasurementApp;

public class QuantityWeight extends Quantity {

    protected final WeightUnit unit;

    protected QuantityWeight(double value, WeightUnit unit) {
        super(value);
        this.unit = unit;
    }

    public QuantityWeight add(QuantityWeight other) {

        if (other == null)
            throw new IllegalArgumentException("Cannot add null");

        double thisInGram = unit.toGram(this.value);
        double otherInGram = other.unit.toGram(other.value);

        double sumInGram = thisInGram + otherInGram;

        double finalValue = unit.fromGram(sumInGram);

        return new QuantityWeight(finalValue, this.unit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof QuantityWeight)) return false;

        QuantityWeight other = (QuantityWeight) obj;

        double thisInGram = unit.toGram(this.value);
        double otherInGram = other.unit.toGram(other.value);

        return Double.compare(thisInGram, otherInGram) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.toGram(value));
    }
}