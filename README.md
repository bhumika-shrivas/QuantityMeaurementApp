# ✅ UC11: Volume Measurement

## 📖 Description

UC11 extends the Generic Quantity architecture by introducing **Volume Measurement** support into the Quantity Measurement Application.

Building on UC10’s generic `Quantity<U>` design, this use case adds a new measurement category without modifying the core arithmetic logic.

The system now supports three independent measurement domains:

- 📏 Length (Feet, Inch, Yard)
- ⚖️ Weight (Gram, Kilogram, Tonne)
- 🧪 Volume (Milliliter, Liter, Kiloliter, Gallon)

This use case demonstrates that the architecture adheres to the **Open–Closed Principle** — new measurement categories can be added without restructuring the system.

---

## 🎯 Objective

- Introduce Volume measurement category.
- Implement `VolumeUnit` enum implementing `IMeasurable`.
- Support:
  - Equality comparison
  - Unit conversion
  - Addition
  - Explicit target unit addition
- Preserve immutability and type safety.
- Ensure backward compatibility with UC1–UC10.

---

## 🏗 Architectural Integration

### 🔹 Base Unit

Volume base unit: **Milliliter**

All conversions are internally normalized to milliliters.

### 🔹 Supported Units

| Unit | Conversion to Base (mL) |
|------|--------------------------|
| MILLILITER | 1.0 |
| LITER | 1000.0 |
| KILOLITER | 1,000,000.0 |
| GALLON | 3785.411784 |

### 🔹 Generic Design

The existing generic class:

```
Quantity<U extends IMeasurable>
```

Requires **no modification** to support volume.

Volume works automatically because:

- `VolumeUnit` implements `IMeasurable`
- The system relies on polymorphism
- Conversion is delegated to the unit enum

---

## 🔄 Main Flow

### 1️⃣ Equality

- Both quantities are converted to base unit (mL)
- Base values are compared
- Cross-category comparisons return `false`

Example:

```
1.0 L = 1000.0 mL
1.0 Gallon ≈ 3.78541 L
```

---

### 2️⃣ Conversion

```
new Quantity<>(1.0, LITER).convertTo(MILLILITER)
→ Quantity(1000.0, MILLILITER)
```

Supports:

- Litre ↔ Millilitre
- Litre ↔ Gallon
- Millilitre ↔ Gallon
- Round-trip conversion

---

### 3️⃣ Addition (Implicit Target Unit)

```
1.0 L + 1000.0 mL → 2.0 L
```

Result unit defaults to the first operand’s unit.

---

### 4️⃣ Addition (Explicit Target Unit)

```
1.0 L + 1000.0 mL (target = MILLILITER)
→ 2000.0 mL
```

Explicit unit overrides implicit default.

---

## 📤 Postconditions

- Volume operations return new immutable objects.
- Cross-category arithmetic is prevented.
- Zero and negative values are supported.
- Floating-point precision is handled using epsilon comparison.
- Previous functionality (Length & Weight) remains unaffected.

---

## 🧪 Key Concepts Tested

### 🔁 Equality Tests

- Same unit equality
- Cross-unit equality
- Gallon conversion equality
- Transitive property
- Reflexive property
- Zero handling
- Negative handling
- Large value handling
- Small precision handling
- Cross-category prevention
- Null comparison

---

### 🔄 Conversion Tests

- Litre → Millilitre
- Millilitre → Litre
- Gallon → Litre
- Litre → Gallon
- Round-trip conversions
- Zero value conversion
- Negative value conversion
- Same-unit conversion

---

### ➕ Addition Tests

- Same unit addition
- Cross-unit addition
- Explicit target unit addition
- Commutativity
- Identity element (add zero)
- Negative values
- Large magnitude values
- Small magnitude precision

---

### 🧾 Enum Validation

- `getConversionFactor()` validation
- `convertToBaseUnit()` correctness
- `convertFromBaseUnit()` correctness

---

### 🔒 Cross-Domain Safety

- Volume ≠ Length
- Volume ≠ Weight
- Cross-category operations prevented

---

## 🧠 Concepts Learned

- Open–Closed Principle
- Interface-based polymorphism
- Generic architecture scalability
- Immutability preservation
- Cross-domain type safety
- Floating-point precision management
- Explicit vs implicit target unit design pattern

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
| UC10 | Generic quantity architecture |
| UC11 | Volume measurement support |

---

## 🔥 Key Achievement

UC11 proves the robustness of the generic design introduced in UC10.

Without modifying the `Quantity` class:

- A new measurement category was added.
- All arithmetic and comparison operations function automatically.
- The architecture scales linearly.
- Backward compatibility is fully preserved.

The system now behaves as a complete multi-domain measurement framework supporting Length, Weight, and Volume operations in a unified design.

---
