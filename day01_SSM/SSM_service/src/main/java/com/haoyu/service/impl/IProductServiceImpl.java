package com.haoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.haoyu.dao.IProductDao;
import com.haoyu.domain.Product;
import com.haoyu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-09 10:55 lxz
 **/
@Service
@Transactional
public class IProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        //参数pageNum是页码，参数pageSize是每页显示数量
        PageHelper.startPage(page,size);
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) {
        iProductDao.save(product);
    }
}
