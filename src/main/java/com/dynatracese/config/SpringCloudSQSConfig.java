package com.dynatracese.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

@Configuration
public class SpringCloudSQSConfig {
	// @Value("${cloud.aws.region.static}")
	// private String region;

	// @Value("${cloud.aws.credentials.access-key}")
	// private String accessKey;

	// @Value("${cloud.aws.credentials.secret-key}")
	// private String secretKey;

	// @Value("${cloud.aws.credentials.access-token}")
	// private String accessToken;

	@Bean
	public QueueMessagingTemplate queueMessagingTemplate() {
		return new QueueMessagingTemplate(amazonSQSAsync());
	}

	public AmazonSQSAsync amazonSQSAsync() {

		AmazonSQSAsyncClientBuilder amazonSQSAsyncClientBuilder = AmazonSQSAsyncClientBuilder.standard(); //standard();
		AmazonSQSAsync amazonSQSAsync = null;
		
		amazonSQSAsyncClientBuilder.withRegion(Regions.US_EAST_1);
		//BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
		//BasicSessionCredentials basicAWSSessionCredentials = new BasicSessionCredentials(accessKey, secretKey, accessToken);
		
		//amazonSQSAsyncClientBuilder.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials));
		amazonSQSAsync = amazonSQSAsyncClientBuilder.build();
		return amazonSQSAsync;

	}

}
