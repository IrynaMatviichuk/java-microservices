package com.euclient.configService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ConfigurationsController {
    @Autowired
    private ConfigClientAppConfiguration configClientAppConfiguration;

    @GetMapping("/configs")
    public HashMap<String, String> getConfigurations() {
        return configClientAppConfiguration.getAllConfigurations();
    }
}
