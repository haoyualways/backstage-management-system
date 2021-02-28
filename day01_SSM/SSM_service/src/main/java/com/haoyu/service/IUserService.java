package com.haoyu.service;

import com.haoyu.domain.Role;
import com.haoyu.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-19 20:34
 **/
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll(int page,int size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
