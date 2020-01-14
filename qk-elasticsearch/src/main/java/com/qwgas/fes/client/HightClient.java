package com.qwgas.fes.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

public class HightClient {

    public RestHighLevelClient restHighLevelClient;

    @Before
    public void getClient() {
        restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")
                )
        );
    }

    @After
    public void closeClient() throws IOException {
        if (restHighLevelClient != null) {
            restHighLevelClient.close();
        }
    }
}
