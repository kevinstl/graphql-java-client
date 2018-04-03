package com.kevinwilde.graphqljavaclient;

import com.kevinwilde.graphqljavaclient.factory.HttpEntityFactory;
import com.kevinwilde.graphqljavaclient.factory.JSONObjectFactory;
import com.kevinwilde.graphqljavaclient.factory.RestTemplateFactory;
import com.kevinwilde.junit.extension.mockito.MockitoExtension;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@ContextConfiguration(classes = { SpringTestConfiguration.class })
public class GraphQlClientTest {


    @InjectMocks
    private GraphQlClient classUnderTest;

    @Mock
    private RestTemplateFactory restTemplateFactory;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private HttpEntityFactory httpEntityFactory;

    @Mock
    private HttpEntity httpEntity;

    @Mock
    private JSONObjectFactory jsonObjectFactory;

    @Mock
    private JSONObject jsonObject;

    private String url = "url";
    private String query = "query";
    private Class stringClass = String.class;
    private String response = "response";

    private String expectedResponse = "expectedResponse";

    @BeforeEach
    public void setupAll(){

        when(httpEntityFactory.build(query)).thenReturn(httpEntity);
        when(restTemplateFactory.build()).thenReturn(restTemplate);
        when(jsonObjectFactory.build(response)).thenReturn(jsonObject);

        when(restTemplate.postForObject(url, httpEntity, stringClass)).thenReturn(expectedResponse);
    }

    @Test
    public void execute_postsToUrl(){

        classUnderTest.execute(url, query, stringClass);

        verify(restTemplate).postForObject(url, httpEntity, stringClass);
    }


}
