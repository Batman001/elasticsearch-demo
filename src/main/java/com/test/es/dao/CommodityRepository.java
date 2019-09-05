package com.test.es.dao;

import com.test.es.entity.Commodity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Batman create on 2019-09-04 10:50
 */
@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {

}
