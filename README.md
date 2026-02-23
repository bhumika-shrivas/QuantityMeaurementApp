# ✅ UC12: Subtraction & Division Support

## 📖 Description

UC12 extends the Generic Quantity architecture by introducing **Subtraction** and **Division** operations.

Until UC11, the system supported:

- Equality comparison
- Unit conversion
- Addition (implicit & explicit target unit)
- Multiple domains (Length, Weight, Volume)

UC12 upgrades the system into a **complete arithmetic measurement framework** by adding:

- Subtraction between quantities
- Explicit target unit subtraction
- Division producing a dimensionless ratio

This enhancement preserves immutability, type safety, and cross-category protection.

---

## 🎯 Objective

- Implement subtraction for same-category quantities.
- Support explicit target unit subtraction.
- Implement division returning a `double` ratio.
- Prevent cross-category arithmetic.
- Maintain immutability.
- Ensure backward compatibility with UC1–UC11.

---

## ➖ Subtraction

### 🔹 Implicit Target Unit

Result defaults to the unit of the first operand.

Example:

```
10 ft - 6 inch → 9.5 ft
```

### 🔹 Explicit Target Unit

Result is returned in specified unit.

```
10 ft - 6 inch (target = INCH) → 114 inch
```

### 🔹 Behavior Rules

- Order matters (non-commutative).
- Negative results are allowed.
- Zero results are valid.
- Rounding applied to 2 decimal places.
- Returns a new immutable `Quantity<U>`.

---

## ➗ Division

Division produces a **dimensionless ratio**.

Example:

```
10 ft ÷ 5 ft → 2.0
24 inch ÷ 2 ft → 1.0
```

### 🔹 Division Rules

- Units cancel out.
- Returns `double`.
- Non-commutative.
- Division by zero throws `ArithmeticException`.
- Cross-category division throws `IllegalArgumentException`.

---

## 🔒 Cross-Category Safety

Subtraction and division are allowed only within the same measurement category.

Invalid operations:

```
10 ft - 5 kg
10 L ÷ 2 ft
```

These throw `IllegalArgumentException`.

---

## 📤 Postconditions

- All arithmetic returns new immutable objects.
- No mutation of original quantities.
- Cross-category safety preserved.
- Division by zero prevented.
- Previous use cases remain fully functional.

---

## 🧪 Key Concepts Tested

### ➖ Subtraction Tests

- Same unit subtraction
- Cross-unit subtraction
- Explicit target subtraction
- Negative results
- Zero result
- Null operand handling
- Cross-category protection
- Immutability validation

---

### ➗ Division Tests

- Same unit division
- Cross-unit division
- Ratio > 1
- Ratio < 1
- Non-commutativity
- Division by zero
- Cross-category division
- Immutability validation

---

### 🔁 Integration Tests

- Addition and subtraction inverse property
- Arithmetic chaining
- Backward compatibility validation

---

## 🧠 Concepts Learned

- Non-commutative operation handling
- Dimensionless ratio design
- Defensive programming
- Fail-fast validation
- Rounding strategy
- Mathematical property validation
- Operation chaining
- Architectural scalability

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

---

## 🔥 Key Achievement

UC12 transforms the application from a comparison-based system into a **fully operational arithmetic measurement engine**.

The system now supports:

- Equality
- Conversion
- Addition
- Subtraction
- Division
- Explicit target units
- Multiple measurement domains
- Strong type safety

The architecture remains generic, scalable, and extensible.
