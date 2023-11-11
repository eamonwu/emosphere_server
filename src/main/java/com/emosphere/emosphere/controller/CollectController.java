package com.emosphere.emosphere.controller;


import com.emosphere.emosphere.domain.Collect;
import com.emosphere.emosphere.service.CollectService;
import com.emosphere.emosphere.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    CollectService collectService;

    @GetMapping("")
    R getCollectsByUid(@RequestParam("currentPage")Integer currentPage,
                       @RequestParam("pageSize")Integer pageSize,
                       @RequestParam("uid") Integer uid
                       ){
        List<Collect> collects = collectService.getCollectsByUid(uid,pageSize,currentPage);
        return R.ok("查询成功").put("collects",collects);
    }

    @DeleteMapping("")
    R deleteCollect(@RequestParam("id")Integer id){
        collectService.deleteCollect(id);
        return R.ok("删除成功");
    }

    @PostMapping("")
    R addCollect(@RequestBody Collect collect){
        collectService.addCollect(collect);
        return R.ok("添加成功");
    }


}
