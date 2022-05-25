package com.liu.imagepref.third.tx.service;


import com.liu.imagepref.params.tx.faceChange.ChangeAgePicParams;

/**
 * @Author: hollow
 * @Date: 2022/5/24 14:50
 */
public interface FaceChangeService {
    /**
     * 人脸年龄变化
     * @param changeAgePicParams
     * @return
     */
    String changeAgePic(ChangeAgePicParams changeAgePicParams);
}
