package com.emosphere.emosphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emosphere.emosphere.domain.MoodRecord;
import com.emosphere.emosphere.service.MoodRecordService;
import com.emosphere.emosphere.mapper.MoodRecordMapper;
import com.emosphere.emosphere.utils.BizErrorCodeEnum;
import com.emosphere.emosphere.utils.BizException;
import com.emosphere.emosphere.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author eamon
 * @description 针对表【mood_record】的数据库操作Service实现
 * @createDate 2023-11-08 18:34:10
 */
@Service
public class MoodRecordServiceImpl extends ServiceImpl<MoodRecordMapper, MoodRecord>
        implements MoodRecordService {

    @Autowired
    MoodRecordMapper moodRecordMapper;

    @Override
    public List<MoodRecord> getRecentMoodRecords(int uid, int nums) {
        QueryWrapper<MoodRecord> wrapper = new QueryWrapper<MoodRecord>()
                .eq("uid", uid) // 根据uid查询
                .orderByDesc("create_date") // 按时间降序排序
                .last("LIMIT 3"); // 限制返回结果为3条
        return moodRecordMapper.selectList(wrapper);
    }

    @Override
    public MoodRecord getMoodRecordById(int id) {
        return moodRecordMapper.selectById(id);
    }

    @Override
    public MoodRecord getMoodRecordByDay(int uid, Date date) {
        DateUtil util = new DateUtil();
        QueryWrapper<MoodRecord> queryWrapper = new QueryWrapper<MoodRecord>()
                .eq("uid", uid) // 根据uid查询
                .between("create_date", util.getDayStart(date), util.getDayEnd(date)); // 根据时间范围查询
        List<MoodRecord> result = moodRecordMapper.selectList(queryWrapper);
        //说明改天存在多条记录
        if (result != null && result.size() > 1) {
            throw new BizException(BizErrorCodeEnum.DUPLICATED_RECORD);
        }
        if (result == null) {
            throw new BizException(BizErrorCodeEnum.MOOD_RECORD_DOESNT_EXIST);
        }
        return result.get(0);
    }

    @Override
    public List<MoodRecord> getMoodRecordByMonth(int uid, Date date) {
        DateUtil dateUtil = new DateUtil();
        //根据时间范围查询
        return moodRecordMapper.selectBasicInfo(uid,
                dateUtil.getMonthStart(date),
                dateUtil.getMonthEnd(date));
    }

    @Override
    public void deleteMoodRecordById(int id) {
        int status = moodRecordMapper.deleteById(id);
        if (status != 1) {
            throw new BizException(BizErrorCodeEnum.MOOD_RECORD_DOESNT_EXIST);
        }
    }

    @Override
    public void addMoodRecord(MoodRecord moodRecord) {
        moodRecord.setId(null);
        moodRecord.setCreateDate(new Date());
        DateUtil util = new DateUtil();
        Date now = new Date();
        QueryWrapper<MoodRecord> queryWrapper = new QueryWrapper<MoodRecord>()
                .eq("uid", moodRecord.getUid()) // 根据uid查询
                .between("create_date", util.getDayStart(now), util.getDayEnd(now)); // 根据时间范围查询
        Long counts = moodRecordMapper.selectCount(queryWrapper);
        if (counts > 0) {
            throw new BizException(BizErrorCodeEnum.DUPLICATED_RECORD);
        }
        moodRecordMapper.insert(moodRecord);
    }
}




