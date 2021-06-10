package br.com.cominotti.demo.sns;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class SnsConfigLocal {

    @Value("${cloud.aws.region.static}")
    private final String awsRegion;

    @Value("${localstack.sns.url}")
    private final String localStackSnsUrl;

    public SnsConfigLocal(
            final @Value("${cloud.aws.region.static}") String awsRegion,
            final @Value("${localstack.sns.url}") String localStackSnsUrl
    ) {
        this.awsRegion = awsRegion;
        this.localStackSnsUrl = localStackSnsUrl;
    }

    @Bean
    public AmazonSNS amazonSNS() {
        return AmazonSNSClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(localStackSnsUrl, awsRegion))
                .build();
    }
}
