package com.miaosha.demo.dao;

import com.miaosha.demo.domain.Disaster;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DisasterDao {
    @Insert("INSERT INTO comm_disaster(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES " +
            "(#{disaster.id},#{disaster.date},#{disaster.location},#{disaster.type}," +
            "#{disaster.grade},#{disaster.picture},#{disaster.note},#{disaster.reporting_unit})")
    void Insert(@Param("disaster") Disaster disaster);

    @Select("select * from comm_disaster ORDER BY `key` ASC")
    List<Disaster> selectAll();

    @Select("select * from comm_disaster where type = #{type}")
    List<Disaster> selectByType(@Param("type") String type);

    @Select("select * from comm_disaster where reporting_unit = #{reporting_unit}")
    List<Disaster> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from comm_disaster where `key` = #{key}")
    List<Disaster> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO comm_disaster(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    boolean insertForeach(@Param(value = "list") List<Disaster> list);
    
    @Insert({
        "<script>",
        "INSERT INTO comm_disaster_b(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    boolean beifen(@Param(value = "list") List<Disaster> list);
    
    @Delete("delete from comm_disaster where `key` = #{key}")
    void deleteByKey(@Param("key") String key);
    
    @Delete("delete from comm_disaster")
    void deleteAll();
    
    @Update("update comm_disaster SET id=#{disaster.id},date=#{disaster.date},location=#{disaster.location},type=#{disaster.type},grade=#{disaster.grade},"
    		+ "picture=#{disaster.picture},note=#{disaster.note},reporting_unit=#{disaster.reporting_unit} where `key` = #{disaster.key} ")
    void updateByKey(@Param("disaster") Disaster disaster);
}
