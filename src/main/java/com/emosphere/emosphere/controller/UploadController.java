package com.emosphere.emosphere.controller;

import com.emosphere.emosphere.service.UploadImageService;
import com.emosphere.emosphere.utils.R;
import com.emosphere.emosphere.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: SpringBoot Qiniu
 * @description:
 * @author: CodeDuck
 * @create: 2020-07-30 16:12
 **/
@Slf4j
@RestController
@RequestMapping("/qiniu")
public class UploadController {

    @Autowired
    UploadImageService uploadImageService;

    @PostMapping(value = "/file")
    private R upLoadImage(@RequestParam("file") MultipartFile file) throws IOException {

        // 获取文件的名称
        String fileName = file.getOriginalFilename();

        // 使用工具类根据上传文件生成唯一图片名称
        assert fileName != null;
        String imgName = StringUtil.getRandomImgName(fileName);

        if (!file.isEmpty()) {

            InputStream inputStream = file.getInputStream();

            String path = uploadImageService.uploadQNImg(inputStream, imgName);
            System.out.print("七牛云返回的图片链接:" + path);
            return R.ok("图片上传成功").put("url",path);
        }
        return R.error("上传失败");
    }

}