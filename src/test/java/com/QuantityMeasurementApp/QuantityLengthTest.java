package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    // ---------- CONVERSION TESTS ----------

    @Test
    void testFeetToInchConversion() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength converted = feet.convertTo(LengthUnit.INCH);

        assertEquals(12.0, converted.getValue());
        assertEquals(LengthUnit.INCH, converted.getUnit());
    }

    @Test
    void testInchToFeetConversion() {
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength converted = inch.convertTo(LengthUnit.FEET);

        assertEquals(1.0, converted.getValue());
        assertEquals(LengthUnit.FEET, converted.getUnit());
    }

    @Test
    void testYardToFeetConversion() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength converted = yard.convertTo(LengthUnit.FEET);

        assertEquals(3.0, converted.getValue());
        assertEquals(LengthUnit.FEET, converted.getUnit());
    }

    @Test
    void testYardToInchConversion() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength converted = yard.convertTo(LengthUnit.INCH);

        assertEquals(36.0, converted.getValue());
        assertEquals(LengthUnit.INCH, converted.getUnit());
    }

    // ---------- EQUALITY STILL WORKS ----------

    @Test
    void testCrossUnitEquality() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(feet.equals(inch));
    }

    @Test
    void testNullComparison() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q.equals(null));
    }
}