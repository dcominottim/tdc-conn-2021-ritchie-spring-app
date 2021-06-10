package br.com.cominotti.demo.sqs;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class SqsConfigLocal {

    private final String awsRegion;

    private final String localStackSqsUrl;

    public SqsConfigLocal(
            final @Value("${cloud.aws.region.static}") String awsRegion,
            final @Value("${localstack.sqs.url}") String localStackSqsUrl
    ) {
        this.awsRegion = awsRegion;
        this.localStackSqsUrl = localStackSqsUrl;
    }

    @Bean
    public AmazonSQSAsync amazonSqs() {
        return AmazonSQSAsyncClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(localStackSqsUrl, awsRegion))
                .build();
    }
}
