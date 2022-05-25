package com.liu.imagepref.third.ali.service.impl;

import com.liu.imagepref.params.ali.faceBody.FaceTidyupParams;
import com.liu.imagepref.params.ali.faceBody.GenerateHumanAnimeStyleParams;
import com.liu.imagepref.params.ali.faceBody.GenerateHumanSketchStyleParams;
import com.liu.imagepref.property.AliFaceProperty;
import com.liu.imagepref.third.ali.service.FaceBodyService;
import com.aliyun.facebody20191230.*;
import com.aliyun.facebody20191230.models.*;
import com.aliyun.teaopenapi.models.*;
import com.aliyun.teautil.models.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hollow
 * @Date: 2022/5/25 10:35
 */
public class FaceBodyServiceImpl implements FaceBodyService {
    @Autowired
    private AliFaceProperty aliFaceProperty;

    @Override
    public String generateHumanAnimeStyle(GenerateHumanAnimeStyleParams params) throws Exception {
        Client client = createClient();
        GenerateHumanAnimeStyleRequest generateHumanAnimeStyleRequest = new GenerateHumanAnimeStyleRequest()
                .setImageURL(params.getImageUrl())
                .setAlgoType(params.getAlgoType());
        RuntimeOptions runtime = new RuntimeOptions();
        // 复制代码运行请自行打印 API 的返回值
        client.generateHumanAnimeStyleWithOptions(generateHumanAnimeStyleRequest, runtime);
        return null;
    }

    @Override
    public String faceTidyup(FaceTidyupParams params) throws Exception {
        Client client = createClient();
        FaceTidyupRequest faceTidyupRequest = new FaceTidyupRequest()
                .setImageURL(params.getImageUrl())
                .setShapeType(params.getShapeType())
                .setStrength(params.getStrength());
        RuntimeOptions runtime = new RuntimeOptions();
        // 复制代码运行请自行打印 API 的返回值
        client.faceTidyupWithOptions(faceTidyupRequest, runtime);
        return null;
    }

    @Override
    public String generateHumanSketchStyle(GenerateHumanSketchStyleParams params) throws Exception {
        Client client = createClient();
        GenerateHumanSketchStyleRequest generateHumanSketchStyleRequest = new GenerateHumanSketchStyleRequest()
                .setImageURL(params.getImageUrl())
                .setReturnType(params.getReturnType());
        RuntimeOptions runtime = new RuntimeOptions();
        // 复制代码运行请自行打印 API 的返回值
        client.generateHumanSketchStyleWithOptions(generateHumanSketchStyleRequest, runtime);
        return null;
    }

    /**
     * 使用AK&SK初始化账号Client
     *
     * @return Client
     * @throws Exception
     */
    public Client createClient() throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(aliFaceProperty.getSecretId())
                // 您的AccessKey Secret
                .setAccessKeySecret(aliFaceProperty.getSecretKey());
        // 访问的域名
        config.endpoint = "facebody.cn-shanghai.aliyuncs.com";
        return new Client(config);
    }

}
