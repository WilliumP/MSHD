package com.miaosha.demo.dao;

import com.miaosha.demo.domain.DisasterRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DisasterRequestDao {
    @Insert("INSERT INTO disaster_request(`id`, `date`, `disaster_type`, `status`, `o_url`, `request_unit`) VALUES " +
            "(#{dr.id},#{dr.date},#{dr.disaster_type},#{dr.status}," +
            "#{dr.o_url},#{dr.request_unit})")
    void Insert(@Param("dr") DisasterRequest dr);

    @Select("select * from disaster_request ORDER BY `date` ASC")
    List<DisasterRequest> selectAll();

    @Select("select * from disaster_request where `key` = #{key}")
    List<DisasterRequest> selectByKey(@Param("key") String key);
    
    @Select("select * from disaster_request where `status` = 0 ORDER BY `date` ASC")
    List<DisasterRequest> selectNotSend();
    
    @Select("select * from disaster_request where `status` = 1 ORDER BY `date` ASC")
    List<DisasterRequest> selectSended();
    
    @Delete("delete from disaster_request where `key` = #{key}")
    void deleteByKey(@Param("key") String key);
    
    @Update("update disaster_request SET status=#{dr.status} where `key` = #{dr.key} ")
    void updateByKey(@Param("dr") DisasterRequest dr);
    
    @Update("update disaster_request SET status=1 where `key` = #{dr.key} ")
    void send(@Param("dr") DisasterRequest dr);
}
