package com.haoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.haoyu.dao.IPermissionDao;
import com.haoyu.domain.Permission;
import com.haoyu.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2021-02-28 12:32
 **/

@Service
public class IPermissionServiceImpl implements IPermissionService {


    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll(int page,int size) throws Exception{
        //参数pageNum是页码，参数pageSize是每页显示数量
        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public void deleteById(String id) throws Exception {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleteById(id);
    }

    @Override
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }
}
