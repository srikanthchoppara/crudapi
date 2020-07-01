package com.hibernate.example.crudapi.model;

import org.hibernate.search.backend.elasticsearch.index.layout.IndexLayoutStrategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomLayoutStrategy implements IndexLayoutStrategy {


    @Override
    public String createInitialElasticsearchIndexName(String hibernateSearchIndexName) {
        return hibernateSearchIndexName + "-001";
    }

    @Override
    public String createWriteAlias(String hibernateSearchIndexName) {
        return hibernateSearchIndexName + "-write";
    }

    @Override
    public String createReadAlias(String hibernateSearchIndexName) {
        return hibernateSearchIndexName+ "-read";
    }

    @Override
    public String extractUniqueKeyFromHibernateSearchIndexName(
            String hibernateSearchIndexName) {
        return hibernateSearchIndexName;
    }

    @Override
    public String extractUniqueKeyFromElasticsearchIndexName(
            String elasticsearchIndexName) {
        return elasticsearchIndexName;
    }
}
