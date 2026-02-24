package com.QuantityMeasurementApp;

/**
 * Enum representing Temperature Units.
 * Base unit: CELSIUS
 */
public enum TemperatureUnit implements IMeasurable {

    CELSIUS {
        @Override
        public double toBase(double value) {
            return value;
        }

        @Override
        public double fromBase(double baseValue) {
            return baseValue;
        }
    },

    FAHRENHEIT {
        @Override
        public double toBase(double value) {
            return (value - 32) * 5 / 9;
        }

        @Override
        public double fromBase(double baseValue) {
            return (baseValue * 9 / 5) + 32;
        }
    },

    KELVIN {
        @Override
        public double toBase(double value) {
            return value - 273.15;
        }

        @Override
        public double fromBase(double baseValue) {
            return baseValue + 273.15;
        }
    };
}