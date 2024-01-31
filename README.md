# How to run this

1. Add the queue endpoint to the application.yaml file
2. Build the application ```mvn clean package```
3. Start the application ```java -jar target/spring-boot-aws-sqs-listener-example-0.0.1-SNAPSHOT.jar```
4. Send a web request: ```curl -H "Content-Type: application/json" http://localhost:9091/produce/message -d @data.json```
5. The application uses the defaul AWS credentials chain, so make sure to have AWS connection defined as system properties, environment variables or there is a valid ```~/.aws/credentials``` file present.
6. After sending the request a message will be sent to the SQS and will be also consumed

