package com.best.spring.boot.elastic.search;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.best.spring.boot.elastic.search.enums.SexEnum;

import com.best.spring.boot.elastic.search.model.User;
import com.best.spring.boot.elastic.search.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MinAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.SumAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
class SpringBootElasticSearchDemoTest {
    @Autowired
    private UserRepo userRepo;
    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            String username = IdUtil.fastSimpleUUID();
            User user = new User();
            user.setUserName(username);
            user.setSex(SexEnum.MAN);
            user.setAge(i);
            userRepo.save(user);
        }
        for (int i = 0; i < 100; i++) {
            String username = IdUtil.fastSimpleUUID();
            User user = new User();
            user.setUserName(username);
            user.setSex(SexEnum.WOMAN);
            user.setAge(i);
            userRepo.save(user);
        }
        userRepo.findAll().forEach(user1 -> System.out.println(user1.toString()));
    }

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Test
    public void test2() throws IOException {

        SearchRequest searchRequest = new SearchRequest("tbsendrcd_202208");
        searchRequest.routing("20220808");


        SearchResponse response2 = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);



        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("sex", "MAN");
        boolQuery.filter(termQueryBuilder);


        SearchSourceBuilder builder = new SearchSourceBuilder();



//        builder.from(0).size(5);

        String[] includes = {"id","userName","sex","age"};
        AggregationBuilder top = AggregationBuilders.topHits("result").fetchSource(includes, Strings.EMPTY_ARRAY);

        TermsAggregationBuilder aggBuilder = AggregationBuilders.terms("group1").field("testhaha").size(100000000);

//        builder.aggregation(aggBuilder);

        QueryBuilder successCountBuilder = QueryBuilders.rangeQuery("age").gte("0");
        FilterAggregationBuilder successCountFilter = AggregationBuilders.filter("successCount", successCountBuilder);
        successCountFilter.subAggregation(AggregationBuilders.count("age_sum").field("sex"));

//        TermsAggregationBuilder terms = AggregationBuilders.terms("test11").field("test").size(100000000);


//        TermsAggregationBuilder terms2 = AggregationBuilders.terms("age").field("age");
//        aggBuilder.subAggregation(terms.subAggregation(AggregationBuilders.sum("123").field("age")));

        aggBuilder.subAggregation(top);

        aggBuilder.subAggregation(successCountFilter);

        builder.aggregation(aggBuilder);

        builder.query(boolQuery);

        searchRequest.source(builder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);




        log.info(String.valueOf(response));
    }
}