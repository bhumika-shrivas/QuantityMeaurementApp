# ✅ UC14: Temperature Measurement

## 📖 Description

UC14 extends the Generic Quantity framework by introducing **Temperature Measurement** support.

Unlike previous measurement categories (Length, Weight, Volume), temperature conversion is **non-linear** and involves both scaling and offset adjustments.

This use case demonstrates that the architecture supports not only multiplicative conversions but also **formula-based conversions**, without modifying the core `Quantity` class.

---

## 🎯 Objective

- Introduce `TemperatureUnit` enum.
- Support temperature units:
  - Celsius
  - Fahrenheit
  - Kelvin
- Enable:
  - Equality comparison
  - Conversion between units
  - Addition and subtraction
- Preserve centralized arithmetic logic from UC13.
- Maintain cross-category safety.
- Ensure backward compatibility (UC1–UC13 remain unchanged).

---

## 🌡 Temperature Units

| Unit | Conversion to Base (Celsius) |
|------|-------------------------------|
| Celsius | C |
| Fahrenheit | (F − 32) × 5/9 |
| Kelvin | K − 273.15 |

Base unit: **Celsius**

---

## 🔄 Conversion Formulas

### 🔹 Celsius ↔ Fahrenheit

```
°F = (°C × 9/5) + 32
°C = (°F − 32) × 5/9
```

### 🔹 Celsius ↔ Kelvin

```
K = °C + 273.15
°C = K − 273.15
```

---

## 🏗 Architectural Design

Temperature is implemented as:

```
enum TemperatureUnit implements IMeasurable
```

Each constant overrides:

```
toBase(double value)
fromBase(double baseValue)
```

Unlike Length/Weight/Volume, temperature does **not** rely on a simple multiplication factor.

No modification was required in:

- `Quantity` class
- Centralized arithmetic logic
- Existing measurement domains

This confirms the flexibility of the generic architecture.

---

## 🔄 Functional Behavior

### 🔹 Equality

```
0°C == 32°F
0°C == 273.15K
32°F == 273.15K
```

All comparisons normalize to Celsius before evaluation.

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

Arithmetic works through centralized logic.

Example:

```
10°C + 5°C → 15°C
```

```
10°C − 5°C → 5°C
```

⚠ Note: Although mathematically valid in this framework, temperature arithmetic may not always represent physical temperature behavior in real-world thermodynamics.

---

## 🔒 Cross-Category Safety

Temperature cannot be compared or combined with:

- Length
- Weight
- Volume

Invalid example:

```
0°C == 1 ft → false
```

Cross-category arithmetic throws `IllegalArgumentException`.

---

## 📤 Postconditions

- Temperature integrates without modifying core framework.
- Non-linear unit conversion is fully supported.
- All previous use cases remain functional.
- Arithmetic logic remains centralized (UC13).
- Immutability preserved.

---

## 🧪 Key Concepts Tested

### 🌡 Equality Tests

- Celsius ↔ Fahrenheit equality
- Celsius ↔ Kelvin equality
- Fahrenheit ↔ Kelvin equality
- Cross-category comparison prevention

---

### 🔄 Conversion Tests

- Celsius to Fahrenheit
- Fahrenheit to Celsius
- Celsius to Kelvin
- Kelvin to Celsius
- Round-trip conversion validation

---

### ➕ Arithmetic Tests

- Addition in same unit
- Subtraction in same unit
- Centralized arithmetic validation

---

## 🧠 Concepts Learned

- Non-linear unit conversion
- Offset-based transformation
- Enum constant-specific behavior
- Polymorphism through method overriding
- Architectural scalability validation
- Open–Closed Principle compliance

---

## 🚀 Architectural Evolution

| Use Case | Capability Added |
|----------|------------------|
| UC1 | Feet equality |
| UC2 | Inch equality |
| UC3 | Generic Length |
| UC4 | Yard support |
| UC5 | Unit conversion |
| UC6 | Unit addition |
| UC7 | Explicit target addition |
| UC8 | Standalone units |
| UC9 | Weight management |
| UC10 | Generic quantity architecture |
| UC11 | Volume measurement |
| UC12 | Subtraction & Division |
| UC13 | Centralized arithmetic logic |
| UC14 | Temperature measurement |

---

## 🔥 Key Achievement

UC14 proves that the system supports both:

- Linear unit transformations (multiplicative)
- Non-linear unit transformations (formula-based)

Without changing the core arithmetic engine.

This confirms the framework’s robustness, scalability, and extensibility across fundamentally different measurement domains.
