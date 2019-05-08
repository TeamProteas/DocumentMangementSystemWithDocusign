package com.nineleaps.DocumentManagementSystem.elasticsearch;

import com.nineleaps.DocumentManagementSystem.dao.ElasticSearchData;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ElasticSearchQueryBuilder {


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public List<ElasticSearchData> getAll(String text) {

        QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(text)
                                .lenient(true)
                                .field("emailId")
                ).should(QueryBuilders.queryStringQuery(text + "*")
                        .lenient(true)
                        .field("emailId"));
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<ElasticSearchData> userses = elasticsearchTemplate.queryForList(build, ElasticSearchData.class);

        return userses;
    }
}
