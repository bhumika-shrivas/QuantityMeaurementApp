package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void testFeetToFeet_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testInchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testFeetToInch_Equivalent() {
        QuantityLength qFeet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength qInch = new QuantityLength(12.0, LengthUnit.INCH);
        assertTrue(qFeet.equals(qInch));
    }

    @Test
    void testDifferentFeetValues() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testDifferentInchValues() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCH);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testNullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(null));
    }

    @Test
    void testSameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q1));
    }
}