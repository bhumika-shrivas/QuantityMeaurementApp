package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Feet and Inches equality.
 * Follows value-based equality and equality contract rules.
 */
class QuantityMeasurementAppTest {

    // ---------------- FEET TESTS ----------------

	
	// Should Return True
    @Test
    void testFeetEquality_SameValue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);

        assertTrue(first.equals(second),
                "1.0 ft should be equal to 1.0 ft");
    }

    // Should Return False
    @Test
    void testFeetEquality_DifferentValue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(2.0);

        assertFalse(first.equals(second),
                "1.0 ft should not be equal to 2.0 ft");
    }

    // Should Return False
    @Test
    void testFeetEquality_NullComparison() {
        Feet first = new Feet(1.0);

        assertFalse(first.equals(null),
                "Feet object should not be equal to null");
    }
    
    // Should Return True
    @Test
    void testFeetEquality_SameReference() {
        Feet first = new Feet(1.0);

        assertTrue(first.equals(first),
                "Object must be equal to itself (reflexive)");
    }
    
    @Test
    public void testFeetEquality_DifferentClass() {
        Feet f1 = new Feet(1.0);
        String other = "1.0";

        assertFalse(f1.equals(other), "Feet object should not be equal to different type");
    }
    
    // ---------------- INCHES TESTS ----------------

    // Should Return True
    @Test
    void testInchesEquality_SameValue() {
        Inches first = new Inches(1.0);
        Inches second = new Inches(1.0);

        assertTrue(first.equals(second),
                "1.0 inch should be equal to 1.0 inch");
    }
    

    // Should Return False
    @Test
    void testInchesEquality_DifferentValue() {
        Inches first = new Inches(1.0);
        Inches second = new Inches(2.0);

        assertFalse(first.equals(second),
                "1.0 inch should not be equal to 2.0 inch");
    }

    // Should Return False
    @Test
    void testInchesEquality_NullComparison() {
        Inches first = new Inches(1.0);

        assertFalse(first.equals(null),
                "Inches object should not be equal to null");
    }

    // Should Return False
    @Test
    void testFeetAndInchesComparison() {
        Feet feet = new Feet(1.0);
        Inches inches = new Inches(1.0);

        assertFalse(feet.equals(inches),
                "Feet and Inches should not be equal (type safety)");
    }
    
    @Test
    public void testInchesEquality_DifferentClass() {
        Inches i1 = new Inches(1.0);
        String other = "1.0";

        assertFalse(i1.equals(other), "Inch object should not be equal to different type");
    }
}