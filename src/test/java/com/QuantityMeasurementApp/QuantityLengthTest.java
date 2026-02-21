package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    // ---------- ADDITION TESTS ----------

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
    void testYardPlusInch() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);

        QuantityLength result = yard.add(inch);

        assertEquals(2.0, result.getValue());
    }

    @Test
    void testAddNull_ShouldThrowException() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q.add(null));
    }

    // ---------- EQUALITY STILL WORKS ----------

    @Test
    void testCrossUnitEquality() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(feet.equals(inch));
    }
}