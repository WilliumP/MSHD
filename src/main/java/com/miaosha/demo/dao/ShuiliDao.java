package com.miaosha.demo.dao;


import com.miaosha.demo.domain.Shuili;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShuiliDao {
    @Insert("INSERT INTO shuili(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES " +
            "(#{disaster.id},#{disaster.date},#{disaster.location},#{disaster.type}," +
            "#{disaster.grade},#{disaster.picture},#{disaster.note},#{disaster.reporting_unit})")
    void Insert(@Param("disaster") Shuili disaster);

    @Select("select * from shuili ORDER BY `key` ASC")
    List<Shuili> selectAll();

    @Select("select * from shuili where type = #{type}")
    List<Shuili> selectByType(@Param("type") String type);

    @Select("select * from shuili where reporting_unit = #{reporting_unit}")
    List<Shuili> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from shuili where `key` = #{key}")
    List<Shuili> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO shuili(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    boolean insertForeach(@Param(value = "list") List<Shuili> list);
    
    @Insert({
        "<script>",
        "INSERT INTO shuili_b(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    boolean beifen(@Param(value = "list") List<Shuili> list);
    
    @Delete("delete from shuili where `key` = #{key}")
    void deleteByKey(@Param("key") String key);
    
    @Delete("delete from shuili")
    void deleteAll();
    
    @Update("update shuili SET id=#{disaster.id},date=#{disaster.date},location=#{disaster.location},type=#{disaster.type},grade=#{disaster.grade},"
    		+ "picture=#{disaster.picture},note=#{disaster.note},reporting_unit=#{disaster.reporting_unit} where `key` = #{disaster.key} ")
    void updateByKey(@Param("disaster") Shuili disaster);
}
