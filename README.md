# ✅ UC6: Unit Addition Feature

## 📖 Description

The Quantity Measurement Application is enhanced to support **addition of length quantities**, even when the units are different.

Building upon:

- UC3 (Generic Length Design)
- UC4 (Yard Support)
- UC5 (Unit Conversion)

UC6 introduces the ability to add two `QuantityLength` objects and return the result in a consistent and predictable unit.

Example:

1 ft + 12 inch = 2 ft
1 yard + 3 ft = 2 yard


All operations are internally normalized through a base unit (**Feet**) to ensure correctness.

---

## 🔎 Preconditions

- Two `QuantityLength` objects must be created.
- Both objects must have valid `LengthUnit`.
- The second operand must not be `null`.
- Units supported:
  - Feet
  - Inch
  - Yard

---

## 🔄 Main Flow

1. User calls the `add()` method on a `QuantityLength` object.
2. Internally:
   - Both values are converted to the base unit (Feet).
   - The values are added.
   - The result is converted back to the unit of the calling object.
3. A new immutable `QuantityLength` object is returned.

---

## 📤 Postconditions

- Returns a new `QuantityLength` containing the sum.
- The original objects remain unchanged (immutability preserved).
- Throws `IllegalArgumentException` if attempting to add `null`.

---

## 🧠 Concepts Learned (UC6)

- ✅ Cross-unit arithmetic operations
- ✅ Base unit normalization for safe computation
- ✅ Immutability (returns new object instead of modifying existing one)
- ✅ Exception handling
- ✅ Clean and extensible architecture
- ✅ Reuse of conversion logic (DRY Principle)

---

## 🧪 Key Concepts Tested

### ➕ Same Unit Addition

| Operation | Result |
|------------|--------|
| 1 ft + 1 ft | 2 ft |
| 1 yard + 1 yard | 2 yard |

---

### 🔄 Cross-Unit Addition

| Operation | Result |
|------------|--------|
| 1 ft + 12 inch | 2 ft |
| 1 yard + 3 ft | 2 yard |
| 1 yard + 36 inch | 2 yard |

---

### ⚠ Exception Handling

- Adding `null` throws `IllegalArgumentException`

---

## 🧪 Sample Test Cases

- `testFeetPlusFeet()`
- `testFeetPlusInch()`
- `testYardPlusFeet()`
- `testYardPlusInch()`
- `testAddNull_ShouldThrowException()`
- `testCrossUnitEquality()`

---
