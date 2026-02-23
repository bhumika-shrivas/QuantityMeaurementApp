# ✅ UC9: Weight Measurement

## 📖 Description

The Quantity Measurement Application is extended to support **Weight Management** in addition to Length Management.

Until UC8, the system handled only length units such as:

- Feet
- Inch
- Yard

UC9 introduces support for weight units:

- Gram
- Kilogram
- Tonne

This enhancement ensures that different measurement domains (Length and Weight) are handled separately while maintaining consistency in equality and addition operations.

---

## 🔎 Preconditions

- Length and Weight are treated as separate measurement categories.
- Each measurement type has its own unit system.
- Supported Weight conversions:
  - `1 Kilogram = 1000 Gram`
  - `1 Tonne = 1,000,000 Gram`
- Length and Weight must not be mixed during comparison or addition.

---

## 🔄 Main Flow

1. User creates measurement objects:
   - Length → `Feet`, `Inch`, `Yard`
   - Weight → `Gram`, `Kilogram`, `Tonne`
2. For comparison:
   - Values are normalized to their respective base unit.
     - Length → Feet
     - Weight → Gram
3. For addition:
   - Both quantities are converted to base unit.
   - Values are added.
   - Result is converted back to the unit of the calling object.

---

## 📤 Postconditions

- Length operations work only with Length.
- Weight operations work only with Weight.
- Cross-domain comparison (Length vs Weight) returns `false`.
- Addition returns a new immutable object.
- Adding `null` throws `IllegalArgumentException`.

---

## 🧠 Concepts Learned (UC9)

- Domain Separation (Length vs Weight)
- Abstraction using Base Class (`Quantity`)
- Encapsulation of Conversion Logic
- Type Safety
- Immutability
- Open-Closed Principle
- Scalable Multi-Domain Architecture

---

## 🧪 Key Concepts Tested

### 🔁 Length Equality

| Comparison | Result |
|------------|--------|
| 1 ft vs 12 inch | ✅ Equal |
| 1 yard vs 3 ft | ✅ Equal |

---

### ⚖️ Weight Equality

| Comparison | Result |
|------------|--------|
| 1 kg vs 1000 gram | ✅ Equal |
| 1 tonne vs 1000 kg | ✅ Equal |

---

### ➕ Length Addition

| Operation | Result |
|------------|--------|
| 1 ft + 12 inch | 2 ft |
| 1 yard + 3 ft | 2 yard |

---

### ➕ Weight Addition

| Operation | Result |
|------------|--------|
| 1 kg + 1000 gram | 2 kg |
| 1 tonne + 1000 kg | 2 tonne |

---

### 🚫 Type Safety

- Length ≠ Weight  
- Example:
  - `1 ft` is **not equal** to `1 kg`

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
| UC8 | Standalone unit classes |
| UC9 | Weight management |

---

## 🔥 Key Achievement

UC9 transforms the system from a single-domain measurement application into a **multi-domain measurement framework**.

The architecture now:

- Supports multiple measurement categories
- Prevents invalid cross-domain operations
- Maintains clean abstraction
- Remains easily extensible for future measurement types
