package com.nineleaps.DocumentManagementSystem.repository;

import com.nineleaps.DocumentManagementSystem.dao.ElasticSearchData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchDataRepository extends ElasticsearchRepository<ElasticSearchData, String> {
}
