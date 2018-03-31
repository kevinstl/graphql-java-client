package com.kevinwilde.graphqljavaclient.factory;

import org.json.JSONObject;

public class JSONObjectFactory {

    public JSONObject build(String json){
        return new JSONObject(json);
    }
}
