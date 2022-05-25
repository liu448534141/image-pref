package com.liu.imagepref.dto.tx;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @Author: hollow
 * @Date: 2022/5/24 16:16
 * 人脸变年龄信息
 */
@Data
public class AgeInfoDTO {
    /**
     * 变化到的人脸年龄 [10,80]。
     */
    @Range(min = 10, max = 80, message = "必须在10-80之间")
    private Long age;

    /**
     * 人脸框位置
     */
    private FaceRectDTO faceRect;


}
