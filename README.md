# 📏 Quantity Measurement App

## 📌 Overview

The Quantity Measurement App compares two quantities (such as length, weight, etc.) and provides comparison across different units.

The application will progressively add:
- 🔄 Conversion from one unit to another  
- ➕ Support for quantity arithmetic  

This app is being developed incrementally. Each use case defines a specific scope, and development must strictly follow that scope.

---

## 🚀 Implemented Features

### ✅ UC1: Feet Measurement Equality  

#### 📖 Description  
The `QuantityMeasurementApp` class compares two numerical values measured in feet and determines if they are equal, handling key edge cases properly.  

#### 🔎 Preconditions  
- `QuantityMeasurementApp` is instantiated.  
- Two numerical feet values are provided.  

#### 🔄 Main Flow  
1. User enters two feet values.  
2. Inputs are validated to ensure they are numeric.  
3. Values are compared for equality.  
4. Result (`true`/`false`) is returned.  

#### 📤 Postconditions  
- Returns `true` if values are equal.  
- Returns `false` otherwise.  

---

## 🧠 Concepts Covered (UC1)  

- Object Equality – Overriding `equals()` correctly  
- Floating-Point Comparison – Using `Double.compare()`  
- Null Safety – Avoiding `NullPointerException`  
- Type Safety – Comparing only same types  
- Encapsulation & Immutability – Private `final` fields  
- Unit Testing best practices  

---

## 🧪 Key Principles Tested  

### 🔁 Equality Contract  
- Reflexive  
- Symmetric  
- Transitive  
- Consistent  
- Null handling  

### 🛡️ Type Safety  
- Equality only for same-type objects  

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
Adds equality support for both **Feet** and **Inches** measurements.  
Extends UC1 by introducing an `Inches` class while keeping `Feet` intact.  
Ensures strict type safety (`Feet ≠ Inches`) and value-based comparison.

---

#### 🔎 Preconditions
- `Feet` and `Inches` classes are defined.
- Two measurement objects are created.
- Equality works only for same-type objects.

---

#### 🔄 Main Flow
1. Create two `Feet` or `Inches` objects.
2. Values stored in `private final` fields.
3. `equals()` method compares values.
4. Type check ensures same-class comparison.
5. Returns `true` / `false`.

---

#### 📤 Postconditions
- `true` → Same type and same value  
- `false` → Different value, different type, or `null`

---

## 🧠 Concepts Covered
- Extending functionality safely  
- Equality Contract implementation  
- Strict Type Safety  
- Encapsulation & Immutability  
- Value-based comparison  

---

## 🧪 Equality Rules
- `Feet` equals only `Feet`  
- `Inches` equals only `Inches`  
- `Feet` ≠ `Inches` (even if values match)

---

## 🧪 Sample Test Cases
- `testFeetEquality_SameValue()`
- `testFeetEquality_DifferentValue()`
- `testInchesEquality_SameValue()`
- `testInchesEquality_DifferentValue()`
- `testFeetAndInchesComparison_ShouldReturnFalse()`

---

### ✅ UC3: Generic Length Equality

#### 📖 Description
Introduces a unified `QuantityLength` class with a `LengthUnit` enum to support generic length comparison.  
Removes separate `Feet` and `Inches` classes and enables cross-unit comparison.

Example: `1.0 ft == 12.0 inch → true`

---

#### 🔎 Preconditions
- `QuantityLength` is created with:
  - Numeric value  
  - Valid `LengthUnit`
- Units are defined in `LengthUnit`.
- Values are converted to a common base unit before comparison.

---

#### 🔄 Main Flow
1. Create two `QuantityLength` objects.
2. Each stores value + unit.
3. During `equals()`:
   - Convert both to base unit (Feet).
   - Use `Double.compare()` for accuracy.
4. Return `true` / `false`.

---

#### 📤 Postconditions
- `true` → Values are equal after conversion  
- `false` → Values differ, object is `null`, or type mismatch  

---

## 🧠 Concepts Covered
- Generic design & refactoring  
- DRY principle  
- Enums for unit handling  
- Cross-unit comparison  
- Value normalization before equality  
- Scalable architecture  

---

## 🧪 Key Rules
- `1.0 ft = 12.0 inch`
- `2.0 ft = 24.0 inch`
- Different normalized values → Not equal

---

## 🧪 Sample Test Cases
- `testSameUnitEquality_Feet()`
- `testSameUnitEquality_Inch()`
- `testCrossUnitEquality()`
- `testDifferentValues_ShouldReturnFalse()`
- `testNullComparison_ShouldReturnFalse()`
- `testSameReference_ShouldReturnTrue()`

---

### ✅ UC4: Yard Equality Support

#### 📖 Description
Extends the generic `QuantityLength` design by adding **Yard** to `LengthUnit`.  
All units (Feet, Inch, Yard) support cross-unit comparison.

Example: `1.0 yard == 3.0 ft → true`

---

#### 🔎 Preconditions
- `QuantityLength` is created with:
  - Numeric value  
  - Valid `LengthUnit`
- Yard conversion is defined in `LengthUnit`.
- Values are converted to base unit (Feet) before comparison.

---

#### 🔄 Main Flow
1. Create two `QuantityLength` objects.
2. Each stores value + unit.
3. During `equals()`:
   - Convert both to Feet.
   - Use `Double.compare()` for precision.
4. Return `true` / `false`.

---

#### 📤 Postconditions
- `true` → Equal after conversion  
- `false` → Values differ, object is `null`, or type mismatch  

---

## 🧠 Concepts Covered
- Open-Closed Principle  
- Enum-based unit extension  
- Cross-unit comparison  
- DRY principle  
- Scalable architecture  

---

## 🧪 Key Rules
- `1.0 yard = 3.0 ft`
- `1.0 yard = 36.0 inch`
- Different normalized values → Not equal  

---

## 🧪 Sample Test Cases
- `testYardEquality_SameUnit()`
- `testYardToFeet_Equality()`
- `testYardToInch_Equality()`
- `testDifferentValues_ShouldReturnFalse()`
- `testNullComparison_ShouldReturnFalse()`
- `testSameReference_ShouldReturnTrue()`

---
