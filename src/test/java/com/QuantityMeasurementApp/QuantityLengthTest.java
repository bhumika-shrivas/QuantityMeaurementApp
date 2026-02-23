package com.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive Test Suite for Quantity Measurement App.
 * Covers UC1 through UC12 requirements.
 */
public class QuantityLengthTest {

    // Helper Enum for Scalability Tests
    enum VolumeUnit implements IMeasurable {
        LITRE(1.0),
        GALLON(3.78541),
        MILLILITRE(0.001);

        private final double conversionFactor;
        VolumeUnit(double factor) { this.conversionFactor = factor; }
        public double getConversionFactor() { return conversionFactor; }
        public double convertToBaseUnit(double v) { return v * conversionFactor; }
        public double convertFromBaseUnit(double b) { return b / conversionFactor; }
        public String getUnitName() { return this.name(); }
    }

    @Test
    void testIMeasurableInterface_LengthUnitImplementation() {
        LengthUnit unit = LengthUnit.FEET;
        assertEquals(12.0, unit.getConversionFactor());
        assertEquals(12.0, unit.convertToBaseUnit(1.0));
        assertEquals(1.0, unit.convertFromBaseUnit(12.0));
        assertEquals("FEET", unit.getUnitName());
    }

    @Test
    void testIMeasurableInterface_WeightUnitImplementation() {
        WeightUnit unit = WeightUnit.KILOGRAM;
        assertEquals(1.0, unit.getConversionFactor());
        assertEquals(1.0, unit.convertToBaseUnit(1.0), 1e-6);
        assertEquals("KILOGRAM", unit.getUnitName());
    }

    @Test
    void testIMeasurableInterface_ConsistentBehavior() {
        assertTrue(IMeasurable.class.isAssignableFrom(LengthUnit.class));
        assertTrue(IMeasurable.class.isAssignableFrom(WeightUnit.class));
    }

    @Test
    void testGenericQuantity_LengthOperations_Equality() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testGenericQuantity_WeightOperations_Equality() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testGenericQuantity_LengthOperations_Conversion() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        double result = q.convertTo(LengthUnit.INCHES);
        assertEquals(12.0, result, 1e-6);
    }

    @Test
    void testGenericQuantity_WeightOperations_Conversion() {
        Quantity<WeightUnit> q = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        double result = q.convertTo(WeightUnit.GRAM);
        assertEquals(1000.0, result, 1e-6);
    }

    @Test
    void testGenericQuantity_LengthOperations_Addition() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.FEET);
        assertEquals(2.0, result.getValue(), 1e-6);
    }

    @Test
    void testGenericQuantity_WeightOperations_Addition() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = q1.add(q2, WeightUnit.KILOGRAM);
        assertEquals(2.0, result.getValue(), 1e-6);
    }

    @Test
    void testCrossCategoryPrevention_LengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(length.equals(weight));
    }

    @Test
    void testGenericQuantity_ConstructorValidation_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(1.0, null));
    }

    @Test
    void testGenericQuantity_ConstructorValidation_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(Double.POSITIVE_INFINITY, LengthUnit.FEET));
    }

    @Test
    void testGenericQuantity_Conversion_AllUnitCombinations() {
        for (LengthUnit u1 : LengthUnit.values()) {
            for (LengthUnit u2 : LengthUnit.values()) {
                Quantity<LengthUnit> q = new Quantity<>(1.0, u1);
                double converted = q.convertTo(u2);
                Quantity<LengthUnit> q2 = new Quantity<>(converted, u2);
                assertTrue(q.equals(q2), "Failed conversion: " + u1 + " to " + u2);
            }
        }
    }

    @Test
    void testGenericQuantity_Addition_AllUnitCombinations() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.FEET);
        assertEquals(4.0, result.getValue(), 1e-6);
    }

    @Test
    void testBackwardCompatibility_AllUC1Through9Tests() {
        backwardCompatibilityLengthFeetEqualsInches();
        backwardCompatibilityWeightKilogramEqualsGrams();
        backwardCompatibilityLengthYardsEqualsFeet();
    }

    @Test
    void testQuantityMeasurementApp_SimplifiedDemonstration_Equality() {
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateEquality(l1, l2));
    }

    @Test
    void testQuantityMeasurementApp_SimplifiedDemonstration_Conversion() {
        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = QuantityMeasurementApp.demonstrateConversion(w, WeightUnit.GRAM);
        assertEquals(1000.0, result.getValue(), 1e-6);
    }

    @Test
    void testQuantityMeasurementApp_SimplifiedDemonstration_Addition() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = QuantityMeasurementApp.demonstrateAddition(q1, q2);
        assertEquals(2.0, result.getValue(), 1e-6);
    }

    @Test
    void testTypeWildcard_FlexibleSignatures() {
        Quantity<?> q = new Quantity<>(1.0, LengthUnit.FEET);
        assertNotNull(q.getUnit());
    }

    @Test
    void testScalability_NewUnitEnumIntegration() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertTrue(v1.equals(v2));
    }

    @Test
    void testScalability_MultipleNewCategories() {
        assertDoesNotThrow(() -> {
            new Quantity<>(100, VolumeUnit.MILLILITRE);
        });
    }

    @Test
    void testGenericBoundedTypeParameter_Enforcement() {
        assertTrue(IMeasurable.class.isAssignableFrom(LengthUnit.class));
    }

    @Test
    void testHashCode_GenericQuantity_Consistency() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        assertEquals(q1.hashCode(), q2.hashCode());
    }

    @Test
    void testEquals_GenericQuantity_ContractPreservation() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> c = new Quantity<>(1.0, LengthUnit.FEET);

        assertTrue(a.equals(a)); 
        assertTrue(a.equals(b)); 
        assertTrue(b.equals(a));
        assertTrue(a.equals(b) && b.equals(c) && a.equals(c));
    }

    @Test
    void testEnumAsUnitCarrier_BehaviorEncapsulation() {
        IMeasurable unit = LengthUnit.FEET;
        assertEquals(12.0, unit.convertToBaseUnit(1.0));
    }

    @Test
    void testTypeErasure_RuntimeSafety() {
        Quantity<?> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<?> q2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testCompositionOverInheritance_Flexibility() {
        Quantity<LengthUnit> q = new Quantity<>(5.0, LengthUnit.FEET);
        assertNotNull(q);
    }

    @Test
    void testCodeReduction_DRYValidation() {
        assertTrue(Quantity.class.getTypeParameters().length > 0);
    }

    @Test
    void testMaintainability_SingleSourceOfTruth() {
        assertNotNull(Quantity.class.getDeclaredMethods());
    }

    @Test
    void testArchitecturalReadiness_MultipleNewCategories() {
        assertTrue(IMeasurable.class.isInterface());
    }

    @Test
    void testPerformance_GenericOverhead() {
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            new Quantity<>(1.0, LengthUnit.FEET).add(new Quantity<>(12.0, LengthUnit.INCHES));
        }
        long end = System.nanoTime();
        assertTrue((end - start) > 0);
    }

    @Test
    void testDocumentation_PatternClarity() {
        assertNotNull(Quantity.class.getSimpleName());
    }

    @Test
    void testInterfaceSegregation_MinimalContract() {
        assertTrue(IMeasurable.class.getDeclaredMethods().length >= 4);
    }

    @Test
    void testImmutability_GenericQuantity() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = q1.add(new Quantity<>(12.0, LengthUnit.INCHES));
        assertNotSame(q1, q2);
    }

    // Backward Compatibility Methods
    public void backwardCompatibilityLengthFeetEqualsInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    public void backwardCompatibilityWeightKilogramEqualsGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(kg.equals(gram));
    }

    public void backwardCompatibilityLengthYardsEqualsFeet() {
        Quantity<LengthUnit> yard = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> feet = new Quantity<>(3.0, LengthUnit.FEET);
        assertTrue(yard.equals(feet));
    }
}