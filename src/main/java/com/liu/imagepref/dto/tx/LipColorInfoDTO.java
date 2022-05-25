package com.liu.imagepref.dto.tx;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Author: hollow
 * @Date: 2022/5/24 16:16
 */
@Data
public class LipColorInfoDTO {
    /**
     * rgb
     */
    @NotNull(message = "rgba不为空")
    private RGBAInfoDTO rgbaInfoDTO;

    /**
     * 人脸框位置
     */
    private FaceRectDTO faceRectDTO;

    /**
     * 涂妆浓淡[0,100]。建议取值50。本参数仅控制ModelId对应的涂妆浓淡。
     */
    @Range(min = 0,max = 100,message = "必须在0-100之间")
    private Long modelAlpha;
}
