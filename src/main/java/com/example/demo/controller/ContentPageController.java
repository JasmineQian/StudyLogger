package com.example.demo.controller;

import com.example.demo.bean.dto.Content;
import com.example.demo.bean.dto.Type;
import com.example.demo.bean.po.Request;
import com.example.demo.bean.po.Response;
import com.example.demo.bean.po.ResponseBean;
import com.example.demo.common.Message;
import com.example.demo.service.ContentService;
import com.example.demo.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ContentPageController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ContentService contentService;

    @Autowired
    TypeService typeService;

    @GetMapping("/pcontent")
    public String findByIdpage(Model model) {
        logger.info("根据用户的所有的学习内容");
        Response response = contentService.getContents();
        Object lists= ((ResponseBean) response).getData();

        if (response != null) {
            logger.info("查询成功！");
            model.addAttribute("content", lists);
            model.addAttribute("message", "查询成功");
            return "content";
        } else {
            model.addAttribute("message", "查询失败");
            return "auto";
        }
    }


    @GetMapping("/pinsert")
    public String insert(Model model) {
        logger.info("即将跳转到新增学习内容页面");
        List<Type> types = typeService.findTypes();
        model.addAttribute("types", types);
        return "insert";
        }


    @PostMapping("/create")
    public String create(Model model, Content content) {
        logger.info("新增Content记录");
       Response reponse = contentService.insertContent(content);
        if (reponse.getCode() == Message.SUCCESS_CODE) {
            logger.info("新增Content成功！");
            model.addAttribute("message", "新增成功");
            return "auto";
        } else {
            model.addAttribute("message", "新增失败");
            logger.info("新增Content失败!");
            return "auto";
        }

    }

    @PostMapping("/findById")
    public String findByIdpage(Model model, @RequestParam("id") int id) {
        logger.info("根据用户ID查询用户信息");
        Request request = new Request();
        request.setId(id);


        ResponseBean rb = contentService.getContentById(request);
        if (rb.getData() != null) {
            logger.info("查询成功！");
            model.addAttribute("content", rb.getData() );
            model.addAttribute("message", "查询成功");
            return "content/details";
        } else {
            model.addAttribute("message", "查询失败");
            return "auto";
        }
    }



}
