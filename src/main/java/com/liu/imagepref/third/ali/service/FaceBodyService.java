package com.liu.imagepref.third.ali.service;


import com.liu.imagepref.params.ali.faceBody.FaceTidyupParams;
import com.liu.imagepref.params.ali.faceBody.GenerateHumanAnimeStyleParams;
import com.liu.imagepref.params.ali.faceBody.GenerateHumanSketchStyleParams;
import com.liu.imagepref.params.tx.faceChange.ChangeAgePicParams;

/**
 * @Author: hollow
 * @Date: 2022/5/24 14:50
 */
public interface FaceBodyService {

    /**
     * 人物动漫化
     * @param params
     * @return
     * @throws Exception
     */
    String generateHumanAnimeStyle(GenerateHumanAnimeStyleParams params) throws Exception;

    /**
     * 人脸美型
     * @param params
     * @return
     * @throws Exception
     */
    String faceTidyup(FaceTidyupParams params) throws Exception;


    /**
     * 人像素描风格化
     * @param params
     * @return
     * @throws Exception
     */
    String generateHumanSketchStyle(GenerateHumanSketchStyleParams params) throws Exception;


}
