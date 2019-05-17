package com.example.demo.service.impl;

import com.example.demo.bean.dto.Content;
import com.example.demo.bean.po.Request;
import com.example.demo.bean.po.Response;
import com.example.demo.bean.po.ResponseBean;
import com.example.demo.common.Message;
import com.example.demo.mapper.ContentMapper;
import com.example.demo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Value("${sys.name}")
    private String uid;

    @Value("${sys.dateformat}")
    private String dateformat;

    @Value("${sys.PageSize}")
    private int pagesize;

    @Autowired
    private ContentMapper contentMapper;


    @Override
    public ResponseBean getContents() {
        ResponseBean re = new ResponseBean();
        List<Content> lists = contentMapper.getContents();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getContentById(Request request) {
        return null;
    }

    @Override
    public Response insertContent(Content content) {


        Date dt = new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat(dateformat);
        String date = dateFormat.format(dt);

        content.setUid(1);
        content.setDesc(content.getDesc().trim());

        content.setCreationdt(date);
        content.setUpdatedt(date);

        Response response = new Response();
        int count =contentMapper.insert(content);


        if (count > 0) {
            response.setCode(Message.SUCCESS_CODE);
            response.setMsg(Message.SUCCESS_MESSAGE);
        } else {
            response.setCode(Message.ERROR_CODE);
            response.setMsg(Message.ERROR_MESSAGE);

        }
        return response;
    }

    @Override
    public Response updateContent(Content content) {
        Date dt = new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat(dateformat);
        String date = dateFormat.format(dt);
        content.setCreationdt(date);
        content.setUpdatedt(date);

        Response response = new Response();
        int count =contentMapper.updateById(content);


        if (count > 0) {
            response.setCode(Message.SUCCESS_CODE);
            response.setMsg(Message.SUCCESS_MESSAGE);
        } else {
            response.setCode(Message.ERROR_CODE);
            response.setMsg(Message.ERROR_MESSAGE);

        }
        return response;
    }
}