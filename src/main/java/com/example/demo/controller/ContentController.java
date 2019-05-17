package com.example.demo.controller;

import com.example.demo.bean.dto.Content;
import com.example.demo.bean.po.Response;
import com.example.demo.service.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("content")
@Api(value = "对学习进行增删查改", description = "查询信息并对学习的信息进行增删查改", position = 0)

public class ContentController {

    @Autowired
    ContentService contentService;

    @ApiOperation(value = "展示列表请求接口", notes = "展示列表请求接口")
    @ApiImplicitParam(dataType = "BugInsertRequest", name = "bugInsertRequest", value = "增加bug信息")
    @GetMapping(value="/showall")
    public Response findAll() {
        Response response = contentService.getContents();
        return response;
    }

    @ApiOperation(value = "新增加Content内容", notes = "新增加Content内容")
    @ApiImplicitParam(dataType = "Content", name = "content", value = "增加content信息", required = true)
    @PostMapping(value="/add")
    public Response add(@RequestBody Content content) {
        Response response = contentService.insertContent(content);
        return response;
    }
}
