package com.haoyu.service;

import com.haoyu.domain.Permission;
import com.haoyu.domain.Role;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2021-02-27 18:09
 **/
public interface IRoleService {

    List<Role> findAll(int page,int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    void deleteRoleById(String roleId) throws Exception;
}
