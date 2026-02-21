# ✅ UC3: Generic Length Equality

## 📖 Description

The Quantity Measurement Application is enhanced to support **generic length comparison** using a unified model.

Instead of having separate classes for `Feet` and `Inches`, UC3 introduces:

- `QuantityLength` – A generic length representation
- `LengthUnit` – An enum defining supported units and their conversion factors

This design eliminates duplication and allows comparison across different measurement units.

Example: 1.0 ft == 12.0 inch → true

---

## 🔎 Preconditions

- A `QuantityLength` object is created with:
  - A numeric value
  - A valid `LengthUnit`
- Supported units are defined in `LengthUnit` enum.
- Values are converted to a common base unit before comparison.

---

## 🔄 Main Flow

1. User creates two `QuantityLength` objects.
2. Each object stores:
   - A numeric value
   - Its measurement unit
3. During comparison:
   - Both values are converted to a base unit (Feet).
   - `Double.compare()` is used for accurate floating-point comparison.
4. Equality result (`true` / `false`) is returned.

---

## 📤 Postconditions

- Returns `true` if:
  - Both measurements are equivalent after conversion  
- Returns `false` if:
  - Converted values differ  
  - Object is `null`  
  - Compared with a different type  

---

## 🧠 Concepts Learned (UC3)

- ✅ Refactoring to Generic Design  
- ✅ Eliminating Code Duplication (DRY Principle)  
- ✅ Using Enums for Unit Representation  
- ✅ Cross-Unit Comparison  
- ✅ Value Normalization Before Equality  
- ✅ Clean and Scalable Architecture  

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

- `1.0 ft` equals `12.0 inch`
- `2.0 ft` equals `24.0 inch`

---

### 🎯 Value-Based Equality

| Comparison | Result |
|------------|--------|
| 1.0 ft vs 1.0 ft | ✅ Equal |
| 1.0 inch vs 1.0 inch | ✅ Equal |
| 1.0 ft vs 12.0 inch | ✅ Equal |
| 2.0 ft vs 24.0 inch | ✅ Equal |
| 1.0 ft vs 2.0 ft | ❌ Not Equal |
| 1.0 inch vs 2.0 inch | ❌ Not Equal |

---

## 🧪 Sample Test Cases

- `testSameUnitEquality_Feet()`
- `testSameUnitEquality_Inch()`
- `testCrossUnitEquality()`
- `testDifferentValues_ShouldReturnFalse()`
- `testNullComparison_ShouldReturnFalse()`
- `testSameReference_ShouldReturnTrue()`

---
