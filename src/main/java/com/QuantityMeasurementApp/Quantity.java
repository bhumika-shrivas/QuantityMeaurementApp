package com.QuantityMeasurementApp;

import java.util.function.BinaryOperator;

/**
 * Generic Quantity class supporting all measurement types with centralized arithmetic.
 */
public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.00001;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
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

    // ==========================
    // EQUALITY
    // ==========================

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        // Prevent cross-category comparison
        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        double baseThis = unit.convertToBaseUnit(this.value);
        double baseOther = ((Quantity<IMeasurable>)other).unit.convertToBaseUnit(((Quantity<IMeasurable>)other).value);

        return Math.abs(baseThis - baseOther) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.convertToBaseUnit(value));
    }

    // ==========================
    // CONVERSION
    // ==========================

    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(this.value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    // ==========================
    // ADDITION
    // ==========================

    public Quantity<U> add(Quantity<U> other) {
        return performOperation(other, this.unit, Double::sum);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        return performOperation(other, targetUnit, Double::sum);
    }

    // ==========================
    // SUBTRACTION
    // ==========================

    public Quantity<U> subtract(Quantity<U> other) {
        return performOperation(other, this.unit, (a, b) -> a - b);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        return performOperation(other, targetUnit, (a, b) -> a - b);
    }

    // ==========================
    // DIVISION
    // ==========================

    public double divide(Quantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException("Null operand");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");

        double baseOther = other.unit.convertToBaseUnit(other.value);

        if (Math.abs(baseOther) < EPSILON)
            throw new ArithmeticException("Division by zero");

        double baseThis = unit.convertToBaseUnit(this.value);

        return baseThis / baseOther;
    }

    // ==========================
    // CENTRALIZED ARITHMETIC (UC13)
    // ==========================

    private Quantity<U> performOperation(
            Quantity<U> other,
            U targetUnit,
            BinaryOperator<Double> operator) {

        validateOperands(other, targetUnit);

        double baseThis = unit.convertToBaseUnit(this.value);
        double baseOther = other.unit.convertToBaseUnit(other.value);

        double baseResult = operator.apply(baseThis, baseOther);

        double converted = targetUnit.convertFromBaseUnit(baseResult);

        // Round to 2 decimal places as per requirements
        double rounded = Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(rounded, targetUnit);
    }

    private void validateOperands(Quantity<U> other, U targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Null operand");

        if (targetUnit == null)
            throw new IllegalArgumentException("Null target unit");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");
    }
}