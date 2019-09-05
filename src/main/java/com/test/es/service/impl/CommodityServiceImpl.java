package com.test.es.service.impl;

import com.test.es.dao.CommodityRepository;
import com.test.es.entity.Commodity;
import com.test.es.service.CommodityService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Batman create on 2019-09-04 10:56
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;


    /**
     * 统计商品
     *
     * @return 统计数字
     */
    @Override
    public long count() {
        return commodityRepository.count();
    }

    /**
     * 商品保存方法
     *
     * @param commodity 待保存商品
     * @return 保存的商品
     */
    @Override
    public Commodity save(Commodity commodity) {
        return commodityRepository.save(commodity);
    }

    /**
     * 商品的删除方法
     *
     * @param commodity 待删除商品
     */
    @Override
    public void delete(Commodity commodity) {
        commodityRepository.delete(commodity);
    }

    /**
     * 返回全部的商品接口
     *
     * @return 迭代器
     */
    @Override
    public Iterable<Commodity> getAll() {
        return commodityRepository.findAll();
    }

    /**
     * 通过名字得到商品的列表
     *
     * @param name 商品名称
     * @return 商品列表
     */
    @Override
    public List<Commodity> getByName(String name) {
        List<Commodity> list = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", name);
        Iterable<Commodity> iterable = commodityRepository.search(matchQueryBuilder);
        iterable.forEach(e->list.add(e));
        return list;
    }

    /**
     * 分页查询
     *
     * @param pageNo
     * @param pageSize
     * @param kw
     * @return 分页信息
     */
    @Override
    public Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name", kw))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return commodityRepository.search(searchQuery);
    }
}
