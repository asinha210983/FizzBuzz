1) Install Apache Maven 3.8.4
2) Install JDK 11
3) Set the Env Variables to Recognize Maven command
4) To Build and Run unit test
   ./mvnw  -DprojectType=api -DprojectName=FizzBuzz clean test
5) To Start In built tomcat server
   ./mvnw -DprojectType=api -DprojectName=FizzBuzz spring-boot:run
6) Once Server is UP Swagger UI can be used to test different scenerios
   http://localhost:<port>/interview/swagger-ui.html#!/fizzBuzz/calculateFizzBuzz
