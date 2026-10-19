# Sprint1_Annotations

## 📌 Project Scope
Due to time constraints, this project focuses on completing **Level 1** and **Level 2** solidly. I made the conscious decision to omit Level 3 (Reflection) to prioritize code quality, documentation, and test coverage for the previous levels.

From Level 1 onwards, the sprint's cumulative rule was applied: **every task includes unit tests using JUnit 5**.

---

## 📂 Project Structure
```text

Sprint1_Annotations/
├── src/
│   ├── main/java/
│   │   ├── Level1_BasicAnnotations/Override/
│   │   │   ├── Worker.java
│   │   │   ├── OnSiteWorker.java
│   │   │   ├── OnlineWorker.java
│   │   │   ├── DeprecatedCaller.java
│   │   │   └── Main.java
│   │   └── Level2_CustomAnnotations/
│   │       ├── JsonSerializable.java
│   │       └── Person.java
│   └── test/java/
│       ├── Level1_BasicAnnotations/Override/
│       │   ├── WorkerTest.java
│       │   ├── OnSiteWorkerTest.java
│       │   ├── OnlineWorkerTest.java
│       │   └── DeprecatedCallerTest.java
│       └── Level2_CustomAnnotations/
│           └── PersonTest.java
└── pom.xml

---

## ✅ Level 1: Basic Annotations

### Exercise 1: `@Override` and Polymorphism
The goal was to create a worker hierarchy (`Worker`, `OnSiteWorker`, `OnlineWorker`) and use `@Override` to show polymorphism.
*   **Logic implemented**:
    *   `Worker` calculates the base salary (hours × price per hour).
    *   `OnSiteWorker` overrides the method by adding a `static double gas` attribute (shared gas expenses).
    *   `OnlineWorker` overrides the method by adding a `static final double INTERNET_FLAT_RATE` constant (flat internet rate).
*   **Demonstration**: In the `Main` class, an array of type `Worker[]` loops through the three instances. Although the reference is the parent type, Java executes the overridden method of each child class at runtime. This shows the real power of `@Override`.
*   **Testing**: 12 tests were implemented (5 for the base, 4 for on-site, 3 for online). `@BeforeEach` was used to reset the `static gas` attribute before each test to avoid cross-contamination.
*   **Tag**: `L1.E1-complete`

### Exercise 2: `@Deprecated` and Warnings Suppression
The goal was to mark methods as obsolete and learn how to manage IDE warnings.
*   **Implementation**: `calculateSalaryOld()` in `OnSiteWorker` and `calculateSalaryObsolete()` in `OnlineWorker` were created. Both methods are marked with `@Deprecated` because they represent old calculation versions that do not include the extras (gas or flat rate).
*   **External class**: `DeprecatedCaller` was created as an independent class that invokes these obsolete methods. To avoid yellow warnings from the IDE, the `@SuppressWarnings("deprecation")` annotation was used at method level.
*   **Testing**: `DeprecatedCallerTest` was added using `assertDoesNotThrow` to verify that the external class works without throwing exceptions.
*   **Tag**: `L1.E2-complete`

---

## ✅ Level 2: Custom Annotations

### Exercise 1: JSON Serialization
The goal was to create our own annotation to enrich the code with metadata.
*   **Implementation**: The `@JsonSerializable` annotation was created. To make it useful in the future, it was configured with `@Retention(RetentionPolicy.RUNTIME)` (so the Virtual Machine can read it at runtime) and `@Target(ElementType.TYPE)` (so it only applies to classes). It also receives a `String directory()` parameter to indicate where to save the resulting file.
*   **Usage**: The annotation was applied to the `Person` example class like this: `@JsonSerializable(directory = "output/")`.
*   **Testing**: `PersonTest` was created, showing through basic Reflection (using `isAnnotationPresent` and `getAnnotation`) that the class has the annotation and that the directory parameter is saved correctly.
*   **Tag**: `L2.E1-complete`

---

## 🏷️ Git Tags
The project is tagged by milestones to make review easier:
*   `L1.E1-complete`: @Override hierarchy and polymorphism (12 tests).
*   `L1.E2-complete`: @Deprecated methods and warnings suppression (13 tests).
*   `L2.E1-complete`: Custom @JsonSerializable annotation (15 tests).

---

## 🧠 Key Learnings
*   **Cumulative Testing**: From Level 1 onwards, every new feature must include its unit tests (JUnit 5).
*   **Static State Management**: `static` attributes require using `@BeforeEach` in tests to ensure each test starts with a known state (e.g., `setGas(50.0)`).
*   **Binary Precision**: When comparing `double` in tests, always use a delta (e.g., `0.001`) because decimals are not represented exactly in binary.
*   **Code Best Practices**: Do not mix languages (all in English), use `SCREAMING_SNAKE_CASE` for constants, and apply encapsulation (getters yes, unnecessary setters no).
*   **@Deprecated**: It is a communication tool, not a compilation error. It warns that a better alternative exists. It is silenced with `@SuppressWarnings`.