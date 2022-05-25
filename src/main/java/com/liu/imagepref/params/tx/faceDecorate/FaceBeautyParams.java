package com.liu.imagepref.params.tx.faceDecorate;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @Author: hollow
 * @Date: 2022/5/24 14:52
 */
@Data
@Accessors(chain = true)
public class FaceBeautyParams {
    /**
     * 图片路径
     */
    @NotBlank(message = "图片路径不能为空")
    private String imgUrl;

    /**
     * 美白程度，取值范围[0,100]。0不美白，100代表最高程度。默认值30。
     */
    @Range(min = 0,max = 100,message = "必须在0-100之间")
    private Long whitening;

    /**
     * 磨皮程度，取值范围[0,100]。0不磨皮，100代表最高程度。默认值10。
     */
    @Range(min = 0,max = 100,message = "必须在0-100之间")
    private Long smoothing;

    /**
     * 瘦脸程度，取值范围[0,100]。0不瘦脸，100代表最高程度。默认值70。
     */
    @Range(min = 0,max = 100,message = "必须在0-100之间")
    private Long faceLifting;

    /**
     * 大眼程度，取值范围[0,100]。0不大眼，100代表最高程度。默认值70。
     */
    @Range(min = 0,max = 100,message = "必须在0-100之间")
    private Long eyeEnlarging;
}
