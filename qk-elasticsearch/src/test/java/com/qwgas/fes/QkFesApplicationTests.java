package com.qwgas.fes;

import com.qwgas.fes.index.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QkFesApplicationTests {

    @Autowired
    private IndexService indexService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testIndexService() {
        indexService.createIndex();
        //indexService.deleteIndex();
    }
}
