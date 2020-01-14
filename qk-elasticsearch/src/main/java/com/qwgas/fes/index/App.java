package com.qwgas.fes.index;

import com.qwgas.fes.client.HightClient;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class App extends HightClient {

    @Test
    public void testIndex1() throws IOException {
        IndexRequest indexRequest = new IndexRequest("posts");
        indexRequest.id("1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        indexRequest.source(jsonString, XContentType.JSON);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getIndex());
    }
    @Test
    public void testIndex2() throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("user", "kimchy");
        map.put("postDate", LocalDateTime.now());
        map.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts").id("1").source(map);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
        System.out.println(indexResponse.getIndex());
        System.out.println(indexResponse.getId()+"----"+indexResponse.getSeqNo());
    }
    @Test
    public void testIndex3() throws IOException {
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder();
        xContentBuilder.startObject();
        {
            xContentBuilder.field("user", "kimchy");
            xContentBuilder.timeField("postDate",LocalDateTime.now());
            xContentBuilder.field("message", "trying out Elasticsearch");
        }
        xContentBuilder.endObject();
        IndexRequest indexRequest = new IndexRequest("posts").id("2").source(xContentBuilder);
        indexRequest.routing("routing");
        indexRequest.timeout(TimeValue.timeValueSeconds(1));
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.getLocation("routing"));

    }
}
