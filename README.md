# ✅ UC4: Yard Equality Support

## 📖 Description

The Quantity Measurement Application is extended to support **Yard** as a new unit of length.

This enhancement builds on the generic design introduced in **UC3**, where all length measurements are represented using:

- `QuantityLength` (generic length class)
- `LengthUnit` (enum for supported units)

With UC4, the system now supports:

- Feet
- Inch
- Yard

All units can be compared with each other using automatic conversion to a common base unit (Feet).

---

## 🔎 Preconditions

- `QuantityLength` objects must be created with:
  - A numeric value
  - A valid `LengthUnit`
- Supported units are defined in `LengthUnit` enum.
- Yard conversion factor is properly defined:
  

1 Yard = 3 Feet
1 Yard = 36 Inches


---

## 🔄 Main Flow

1. User creates two `QuantityLength` objects.
2. Each object stores:
 - A numeric value
 - Its measurement unit
3. During comparison:
 - Both values are converted to the base unit (Feet).
 - `Double.compare()` ensures precise floating-point comparison.
4. Equality result (`true` / `false`) is returned.

---

## 📤 Postconditions

- Returns `true` if:
- Measurements are equivalent after unit conversion
- Returns `false` if:
- Converted values differ
- Compared object is `null`
- Compared with a different type

---

## 🧠 Concepts Learned (UC4)

- ✅ Open-Closed Principle (Extend without modifying core logic)
- ✅ Enum-based unit representation
- ✅ Cross-unit comparison
- ✅ Scalable architecture
- ✅ Clean and maintainable design
- ✅ DRY Principle (No duplicate logic)

---

## 🧪 Key Concepts Tested

### 🔁 Equality Contract

- Reflexive  
- Symmetric  
- Transitive  
- Consistent  
- Null handling  

---

### 🔄 Cross-Unit Conversion

| Comparison | Result |
|------------|--------|
| 1 Yard vs 1 Yard | ✅ Equal |
| 1 Yard vs 3 Feet | ✅ Equal |
| 1 Yard vs 36 Inch | ✅ Equal |
| 2 Yard vs 6 Feet | ✅ Equal |
| 1 Yard vs 2 Yard | ❌ Not Equal |

---

## 🧪 Sample Test Cases

- `testYardToYard_SameValue()`
- `testYardToFeet_Equivalent()`
- `testYardToInch_Equivalent()`
- `testDifferentValues_ShouldReturnFalse()`
- `testNullComparison_ShouldReturnFalse()`
- `testSameReference_ShouldReturnTrue()`

---

## 📁 Project Structure (UC4)


src/main/java/com/QuantityMeasurementApp/
LengthUnit.java
QuantityLength.java

src/test/java/com/QuantityMeasurementApp/
QuantityLengthTest.java


---

## 🚀 Architectural Evolution

| Use Case | Design |
|----------|--------|
| UC1 | Only Feet |
| UC2 | Feet + Inch |
| UC3 | Generic Length (Enum-based) |
| UC4 | Extended with Yard (No logic modification required) |

---

## 🔥 Key Achievement

Adding a new unit (Yard) required **only one change** — updating the `LengthUnit` enum.

No modification was needed in:

- `QuantityLength`
- Equality logic
- Conversion logic

This demonstrates a scalable and extensible architecture.
