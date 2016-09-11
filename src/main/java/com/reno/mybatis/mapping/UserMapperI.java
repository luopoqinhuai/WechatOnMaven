package com.reno.mybatis.mapping;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reno.mybatis.domain.User;

/**
 * 
 * @author Reno
 *
 */
public interface UserMapperI {

    //使用@Insert注解指明add方法要执行的SQL
    @Insert("insert into testuser2(name, age) values(#{name}, #{age})")
    public int add(User user);
    
    //使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from testuser2 where id=#{id}")
    public int deleteById(int id);
    
    //使用@Update注解指明update方法要执行的SQL
    @Update("update testuser2 set name=#{name},age=#{age} where id=#{id}")
    public int update(User user);
    
    //使用@Select注解指明getById方法要执行的SQL
    @Select("select * from testuser2 where id=#{id}")
    public User getById(int id);
    
    //使用@Select注解指明getAll方法要执行的SQL
    @Select("select * from testuser2")
    public List<User> getAll();
}
