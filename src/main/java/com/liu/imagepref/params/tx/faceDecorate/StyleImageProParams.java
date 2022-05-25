package com.liu.imagepref.params.tx.faceDecorate;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @Author: hollow
 * @Date: 2022/5/24 14:52
 */
@Data
@Accessors(chain = true)
public class StyleImageProParams {
    /**
     * 图片路径
     */
    @NotBlank(message = "图片路径不能为空")
    private String imgUrl;

    /**
     * 滤镜类型
     */
    @Range(min = 1,max = 78,message = "必须在1-78之间")
    private Long filterType;

    /**
     *滤镜效果，取值[0,100]，0表示无效果，100表示满滤镜效果。默认值为80。
     */
    @Range(min = 0,max = 100,message = "必须在0-100之间")
    private Long filterDegree;


}
