package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Feet and Inches equality.
 * Follows value-based equality and equality contract rules.
 */
class QuantityMeasurementAppTest {

    // ---------------- FEET TESTS ----------------

    @Test
    void testFeetEquality_SameValue_ShouldReturnTrue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);

        assertTrue(first.equals(second),
                "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    void testFeetEquality_DifferentValue_ShouldReturnFalse() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(2.0);

        assertFalse(first.equals(second),
                "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    void testFeetEquality_NullComparison_ShouldReturnFalse() {
        Feet first = new Feet(1.0);

        assertFalse(first.equals(null),
                "Feet object should not be equal to null");
    }

    @Test
    void testFeetEquality_SameReference_ShouldReturnTrue() {
        Feet first = new Feet(1.0);

        assertTrue(first.equals(first),
                "Object must be equal to itself (reflexive)");
    }

    // ---------------- INCHES TESTS ----------------

    @Test
    void testInchesEquality_SameValue_ShouldReturnTrue() {
        Inches first = new Inches(1.0);
        Inches second = new Inches(1.0);

        assertTrue(first.equals(second),
                "1.0 inch should be equal to 1.0 inch");
    }

    @Test
    void testInchesEquality_DifferentValue_ShouldReturnFalse() {
        Inches first = new Inches(1.0);
        Inches second = new Inches(2.0);

        assertFalse(first.equals(second),
                "1.0 inch should not be equal to 2.0 inch");
    }

    @Test
    void testInchesEquality_NullComparison_ShouldReturnFalse() {
        Inches first = new Inches(1.0);

        assertFalse(first.equals(null),
                "Inches object should not be equal to null");
    }

    @Test
    void testFeetAndInchesComparison_ShouldReturnFalse() {
        Feet feet = new Feet(1.0);
        Inches inches = new Inches(1.0);

        assertFalse(feet.equals(inches),
                "Feet and Inches should not be equal (type safety)");
    }
}