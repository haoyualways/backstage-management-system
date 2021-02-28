package com.haoyu.controller;

import com.github.pagehelper.PageInfo;
import com.haoyu.domain.Product;
import com.haoyu.service.IProductService;
import com.haoyu.utils.DateStringEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：基础数据管理-产品管理
 * @create: 2020-12-09 23:05
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    //字符转换
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new DateStringEditor());
    }

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> list = service.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("productList",pageInfo);
        mv.setViewName("product-page-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Product product){
        service.save(product);
        return "redirect:findAll";
    }

}
