package com.best.spring.boot.mybatis.page.helper.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  {


    Page<User> selectList();

}