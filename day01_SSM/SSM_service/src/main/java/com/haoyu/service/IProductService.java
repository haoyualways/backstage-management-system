package com.haoyu.service;

import com.haoyu.domain.Product;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-09 10:53
 **/
public interface IProductService {

    List<Product> findAll(int page,int size) throws Exception ;

    void save(Product product);
}
