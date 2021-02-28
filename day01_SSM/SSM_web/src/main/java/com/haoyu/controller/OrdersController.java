package com.haoyu.controller;

import com.github.pagehelper.PageInfo;
import com.haoyu.domain.Orders;
import com.haoyu.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：基础数据管理-订单管理
 * @create: 2020-12-18 19:26
 **/

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService service;

    /**
     * 查询所有,未进行分页
     * @return
     * @throws Exception
     */
    /*@RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> list = service.findAll();
        modelAndView.addObject("ordersList",list);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }*/

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = service.findAll(page, size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String ordersId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Orders orders = service.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
