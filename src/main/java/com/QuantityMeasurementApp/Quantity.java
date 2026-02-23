package com.QuantityMeasurementApp;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;
    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        if (Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateOperation(other);

        double baseResult =
                this.unit.convertToBaseUnit(this.value) +
                other.unit.convertToBaseUnit(other.value);

        double finalValue = targetUnit.convertFromBaseUnit(baseResult);
        return new Quantity<>(finalValue, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateOperation(other);

        double baseResult = this.unit.convertToBaseUnit(this.value) - other.unit.convertToBaseUnit(other.value);

        double finalValue = targetUnit.convertFromBaseUnit(baseResult);
        return new Quantity<>(finalValue, targetUnit);
    }

    public double divide(Quantity<U> other) {
        validateOperation(other);

        double divisorBase = other.unit.convertToBaseUnit(other.value);
        if (Math.abs(divisorBase) < EPSILON)
            throw new ArithmeticException("Division by zero");

        double dividendBase = this.unit.convertToBaseUnit(this.value);
        return dividendBase / divisorBase;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Quantity<?> other = (Quantity<?>) obj;

        // Ensure units are from the same category
        if (this.unit.getClass() != other.unit.getClass()) return false;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.getClass(), Math.round(unit.convertToBaseUnit(value) / EPSILON));
    }

    private void validateOperation(Quantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (this.unit.getClass() != other.unit.getClass())
            throw new IllegalArgumentException("Cross-category operation not allowed");
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}