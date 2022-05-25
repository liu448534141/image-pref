package com.liu.imagepref.params.ali.faceBody;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: hollow
 * @Date: 2022/5/24 14:52
 * 人像素描风格化
 */
@Data
@Accessors(chain = true)
public class GenerateHumanSketchStyleParams {
    /**
     * 图片路径
     */
    @NotBlank(message = "图片路径不能为空")
    private String imageUrl;

    /**
     * 图像返回形式
     */
    private String returnType;
}
