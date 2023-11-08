package com.emosphere.emosphere.mapper;

import com.emosphere.emosphere.domain.MoodRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
* @author eamon
* @description 针对表【mood_record】的数据库操作Mapper
* @createDate 2023-11-08 18:34:10
* @Entity com.emosphere.emosphere.domain.MoodRecord
*/
public interface MoodRecordMapper extends BaseMapper<MoodRecord> {
    @Select("SELECT id,uid, mood,create_date FROM mood_record " +
            "WHERE uid = #{uid} " +
            "AND create_date BETWEEN #{startTime} AND #{endTime} " +
            "ORDER BY create_date DESC")
    List<MoodRecord> selectBasicInfo(@Param("uid") int uid,
                                     @Param("startTime") Date startTime,
                                     @Param("endTime") Date endTime);
}




