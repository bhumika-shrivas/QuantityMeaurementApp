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

🔗 [UC1 - FeetEquality](https://github.com/bhumika-shrivas/QuantityMeaurementApp/tree/feature/UC1-FeetEquality)

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

🔗 [UC2 - InchEquality](https://github.com/bhumika-shrivas/QuantityMeaurementApp/tree/feature/UC2-InchEquality)

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

🔗 [UC3 - GenericLength](https://github.com/bhumika-shrivas/QuantityMeaurementApp/tree/feature/UC3-GenericLength)

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

🔗 [UC4 - YardEquality](https://github.com/bhumika-shrivas/QuantityMeaurementApp/tree/feature/UC4-YardEquality)

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

🔗 [UC5 - UnitConversion](https://github.com/bhumika-shrivas/QuantityMeaurementApp/tree/feature/UC5-UnitConversion)

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

### ✅ UC10: Generic Quantity Architecture

#### 📖 Description
UC10 introduces a **generic quantity design** that unifies Length and Weight handling.

Previously:
- `QuantityLength`
- `QuantityWeight`

Now replaced with:
- A single `Quantity` class  
- A common `Unit` interface  
- `LengthUnit` and `WeightUnit` implementing `Unit`  

This removes duplication and creates a reusable, domain-independent framework while preserving domain separation.

---

#### 🎯 Objective
- Eliminate duplicate logic  
- Unify quantity handling  
- Preserve domain safety (Length ≠ Weight)  
- Maintain immutability  
- Improve extensibility  

---

#### 🔎 Core Design

**Unit Interface**
- `toBase(double value)`
- `fromBase(double baseValue)`

**Quantity Class**
- Handles equality  
- Handles conversion  
- Handles addition  
- Enforces domain/type safety  
- Returns immutable objects  

---

#### 🔄 Main Flow
1. Create:
   ```java
   new Quantity(1.0, LengthUnit.FEET);
   new Quantity(1.0, WeightUnit.KILOGRAM);
   ```
2. Equality:
   - Normalize using `toBase()`
   - Compare only same domains  
3. Addition:
   - Convert to base  
   - Add values  
   - Return in calling unit  
4. Conversion:
   - Base → Target unit  

---

#### 📤 Postconditions
- Equality works within same domain  
- Length ≠ Weight  
- Cross-domain addition throws `IllegalArgumentException`  
- All operations return new immutable objects  
- Logic is centralized  

---

## 🧠 Concepts Covered
- Interface-based design  
- DRY principle  
- Domain separation  
- Polymorphism  
- Open-Closed Principle  
- Scalable architecture  

---

## 🧪 Key Validations

### 🔁 Equality Contract
- Reflexive  
- Symmetric  
- Transitive  
- Consistent  
- Null handling  
- HashCode consistency  

### 📏 Length
- Feet ↔ Inch ↔ Yard equality  
- Length addition & conversion  
- Zero and negative cases  

### ⚖️ Weight
- Gram ↔ Kilogram ↔ Tonne equality  
- Weight addition & conversion  
- Zero and negative cases  

### 🚫 Type Safety
- Length ≠ Weight  
- Cross-domain addition throws exception

---

### ✅ UC11: Volume Measurement

#### 📖 Description
UC11 extends the Generic Quantity architecture by adding **Volume Measurement** support.

The system now supports three domains:

- 📏 Length (Feet, Inch, Yard)  
- ⚖️ Weight (Gram, Kilogram, Tonne)  
- 🧪 Volume (Milliliter, Liter, Kiloliter, Gallon)  

Volume integrates seamlessly using the existing generic `Quantity<U extends IMeasurable>` design.

---

#### 🎯 Objective
- Introduce Volume measurement category  
- Implement `VolumeUnit` implementing `IMeasurable`  
- Support equality, conversion, and addition  
- Preserve immutability and type safety  
- Maintain compatibility with previous use cases  

---

#### 🔎 Core Design

**Base Unit:** Milliliter (mL)  
All values normalize internally to milliliters.

| Unit | Conversion to mL |
|------|------------------|
| MILLILITER | 1.0 |
| LITER | 1000.0 |
| KILOLITER | 1,000,000.0 |
| GALLON | 3785.411784 |

No changes were required in the `Quantity` class.

---

#### 🔄 Main Flow

**1️⃣ Equality**
- Convert both values to mL  
- Compare normalized values  
- Cross-domain comparison returns `false`  

Example:
```
1.0 L = 1000.0 mL
1.0 Gallon ≈ 3.78541 L
```

---

**2️⃣ Conversion**
```
new Quantity<>(1.0, LITER).convertTo(MILLILITER)
→ Quantity(1000.0, MILLILITER)
```

Supports Liter ↔ Milliliter ↔ Gallon conversions.

---

**3️⃣ Addition (Implicit Unit)**
```
1.0 L + 1000.0 mL → 2.0 L
```
Result defaults to the first operand’s unit.

---

**4️⃣ Addition (Explicit Target Unit)**
```
1.0 L + 1000.0 mL (target = MILLILITER)
→ 2000.0 mL
```

---

#### 📤 Postconditions
- Returns new immutable objects  
- Cross-domain arithmetic prevented  
- Zero and negative values supported  
- Floating-point precision handled using epsilon  
- Existing Length and Weight functionality remains unchanged  

---

## 🧠 Concepts Covered
- Open–Closed Principle  
- Generic architecture scalability  
- Interface-based polymorphism  
- Domain separation and type safety  
- Immutability  

---

## 🧪 Key Validations

### 🔁 Equality
- Same-unit and cross-unit equality  
- Gallon conversion  
- Zero, negative, and precision cases  
- Cross-domain prevention  

### 🔄 Conversion
- Liter ↔ Milliliter  
- Liter ↔ Gallon  
- Round-trip conversion  

### ➕ Addition
- Same-unit addition  
- Cross-unit addition  
- Explicit target unit addition  
- Identity (add zero)  

### 🔒 Cross-Domain Safety
- Volume ≠ Length  
- Volume ≠ Weight  
- Cross-category operations prevented  

---

### ✅ UC12: Subtraction & Division Support

#### 📖 Description
UC12 extends the Generic Quantity architecture by adding **Subtraction** and **Division** operations.

Until UC11, the system supported:
- Equality
- Conversion
- Addition (implicit & explicit target)
- Multiple domains (Length, Weight, Volume)

UC12 enhances the framework with:
- Subtraction between quantities
- Explicit target unit subtraction
- Division producing a dimensionless ratio

Immutability and cross-category safety are preserved.

---

#### 🎯 Objective
- Implement subtraction for same-category quantities  
- Support explicit target subtraction  
- Implement division returning `double` ratio  
- Prevent cross-category arithmetic  
- Maintain immutability and backward compatibility  

---

## ➖ Subtraction

### 🔹 Implicit Target Unit
Result defaults to the first operand’s unit.

```
10 ft - 6 inch → 9.5 ft
```

### 🔹 Explicit Target Unit
```
10 ft - 6 inch (target = INCH) → 114 inch
```

### 🔹 Rules
- Non-commutative  
- Negative results allowed  
- Zero results valid  
- Rounded to 2 decimal places  
- Returns new immutable `Quantity<U>`  

---

## ➗ Division

Produces a **dimensionless ratio**.

```
10 ft ÷ 5 ft → 2.0
24 inch ÷ 2 ft → 1.0
```

### 🔹 Rules
- Units cancel out  
- Returns `double`  
- Non-commutative  
- Division by zero → `ArithmeticException`  
- Cross-category division → `IllegalArgumentException`  

---

## 🔒 Cross-Category Safety
Invalid operations:
```
10 ft - 5 kg
10 L ÷ 2 ft
```
These throw `IllegalArgumentException`.

---

#### 📤 Postconditions
- All operations return new immutable objects  
- Original quantities remain unchanged  
- Cross-category protection enforced  
- Division by zero prevented  
- Previous use cases remain functional  

---

## 🧠 Concepts Covered
- Non-commutative operations  
- Dimensionless ratio design  
- Defensive programming  
- Fail-fast validation  
- Rounding strategy  
- Arithmetic chaining  
- Scalable architecture  

---

## 🧪 Key Validations

### ➖ Subtraction
- Same & cross-unit subtraction  
- Explicit target subtraction  
- Negative & zero results  
- Null handling  
- Cross-category protection  

### ➗ Division
- Same & cross-unit division  
- Ratio > 1 and < 1  
- Non-commutativity  
- Division by zero  
- Cross-category validation  

### 🔁 Integration
- Addition–subtraction inverse property  
- Arithmetic chaining  
- Backward compatibility

---

### ✅ UC13: Centralized Arithmetic Logic

#### 📖 Description
UC13 refactors the system by centralizing arithmetic logic inside the `Quantity` class.

Until UC12, methods like:
- `add()`
- `subtract()`
- `add(targetUnit)`
- `subtract(targetUnit)`

contained repeated base conversion and rounding logic.

UC13 removes duplication by introducing a single internal method that handles all arithmetic operations.

No new functionality is added. All UC1–UC12 behavior remains unchanged.

---

#### 🎯 Objective
- Eliminate duplicated arithmetic logic  
- Centralize conversion and computation  
- Improve maintainability and readability  
- Preserve backward compatibility  
- Apply DRY principle  

---

#### 🏗 Architectural Improvement

**Before UC13**
Each arithmetic method performed:
- Convert to base unit  
- Apply operation  
- Convert to target unit  
- Apply rounding  
- Validate inputs  

This caused repetition.

**After UC13**

A single private method manages arithmetic:

```
private Quantity<U> performOperation(
    Quantity<U> other,
    U targetUnit,
    BinaryOperator<Double> operator
)
```

Public methods delegate:

```
add()        → performOperation(..., Double::sum)
subtract()   → performOperation(..., (a, b) -> a - b)
```

This centralizes:
- Base conversion  
- Operation execution  
- Target conversion  
- Rounding  
- Validation  

---

#### 🔄 Functional Behavior

**➕ Addition**
```
10 ft + 5 ft → 15 ft
```

**➖ Subtraction**
```
10 ft - 6 inch → 9.5 ft
```

Both delegate to the centralized method.

**➗ Division**
Remains separate because it returns a `double`.

```
10 ft ÷ 5 ft → 2.0
```

---

#### 📤 Postconditions
- No behavioral changes from UC12  
- All previous tests pass unchanged  
- Code duplication removed  
- Arithmetic logic centralized  
- Immutability preserved  
- Cross-category safety preserved  

---

## 🧠 Concepts Covered
- Refactoring without behavior change  
- DRY principle  
- Functional interfaces (`BinaryOperator`)  
- Centralized logic design  
- Maintainability improvement  
- Clean architecture refinement  

---

### ✅ UC14: Temperature Measurement

#### 📖 Description
UC14 extends the Generic Quantity framework by introducing **Temperature Measurement**.

Unlike Length, Weight, and Volume, temperature conversion is **non-linear** (requires scaling + offset).  
This use case proves the architecture supports **formula-based conversions** without modifying the core `Quantity` class.

---

#### 🎯 Objective
- Introduce `TemperatureUnit` enum  
- Support Celsius, Fahrenheit, Kelvin  
- Enable equality, conversion, addition, subtraction  
- Preserve centralized arithmetic logic (UC13)  
- Maintain cross-category safety  
- Ensure backward compatibility  

---

## 🌡 Temperature Units

**Base Unit:** Celsius

| Unit | Conversion to Base (°C) |
|------|--------------------------|
| Celsius | C |
| Fahrenheit | (F − 32) × 5/9 |
| Kelvin | K − 273.15 |

---

## 🔄 Conversion Formulas

**Celsius ↔ Fahrenheit**
```
°F = (°C × 9/5) + 32
°C = (°F − 32) × 5/9
```

**Celsius ↔ Kelvin**
```
K = °C + 273.15
°C = K − 273.15
```

---

## 🏗 Architectural Design

Implemented as:
```
enum TemperatureUnit implements IMeasurable
```

Each unit overrides:
```
toBase(double value)
fromBase(double baseValue)
```

Temperature does not rely on a simple multiplication factor.  
No modification was required in:
- `Quantity` class  
- Centralized arithmetic logic  
- Other measurement domains  

---

## 🔄 Functional Behavior

### 🔹 Equality
```
0°C == 32°F
0°C == 273.15K
32°F == 273.15K
```
All comparisons normalize to Celsius.

---

### 🔹 Conversion
```
new Quantity<>(0, CELSIUS).convertTo(FAHRENHEIT)
→ 32°F
```

```
new Quantity<>(273.15, KELVIN).convertTo(CELSIUS)
→ 0°C
```

---

### 🔹 Addition & Subtraction
Handled via centralized arithmetic logic.

```
10°C + 5°C → 15°C
10°C − 5°C → 5°C
```

> Note: Arithmetic is mathematically supported but may not reflect real-world thermodynamic behavior.

---

## 🔒 Cross-Category Safety
Temperature cannot be combined with:
- Length  
- Weight  
- Volume  

Example:
```
0°C == 1 ft → false
```

Cross-category arithmetic throws `IllegalArgumentException`.

---

## 📤 Postconditions
- Temperature integrates without modifying core framework  
- Non-linear conversion fully supported  
- Previous use cases remain functional  
- Arithmetic logic remains centralized  
- Immutability preserved  

---

## 🧪 Key Validations

### 🌡 Equality
- Celsius ↔ Fahrenheit  
- Celsius ↔ Kelvin  
- Fahrenheit ↔ Kelvin  
- Cross-category prevention  

### 🔄 Conversion
- C ↔ F  
- C ↔ K  
- Round-trip validation  

### ➕ Arithmetic
- Same-unit addition  
- Same-unit subtraction  
- Centralized arithmetic validation  

---

## 🧠 Concepts Covered
- Non-linear unit conversion  
- Offset-based transformation  
- Enum constant-specific behavior  
- Polymorphism via method overriding  
- Open–Closed Principle  
- Architectural scalability

---
