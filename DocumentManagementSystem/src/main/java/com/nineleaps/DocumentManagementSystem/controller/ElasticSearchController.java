package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dao.ElasticSearchData;
import com.nineleaps.DocumentManagementSystem.elasticsearch.ElasticSearchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ElasticSearchController {

    @Autowired
    private ElasticSearchQueryBuilder elasticSearchQueryBuilder;

    @ResponseBody
    @GetMapping(value = "/v1/search")
    public List<ElasticSearchData> getAll(@RequestParam("text") String text) {

        return elasticSearchQueryBuilder.getAll(text);
    }

}
