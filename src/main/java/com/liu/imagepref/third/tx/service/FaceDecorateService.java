package com.liu.imagepref.third.tx.service;

import com.liu.imagepref.params.tx.faceDecorate.FaceBeautyParams;
import com.liu.imagepref.params.tx.faceDecorate.StyleImageProParams;
import com.liu.imagepref.params.tx.faceDecorate.TryLipstickPicParams;

/**
 * @Author: hollow
 * @Date: 2022/5/24 14:50
 */
public interface FaceDecorateService {
    /**
     * 人脸美颜
     * @param faceBeautyParams
     * @return
     */
    String faceBeauty(FaceBeautyParams faceBeautyParams);

    /**
     * 图片滤镜（高级版）
     * @param styleImageProParams
     * @return
     */
    String styleImagePro(StyleImageProParams styleImageProParams);

    /**
     * 试唇色相关接口
     * @param tryLipstickPicParams
     * @return
     */
    String tryLipstickPic(TryLipstickPicParams tryLipstickPicParams);
}
