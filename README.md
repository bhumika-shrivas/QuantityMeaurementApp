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
