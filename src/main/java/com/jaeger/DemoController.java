package com.jaeger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("foo.development")
    private String dev;

    @Value("foo.production")
    private String prod;

    @RequestMapping(value = "/")
    public String index() {
        return "Hello World!!!";
    }

    @RequestMapping(value = "/test/{env}")
    public String test(@PathVariable("env") String env) {
        String message = "";

        if ("dev".equalsIgnoreCase(env)) {
            message = dev;
        } else if ("prod".equalsIgnoreCase(env)) {
            message = prod;
        }

        return "Message : " + message;
    }

}
