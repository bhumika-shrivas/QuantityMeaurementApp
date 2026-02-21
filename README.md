# ✅ UC7: Target Unit Addition

## 📖 Description

The Quantity Measurement Application is enhanced to support **addition of length quantities with a specified target unit**.

This feature builds upon:

- UC3 – Generic Length Design  
- UC4 – Yard Support  
- UC5 – Unit Conversion  
- UC6 – Unit Addition  

UC7 allows users to add two `QuantityLength` objects and explicitly specify the unit in which the result should be returned.

### 📌 Example

```
1 ft + 12 inch → 24 inch
1 yard + 3 ft → 6 ft
3 ft + 1 yard → 2 yard
```

All calculations internally normalize values through a base unit (**Feet**) to ensure consistency and accuracy.

---

## 🔎 Preconditions

- Two valid `QuantityLength` objects must be created.
- A valid `LengthUnit` must be provided as the target unit.
- The second operand must not be `null`.
- Supported units:
  - Feet
  - Inch
  - Yard

---

## 🔄 Main Flow

1. User calls:

   ```java
   add(QuantityLength other, LengthUnit targetUnit)
   ```

2. Internally:
   - Both quantities are converted to the base unit (Feet).
   - Values are added.
   - The sum is converted to the specified target unit.

3. A new immutable `QuantityLength` object is returned.

---

## 📤 Postconditions

- Returns a new `QuantityLength` object in the specified target unit.
- Original objects remain unchanged (immutability preserved).
- Throws `IllegalArgumentException` if attempting to add `null`.

---

## 🧠 Concepts Learned (UC7)

- Target-based arithmetic operations  
- Flexible API design  
- Base unit normalization  
- Open-Closed Principle  
- Immutability  
- Clean and scalable architecture  

---

## 🧪 Key Concepts Tested

### ➕ Target Unit Addition

| Operation | Target Unit | Result |
|------------|------------|--------|
| 1 ft + 12 inch | Inch | 24 inch |
| 1 yard + 3 ft | Feet | 6 ft |
| 3 ft + 1 yard | Yard | 2 yard |

---

### ⚠ Exception Handling

- Adding `null` throws `IllegalArgumentException`

---

## 🧪 Sample Test Cases

- `testAdditionWithTargetUnit_Inch()`
- `testAdditionWithTargetUnit_Feet()`
- `testAdditionWithTargetUnit_Yard()`
- `testAddNull_ShouldThrowException()`
- `testCrossUnitEquality()`

---

## 📁 Project Structure

```
src/main/java/com/QuantityMeasurementApp/
    LengthUnit.java
    QuantityLength.java

src/test/java/com/QuantityMeasurementApp/
    QuantityLengthTest.java
```

---

## 🚀 Architectural Evolution

| Use Case | Capability Added |
|-----------|------------------|
| UC1 | Feet equality |
| UC2 | Feet + Inch equality |
| UC3 | Generic Length design |
| UC4 | Yard support |
| UC5 | Unit conversion |
| UC6 | Unit addition |
| UC7 | Target unit addition |

---

## 🔥 Key Achievement

UC7 provides full flexibility for arithmetic operations across units by allowing users to control the output unit.

The system now supports:

- Equality comparison  
- Unit conversion  
- Cross-unit addition  
- Target-based addition  

The architecture remains scalable and easily extendable for future units.
