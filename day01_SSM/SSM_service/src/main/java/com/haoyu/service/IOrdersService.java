package com.haoyu.service;

import com.haoyu.domain.Orders;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-18 19:27
 **/
public interface IOrdersService {

    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
