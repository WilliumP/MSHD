package com.miaosha.demo.dao;


import com.miaosha.demo.domain.Shuyou;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShuyouDao {
    @Insert("INSERT INTO shuyou(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES " +
            "(#{disaster.id},#{disaster.date},#{disaster.location},#{disaster.type}," +
            "#{disaster.grade},#{disaster.picture},#{disaster.note},#{disaster.reporting_unit})")
    void Insert(@Param("disaster") Shuyou disaster);

    @Select("select * from shuyou ORDER BY `key` ASC")
    List<Shuyou> selectAll();

    @Select("select * from shuyou where type = #{type}")
    List<Shuyou> selectByType(@Param("type") String type);

    @Select("select * from shuyou where reporting_unit = #{reporting_unit}")
    List<Shuyou> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from shuyou where `key` = #{key}")
    List<Shuyou> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO shuyou(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    boolean insertForeach(@Param(value = "list") List<Shuyou> list);
    
    @Insert({
        "<script>",
        "INSERT INTO shuyou_b(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    boolean beifen(@Param(value = "list") List<Shuyou> list);
    
    @Delete("delete from shuyou where `key` = #{key}")
    void deleteByKey(@Param("key") String key);
    
    @Delete("delete from shuyou")
    void deleteAll();
    
    @Update("update shuyou SET id=#{disaster.id},date=#{disaster.date},location=#{disaster.location},type=#{disaster.type},grade=#{disaster.grade},"
    		+ "picture=#{disaster.picture},note=#{disaster.note},reporting_unit=#{disaster.reporting_unit} where `key` = #{disaster.key} ")
    void updateByKey(@Param("disaster") Shuyou disaster);
}
