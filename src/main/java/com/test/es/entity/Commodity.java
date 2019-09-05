package com.test.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author Batman create on 2019-09-04 10:48
 */
@Data
@Document(indexName = "commodity")
public class Commodity implements Serializable {
    @Id
    private String skuId;

    private String name;

    private String category;

    private Integer price;

    private String brand;

    private Integer stock;


}
