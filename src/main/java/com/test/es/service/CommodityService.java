package com.test.es.service;

import com.test.es.entity.Commodity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Batman create on 2019-09-04 10:51
 */
public interface CommodityService {
    /**
     * 统计商品
     * @return 统计数字
     */
    long count();

    /**
     * 商品保存方法
     * @param commodity 待保存商品
     * @return 保存的商品
     */
    Commodity save(Commodity commodity);

    /**
     * 商品的删除方法
     * @param commodity 待删除商品
     */
    void delete(Commodity commodity);


    /**
     * 返回全部的商品接口
     * @return 迭代器
     */
    Iterable<Commodity> getAll();

    /**
     * 通过名字得到商品的列表
     * @param name 商品名称
     * @return 商品列表
     */
    List<Commodity> getByName(String name);

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param kw
     * @return 分页信息
     */
    Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw);


}
