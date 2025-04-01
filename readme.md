# How to set up web app

1. Make sure you have java 17 installed;
2. Build project by running next command from project root folder:

Unix: `./gradlew build`
Windows: `gradlew.bat build`

3. Run application by command: `java -jar build/libs/demo-0.0.1-SNAPSHOT.jar`

4. Test that it works by curl:

`curl -X GET http://localhost:8080/users/user1/subscriptions`

# How run unit tests

1. Make sure you have java 17 installed;
2. Run tests by command:

Unix: `./gradlew test`
Windows: `gradlew.bat test`

# About project

Java classes can be found in ./src/main/java/com/example/demo folder and subfolders.
Java tests can be found in ./src/test/java/com/example/demo folder and subfolders.

Unit tests were added for:

com.example.demo.services.DefaultSubscriptionService (com.example.demo.services.DefaultSubscriptionServiceTest)
com.example.demo.comparator.SubscriptionDataComparator (com.example.demo.comparator.SubscriptionDataComparatorTest)

Unit tests can be added for all other classes (except probably com.example.demo.DemoApplication, since we don't usually add tests on spring configuration).

