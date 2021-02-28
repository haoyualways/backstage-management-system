package com.haoyu.dao;

import com.haoyu.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-19 18:00
 **/
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
