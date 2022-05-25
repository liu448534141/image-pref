package com.liu.imagepref.dto.tx;

import lombok.Data;

/**
 * @Author: hollow
 * @Date: 2022/5/24 16:16
 * 人脸变年龄信息
 */
@Data
public class FaceRectDTO {
    /**
     * 人脸框左上角纵坐标。
     */
    private Long y;

    /**
     * 人脸框左上角横坐标。
     */
    private Long x;

    /**
     * 人脸框宽度。
     */
    private Long width;

    /**
     * 人脸框高度。
     */
    private Long height	;
}
