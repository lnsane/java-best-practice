package com.best.spring.boot.elastic.search;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.best.spring.boot.elastic.search.enums.SexEnum;
import com.best.spring.boot.elastic.search.model.User;
import com.best.spring.boot.elastic.search.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
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

    @Test
    public void test2(){
        User user = new User();
        user.setUserName("wang");
        user.setSex(SexEnum.MAN);
        user.setAge(50);
        user.setCreateTime(DateUtil.parse("2020-02-10 12:12:12"));
        userRepo.save(user);
        User user2 = new User();
        user2.setUserName("wang2");
        user2.setSex(SexEnum.WOMAN);
        user2.setAge(30);
        user2.setCreateTime(DateUtil.parse("2020-01-10 12:12:12"));
        userRepo.save(user2);
        User user3 = new User();
        user3.setUserName("wang");
        user3.setSex(SexEnum.MAN);
        user3.setAge(50);
        user3.setCreateTime(DateUtil.parse("2020-01-01 12:12:12"));
        userRepo.save(user3);
//        User user4 = new User();
//        user4.setUserName("wang3");
//        user4.setSex(SexEnum.MAN);
//        user4.setAge(50);
//        userRepo.save(user4);
    }

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Test
    public void test3() throws IOException {

        SearchRequest searchRequest = new SearchRequest();


//        SearchResponse response2 = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);


        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("userName", "wang");
//        boolQuery.filter(termQueryBuilder);

//
//
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.sort("createTime", SortOrder.ASC);


//        builder.from(0).size(5);

        String[] includes = {"id", "userName", "sex", "age","createTime"};
        AggregationBuilder top = AggregationBuilders.topHits("result").sort("createTime", SortOrder.ASC).fetchSource(includes, Strings.EMPTY_ARRAY).size(1);

        TermsAggregationBuilder aggBuilder = AggregationBuilders.terms("group1").field("sex")
//                .subAggregation(AggregationBuilders.topHits("result").sort("createTime", SortOrder.ASC))
                .subAggregation(AggregationBuilders.terms("group2").field("userName")
//                        .subAggregation(AggregationBuilders.topHits("result2").sort("createTime", SortOrder.ASC))
                                .subAggregation(top)
                                .subAggregation(AggregationBuilders.sum("age").field("age"))
                )
                .size(100000000);

//
//        QueryBuilder successCountBuilder = QueryBuilders.termQuery("userName","wang");
//        FilterAggregationBuilder successCountFilter = AggregationBuilders.filter("successCount", successCountBuilder);
//        successCountFilter.subAggregation();
//
//

//        TermsAggregationBuilder terms2 = AggregationBuilders.terms("age").field("age");
//        aggBuilder.subAggregation(terms.subAggregation(AggregationBuilders.sum("123").field("age")));

        builder.query(boolQuery);

        builder.aggregation(aggBuilder);
//        builder.from(0).size(1);



        searchRequest.source(builder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);


        log.info(String.valueOf(response));
    }

    @Test
    public void test4() throws IOException {
        SearchRequest searchRequest = new SearchRequest();


//        SearchResponse response2 = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);


        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("day_of_week2", "wang#50");
        boolQuery.filter(termQueryBuilder);

//
//
        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.sort("createTime", SortOrder.ASC);
//
//
////        builder.from(0).size(5);
//
//        String[] includes = {"id", "userName", "sex", "age","createTime"};
//        AggregationBuilder top = AggregationBuilders.topHits("result").sort("createTime", SortOrder.ASC).fetchSource(includes, Strings.EMPTY_ARRAY).size(1);
//
//        TermsAggregationBuilder aggBuilder = AggregationBuilders.terms("group1").field("sex")
////                .subAggregation(AggregationBuilders.topHits("result").sort("createTime", SortOrder.ASC))
//                .subAggregation(AggregationBuilders.terms("group2").field("age")
////                        .subAggregation(AggregationBuilders.topHits("result2").sort("createTime", SortOrder.ASC))
//                                .subAggregation(top)
//                                .subAggregation(AggregationBuilders.sum("age").field("age"))
//                )
//                .size(100000000);


        builder.query(boolQuery);

//        builder.aggregation(aggBuilder);



        searchRequest.source(builder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);


        log.info(String.valueOf(response));
    }


    @Test
    public void test5() throws IOException {

        SearchRequest searchRequest = new SearchRequest();


//        SearchResponse response2 = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);


        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("day_of_week2.keyword", "wang#50");

//
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("userName", "wang");
        boolQuery.filter(termQueryBuilder);

//
//
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.sort("createTime", SortOrder.ASC);


//        builder.from(0).size(5);

        String[] includes = {"id", "userName", "sex", "age","createTime"};
        AggregationBuilder top = AggregationBuilders.topHits("result").sort("createTime", SortOrder.ASC).fetchSource(includes, Strings.EMPTY_ARRAY).size(1);
//
        TermsAggregationBuilder aggBuilder = AggregationBuilders.terms("group").field("group8")
//                .subAggregation(AggregationBuilders.topHits("result").sort("createTime", SortOrder.ASC))
//                .subAggregation(AggregationBuilders.terms("group2").field("userName")
//                        .subAggregation(AggregationBuilders.topHits("result2").sort("createTime", SortOrder.ASC))

//                )
                .subAggregation(top)
//                .subAggregation(AggregationBuilders.sum("age").field("age"))
                .size(100000000);

//
//        QueryBuilder successCountBuilder = QueryBuilders.termQuery("userName","wang");
//        FilterAggregationBuilder successCountFilter = AggregationBuilders.filter("successCount", successCountBuilder);
//        successCountFilter.subAggregation();
//
//

//        TermsAggregationBuilder terms2 = AggregationBuilders.terms("group1").field("group8");
//        aggBuilder.subAggregation(terms.subAggregation(AggregationBuilders.sum("123").field("age")));

        builder.aggregation(aggBuilder);

//        builder.aggregation(terms2);
//        builder.from(0).size(1);



        searchRequest.source(builder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);


        log.info(String.valueOf(response));
    }
}