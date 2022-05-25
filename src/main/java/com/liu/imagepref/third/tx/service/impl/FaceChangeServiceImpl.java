package com.liu.imagepref.third.tx.service.impl;

import com.liu.imagepref.dto.tx.AgeInfoDTO;
import com.liu.imagepref.dto.tx.FaceRectDTO;
import com.liu.imagepref.params.tx.faceChange.ChangeAgePicParams;
import com.liu.imagepref.property.TxFaceProperty;
import com.liu.imagepref.third.tx.service.FaceChangeService;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.ft.v20200304.FtClient;
import com.tencentcloudapi.ft.v20200304.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * @Author: hollow
 * @Date: 2022/5/24 16:51
 */
@Service
public class FaceChangeServiceImpl implements FaceChangeService {
    @Autowired
    private TxFaceProperty txFaceProperty;

    public FtClient init() {
        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
        Credential cred = new Credential(txFaceProperty.getSecretId(), txFaceProperty.getSecretKey());
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("ft.tencentcloudapi.com");
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        FtClient client = new FtClient(cred, "ap-shanghai", clientProfile);
        return client;
    }

    @Override
    public String changeAgePic(ChangeAgePicParams changeAgePicParams) {
        String result = null;
        try {
            FtClient client = this.init();

            // 实例化一个请求对象,每个接口都会对应一个request对象
            ChangeAgePicRequest req = new ChangeAgePicRequest();
            req.setUrl(changeAgePicParams.getImgUrl());

            ArrayList<AgeInfoDTO> ageInfos = changeAgePicParams.getAgeInfos();
            if (CollectionUtils.isEmpty(ageInfos)) {
                return null;
            }

            AgeInfo[] ageInfosResult = new AgeInfo[ageInfos.size()];
            for (int i = 0; i < ageInfos.size(); i++) {
                FaceRectDTO faceRectDTO = ageInfos.get(i).getFaceRect();

                AgeInfo ageInfo = new AgeInfo();
                ageInfo.setAge(ageInfos.get(i).getAge());
                if (faceRectDTO != null) {
                    FaceRect faceRect = new FaceRect();
                    faceRect.setY(faceRectDTO.getX());
                    faceRect.setX(faceRectDTO.getY());
                    faceRect.setWidth(faceRectDTO.getWidth());
                    faceRect.setHeight(faceRectDTO.getHeight());
                    ageInfo.setFaceRect(faceRect);
                }

                ageInfosResult[i] = ageInfo;
            }

            req.setAgeInfos(ageInfosResult);

            req.setRspImgType("url");

            // 返回的resp是一个ChangeAgePicResponse的实例，与请求对象对应
            ChangeAgePicResponse resp = client.ChangeAgePic(req);
            // 输出json格式的字符串回包
            System.out.println(ChangeAgePicResponse.toJsonString(resp));
            result = ChangeAgePicResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return result;
    }
}
