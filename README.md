# ✅ UC5: Unit Conversion Support

## 📖 Description

The Quantity Measurement Application is enhanced to support **explicit unit conversion** between supported length units.

Building on the generic architecture introduced in **UC3** and extended in **UC4**, UC5 allows a `QuantityLength` object to be converted from one unit to another.

Supported units:

- Feet
- Inch
- Yard

All conversions are internally normalized through a base unit (**Feet**) to ensure accuracy and consistency.

---

## 🔎 Preconditions

- A `QuantityLength` object must be created with:
  - A numeric value
  - A valid `LengthUnit`
- Conversion is performed using the `convertTo()` method.
- Supported conversion factors:
  - `1 Foot = 12 Inch`
  - `1 Yard = 3 Feet`
  - `1 Yard = 36 Inch`

---

## 🔄 Main Flow

1. User creates a `QuantityLength` object.
2. Calls `convertTo(targetUnit)` method.
3. Internally:
   - Value is converted to base unit (Feet).
   - Then converted from Feet to target unit.
4. A new `QuantityLength` object is returned with:
   - Converted value
   - Target unit

---

## 📤 Postconditions

- Returns a new `QuantityLength` object in the requested unit.
- Original object remains unchanged (immutability preserved).
- Equality logic remains unaffected and continues to work across units.

---

## 🧠 Concepts Learned (UC5)

- ✅ Unit Conversion Logic
- ✅ Bi-directional Conversion
- ✅ Immutability (returns new object)
- ✅ Base Unit Normalization
- ✅ Open-Closed Principle
- ✅ Clean and Extensible Design

---

## 🧪 Key Concepts Tested

### 🔄 Unit Conversion

| Conversion | Result |
|------------|--------|
| 1 ft → inch | 12 inch |
| 12 inch → ft | 1 ft |
| 1 yard → ft | 3 ft |
| 1 yard → inch | 36 inch |

---

### 🔁 Equality After Conversion

- `1 ft == 12 inch`
- `1 yard == 3 ft`
- `1 yard == 36 inch`

---

## 🧪 Sample Test Cases

- `testFeetToInchConversion()`
- `testInchToFeetConversion()`
- `testYardToFeetConversion()`
- `testYardToInchConversion()`
- `testCrossUnitEquality()`
- `testNullComparison()`

---
