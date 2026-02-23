# 📏 Quantity Measurement App

## 📌 Overview

The Quantity Measurement App compares two quantities (such as length, weight, etc.) and provides comparison across different units.

The application will progressively add:
- 🔄 Conversion from one unit to another  
- ➕ Support for quantity arithmetic  

This app is being developed incrementally. Each use case defines a specific scope, and development must strictly follow that scope.

---

## 🚀 Implemented Feature

### ✅ UC1: Feet Measurement Equality

#### 📖 Description

The `QuantityMeasurementApp` class checks the equality of two numerical values measured in feet. It ensures accurate comparison and handles important edge cases.

#### 🔎 Preconditions

- The `QuantityMeasurementApp` class is instantiated.
- Two numerical values in feet are provided for comparison.

#### 🔄 Main Flow

1. User inputs two numerical values in feet.
2. Input values are validated to ensure they are numeric.
3. The two values are compared for equality.
4. The result (true/false) is returned.

#### 📤 Postconditions

- Returns `true` if both values are equal.
- Returns `false` if values are not equal.

---

## 🧠 Concepts Learned (UC1)

- ✅ Object Equality – Properly overriding `equals()` method  
- ✅ Floating-Point Comparison – Using `Double.compare()` instead of `==`  
- ✅ Null Safety – Preventing `NullPointerException`  
- ✅ Type Safety – Ensuring correct object comparison  
- ✅ Encapsulation & Immutability – Using private final fields  
- ✅ Unit Testing Best Practices  

---

## 🧪 Key Concepts Tested

### 🔁 Equality Contract
- Reflexive  
- Symmetric  
- Transitive  
- Consistent  
- Null handling  

### 🛡️ Type Safety
- Objects are equal only if they belong to the same type.

### 🎯 Value-Based Equality
- Same values → Equal  
- Different values → Not equal  

---

## 🧪 Sample Test Cases

- `testEquality_SameValue()`  
- `testEquality_DifferentValue()`  
- `testEquality_NullComparison()`  
- `testEquality_NonNumericInput()`  
- `testEquality_SameReference()`  

---

### ✅ UC2: Feet and Inches Measurement Equality

#### 📖 Description

The Quantity Measurement Application now supports equality comparison for both **Feet** and **Inches** measurements.

This use case extends **UC1 (Feet Equality)** by introducing a separate `Inches` class while preserving the existing `Feet` functionality.

Each measurement type ensures accurate value-based comparison and maintains strict type safety (`Feet ≠ Inches`).

---

#### 🔎 Preconditions

- `Feet` and `Inches` classes are properly defined.
- Two numerical values (either in feet or inches) are provided for comparison.
- Objects must belong to the same measurement type for equality to return `true`.

---

#### 🔄 Main Flow

1. User creates two measurement objects (`Feet` or `Inches`).
2. Values are stored in immutable (`private final`) fields.
3. The `equals()` method is invoked for comparison.
4. Type checking ensures only same-type objects are compared.
5. Result (`true` / `false`) is returned.

---

#### 📤 Postconditions

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
