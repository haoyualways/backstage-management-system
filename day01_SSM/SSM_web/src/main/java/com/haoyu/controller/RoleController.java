package com.haoyu.controller;

import com.github.pagehelper.PageInfo;
import com.haoyu.domain.Permission;
import com.haoyu.domain.Role;
import com.haoyu.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2021-02-27 18:06
 **/
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {        ModelAndView mv = new ModelAndView();
        List<Role> list = iRoleService.findAll(page,size);
        PageInfo roleList = new PageInfo(list);
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        iRoleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String roleId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = iRoleService.findById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = iRoleService.findById(roleId);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = iRoleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    //给角色添加权限
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {
        iRoleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll";
    }

    @RequestMapping("/deleteRole")
    public String deleteRole(@RequestParam(name="id",required = true) String roleId) throws Exception {
        iRoleService.deleteRoleById(roleId);
        return "redirect:findAll";
    }

}
