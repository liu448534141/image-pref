package com.liu.imagepref.params.ali.faceBody;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: hollow
 * @Date: 2022/5/24 14:52
 */
@Data
@Accessors(chain = true)
public class FaceTidyupParams {
    /**
     * 图片路径
     */
    @NotBlank(message = "图片路径不能为空")
    private String imageUrl;

    /**
     * 美型部位
     */
    @Range(min = 0, max = 21, message = "无此美型部位")
    private Integer shapeType;

    /**
     * 美型强度
     */
    @Range(min = 0, max = 1, message = "强度范围在0-1之间")
    private Float strength;
}
