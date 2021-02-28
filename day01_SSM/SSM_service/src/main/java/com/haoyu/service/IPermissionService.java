package com.haoyu.service;

import com.haoyu.domain.Permission;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2021-02-28 12:31
 **/
public interface IPermissionService {

    List<Permission> findAll(int page,int size) throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void deleteById(String id) throws Exception;
}
