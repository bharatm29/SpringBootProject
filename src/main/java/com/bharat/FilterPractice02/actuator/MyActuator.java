package com.bharat.FilterPractice02.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "myEndpoint")
@Component
public class MyActuator {
    @ReadOperation
    public String myEndpoint(){
        return "wtf?";
    }
}
