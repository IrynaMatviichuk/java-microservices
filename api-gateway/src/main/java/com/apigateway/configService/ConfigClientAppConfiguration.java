package com.apigateway.configService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@RefreshScope
@Component
@ConfigurationProperties(prefix = "api-gateway")
public class ConfigClientAppConfiguration {

    @Value("${api-gateway.test.property1}")
    private String property1;

    @Value("${api-gateway.test.property2}")
    private String property2;

    public String getProperty1() {
        return this.property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return this.property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public HashMap<String, String> getAllConfigurations() {
        HashMap<String, String> configurations = new HashMap<>();
        configurations.put("api-gateway.test.property1", this.property1);
        configurations.put("api-gateway.test.property2", this.property2);

        return configurations;
    }
}
