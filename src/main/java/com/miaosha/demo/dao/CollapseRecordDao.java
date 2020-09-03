package com.miaosha.demo.dao;

import com.miaosha.demo.domain.CollapseRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CollapseRecordDao {
    @Insert("INSERT INTO collapse_record(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES " +
            "(#{cr.id},#{cr.location},#{cr.date}," +
            "#{cr.type},#{cr.status},#{cr.note},#{cr.picture},#{cr.reporting_unit})")
    void Insert(@Param("cr") CollapseRecord cr);

    @Select("select * from collapse_record ORDER BY `key` ASC")
    List<CollapseRecord> selectAll();

    @Select("select * from collapse_record where type = #{type}")
    List<CollapseRecord> selectByType(@Param("type") String type);

    @Select("select * from collapse_record where reporting_unit = #{reporting_unit}")
    List<CollapseRecord> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from collapse_record where `key` = #{key}")
    List<CollapseRecord> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO collapse_record(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    boolean insertForeach(@Param(value = "list") List<CollapseRecord> list);
    
    @Insert({
        "<script>",
        "INSERT INTO collapse_record_b(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    boolean beifen(@Param(value = "list") List<CollapseRecord> list);
    
    @Delete("delete from collapse_record where `key` = #{key}")
    void deleteByKey(@Param("key") String key);
    
    @Delete("delete from collapse_record")
    void deleteAll();
    
    @Update("update collapse_record SET id = #{cr.id},location=#{cr.location},date=#{cr.date},type=#{cr.type},status=#{cr.status},note=#{cr.note},picture=#{cr.picture},reporting_unit=#{cr.reporting_unit} where `key` = #{cr.key} ")
    void updateByKey(@Param("cr") CollapseRecord cr);
}
