package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC10 – Generic Quantity.
 * Covers:
 *  - Length equality
 *  - Weight equality
 *  - Conversion
 *  - Addition
 *  - Type safety
 */
class QuantityTest {

    // ---------------- LENGTH TESTS ----------------

    @Test
    void testLengthEquality() {
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);
        Quantity inch = new Quantity(12.0, LengthUnit.INCH);

        assertTrue(feet.equals(inch));
    }

    @Test
    void testLengthAddition() {
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);
        Quantity inch = new Quantity(12.0, LengthUnit.INCH);

        Quantity result = feet.add(inch);

        assertEquals(2.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testLengthConversion() {
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);

        Quantity converted = feet.convertTo(LengthUnit.INCH);

        assertEquals(12.0, converted.getValue());
        assertEquals(LengthUnit.INCH, converted.getUnit());
    }

    // ---------------- WEIGHT TESTS ----------------

    @Test
    void testWeightEquality() {
        Quantity kg = new Quantity(1.0, WeightUnit.KILOGRAM);
        Quantity gram = new Quantity(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(gram));
    }

    @Test
    void testWeightAddition() {
        Quantity kg = new Quantity(1.0, WeightUnit.KILOGRAM);
        Quantity gram = new Quantity(1000.0, WeightUnit.GRAM);

        Quantity result = kg.add(gram);

        assertEquals(2.0, result.getValue());
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    void testWeightConversion() {
        Quantity kg = new Quantity(1.0, WeightUnit.KILOGRAM);

        Quantity converted = kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, converted.getValue());
        assertEquals(WeightUnit.GRAM, converted.getUnit());
    }

    // ---------------- TYPE SAFETY TEST ----------------

    @Test
    void testLengthAndWeightNotEqual() {
        Quantity length = new Quantity(1.0, LengthUnit.FEET);
        Quantity weight = new Quantity(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    void testAddDifferentTypes_ShouldThrowException() {
        Quantity length = new Quantity(1.0, LengthUnit.FEET);
        Quantity weight = new Quantity(1.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> length.add(weight));
    }

    @Test
    void testAddNull_ShouldThrowException() {
        Quantity quantity = new Quantity(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> quantity.add(null));
    }
}