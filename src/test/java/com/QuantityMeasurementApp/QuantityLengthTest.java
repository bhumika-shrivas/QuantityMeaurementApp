package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UC10 - Generic Quantity
 * Complete 35 Test Case Suite
 */
class QuantityTest {

	 /**
     * Verifies that identical litre measurements are equal.
     * 1.0 L == 1.0 L → true
     */
    @Test
    void testEquality_LitreToLitre_SameValue() {
        assertTrue(new Quantity(1.0, VolumeUnit.LITER)
                .equals(new Quantity(1.0, VolumeUnit.LITER)));
    }

    /**
     * Verifies that different litre measurements are not equal.
     * 1.0 L != 2.0 L → false
     */
    @Test
    void testEquality_LitreToLitre_DifferentValue() {
        assertFalse(new Quantity(1.0, VolumeUnit.LITER)
                .equals(new Quantity(2.0, VolumeUnit.LITER)));
    }

    /**
     * Verifies litre-to-millilitre conversion equality.
     * 1.0 L == 1000.0 mL → true
     */
    @Test
    void testEquality_LitreToMillilitre_EquivalentValue() {
        assertTrue(new Quantity(1.0, VolumeUnit.LITER)
                .equals(new Quantity(1000.0, VolumeUnit.MILLILITER)));
    }

    /**
     * Verifies symmetry of litre and millilitre conversion.
     * 1000.0 mL == 1.0 L → true
     */
    @Test
    void testEquality_MillilitreToLitre_EquivalentValue() {
        assertTrue(new Quantity(1000.0, VolumeUnit.MILLILITER)
                .equals(new Quantity(1.0, VolumeUnit.LITER)));
    }

    /**
     * Verifies litre-to-gallon conversion equality (within epsilon).
     * 1.0 L ≈ 0.264172 Gallon
     */
    @Test
    void testEquality_LitreToGallon_EquivalentValue() {
        assertTrue(new Quantity(1.0, VolumeUnit.LITER)
                .equals(new Quantity(0.264172, VolumeUnit.GALLON)));
    }

    /**
     * Verifies symmetry of gallon-to-litre conversion.
     * 1.0 Gallon ≈ 3.78541 L
     */
    @Test
    void testEquality_GallonToLitre_EquivalentValue() {
        assertTrue(new Quantity(1.0, VolumeUnit.GALLON)
                .equals(new Quantity(3.78541, VolumeUnit.LITER)));
    }

    /**
     * Verifies that volume is not equal to length.
     */
    @Test
    void testEquality_VolumeVsLength_Incompatible() {
        assertFalse(new Quantity(1.0, VolumeUnit.LITER)
                .equals(new Quantity(1.0, LengthUnit.FEET)));
    }

    /**
     * Verifies that volume is not equal to weight.
     */
    @Test
    void testEquality_VolumeVsWeight_Incompatible() {
        assertFalse(new Quantity(1.0, VolumeUnit.LITER)
                .equals(new Quantity(1.0, WeightUnit.KILOGRAM)));
    }

    /**
     * Verifies comparison with null returns false.
     */
    @Test
    void testEquality_NullComparison() {
        assertFalse(new Quantity(1.0, VolumeUnit.LITER).equals(null));
    }

    /**
     * Verifies reflexive property.
     * An object must equal itself.
     */
    @Test
    void testEquality_SameReference() {
        Quantity q = new Quantity(1.0, VolumeUnit.LITER);
        assertTrue(q.equals(q));
    }

    /**
     * Verifies constructor throws exception for null unit.
     */
    @Test
    void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity(1.0, null));
    }

    /**
     * Verifies transitive property.
     * If A == B and B == C, then A == C.
     */
    @Test
    void testEquality_TransitiveProperty() {
        Quantity a = new Quantity(1.0, VolumeUnit.LITER);
        Quantity b = new Quantity(1000.0, VolumeUnit.MILLILITER);
        Quantity c = new Quantity(1.0, VolumeUnit.LITER);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    /**
     * Verifies zero values are equal across units.
     */
    @Test
    void testEquality_ZeroValue() {
        assertTrue(new Quantity(0.0, VolumeUnit.LITER)
                .equals(new Quantity(0.0, VolumeUnit.MILLILITER)));
    }

    /**
     * Verifies negative values convert correctly.
     * -1 L == -1000 mL
     */
    @Test
    void testEquality_NegativeVolume() {
        assertTrue(new Quantity(-1.0, VolumeUnit.LITER)
                .equals(new Quantity(-1000.0, VolumeUnit.MILLILITER)));
    }

    /**
     * Verifies large magnitude values maintain precision.
     * 1,000,000 mL == 1000 L
     */
    @Test
    void testEquality_LargeVolumeValue() {
        assertTrue(new Quantity(1000000.0, VolumeUnit.MILLILITER)
                .equals(new Quantity(1000.0, VolumeUnit.LITER)));
    }
    
 // ============================================================
 // SMALL VALUE TEST
 // ============================================================

 /**
  * Verifies that small magnitude values maintain precision.
  * 0.001 L == 1.0 mL
  */
 @Test
 void testEquality_SmallVolumeValue() {
     assertTrue(new Quantity(0.001, VolumeUnit.LITER)
             .equals(new Quantity(1.0, VolumeUnit.MILLILITER)));
 }

 // ============================================================
 // CONVERSION TESTS
 // ============================================================

 /**
  * Verifies conversion from litre to millilitre.
  * 1.0 L → 1000.0 mL
  */
 @Test
 void testConversion_LitreToMillilitre() {
     Quantity result = new Quantity(1.0, VolumeUnit.LITER)
             .convertTo(VolumeUnit.MILLILITER);

     assertEquals(1000.0, result.getValue(), 0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies conversion from millilitre to litre.
  * 1000.0 mL → 1.0 L
  */
 @Test
 void testConversion_MillilitreToLitre() {
     Quantity result = new Quantity(1000.0, VolumeUnit.MILLILITER)
             .convertTo(VolumeUnit.LITER);

     assertEquals(1.0, result.getValue(), 0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies conversion from gallon to litre.
  * 1.0 Gallon ≈ 3.78541 L
  */
 @Test
 void testConversion_GallonToLitre() {
     Quantity result = new Quantity(1.0, VolumeUnit.GALLON)
             .convertTo(VolumeUnit.LITER);

     assertEquals(3.78541, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies conversion from litre to gallon.
  * 3.78541 L ≈ 1.0 Gallon
  */
 @Test
 void testConversion_LitreToGallon() {
     Quantity result = new Quantity(3.78541, VolumeUnit.LITER)
             .convertTo(VolumeUnit.GALLON);

     assertEquals(1.0, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies conversion from millilitre to gallon.
  * 1000.0 mL ≈ 0.264172 Gallon
  */
 @Test
 void testConversion_MillilitreToGallon() {
     Quantity result = new Quantity(1000.0, VolumeUnit.MILLILITER)
             .convertTo(VolumeUnit.GALLON);

     assertEquals(0.264172, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies converting to the same unit returns unchanged value.
  */
 @Test
 void testConversion_SameUnit() {
     Quantity result = new Quantity(5.0, VolumeUnit.LITER)
             .convertTo(VolumeUnit.LITER);

     assertEquals(5.0, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies zero value conversion across units.
  */
 @Test
 void testConversion_ZeroValue() {
     Quantity result = new Quantity(0.0, VolumeUnit.LITER)
             .convertTo(VolumeUnit.MILLILITER);

     assertEquals(0.0, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies negative volume conversion preserves sign.
  * -1.0 L → -1000.0 mL
  */
 @Test
 void testConversion_NegativeValue() {
     Quantity result = new Quantity(-1.0, VolumeUnit.LITER)
             .convertTo(VolumeUnit.MILLILITER);

     assertEquals(-1000.0, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies round-trip conversion maintains precision.
  * 1.5 L → mL → L ≈ 1.5 L
  */
 @Test
 void testConversion_RoundTrip() {
     Quantity result = new Quantity(1.5, VolumeUnit.LITER)
             .convertTo(VolumeUnit.MILLILITER)
             .convertTo(VolumeUnit.LITER);

     assertEquals(1.5, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 // ============================================================
 // ADDITION TESTS
 // ============================================================

 /**
  * Verifies same-unit litre addition.
  * 1.0 L + 2.0 L = 3.0 L
  */
 @Test
 void testAddition_SameUnit_LitrePlusLitre() {
     Quantity result = new Quantity(1.0, VolumeUnit.LITER)
             .add(new Quantity(2.0, VolumeUnit.LITER));

     assertEquals(3.0, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies same-unit millilitre addition.
  * 500 mL + 500 mL = 1000 mL
  */
 @Test
 void testAddition_SameUnit_MillilitrePlusMillilitre() {
     Quantity result = new Quantity(500.0, VolumeUnit.MILLILITER)
             .add(new Quantity(500.0, VolumeUnit.MILLILITER));

     assertEquals(1000.0, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies cross-unit addition with result in litre.
  * 1.0 L + 1000 mL = 2.0 L
  */
 @Test
 void testAddition_CrossUnit_LitrePlusMillilitre() {
     Quantity result = new Quantity(1.0, VolumeUnit.LITER)
             .add(new Quantity(1000.0, VolumeUnit.MILLILITER));

     assertEquals(2.0, result.getValue(), 0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies cross-unit addition with result in millilitre.
  * 1000 mL + 1.0 L = 2000 mL
  */
 @Test
 void testAddition_CrossUnit_MillilitrePlusLitre() {
     Quantity result = new Quantity(1000.0, VolumeUnit.MILLILITER)
             .add(new Quantity(1.0, VolumeUnit.LITER));

     assertEquals(2000.0, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }

 /**
  * Verifies cross-unit addition with gallon conversion.
  * 1.0 Gallon + 3.78541 L ≈ 2.0 Gallon
  */
 @Test
 void testAddition_CrossUnit_GallonPlusLitre() {
     Quantity result = new Quantity(1.0, VolumeUnit.GALLON)
             .add(new Quantity(3.78541, VolumeUnit.LITER));

     assertEquals(2.0, result.getValue(),  0.0001); //Here 0.0001 is value of Epsilon
 }
 
 private static final double EPSILON = 0.00001;

 // ============================================================
 // EXPLICIT TARGET UNIT ADDITION
 // ============================================================

 @Test
 void testAddition_ExplicitTargetUnit_Litre() {
     Quantity result = new Quantity(1.0, VolumeUnit.LITER)
             .add(new Quantity(1000.0, VolumeUnit.MILLILITER), VolumeUnit.LITER);

     assertEquals(2.0, result.getValue(), EPSILON);
 }

 @Test
 void testAddition_ExplicitTargetUnit_Millilitre() {
     Quantity result = new Quantity(1.0, VolumeUnit.LITER)
             .add(new Quantity(1000.0, VolumeUnit.MILLILITER), VolumeUnit.MILLILITER);

     assertEquals(2000.0, result.getValue(), EPSILON);
 }

 @Test
 void testAddition_ExplicitTargetUnit_Gallon() {
     Quantity result = new Quantity(3.78541, VolumeUnit.LITER)
             .add(new Quantity(3.78541, VolumeUnit.LITER), VolumeUnit.GALLON);

     assertEquals(2.0, result.getValue(), EPSILON);
 }

 // ============================================================
 // ADDITION PROPERTIES
 // ============================================================

 @Test
 void testAddition_Commutativity() {
     Quantity a = new Quantity(1.0, VolumeUnit.LITER);
     Quantity b = new Quantity(1000.0, VolumeUnit.MILLILITER);

     assertTrue(a.add(b).equals(b.add(a)));
 }

 @Test
 void testAddition_WithZero() {
     Quantity result = new Quantity(5.0, VolumeUnit.LITER)
             .add(new Quantity(0.0, VolumeUnit.MILLILITER));

     assertEquals(5.0, result.getValue(), EPSILON);
 }

 @Test
 void testAddition_NegativeValues() {
     Quantity result = new Quantity(5.0, VolumeUnit.LITER)
             .add(new Quantity(-2000.0, VolumeUnit.MILLILITER));

     assertEquals(3.0, result.getValue(), EPSILON);
 }

 @Test
 void testAddition_LargeValues() {
     Quantity result = new Quantity(1e6, VolumeUnit.LITER)
             .add(new Quantity(1e6, VolumeUnit.LITER));

     assertEquals(2e6, result.getValue(), EPSILON);
 }

 @Test
 void testAddition_SmallValues() {
     Quantity result = new Quantity(0.001, VolumeUnit.LITER)
             .add(new Quantity(0.002, VolumeUnit.LITER));

     assertEquals(0.003, result.getValue(), EPSILON);
 }

 // ============================================================
 // ENUM CONSTANT VALIDATION
 // ============================================================

 @Test
 void testVolumeUnitEnum_LitreConstant() {
     assertEquals(1.0, VolumeUnit.LITER.getConversionFactor(), EPSILON);
 }

 @Test
 void testVolumeUnitEnum_MillilitreConstant() {
     assertEquals(0.001, VolumeUnit.MILLILITER.getConversionFactor(), EPSILON);
 }

 @Test
 void testVolumeUnitEnum_GallonConstant() {
     assertEquals(3.78541, VolumeUnit.GALLON.getConversionFactor(), EPSILON);
 }

 // ============================================================
 // BASE UNIT CONVERSIONS
 // ============================================================

 @Test
 void testConvertToBaseUnit_LitreToLitre() {
     assertEquals(5.0,
             VolumeUnit.LITER.convertToBaseUnit(5.0),
             EPSILON);
 }

 @Test
 void testConvertToBaseUnit_MillilitreToLitre() {
     assertEquals(1.0,
             VolumeUnit.MILLILITER.convertToBaseUnit(1000.0),
             EPSILON);
 }

 @Test
 void testConvertToBaseUnit_GallonToLitre() {
     assertEquals(3.78541,
             VolumeUnit.GALLON.convertToBaseUnit(1.0),
             EPSILON);
 }

 @Test
 void testConvertFromBaseUnit_LitreToLitre() {
     assertEquals(2.0,
             VolumeUnit.LITER.convertFromBaseUnit(2.0),
             EPSILON);
 }

 @Test
 void testConvertFromBaseUnit_LitreToMillilitre() {
     assertEquals(1000.0,
             VolumeUnit.MILLILITER.convertFromBaseUnit(1.0),
             EPSILON);
 }

 @Test
 void testConvertFromBaseUnit_LitreToGallon() {
     assertEquals(1.0,
             VolumeUnit.GALLON.convertFromBaseUnit(3.78541),
             EPSILON);
 }

 // ============================================================
 // BACKWARD COMPATIBILITY & GENERIC VALIDATION
 // ============================================================

 @Test
 void testBackwardCompatibility_AllUC1Through10Tests() {
     assertTrue(new Quantity(1.0, LengthUnit.FEET)
             .equals(new Quantity(12.0, LengthUnit.INCH)));

     assertTrue(new Quantity(1.0, WeightUnit.KILOGRAM)
             .equals(new Quantity(1000.0, WeightUnit.GRAM)));
 }

 @Test
 void testGenericQuantity_VolumeOperations_Consistency() {
     Quantity a = new Quantity(1.0, VolumeUnit.LITER);
     Quantity b = new Quantity(1000.0, VolumeUnit.MILLILITER);

     assertTrue(a.equals(b));
     assertEquals(2.0, a.add(b).getValue(), EPSILON);
 }

 @Test
 void testScalability_VolumeIntegration() {
     Quantity length = new Quantity(1.0, LengthUnit.FEET);
     Quantity volume = new Quantity(1.0, VolumeUnit.LITER);

     assertFalse(length.equals(volume));
 }
}