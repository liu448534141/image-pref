package com.liu.imagepref.third.tx.service.impl;

import com.liu.imagepref.dto.tx.LipColorInfoDTO;
import com.liu.imagepref.dto.tx.RGBAInfoDTO;
import com.liu.imagepref.dto.tx.FaceRectDTO;
import com.liu.imagepref.params.tx.faceDecorate.FaceBeautyParams;
import com.liu.imagepref.params.tx.faceDecorate.StyleImageProParams;
import com.liu.imagepref.params.tx.faceDecorate.TryLipstickPicParams;
import com.liu.imagepref.property.TxFaceProperty;
import com.liu.imagepref.third.tx.service.FaceDecorateService;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.fmu.v20191213.FmuClient;
import com.tencentcloudapi.fmu.v20191213.models.*;
import com.tencentcloudapi.fmu.v20191213.models.FaceRect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * @Author: hollow
 * @Date: 2022/5/24 14:50
 */
@Service
public class FaceDecorateServiceImpl implements FaceDecorateService {
    @Autowired
    private TxFaceProperty txFaceProperty;

    public FmuClient init() {
        String secretId = txFaceProperty.getSecretId();
        String secretKey = txFaceProperty.getSecretKey();
        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
        Credential cred = new Credential(secretId, secretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("fmu.tencentcloudapi.com");
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        FmuClient client = new FmuClient(cred, "ap-shanghai", clientProfile);
        return client;
    }


    @Override
    public String tryLipstickPic(TryLipstickPicParams tryLipstickPicParams) {
        String result = null;
        try {
            FmuClient client = this.init();

            // 实例化一个请求对象,每个接口都会对应一个request对象
            TryLipstickPicRequest req = new TryLipstickPicRequest();
            req.setUrl(tryLipstickPicParams.getImgUrl());
            ArrayList<LipColorInfoDTO> lipColorInfos = tryLipstickPicParams.getLipColorInfos();
            if (CollectionUtils.isEmpty(lipColorInfos)) {
                return null;
            }

            //组装
            LipColorInfo[] lipColorInfosResult = new LipColorInfo[lipColorInfos.size()];
            for (int i = 0; i < lipColorInfos.size(); i++) {
                RGBAInfoDTO rgbaInfoDTO = lipColorInfos.get(i).getRgbaInfoDTO();
                FaceRectDTO faceRectDTO = lipColorInfos.get(i).getFaceRectDTO();

                LipColorInfo lipColorInfo = new LipColorInfo();
                RGBAInfo rgbaInfo = new RGBAInfo();
                rgbaInfo.setR(rgbaInfoDTO.getR());
                rgbaInfo.setG(rgbaInfoDTO.getG());
                rgbaInfo.setB(rgbaInfoDTO.getB());
                rgbaInfo.setA(rgbaInfoDTO.getA());
                lipColorInfo.setRGBA(rgbaInfo);
                //位置设置
                if (faceRectDTO != null) {
                    FaceRect faceRect = new FaceRect();
                    faceRect.setY(faceRectDTO.getX());
                    faceRect.setX(faceRectDTO.getY());
                    faceRect.setWidth(faceRectDTO.getWidth());
                    faceRect.setHeight(faceRectDTO.getHeight());
                    lipColorInfo.setFaceRect(faceRect);
                }

                lipColorInfo.setModelAlpha(lipColorInfos.get(i).getModelAlpha());
                lipColorInfosResult[i] = lipColorInfo;
            }

            req.setLipColorInfos(lipColorInfosResult);
            req.setRspImgType("url");
            // 返回的resp是一个TryLipstickPicResponse的实例，与请求对象对应
            TryLipstickPicResponse resp = client.TryLipstickPic(req);
            // 输出json格式的字符串回包
            System.out.println(TryLipstickPicResponse.toJsonString(resp));
            result = TryLipstickPicResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return result;
    }

    @Override
    public String styleImagePro(StyleImageProParams styleImageProParams) {
        String result = null;
        try {
            FmuClient client = this.init();

            StyleImageProRequest req = new StyleImageProRequest();
            req.setUrl(styleImageProParams.getImgUrl());
            req.setFilterType(styleImageProParams.getFilterType());
            req.setFilterDegree(styleImageProParams.getFilterDegree());
            req.setRspImgType("url");
            StyleImageProResponse resp = client.StyleImagePro(req);
            System.out.println(StyleImageProResponse.toJsonString(resp));
            result = BeautifyPicResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return result;
    }

    @Override
    public String faceBeauty(FaceBeautyParams faceBeautyParams) {
        String result = null;
        try {
            FmuClient client = this.init();
            // 实例化一个请求对象,每个接口都会对应一个request对象
            BeautifyPicRequest req = new BeautifyPicRequest();
            req.setUrl(faceBeautyParams.getImgUrl());
            req.setWhitening(faceBeautyParams.getWhitening());
            req.setSmoothing(faceBeautyParams.getSmoothing());
            req.setFaceLifting(faceBeautyParams.getFaceLifting());
            req.setEyeEnlarging(faceBeautyParams.getEyeEnlarging());
            req.setRspImgType("url");
            // 返回的resp是一个BeautifyPicResponse的实例，与请求对象对应
            BeautifyPicResponse resp = client.BeautifyPic(req);
            // 输出json格式的字符串回包
            System.out.println(BeautifyPicResponse.toJsonString(resp));
            result = BeautifyPicResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return result;
    }
}
