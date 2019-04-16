package com.nineleaps.DocumentManagementSystem.elasticsearch;

import com.nineleaps.DocumentManagementSystem.dao.ElasticSearchData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ElasticSearchQueryBuilderTest {

    @InjectMocks
    ElasticSearchQueryBuilder elasticSearchQueryBuilder;
    @Mock
    private ElasticsearchTemplate elasticsearchTemplate;
    @Test
    public void getAll() {

        List<ElasticSearchData> elasticSearchData=elasticSearchQueryBuilder.getAll("mukul");
        assertEquals(elasticSearchData.size(),0);


    }
}