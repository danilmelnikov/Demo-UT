# Demo-UT - Subscription Management Demo Application

A Spring Boot application that demonstrates subscription management functionality with unit tests.

## How to set up the web app

1. Make sure you have Java 21 installed
2. Build the project by running the following command from the project root folder:

   ```bash
   # Unix
   ./gradlew build
   
   # Windows
   gradlew.bat build
   ```

3. Run the application:

   ```bash
   java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
   ```

4. Test that it works with curl:

   ```bash
   curl -X GET http://localhost:8080/users/user1/subscriptions
   ```

## How to run unit tests

1. Make sure you have Java 21 installed
2. Run tests with:

   ```bash
   # Unix
   ./gradlew test
   
   # Windows
   gradlew.bat test
   ```

## Setting up GitHub Repository

1. Create a new repository on GitHub
2. Initialize the local repository with GitHub (if not already done):

   ```bash
   # If repository is not initialized yet
   git init
   git add .
   git commit -m "Initial commit"
   
   # Add GitHub as remote and push
   git remote add origin https://github.com/your-username/Demo-UT.git
   git push -u origin main
   ```

3. If you're pushing an existing repository:

   ```bash
   git remote add origin https://github.com/your-username/Demo-UT.git
   git branch -M main
   git push -u origin main
   ```

## Project Structure

- Java classes: `./src/main/java/com/example/demo/` and subfolders
- Java tests: `./src/test/java/com/example/demo/` and subfolders

## Test Coverage

Unit tests are currently available for:

- `com.example.demo.services.DefaultSubscriptionService` (tested in `com.example.demo.services.DefaultSubscriptionServiceTest`)
- `com.example.demo.comparator.SubscriptionDataComparator` (tested in `com.example.demo.comparator.SubscriptionDataComparatorTest`)

Unit tests can be added for all other classes (except `com.example.demo.DemoApplication`, which is primarily a Spring configuration class).

## Tech Stack

- Java 21
- Spring Boot 3.4.4
- Gradle 8.13
- JUnit 5 for testing
- JaCoCo for test coverage