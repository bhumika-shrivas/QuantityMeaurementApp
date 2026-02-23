package com.QuantityMeasurementApp;

/**
 * Generic base class for all measurable quantities.
 */
public abstract class Quantity {

    protected final double value;

    protected Quantity(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}