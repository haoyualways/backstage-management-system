package com.haoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoyu.dao.IOrdersDao;
import com.haoyu.domain.Orders;
import com.haoyu.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-18 19:28
 **/

@Service
@Controller
public class IOrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao dao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //参数pageNum是页码，参数pageSize是每页显示数量
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return dao.findById(ordersId);
    }
}
