package com.example.demo.service.impl;


import com.example.demo.bean.dto.Content;
import com.example.demo.bean.dto.Type;
import com.example.demo.bean.po.ResponseBean;
import com.example.demo.common.Message;
import com.example.demo.mapper.ContentMapper;
import com.example.demo.mapper.TypeMapper;
import com.example.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Value("${sys.name}")
    private String uid;

    @Value("${sys.dateformat}")
    private String dateformat;

    @Value("${sys.PageSize}")
    private int pagesize;

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> findTypes() {
        ResponseBean re = new ResponseBean();
        List<Type> lists = typeMapper.getTypes();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return lists;
    }
}
