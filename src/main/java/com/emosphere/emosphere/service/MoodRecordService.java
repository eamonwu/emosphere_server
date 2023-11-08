package com.emosphere.emosphere.service;

import com.emosphere.emosphere.domain.MoodRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
* @author eamon
* @description 针对表【mood_record】的数据库操作Service
* @createDate 2023-11-08 18:34:10
*/
public interface MoodRecordService extends IService<MoodRecord> {

    List<MoodRecord> getRecentMoodRecords(int uid,int nums);

    MoodRecord getMoodRecordById(int id);

    MoodRecord getMoodRecordByDay(int uid,Date date);
    List<MoodRecord> getMoodRecordByMonth(int uid,Date date);

    Integer deleteMoodRecordById(int id);

    Integer addMoodRecord(MoodRecord moodRecord);
}
