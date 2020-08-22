package com.lvym.mybatisplus.dao;
import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lvym.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface UserMapper extends MyMapper<User> {
   // @Select("select name,age from user ${ew.customSqlSegment}")
    List<User> selectL(@Param(Constants.WRAPPER) Wrapper<User> wrapper);
    @SqlParser(filter = true)
    @Select("select * from user")
    List<User> getall();

    IPage<User> selectPages(Page<User> page,@Param(Constants.WRAPPER) Wrapper<User> wrapper);



}
