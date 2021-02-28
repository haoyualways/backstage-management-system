package com.haoyu.dao;

import com.haoyu.domain.Member;
import com.haoyu.domain.Orders;
import com.haoyu.domain.Product;
import com.haoyu.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-18 19:29
 **/
public interface IOrdersDao {

    //查询所有
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.haoyu.dao.IProductDao.findById")),
    })
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.haoyu.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.haoyu.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.haoyu.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId) throws Exception;

}
