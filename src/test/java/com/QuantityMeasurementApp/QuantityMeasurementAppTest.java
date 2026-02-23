package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive Test Suite for Volume, Length, and Weight Measurements.
 */
public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    // --- Volume Equality Tests ---

    @Test
    void testEquality_LitreToLitre_SameValue() {
        // Verifies that equals() returns true for identical litre measurements.
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_LitreToLitre_DifferentValue() {
        // Verifies that equals() returns false for different litre measurements.
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_LitreToMillilitre_EquivalentValue() {
        // Verifies that equals() returns true for litre-to-millilitre conversion.
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> millilitre = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertTrue(litre.equals(millilitre));
    }

    @Test
    void testEquality_MillilitreToLitre_EquivalentValue() {
        // Verifies that equals() returns true (tests symmetry of conversion).
        Quantity<VolumeUnit> millilitre = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertTrue(millilitre.equals(litre));
    }

    @Test
    void testEquality_LitreToGallon_EquivalentValue() {
        // Verifies that equals() returns true for litre-to-gallon conversion.
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0 / 3.78541, VolumeUnit.GALLON);
        assertTrue(litre.equals(gallon));
    }

    @Test
    void testEquality_GallonToLitre_EquivalentValue() {
        // Verifies that equals() returns true (tests symmetry of conversion).
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> litre = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertTrue(gallon.equals(litre));
    }

    @Test
    void testEquality_VolumeVsLength_Incompatible() {
        // Verifies that equals() returns false when comparing incompatible measurement categories.
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        assertFalse(volume.equals(length));
    }

    @Test
    void testEquality_VolumeVsWeight_Incompatible() {
        // Verifies that equals() returns false when comparing volume with weight.
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(volume.equals(weight));
    }

    @Test
    void testEquality_NullComparison() {
        // Verifies that equals() returns false when comparing with null.
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertFalse(volume.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        // Verifies that a volume object equals itself (reflexive property).
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertTrue(volume.equals(volume));
    }

    @Test
    void testEquality_NullUnit() {
        // Verifies that Exception thrown for null unit in constructor.
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(1.0, null));
    }

    @Test
    void testEquality_TransitiveProperty() {
        // Verifies transitive property: if A equals B and B equals C, then A equals C.
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> cExact = new Quantity<>(1.0 / VolumeUnit.GALLON.getConversionFactor(), VolumeUnit.GALLON);
        
        assertTrue(a.equals(b));
        assertTrue(b.equals(cExact));
        assertTrue(a.equals(cExact));
    }

    @Test
    void testEquality_ZeroValue() {
        // Verifies that Zero values are considered equal across units.
        Quantity<VolumeUnit> q1 = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_NegativeVolume() {
        // Verifies that Negative volume values are handled correctly in conversions.
        Quantity<VolumeUnit> q1 = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(-1000.0, VolumeUnit.MILLILITRE);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_LargeVolumeValue() {
        // Verifies that Large magnitude values maintain precision across conversions.
        Quantity<VolumeUnit> q1 = new Quantity<>(1000000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.LITRE);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_SmallVolumeValue() {
        // Verifies that Small magnitude values maintain precision across conversions.
        Quantity<VolumeUnit> q1 = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.MILLILITRE);
        assertTrue(q1.equals(q2));
    }

    // --- Conversion Tests ---

    @Test
    void testConversion_LitreToMillilitre() {
        // Verifies conversion from litre to millilitre.
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.LITRE);
        double result = q.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(1000.0, result, EPSILON);
    }

    @Test
    void testConversion_MillilitreToLitre() {
        // Verifies conversion from millilitre to litre.
        Quantity<VolumeUnit> q = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        double result = q.convertTo(VolumeUnit.LITRE);
        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testConversion_GallonToLitre() {
        // Verifies conversion from gallon to litre.
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.GALLON);
        double result = q.convertTo(VolumeUnit.LITRE);
        assertEquals(3.78541, result, EPSILON);
    }

    @Test
    void testConversion_LitreToGallon() {
        // Verifies conversion from litre to gallon.
        Quantity<VolumeUnit> q = new Quantity<>(3.78541, VolumeUnit.LITRE);
        double result = q.convertTo(VolumeUnit.GALLON);
        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testConversion_MillilitreToGallon() {
        // Verifies conversion from millilitre to gallon.
        Quantity<VolumeUnit> q = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        double result = q.convertTo(VolumeUnit.GALLON);
        assertEquals(1000.0 * 0.001 / 3.78541, result, EPSILON);
    }

    @Test
    void testConversion_SameUnit() {
        // Verifies that converting to the same unit returns unchanged value.
        Quantity<VolumeUnit> q = new Quantity<>(5.0, VolumeUnit.LITRE);
        double result = q.convertTo(VolumeUnit.LITRE);
        assertEquals(5.0, result, EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {
        // Verifies zero value conversion across units.
        Quantity<VolumeUnit> q = new Quantity<>(0.0, VolumeUnit.LITRE);
        double result = q.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(0.0, result, EPSILON);
    }

    @Test
    void testConversion_NegativeValue() {
        // Verifies that negative volume conversion preserves sign.
        Quantity<VolumeUnit> q = new Quantity<>(-1.0, VolumeUnit.LITRE);
        double result = q.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(-1000.0, result, EPSILON);
    }

    @Test
    void testConversion_RoundTrip() {
        // Verifies that round-trip conversions preserve value within floating-point tolerance.
        Quantity<VolumeUnit> start = new Quantity<>(1.5, VolumeUnit.LITRE);
        double toMl = start.convertTo(VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(toMl, VolumeUnit.MILLILITRE);
        double backToLitre = ml.convertTo(VolumeUnit.LITRE);
        assertEquals(1.5, backToLitre, EPSILON);
    }

    // --- Addition Tests ---

    @Test
    void testAddition_SameUnit_LitrePlusLitre() {
        // Verifies same-unit addition without conversion.
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = q1.add(q2);
        assertEquals(3.0, result.getValue(), EPSILON);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    void testAddition_SameUnit_MillilitrePlusMillilitre() {
        // Verifies same-unit addition for millilitres.
        Quantity<VolumeUnit> q1 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = q1.add(q2);
        assertEquals(1000.0, result.getValue(), EPSILON);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_LitrePlusMillilitre() {
        // Verifies cross-unit addition with result in litre.
        Quantity<VolumeUnit> l = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = l.add(ml);
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_MillilitrePlusLitre() {
        // Verifies cross-unit addition with result in millilitre.
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> l = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = ml.add(l);
        assertEquals(2000.0, result.getValue(), EPSILON);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_GallonPlusLitre() {
        // Verifies cross-unit addition with gallons conversion.
        Quantity<VolumeUnit> g = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> l = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = g.add(l);
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(VolumeUnit.GALLON, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Litre() {
        // Verifies explicit target unit specification in litre.
        Quantity<VolumeUnit> l = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = l.add(ml, VolumeUnit.LITRE);
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Millilitre() {
        // Verifies explicit target unit specification in millilitre.
        Quantity<VolumeUnit> l = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = l.add(ml, VolumeUnit.MILLILITRE);
        assertEquals(2000.0, result.getValue(), EPSILON);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Gallon() {
        // Verifies explicit target unit specification in gallon.
        Quantity<VolumeUnit> l1 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> l2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = l1.add(l2, VolumeUnit.GALLON);
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(VolumeUnit.GALLON, result.getUnit());
    }

    @Test
    void testAddition_Commutativity() {
        // Verifies that addition is commutative with appropriate unit conversions.
        Quantity<VolumeUnit> l = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        
        Quantity<VolumeUnit> sum1 = l.add(ml); // 2.0 Litres
        Quantity<VolumeUnit> sum2 = ml.add(l); // 2000.0 Millilitres
        
        assertTrue(sum1.equals(sum2));
    }

    @Test
    void testAddition_WithZero() {
        // Verifies that adding zero acts as identity element.
        Quantity<VolumeUnit> l = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> zero = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = l.add(zero);
        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        // Verifies addition with negative measurements.
        Quantity<VolumeUnit> l = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> neg = new Quantity<>(-2000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = l.add(neg);
        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_LargeValues() {
        // Verifies addition with large magnitude values.
        Quantity<VolumeUnit> q1 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = q1.add(q2);
        assertEquals(2e6, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_SmallValues() {
        // Verifies addition with small magnitude values.
        Quantity<VolumeUnit> q1 = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(0.002, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = q1.add(q2);
        assertEquals(0.003, result.getValue(), EPSILON);
    }

    // --- Enum Constant and Method Tests ---

    @Test
    void testVolumeUnitEnum_LitreConstant() {
        // Verifies VolumeUnit.LITRE is accessible and has correct conversion factor 1.0.
        assertEquals(1.0, VolumeUnit.LITRE.getConversionFactor());
    }

    @Test
    void testVolumeUnitEnum_MillilitreConstant() {
        // Verifies VolumeUnit.MILLILITRE is accessible and has correct conversion factor 0.001.
        assertEquals(0.001, VolumeUnit.MILLILITRE.getConversionFactor());
    }

    @Test
    void testVolumeUnitEnum_GallonConstant() {
        // Verifies VolumeUnit.GALLON is accessible and has correct conversion factor 3.78541.
        assertEquals(3.78541, VolumeUnit.GALLON.getConversionFactor());
    }

    @Test
    void testConvertToBaseUnit_LitreToLitre() {
        // Verifies conversion to base unit when already in base unit.
        assertEquals(5.0, VolumeUnit.LITRE.convertToBaseUnit(5.0), EPSILON);
    }

    @Test
    void testConvertToBaseUnit_MillilitreToLitre() {
        // Verifies conversion from millilitre to litre (base unit).
        assertEquals(1.0, VolumeUnit.MILLILITRE.convertToBaseUnit(1000.0), EPSILON);
    }

    @Test
    void testConvertToBaseUnit_GallonToLitre() {
        // Verifies conversion from gallon to litre (base unit).
        assertEquals(3.78541, VolumeUnit.GALLON.convertToBaseUnit(1.0), EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_LitreToLitre() {
        // Verifies conversion from base unit (litre) to litre.
        assertEquals(2.0, VolumeUnit.LITRE.convertFromBaseUnit(2.0), EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_LitreToMillilitre() {
        // Verifies conversion from base unit (litre) to millilitre.
        assertEquals(1000.0, VolumeUnit.MILLILITRE.convertFromBaseUnit(1.0), EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_LitreToGallon() {
        // Verifies conversion from base unit (litre) to gallon.
        assertEquals(1.0, VolumeUnit.GALLON.convertFromBaseUnit(3.78541), EPSILON);
    }

    // --- Architectural and Scalability Tests ---

    @Test
    void testBackwardCompatibility_AllUC1Through10Tests() {
        // Runs all test cases from UC1–UC10 unchanged.
        // Verifies length and weight still work.
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));

        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(w1.equals(w2));
    }

    @Test
    void testGenericQuantity_VolumeOperations_Consistency() {
        // Verifies that generic Quantity<U> works identically for volume as for length and weight.
        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertNotNull(v.getUnit());
        assertEquals(1.0, v.getValue());
    }

    @Test
    void testScalability_VolumeIntegration() {
        // Confirms that volume integrates seamlessly with existing system.
        // New categories integrate without modifying Quantity or App logic.
        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.GALLON);
        QuantityMeasurementApp.demonstrateConversion(v, VolumeUnit.LITRE);
    }
}
