package com.QuantityMeasurementApp;

public class QuantityMeasurementApp {

    public static class Feet {

        private final double value;

        public Feet(double value) {
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

            Feet other = (Feet) obj;

            // Floating point comparison
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public static void main(String[] args) {

        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);

        boolean result = first.equals(second);

        System.out.println("Equal: " + result);
    }
}