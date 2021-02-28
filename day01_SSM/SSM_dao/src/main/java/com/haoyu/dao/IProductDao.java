package com.haoyu.dao;

import com.haoyu.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-09 10:50
 **/
public interface IProductDao {

    //查询所有
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;


    //添加
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
