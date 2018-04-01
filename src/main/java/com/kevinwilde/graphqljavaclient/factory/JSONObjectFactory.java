package com.kevinwilde.graphqljavaclient.factory;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JSONObjectFactory {

    public JSONObject build(String json){
        return new JSONObject(json);
    }
}
