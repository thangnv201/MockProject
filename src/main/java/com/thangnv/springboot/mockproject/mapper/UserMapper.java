package com.thangnv.springboot.mockproject.mapper;

import com.thangnv.springboot.mockproject.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByEmail(String email);
}
