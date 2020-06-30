package com.hibernate.example.crudapi;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@SpringBootApplication
@EnableElasticsearchRepositories
public class CrudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudapiApplication.class, args);
	}

	@Bean
	RestHighLevelClient elasticsearchClient() {
		final ClientConfiguration configuration = ClientConfiguration.localhost();
		RestHighLevelClient client = RestClients.create(configuration).rest();
		return client;
	}

	@Bean
	ElasticsearchRestTemplate elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(elasticsearchClient());
	}

}
