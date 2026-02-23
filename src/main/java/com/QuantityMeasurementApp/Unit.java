package com.QuantityMeasurementApp;

/**
 * Common interface for all measurement units.
 */
public interface Unit {

    double toBase(double value);

    double fromBase(double baseValue);
}