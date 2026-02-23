# ✅ UC10: Generic Quantity Architecture

## 📖 Description

UC10 introduces a major architectural refactoring by implementing a **Generic Quantity Design**.

Until UC9, the system managed Length and Weight using separate classes:

- `QuantityLength`
- `QuantityWeight`

In UC10, the system is redesigned to use:

- A single reusable `Quantity` class
- A common `Unit` interface
- `LengthUnit` and `WeightUnit` implementing `Unit`

This eliminates duplication and creates a scalable, domain-independent measurement framework.

---

## 🎯 Objective

- Remove duplicated logic between Length and Weight.
- Introduce a unified quantity model.
- Preserve domain separation (Length ≠ Weight).
- Maintain immutability and clean design.
- Improve extensibility for future measurement types.

---

## 🏗 Architectural Refactoring

### Before UC10
- Separate classes for Length and Weight.
- Repeated equality and addition logic.
- Code duplication across domains.

### After UC10
- Single `Quantity` class.
- Common `Unit` abstraction.
- Centralized equality, conversion, and addition logic.
- Domain safety enforced through unit type checking.

---

## 🔎 Core Design

### 🔹 Unit Interface

Each measurement unit must implement:

- `toBase(double value)` → Converts to base unit.
- `fromBase(double baseValue)` → Converts from base unit.

### 🔹 Quantity Class

Handles:

- Equality comparison
- Unit conversion
- Addition
- Type safety enforcement

---

## 🔄 Main Flow

1. Create a Quantity:

   ```java
   new Quantity(1.0, LengthUnit.FEET);
   new Quantity(1.0, WeightUnit.KILOGRAM);
   ```

2. Equality:
   - Values normalized using `toBase()`
   - Only same domain types are compared

3. Addition:
   - Converted to base unit
   - Added
   - Returned in calling unit

4. Conversion:
   - Convert to base
   - Convert to target unit

---

## 📤 Postconditions

- Equality works within same domain.
- Length ≠ Weight.
- Adding different domains throws `IllegalArgumentException`.
- All operations return new immutable objects.
- Logic is fully centralized.

---

## 🧪 Key Concepts Tested (35 Test Cases)

### 🔁 Equality Contract
- Reflexive
- Symmetric
- Transitive
- Consistent
- Null handling
- HashCode consistency

### 📏 Length Validation
- Feet ↔ Inch ↔ Yard equality
- Length addition
- Length conversion
- Zero & negative cases

### ⚖️ Weight Validation
- Gram ↔ Kilogram ↔ Tonne equality
- Weight addition
- Weight conversion
- Zero & negative cases

### 🚫 Type Safety
- Length ≠ Weight
- Cross-domain addition throws exception

---

## 🧠 Concepts Learned

- Interface-based design
- Elimination of duplication (DRY)
- Domain separation
- Polymorphism through abstraction
- Generic architecture
- Open-Closed Principle
- Clean system scalability

---

## 🚀 Architectural Evolution

| Use Case | Capability Added |
|----------|------------------|
| UC1 | Feet equality |
| UC2 | Feet + Inch equality |
| UC3 | Generic Length design |
| UC4 | Yard support |
| UC5 | Unit conversion |
| UC6 | Unit addition |
| UC7 | Target unit addition |
| UC8 | Standalone unit classes |
| UC9 | Weight management |
| UC10 | Fully generic quantity architecture |

---

## 🔥 Key Achievement

UC10 transforms the application from a unit-specific measurement system into a **generic, reusable measurement framework** capable of supporting multiple domains with minimal duplication.

The system is now:

- Fully extensible
- Architecturally robust
- Domain-safe
- Maintainable
- Ready for future measurement types (Temperature, Volume, etc.)

---
