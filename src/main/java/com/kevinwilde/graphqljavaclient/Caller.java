package com.kevinwilde.graphqljavaclient;

import com.kevinwilde.graphqljavaclient.factory.HttpEntityFactory;
import com.kevinwilde.graphqljavaclient.factory.JSONObjectFactory;
import com.kevinwilde.graphqljavaclient.factory.RestTemplateFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Caller {

    @Autowired
    private RestTemplateFactory restTemplateFactory;

    @Autowired
    private HttpEntityFactory httpEntityFactory;

    @Autowired
    private JSONObjectFactory jsonObjectFactory;

    public String execute(String url, String query) {

        RestTemplate restTemplate = restTemplateFactory.build();
        HttpEntity httpEntity = httpEntityFactory.build(query);

        String response = restTemplate.postForObject(url, httpEntity, String.class);

        JSONObject jsonObj = jsonObjectFactory.build(response);

        System.out.println(jsonObj);

        return jsonObj.toString();
    }

}
