# ✅ UC2: Feet and Inches Measurement Equality

## 📖 Description

The Quantity Measurement Application now supports equality comparison for both **Feet** and **Inches** measurements.

This use case extends **UC1 (Feet Equality)** by introducing a separate `Inches` class while preserving the existing `Feet` functionality.

Each measurement type ensures accurate value-based comparison and maintains strict type safety (`Feet ≠ Inches`).

---

## 🔎 Preconditions

- `Feet` and `Inches` classes are properly defined.
- Two numerical values (either in feet or inches) are provided for comparison.
- Objects must belong to the same measurement type for equality to return `true`.

---

## 🔄 Main Flow

1. User creates two measurement objects (`Feet` or `Inches`).
2. Values are stored in immutable (`private final`) fields.
3. The `equals()` method is invoked for comparison.
4. Type checking ensures only same-type objects are compared.
5. Result (`true` / `false`) is returned.

---

## 📤 Postconditions

- Returns `true` if:
  - Both objects are of the same type  
  - Both contain equal numeric values  

- Returns `false` if:
  - Values differ  
  - Objects are of different types (`Feet` vs `Inches`)  
  - One object is `null`  

---

## 🧠 Concepts Learned (UC2)

- ✅ Extending functionality without breaking existing code  
- ✅ Maintaining the Equality Contract across multiple classes  
- ✅ Strict Type Safety (`Feet ≠ Inches`)  
- ✅ Encapsulation & Immutability  
- ✅ Value-Based Object Comparison  
- ✅ Clean modular design  

---

## 🧪 Key Concepts Tested

### 🔁 Equality Contract

- Reflexive  
- Symmetric  
- Transitive  
- Consistent  
- Null handling  

---

### 🛡️ Type Safety

- `Feet` objects are equal only to `Feet`
- `Inches` objects are equal only to `Inches`
- `Feet` and `Inches` are never equal even if numeric values match

---

### 🎯 Value-Based Equality

| Comparison | Result |
|------------|--------|
| 1.0 ft vs 1.0 ft | ✅ Equal |
| 1.0 inch vs 1.0 inch | ✅ Equal |
| 1.0 ft vs 2.0 ft | ❌ Not Equal |
| 1.0 inch vs 2.0 inch | ❌ Not Equal |
| 1.0 ft vs 1.0 inch | ❌ Not Equal |

---

## 🧪 Sample Test Cases

- `testFeetEquality_SameValue()`
- `testFeetEquality_DifferentValue()`
- `testFeetEquality_NullComparison()`
- `testFeetEquality_SameReference()`
- `testInchesEquality_SameValue()`
- `testInchesEquality_DifferentValue()`
- `testInchesEquality_NullComparison()`
- `testFeetAndInchesComparison_ShouldReturnFalse()`

---
