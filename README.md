# ✅ UC13: Centralized Arithmetic Logic

## 📖 Description

UC13 focuses on architectural improvement by centralizing arithmetic logic inside the `Quantity` class.

Until UC12, arithmetic operations such as:

- Addition
- Subtraction
- Explicit target unit arithmetic

contained repeated base conversion logic.

UC13 refactors the system to eliminate duplication by introducing a single centralized method responsible for handling arithmetic operations.

No new functionality is added in this use case.  
All previous use cases (UC1–UC12) must continue to work unchanged.

---

## 🎯 Objective

- Remove duplicated arithmetic logic.
- Centralize conversion and computation in a single method.
- Improve maintainability and readability.
- Preserve backward compatibility.
- Follow DRY (Don’t Repeat Yourself) principle.

---

## 🏗 Architectural Improvement

### 🔹 Before UC13

Arithmetic methods like:

```
add()
subtract()
add(targetUnit)
subtract(targetUnit)
```

Each performed:

- Conversion to base unit
- Operation in base unit
- Conversion back to target unit
- Rounding logic

This resulted in repeated logic.

---

### 🔹 After UC13

A single private method handles all arithmetic:

```
private Quantity<U> performOperation(
    Quantity<U> other,
    U targetUnit,
    BinaryOperator<Double> operator
)
```

Public methods delegate to it:

```
add() → performOperation(..., Double::sum)
subtract() → performOperation(..., (a, b) -> a - b)
```

This centralizes:

- Base conversion
- Operation execution
- Target conversion
- Rounding
- Validation

---

## 🔄 Functional Behavior

### ➕ Addition

```
10 ft + 5 ft → 15 ft
```

Delegates to centralized method using `Double::sum`.

---

### ➖ Subtraction

```
10 ft - 6 inch → 9.5 ft
```

Delegates to centralized method using `(a, b) -> a - b`.

---

### ➗ Division

Division remains separate because it returns a `double` ratio and does not produce a `Quantity<U>`.

```
10 ft ÷ 5 ft → 2.0
```

---

## 📤 Postconditions

- No change in behavior from UC12.
- All previous tests pass without modification.
- Code duplication removed.
- Arithmetic logic maintained in a single location.
- Immutability preserved.
- Cross-category safety preserved.

---

## 🧪 Testing Strategy

UC13 does not introduce new functionality.

Therefore:

- All UC1–UC12 test cases must pass unchanged.
- No new test cases required.
- Successful test execution validates correct refactoring.

---

## 🧠 Concepts Learned

- Refactoring without changing behavior
- DRY principle implementation
- Functional interfaces (`BinaryOperator`)
- Centralized logic design
- Maintainability improvement
- Clean architecture refinement

---

## 🚀 Architectural Evolution

| Use Case | Capability |
|----------|------------|
| UC1 | Feet equality |
| UC2 | Inch support |
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

---

## 🔥 Key Achievement

UC13 demonstrates architectural maturity.

The system now:

- Avoids duplicated logic
- Is easier to maintain
- Is safer to extend
- Preserves all existing functionality
- Follows clean code principles

This marks the transition from feature-based development to architecture-level refinement.
