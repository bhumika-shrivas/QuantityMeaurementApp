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

### ✅ UC5: Unit Conversion Support

#### 📖 Description
Adds explicit unit conversion using `convertTo()` in `QuantityLength`.  
Supports Feet, Inch, and Yard with normalization through base unit (Feet).

---

#### 🔎 Preconditions
- `QuantityLength` is created with:
  - Numeric value  
  - Valid `LengthUnit`
- Conversion uses defined factors:
  - 1 ft = 12 inch  
  - 1 yard = 3 ft  
  - 1 yard = 36 inch  

---

#### 🔄 Main Flow
1. Create a `QuantityLength` object.
2. Call `convertTo(targetUnit)`.
3. Internally:
   - Convert value to Feet.
   - Convert Feet to target unit.
4. Return a new `QuantityLength` with converted value.

---

#### 📤 Postconditions
- Returns new converted object (immutability maintained).
- Original object remains unchanged.
- Equality continues to work across units.

---

## 🧠 Concepts Covered
- Unit conversion logic  
- Bi-directional conversion  
- Base unit normalization  
- Immutability  
- Open-Closed Principle  
- Extensible design  

---

## 🧪 Key Rules
- `1 ft → 12 inch`
- `12 inch → 1 ft`
- `1 yard → 3 ft`
- `1 yard → 36 inch`

---

## 🧪 Sample Test Cases
- `testFeetToInchConversion()`
- `testInchToFeetConversion()`
- `testYardToFeetConversion()`
- `testYardToInchConversion()`
- `testCrossUnitEquality()`
- `testNullComparison()`

---

### ✅ UC6: Unit Addition Feature

#### 📖 Description
Adds support for adding two `QuantityLength` objects, even with different units.  
Result is returned in the unit of the calling object.

Examples:  
`1 ft + 12 inch = 2 ft`  
`1 yard + 3 ft = 2 yard`  

All calculations are normalized through base unit (Feet).

---

#### 🔎 Preconditions
- Two valid `QuantityLength` objects are created.
- Units supported: Feet, Inch, Yard.
- Second operand must not be `null`.

---

#### 🔄 Main Flow
1. Call `add()` on a `QuantityLength` object.
2. Internally:
   - Convert both values to Feet.
   - Add them.
   - Convert result back to caller’s unit.
3. Return a new immutable `QuantityLength`.

---

#### 📤 Postconditions
- Returns new object with summed value.
- Original objects remain unchanged.
- Throws `IllegalArgumentException` for `null`.

---

## 🧠 Concepts Covered
- Cross-unit arithmetic  
- Base unit normalization  
- Immutability  
- Exception handling  
- Reuse of conversion logic (DRY)  
- Extensible design  

---

## 🧪 Key Rules
- `1 ft + 1 ft = 2 ft`
- `1 ft + 12 inch = 2 ft`
- `1 yard + 3 ft = 2 yard`
- Adding `null` → Exception  

---

## 🧪 Sample Test Cases
- `testFeetPlusFeet()`
- `testFeetPlusInch()`
- `testYardPlusFeet()`
- `testYardPlusInch()`
- `testAddNull_ShouldThrowException()`
- `testCrossUnitEquality()`

---

### ✅ UC7: Target Unit Addition

#### 📖 Description
Enhances addition by allowing users to specify the **target unit** for the result.  
Two `QuantityLength` objects can be added and returned in Feet, Inch, or Yard.

Example: `1 ft + 12 inch → 24 inch`

All calculations are normalized through base unit (Feet).

---

#### 🔎 Preconditions
- Two valid `QuantityLength` objects.
- A valid `LengthUnit` as target unit.
- Second operand must not be `null`.
- Supported units: Feet, Inch, Yard.

---

#### 🔄 Main Flow
1. Call:
   `add(QuantityLength other, LengthUnit targetUnit)`
2. Convert both values to Feet.
3. Add them.
4. Convert sum to target unit.
5. Return new immutable `QuantityLength`.

---

#### 📤 Postconditions
- Returns result in specified unit.
- Original objects remain unchanged.
- Throws `IllegalArgumentException` for `null`.

---

## 🧠 Concepts Covered
- Target-based arithmetic  
- Base unit normalization  
- Immutability  
- DRY principle  
- Scalable design  

---

## 🧪 Key Rules
- `1 ft + 12 inch → 24 inch`
- `1 yard + 3 ft → 6 ft`
- Adding `null` → Exception  

---

## 🧪 Sample Test Cases
- `testAdditionWithTargetUnit_Inch()`
- `testAdditionWithTargetUnit_Feet()`
- `testAdditionWithTargetUnit_Yard()`
- `testAddNull_ShouldThrowException()`
- `testCrossUnitEquality()`

---

### ✅ UC8: Standalone Unit Implementation

#### 📖 Description
Introduces **standalone unit classes**: `Feet`, `Inch`, and `Yard`.

Instead of:
```java
new QuantityLength(1.0, LengthUnit.FEET);
```

Now objects are created as:
```java
new Feet(1.0);
new Inch(12.0);
new Yard(1.0);
```

Each unit class extends `QuantityLength` and inherits:
- Equality comparison  
- Unit conversion  
- Cross-unit addition  
- Target-unit addition  

This improves readability and strengthens object-oriented design.

---

#### 🔎 Preconditions
- `Feet`, `Inch`, and `Yard` extend `QuantityLength`.
- Each class passes the correct `LengthUnit` to the base constructor.
- Core logic remains centralized in `QuantityLength`.

---

#### 🔄 Main Flow
1. Create objects using standalone unit classes.
2. Constructors delegate to the base constructor.
3. All operations (equality, conversion, addition) are handled by `QuantityLength`.
4. Cross-unit functionality works without logic duplication.

---

#### 📤 Postconditions
- Objects are created using specific unit classes.
- No duplication of business logic.
- Immutability is preserved.

---

## 🧠 Concepts Covered
- Inheritance  
- Polymorphism  
- Code reusability  
- Separation of concerns  
- DRY principle  

---

## 🧪 Example Usage
```java
QuantityLength f = new Feet(1.0);
QuantityLength i = new Inch(12.0);

System.out.println(f.equals(i)); // true
```
---

### ✅ UC9: Weight Measurement

#### 📖 Description
Extends the application to support **Weight Management** along with Length.

Length units:
- Feet
- Inch
- Yard

Weight units:
- Gram
- Kilogram
- Tonne

Length and Weight are handled as separate domains while maintaining consistent equality and addition logic.

---

#### 🔎 Preconditions
- Length and Weight are separate measurement categories.
- Each domain has its own base unit:
  - Length → Feet
  - Weight → Gram
- Weight conversions:
  - 1 Kilogram = 1000 Gram
  - 1 Tonne = 1,000,000 Gram
- Cross-domain operations are not allowed.

---

#### 🔄 Main Flow
1. Create measurement objects:
   - Length → `Feet`, `Inch`, `Yard`
   - Weight → `Gram`, `Kilogram`, `Tonne`
2. For equality:
   - Convert values to respective base unit.
3. For addition:
   - Normalize to base unit.
   - Add values.
   - Convert result back to caller’s unit.

---

#### 📤 Postconditions
- Length operations work only with Length.
- Weight operations work only with Weight.
- Length vs Weight comparison → `false`.
- Addition returns new immutable object.
- Adding `null` throws `IllegalArgumentException`.

---

## 🧠 Concepts Covered
- Domain separation (Length vs Weight)
- Abstraction using base class (`Quantity`)
- Type safety
- Base unit normalization
- Immutability
- Open-Closed Principle

---

## 🧪 Key Rules

### 🔁 Length
- `1 ft = 12 inch`
- `1 yard = 3 ft`

### ⚖️ Weight
- `1 kg = 1000 gram`
- `1 tonne = 1000 kg`

### 🚫 Type Safety
- Length ≠ Weight  
- Example: `1 ft` is not equal to `1 kg`

---

## 🧪 Sample Test Cases
- `testLengthEquality()`
- `testWeightEquality()`
- `testLengthAddition()`
- `testWeightAddition()`
- `testCrossDomainComparison_ShouldReturnFalse()`
- `testAddNull_ShouldThrowException()`

---
