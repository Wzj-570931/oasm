package com.oasm.service;

import com.oasm.dao.DbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicService {
    @Autowired
    DbMapper dbMapper;

    public void getApprovalId(){
        String approvalId = dbMapper.getApprovalId(4019774);
        System.out.println(approvalId);
    }
}
