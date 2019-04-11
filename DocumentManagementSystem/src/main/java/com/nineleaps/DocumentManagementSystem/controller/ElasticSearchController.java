package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dao.ElasticSearchData;
import com.nineleaps.DocumentManagementSystem.elasticsearch.ElasticSearchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ElasticSearchController {


    @Autowired
    private ElasticSearchQueryBuilder elasticSearchQueryBuilder;

    @ResponseBody
    @GetMapping(value = "/{text}")
    public List<ElasticSearchData> getAll(@RequestHeader("tokenId") String tokenData, @PathVariable final String text) {
        System.out.println(text);
        return elasticSearchQueryBuilder.getAll(text);
    }

}
