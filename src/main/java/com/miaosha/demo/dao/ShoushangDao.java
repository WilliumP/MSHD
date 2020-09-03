package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.Shoushang;


public interface ShoushangDao {
    @Insert("INSERT INTO shoushang(`id`, `location`, `date`, `number`, `reporting_unit`) VALUES " +
            "(#{ds.id},#{ds.location},#{ds.date}," +
            "#{ds.number},#{ds.reporting_unit})")
    void Insert(@Param("ds") Shoushang ds);

    @Select("select * from shoushang ORDER BY `key` ASC")
    List<Shoushang> selectAll();


    @Select("select * from shoushang where reporting_unit = #{reporting_unit}")
    List<Shoushang> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from shoushang where `key` = #{key}")
    List<Shoushang> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO shoushang(`id`, `location`, `date`, `number`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.location}, #{item.date}, #{item.number}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    boolean insertForeach(@Param(value = "list") List<Shoushang> list);
    
    @Insert({
        "<script>",
        "INSERT INTO shoushang_b(`id`, `location`, `date`, `number`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.location}, #{item.date}, #{item.number}, #{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    boolean beifen(@Param(value = "list") List<Shoushang> list);
    
    @Delete("delete from shoushang where `key` = #{key}")
    void deleteByKey(@Param("key") String key);
    
    @Delete("delete from shoushang")
    void deleteAll();
    
    @Update("update shoushang SET id=#{ds.id},location=#{ds.location},date=#{ds.date},number=#{ds.number},reporting_unit=#{ds.reporting_unit} where `key` = #{ds.key} ")
    void updateByKey(@Param("ds") Shoushang ds);
}
