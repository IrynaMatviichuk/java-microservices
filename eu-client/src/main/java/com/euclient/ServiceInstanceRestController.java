package com.euclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@RestController
public class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instance/{applicationName}")
    public List<ServiceInstance> getServiceInstance(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
