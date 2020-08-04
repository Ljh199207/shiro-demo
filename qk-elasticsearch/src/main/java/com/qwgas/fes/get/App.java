package com.qwgas.fes.get;

import com.qwgas.fes.client.HightClient;
import org.elasticsearch.action.get.GetRequest;
import org.junit.Test;

import java.io.IOException;

public class App extends HightClient {

    @Test
    public void testIndex1() throws IOException {
        GetRequest getRequest = new GetRequest(
                "posts",
                "2");

        System.out.println(getRequest);
    }

    @Test
    public void testIndex2() throws IOException {
    }

    @Test
    public void testIndex3() throws IOException {

    }
}
