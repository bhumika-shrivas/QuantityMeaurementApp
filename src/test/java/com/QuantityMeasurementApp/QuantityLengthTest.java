package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC9 – Weight Management.
 * Covers:
 *  - Length equality
 *  - Weight equality
 *  - Length addition
 *  - Weight addition
 *  - Type safety (Length ≠ Weight)
 */
class QuantityTest {

    // ---------------- LENGTH TESTS ----------------

    @Test
    void testLengthEquality_FeetAndInch() {
        QuantityLength feet = new Feet(1.0);
        QuantityLength inch = new Inch(12.0);

        assertTrue(feet.equals(inch));
    }

    @Test
    void testLengthAddition() {
        QuantityLength feet = new Feet(1.0);
        QuantityLength inch = new Inch(12.0);

        QuantityLength result = feet.add(inch);

        assertEquals(2.0, result.getValue());
    }

    // ---------------- WEIGHT TESTS ----------------

    @Test
    void testWeightEquality_KgAndGram() {
        QuantityWeight kg = new Kilogram(1.0);
        QuantityWeight gram = new Gram(1000.0);

        assertTrue(kg.equals(gram));
    }

    @Test
    void testWeightAddition() {
        QuantityWeight kg = new Kilogram(1.0);
        QuantityWeight gram = new Gram(1000.0);

        QuantityWeight result = kg.add(gram);

        assertEquals(2.0, result.getValue());
    }

    // ---------------- TYPE SAFETY TEST ----------------

    @Test
    void testLengthAndWeight_ShouldNotBeEqual() {
        QuantityLength length = new Feet(1.0);
        QuantityWeight weight = new Kilogram(1.0);

        assertFalse(length.equals(weight));
    }

    @Test
    void testAddNullLength_ShouldThrowException() {
        QuantityLength length = new Feet(1.0);

        assertThrows(IllegalArgumentException.class, () -> length.add(null));
    }

    @Test
    void testAddNullWeight_ShouldThrowException() {
        QuantityWeight weight = new Kilogram(1.0);

        assertThrows(IllegalArgumentException.class, () -> weight.add(null));
    }
}