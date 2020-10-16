package com.example.starter.flow.better;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.HttpURLConnection;
import java.net.URL;

public class Test
{
    private static final String HTTP_LOCALHOST_8080 = "http://localhost:8080/";

    @org.junit.jupiter.api.Test
    void testName() throws Exception
    {

        System.out.println();
        URL url = new URL(HTTP_LOCALHOST_8080);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int code = connection.getResponseCode();

        assertThat(code).isEqualTo(200);
    }
    //
}
