package com.oasm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DbMapper {
    @Select("select approval_id from dictionary_myapprovals where id=#{id}")
    String getApprovalId(@Param("id") int id);
}
