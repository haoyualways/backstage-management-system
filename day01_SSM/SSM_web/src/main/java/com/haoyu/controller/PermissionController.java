package com.haoyu.controller;

import com.github.pagehelper.PageInfo;
import com.haoyu.dao.IPermissionDao;
import com.haoyu.domain.Permission;
import com.haoyu.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2021-02-28 12:28
 **/

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Permission> list = permissionService.findAll(page,size);
        PageInfo permissionList = new PageInfo(list);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/deletePermission")
    public String deletePermission(String id) throws Exception {
        permissionService.deleteById(id);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        Permission permission=  permissionService.findById(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("permission-show");
        mv.addObject("permission",permission);
        return mv;
    }

    @RequestMapping("/save")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll";
    }

}
