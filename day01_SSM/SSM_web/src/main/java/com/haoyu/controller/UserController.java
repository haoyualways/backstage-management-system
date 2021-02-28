package com.haoyu.controller;

import com.github.pagehelper.PageInfo;
import com.haoyu.domain.Role;
import com.haoyu.domain.UserInfo;
import com.haoyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;

    //查询指定id的用户
    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //用户添加
    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list = userService.findAll(page,size);
        PageInfo userList = new PageInfo(list);
        mv.addObject("userList", userList);
        mv.setViewName("user-page-list");
        return mv;
    }

    //给用户添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) throws Exception {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll";
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

}
