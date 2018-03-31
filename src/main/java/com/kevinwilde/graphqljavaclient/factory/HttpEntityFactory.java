package com.kevinwilde.graphqljavaclient.factory;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class HttpEntityFactory {

    public HttpEntity build(String query){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("Authorization",System.getenv("GITHUB_BEARER_TOKEN"));


        JSONObject json = new JSONObject();
        json.put("query", query);

        HttpEntity<String> httpEntity = new HttpEntity <String> (json.toString(), httpHeaders);

        return httpEntity;
    }
}
