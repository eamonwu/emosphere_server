package com.emosphere.emosphere.service;

import com.emosphere.emosphere.config.CloudStorageConfig;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @program: Springboot Qiniu
 * @description:
 * @author: CodeDuck
 * @create: 2020-07-30 19:48
 **/
public abstract class UploadImageService {

    protected CloudStorageConfig config;

    public abstract String uploadQNImg(InputStream file, String path);
}