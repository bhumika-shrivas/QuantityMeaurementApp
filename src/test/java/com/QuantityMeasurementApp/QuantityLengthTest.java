package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Complete test suite for QuantityLength (UC7).
 * Covers equality, conversion, addition, and target-unit addition.
 */
class QuantityLengthTest {

    // ---------------- EQUALITY TESTS ----------------

    @Test
    void testFeetToFeetEquality() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testFeetToInchEquality() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(feet.equals(inch));
    }

    @Test
    void testYardToFeetEquality() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    @Test
    void testDifferentValues_NotEqual() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testNullComparison() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q.equals(null));
    }

    @Test
    void testSameReference() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q.equals(q));
    }

    // ---------------- CONVERSION TESTS ----------------

    @Test
    void testFeetToInchConversion() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = feet.convertTo(LengthUnit.INCH);

        assertEquals(12.0, result.getValue());
        assertEquals(LengthUnit.INCH, result.getUnit());
    }

    @Test
    void testYardToFeetConversion() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength result = yard.convertTo(LengthUnit.FEET);

        assertEquals(3.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // ---------------- UC6 ADDITION TESTS ----------------

    @Test
    void testFeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2);

        assertEquals(2.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testFeetPlusInch() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength result = feet.add(inch);

        assertEquals(2.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testYardPlusFeet() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength result = yard.add(feet);

        assertEquals(2.0, result.getValue());
        assertEquals(LengthUnit.YARD, result.getUnit());
    }

    @Test
    void testAddNull_ShouldThrowException() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q.add(null));
    }

    // ---------------- UC7 TARGET UNIT ADDITION TESTS ----------------

    @Test
    void testAdditionWithTargetUnit_Inch() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength result = feet.add(inch, LengthUnit.INCH);

        assertEquals(24.0, result.getValue());
        assertEquals(LengthUnit.INCH, result.getUnit());
    }

    @Test
    void testAdditionWithTargetUnit_Feet() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength result = yard.add(feet, LengthUnit.FEET);

        assertEquals(6.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAdditionWithTargetUnit_Yard() {
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);

        QuantityLength result = feet.add(yard, LengthUnit.YARD);

        assertEquals(2.0, result.getValue());
        assertEquals(LengthUnit.YARD, result.getUnit());
    }
}