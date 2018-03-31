package com.kevinwilde.graphqljavaclient.factory;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory {

    public RestTemplate build(){
        return new RestTemplate();
    }

}
