package com.emosphere.emosphere.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.emosphere.emosphere.domain.RelaxRecord;
import com.emosphere.emosphere.mapper.RelaxRecordMapper;
import com.emosphere.emosphere.utils.BizErrorCodeEnum;
import com.emosphere.emosphere.utils.BizException;
import com.emosphere.emosphere.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/relax_record")
public class RelaxRecordController {
    @Autowired
    RelaxRecordMapper relaxRecordMapper;

    @PostMapping("")
    R addRelaxRecord(@RequestBody RelaxRecord relaxRecord) {
        relaxRecord.setId(null);
        relaxRecord.setCreateDate(new Date());
        relaxRecordMapper.insert(relaxRecord);
        return R.ok("添加成功");
    }

    @DeleteMapping("/id")
    R deleteRelaxRecord(@RequestParam("id") Integer id) {
        relaxRecordMapper.deleteById(id);
        return R.ok("删除成功");
    }

    @GetMapping("/id")
    R getRelaxRecordsById(@RequestParam("id") Integer id) {
        RelaxRecord record = relaxRecordMapper.selectById(id);
        if (record == null) {
            throw new BizException(BizErrorCodeEnum.MOOD_RECORD_DOESNT_EXIST);
        }
        return R.ok("查询成功").put("record", record);
    }

    @GetMapping("/uid")
    R getRelaxRecordsByUid(@RequestParam("uid") Integer uid) {
        QueryWrapper<RelaxRecord> wrapper = new QueryWrapper<RelaxRecord>()
                .eq("uid", uid);
        List<RelaxRecord> records = relaxRecordMapper.selectList(wrapper);
        if (records.isEmpty()) {
            throw new BizException(BizErrorCodeEnum.MOOD_RECORD_DOESNT_EXIST);
        }
        return R.ok("查询成功").put("records", records);
    }
}
