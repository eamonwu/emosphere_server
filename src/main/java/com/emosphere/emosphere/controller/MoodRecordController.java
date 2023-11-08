package com.emosphere.emosphere.controller;


import com.emosphere.emosphere.domain.MoodRecord;
import com.emosphere.emosphere.service.MoodRecordService;
import com.emosphere.emosphere.utils.BizErrorCodeEnum;
import com.emosphere.emosphere.utils.BizException;
import com.emosphere.emosphere.utils.R;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mood_record")
@Validated
public class MoodRecordController {

    @Autowired
    MoodRecordService moodRecordService;

    @GetMapping("")
    R getRecentMoodRecords(
            @NotNull(message = "查询数量不能为空")
            @RequestParam("nums") Integer nums,
            @NotNull(message = "用户id不能为空")
            @RequestParam("uid") Integer uid) {
        List<MoodRecord> records = moodRecordService.getRecentMoodRecords(uid, nums);
        return R.ok("查询成功").put("records", records);
    }

    @GetMapping("/id")
    R getMoodRecordById(
            @NotNull(message = "id不能为空")
            @RequestParam("id") Integer id) {
        return R.ok("查询成功").put("record", moodRecordService.getMoodRecordById(id));
    }


    @GetMapping("/day")
    R getMoodRecordByDay(
            @NotNull(message = "时间不能为空")
            @RequestParam("date") String dateStr,
            @NotNull(message = "用户id不能为空")
            @RequestParam("uid") Integer uid) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 定义日期格式
        Date date;
        try {
            date = format.parse(dateStr); // 将字符串转换为日期
        } catch (ParseException e) {
            throw new BizException(BizErrorCodeEnum.PARAM_MISTAKE);
        }
        MoodRecord moodRecord = moodRecordService.getMoodRecordByDay(uid, date);
        return R.ok("查询成功").put("record", moodRecord);
    }

    @GetMapping("/month")
    R getMoodRecordByDate(
            @NotNull(message = "时间不能为空")
            @RequestParam("date") String dateStr,
            @NotNull(message = "用户id不能为空")
            @RequestParam("uid") Integer uid) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 定义日期格式
        Date date;
        try {
            date = format.parse(dateStr); // 将字符串转换为日期
        } catch (ParseException e) {
            throw new BizException(BizErrorCodeEnum.PARAM_MISTAKE);
        }
        List<MoodRecord> moodRecords = moodRecordService.getMoodRecordByMonth(uid, date);
        return R.ok("查询成功").put("records", moodRecords);
    }

    @PostMapping("")
    R addMoodRecord(@RequestBody MoodRecord moodRecord) {
        moodRecordService.addMoodRecord(moodRecord);
        return R.ok("保存成功");
    }

    @DeleteMapping("/{id}")
    R deleteMoodRecordById(@PathVariable("id") Integer id) {
        moodRecordService.deleteMoodRecordById(id);
        return R.ok("删除成功");
    }
}
