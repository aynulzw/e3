package com.lzw.community.mapper;

import com.lzw.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lzw
 * @create 2019/10/15/18:59
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user (name,token,account_id,gmt_create,gmt_modify) values (#{name},#{token},#{accountId},#{gmtCreate},#{gmtModify})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String tokenValue);
}
