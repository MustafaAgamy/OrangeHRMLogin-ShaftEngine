### Description
This repository automates the login functionality of the OrangeHRM demo website using APIs and the SHAFT Engine with Java. The project ensures efficient and reliable test execution.

---

### Features
- API-driven login functionality for the OrangeHRM demo.
- Built on the SHAFT Engine for enhanced test automation capabilities.
- Written in Java for compatibility and reliability.
- Easy integration with CI/CD pipelines.

---

### Prerequisites
1. **Java** (version 21 or later).
2. **Maven** installed.
3. A valid API key or login credentials for the OrangeHRM demo website.

---

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Ensure the SHAFT Engine is properly configured.

---

### Project Structure
- **src/main/java/**: Application and utility classes.
  - **api/**: API utilities for login and authentication.
  - **config/**: Configuration constants.
- **src/test/java/**: Test cases and test data.
- **pom.xml**: Maven configuration file.

---

### How to Run
1. Execute login tests:
   ```bash
   mvn test
   ```
2. Generate an Allure report:
   ```bash
   mvn allure:serve
   ```

---

### Customization
- Modify test cases in `src/test/java/` for additional scenarios.

---

### Contact
For questions or support, contact [mostafaagamy1995@gmail.com].
