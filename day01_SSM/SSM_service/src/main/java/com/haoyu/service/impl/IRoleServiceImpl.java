package com.haoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.haoyu.dao.IRoleDao;
import com.haoyu.domain.Permission;
import com.haoyu.domain.Role;
import com.haoyu.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2021-02-27 18:10
 **/
@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll(int page,int size) throws Exception {
        //参数pageNum是页码，参数pageSize是每页显示数量
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception{
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception{
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception{
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public void deleteRoleById(String roleId) throws Exception{
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }
}
