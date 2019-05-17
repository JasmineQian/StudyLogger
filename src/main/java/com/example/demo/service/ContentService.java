package com.example.demo.service;

import com.example.demo.bean.dto.Content;
import com.example.demo.bean.po.Request;

import com.example.demo.bean.po.Response;
import com.example.demo.bean.po.ResponseBean;

public interface ContentService {

    ResponseBean getContents();

    ResponseBean getContentById(Request request);

    Response insertContent(Content content);

    Response updateContent(Content content);

}