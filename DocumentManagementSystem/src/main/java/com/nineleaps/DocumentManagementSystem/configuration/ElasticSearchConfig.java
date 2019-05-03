package com.nineleaps.DocumentManagementSystem.configuration;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.IOException;
import java.net.InetAddress;

@Configuration
@EnableCassandraRepositories(basePackages = "com.nineleaps.DocumentManagementSystem.repository")
@EnableElasticsearchRepositories(basePackages = "com.nineleaps.DocumentManagementSystem.repository")
public class ElasticSearchConfig {


//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }

    @Bean
    public Client client() throws IOException {

        System.setProperty("es.set.netty.runtime.available.processors", "false");

        Settings esSettings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .build();
        TransportClient client = new PreBuiltTransportClient(esSettings);

        client.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        return client;
    }


    @Bean
    public JestClient jestClient() {

        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        return factory.getObject();
    }
}
