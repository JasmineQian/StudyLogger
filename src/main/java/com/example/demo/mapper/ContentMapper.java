package com.example.demo.mapper;


import com.example.demo.bean.dto.Content;
import com.example.demo.bean.po.Page;
import com.example.demo.bean.po.Request;

import java.util.List;
public interface ContentMapper {

    List<Content> getContents();

    List<Content> getContentsByPage(Page page);

    List<Content> getContentsByPageByConditions(Request record);

    Content getByid(Integer id);

    int insert(Content record);

    int updateById(Content record);
}
