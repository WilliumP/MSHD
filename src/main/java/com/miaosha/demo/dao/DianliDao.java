package com.miaosha.demo.dao;

import com.miaosha.demo.domain.Dianli;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DianliDao {
    @Insert("INSERT INTO dianli(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES " +
            "(#{disaster.id},#{disaster.date},#{disaster.location},#{disaster.type}," +
            "#{disaster.grade},#{disaster.picture},#{disaster.note},#{disaster.reporting_unit})")
    void Insert(@Param("disaster") Dianli disaster);

    @Select("select * from dianli ORDER BY `key` ASC")
    List<Dianli> selectAll();

    @Select("select * from dianli where type = #{type}")
    List<Dianli> selectByType(@Param("type") String type);

    @Select("select * from dianli where reporting_unit = #{reporting_unit}")
    List<Dianli> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from dianli where `key` = #{key}")
    List<Dianli> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO dianli(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    boolean insertForeach(@Param(value = "list") List<Dianli> list);
    
    @Insert({
        "<script>",
        "INSERT INTO dianli_b(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    boolean beifen(@Param(value = "list") List<Dianli> list);
    
    @Delete("delete from dianli where `key` = #{key}")
    void deleteByKey(@Param("key") String key);
    
    @Delete("delete from dianli")
    void deleteAll();
    
    @Update("update dianli SET id=#{disaster.id},date=#{disaster.date},location=#{disaster.location},type=#{disaster.type},grade=#{disaster.grade},"
    		+ "picture=#{disaster.picture},note=#{disaster.note},reporting_unit=#{disaster.reporting_unit} where `key` = #{disaster.key} ")
    void updateByKey(@Param("disaster") Dianli disaster);
}
