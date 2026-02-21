package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Generic Length Equality (UC4).
 */
class QuantityLengthTest {

    // ---------- SAME UNIT TESTS ----------

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
    void testYardToYard_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARD);
        assertTrue(q1.equals(q2));
    }

    // ---------- CROSS UNIT TESTS ----------

    @Test
    void testFeetToInch_Equivalent() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);
        assertTrue(feet.equals(inch));
    }

    @Test
    void testYardToFeet_Equivalent() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(yard.equals(feet));
    }

    @Test
    void testYardToInch_Equivalent() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);
        assertTrue(yard.equals(inch));
    }

    // ---------- NEGATIVE TESTS ----------

    @Test
    void testDifferentValues_ShouldReturnFalse() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testNullComparison_ShouldReturnFalse() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(null));
    }

    @Test
    void testSameReference_ShouldReturnTrue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q1));
    }
}