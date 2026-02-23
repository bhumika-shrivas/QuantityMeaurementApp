package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UC10 - Generic Quantity
 * Complete 35 Test Case Suite
 */
class QuantityTest {

    // ---------------- EQUALITY CONTRACT TESTS ----------------

    @Test
    void testReflexive_Length() {
        Quantity q = new Quantity(1.0, LengthUnit.FEET);
        assertTrue(q.equals(q));
    }

    @Test
    void testSymmetric_Length() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
        assertTrue(q2.equals(q1));
    }

    @Test
    void testTransitive_Length() {
        Quantity a = new Quantity(1.0, LengthUnit.FEET);
        Quantity b = new Quantity(12.0, LengthUnit.INCH);
        Quantity c = new Quantity(1.0, LengthUnit.FEET);
        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    void testConsistent_Length() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
        assertTrue(q1.equals(q2));
    }

    @Test
    void testNullComparison() {
        Quantity q = new Quantity(1.0, LengthUnit.FEET);
        assertFalse(q.equals(null));
    }

    // ---------------- LENGTH EQUALITY ----------------

    @Test
    void testFeetEqualsInch() {
        assertTrue(new Quantity(1, LengthUnit.FEET)
                .equals(new Quantity(12, LengthUnit.INCH)));
    }

    @Test
    void testYardEqualsFeet() {
        assertTrue(new Quantity(1, LengthUnit.YARD)
                .equals(new Quantity(3, LengthUnit.FEET)));
    }

    @Test
    void testDifferentLengthValues_NotEqual() {
        assertFalse(new Quantity(1, LengthUnit.FEET)
                .equals(new Quantity(2, LengthUnit.FEET)));
    }

    // ---------------- WEIGHT EQUALITY ----------------

    @Test
    void testKgEqualsGram() {
        assertTrue(new Quantity(1, WeightUnit.KILOGRAM)
                .equals(new Quantity(1000, WeightUnit.GRAM)));
    }

    @Test
    void testTonneEqualsKg() {
        assertTrue(new Quantity(1, WeightUnit.TONNE)
                .equals(new Quantity(1000, WeightUnit.KILOGRAM)));
    }

    @Test
    void testDifferentWeightValues_NotEqual() {
        assertFalse(new Quantity(1, WeightUnit.KILOGRAM)
                .equals(new Quantity(2, WeightUnit.KILOGRAM)));
    }

    // ---------------- CROSS DOMAIN SAFETY ----------------

    @Test
    void testLengthNotEqualWeight() {
        assertFalse(new Quantity(1, LengthUnit.FEET)
                .equals(new Quantity(1, WeightUnit.KILOGRAM)));
    }

    @Test
    void testAddDifferentTypes_ShouldThrow() {
        Quantity length = new Quantity(1, LengthUnit.FEET);
        Quantity weight = new Quantity(1, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class,
                () -> length.add(weight));
    }

    // ---------------- CONVERSION TESTS ----------------

    @Test
    void testFeetToInchConversion() {
        Quantity result = new Quantity(1, LengthUnit.FEET)
                .convertTo(LengthUnit.INCH);
        assertEquals(12, result.getValue());
    }

    @Test
    void testInchToFeetConversion() {
        Quantity result = new Quantity(12, LengthUnit.INCH)
                .convertTo(LengthUnit.FEET);
        assertEquals(1, result.getValue());
    }

    @Test
    void testKgToGramConversion() {
        Quantity result = new Quantity(1, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.GRAM);
        assertEquals(1000, result.getValue());
    }

    @Test
    void testGramToKgConversion() {
        Quantity result = new Quantity(1000, WeightUnit.GRAM)
                .convertTo(WeightUnit.KILOGRAM);
        assertEquals(1, result.getValue());
    }

    // ---------------- ADDITION TESTS (LENGTH) ----------------

    @Test
    void testFeetPlusFeet() {
        Quantity result = new Quantity(1, LengthUnit.FEET)
                .add(new Quantity(1, LengthUnit.FEET));
        assertEquals(2, result.getValue());
    }

    @Test
    void testFeetPlusInch() {
        Quantity result = new Quantity(1, LengthUnit.FEET)
                .add(new Quantity(12, LengthUnit.INCH));
        assertEquals(2, result.getValue());
    }

    @Test
    void testYardPlusFeet() {
        Quantity result = new Quantity(1, LengthUnit.YARD)
                .add(new Quantity(3, LengthUnit.FEET));
        assertEquals(2, result.getValue());
    }

    // ---------------- ADDITION TESTS (WEIGHT) ----------------

    @Test
    void testKgPlusKg() {
        Quantity result = new Quantity(1, WeightUnit.KILOGRAM)
                .add(new Quantity(1, WeightUnit.KILOGRAM));
        assertEquals(2, result.getValue());
    }

    @Test
    void testKgPlusGram() {
        Quantity result = new Quantity(1, WeightUnit.KILOGRAM)
                .add(new Quantity(1000, WeightUnit.GRAM));
        assertEquals(2, result.getValue());
    }

    @Test
    void testTonnePlusKg() {
        Quantity result = new Quantity(1, WeightUnit.TONNE)
                .add(new Quantity(1000, WeightUnit.KILOGRAM));
        assertEquals(2, result.getValue());
    }

    // ---------------- EDGE CASES ----------------

    @Test
    void testZeroLengthEquality() {
        assertTrue(new Quantity(0, LengthUnit.FEET)
                .equals(new Quantity(0, LengthUnit.INCH)));
    }

    @Test
    void testZeroWeightEquality() {
        assertTrue(new Quantity(0, WeightUnit.KILOGRAM)
                .equals(new Quantity(0, WeightUnit.GRAM)));
    }

    @Test
    void testNegativeLength() {
        assertTrue(new Quantity(-1, LengthUnit.FEET)
                .equals(new Quantity(-12, LengthUnit.INCH)));
    }

    @Test
    void testNegativeWeight() {
        assertTrue(new Quantity(-1, WeightUnit.KILOGRAM)
                .equals(new Quantity(-1000, WeightUnit.GRAM)));
    }

    // ---------------- HASHCODE CONSISTENCY ----------------

    @Test
    void testEqualObjectsHaveSameHashCode_Length() {
        Quantity q1 = new Quantity(1, LengthUnit.FEET);
        Quantity q2 = new Quantity(12, LengthUnit.INCH);
        assertEquals(q1.hashCode(), q2.hashCode());
    }

    @Test
    void testEqualObjectsHaveSameHashCode_Weight() {
        Quantity q1 = new Quantity(1, WeightUnit.KILOGRAM);
        Quantity q2 = new Quantity(1000, WeightUnit.GRAM);
        assertEquals(q1.hashCode(), q2.hashCode());
    }

    // ---------------- NULL ADDITION ----------------

    @Test
    void testAddNull_ShouldThrowException() {
        Quantity q = new Quantity(1, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class,
                () -> q.add(null));
    }
    // ---------------- ADDITIONAL EQUALITY CONTRACT (WEIGHT) ----------------

    @Test
    void testReflexive_Weight() {
        Quantity q = new Quantity(1.0, WeightUnit.KILOGRAM);
        assertTrue(q.equals(q));
    }

    @Test
    void testSymmetric_Weight() {
        Quantity q1 = new Quantity(1.0, WeightUnit.KILOGRAM);
        Quantity q2 = new Quantity(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
        assertTrue(q2.equals(q1));
    }

    @Test
    void testTransitive_Weight() {
        Quantity a = new Quantity(1.0, WeightUnit.KILOGRAM);
        Quantity b = new Quantity(1000.0, WeightUnit.GRAM);
        Quantity c = new Quantity(1.0, WeightUnit.KILOGRAM);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    void testConsistent_Weight() {
        Quantity q1 = new Quantity(1.0, WeightUnit.KILOGRAM);
        Quantity q2 = new Quantity(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
        assertTrue(q1.equals(q2));
    }

    // ---------------- ADDITION COMMUTATIVITY ----------------

    @Test
    void testAdditionCommutative_Length() {
        Quantity a = new Quantity(1, LengthUnit.FEET);
        Quantity b = new Quantity(12, LengthUnit.INCH);

        Quantity result1 = a.add(b);
        Quantity result2 = b.add(a);

        assertTrue(result1.equals(result2));
    }
}