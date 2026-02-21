package com.QuantityMeasurementApp;

import java.util.Objects;

public class Inches {

    private final double value;

    public Inches(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {

        // Reflexive
        if (this == obj) return true;

        // Null check
        if (obj == null) return false;

        // Type check
        if (getClass() != obj.getClass()) return false;

        Inches other = (Inches) obj;

        // Floating-point safe comparison
        return Double.compare(this.value, other.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}