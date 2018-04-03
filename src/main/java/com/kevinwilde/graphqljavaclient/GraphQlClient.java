package com.kevinwilde.graphqljavaclient;

import com.kevinwilde.graphqljavaclient.factory.HttpEntityFactory;
import com.kevinwilde.graphqljavaclient.factory.JSONObjectFactory;
import com.kevinwilde.graphqljavaclient.factory.RestTemplateFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GraphQlClient {

    @Autowired
    private RestTemplateFactory restTemplateFactory;

    @Autowired
    private HttpEntityFactory httpEntityFactory;


    public <T>T execute(String url, String query, Class<T> responseType) {

        RestTemplate restTemplate = restTemplateFactory.build();
        HttpEntity httpEntity = httpEntityFactory.build(query);

        T response = restTemplate.postForObject(url, httpEntity, responseType);

        System.out.println("response: " + response);

        return response;
    }


}
