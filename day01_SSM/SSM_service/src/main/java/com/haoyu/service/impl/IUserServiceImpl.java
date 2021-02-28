package com.haoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.haoyu.dao.IUserDao;
import com.haoyu.domain.Role;
import com.haoyu.domain.UserInfo;
import com.haoyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-19 20:35
 **/
@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = dao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus()==0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    //返回一个list集合，集合中装的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll(int page,int size) throws Exception {
        //参数pageNum是页码，参数pageSize是每页显示数量
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        dao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(String userid) throws Exception{
        return dao.findOtherRoles(userid);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception{
        for(String roleId:roleIds){
            dao.addRoleToUser(userId,roleId);
        }
    }
}
