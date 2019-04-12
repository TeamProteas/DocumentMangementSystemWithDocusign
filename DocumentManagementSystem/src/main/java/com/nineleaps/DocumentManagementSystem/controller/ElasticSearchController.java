package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dao.ElasticSearchData;
import com.nineleaps.DocumentManagementSystem.elasticsearch.ElasticSearchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ElasticSearchController {


    @Autowired
    private ElasticSearchQueryBuilder elasticSearchQueryBuilder;

    @ResponseBody
    @GetMapping(value = "v1/search")
    public List<ElasticSearchData> getAll(@RequestHeader("tokenId") String tokenData, @RequestParam("text")  String text) {
        System.out.println(text);
        return elasticSearchQueryBuilder.getAll(text);
    }

}
