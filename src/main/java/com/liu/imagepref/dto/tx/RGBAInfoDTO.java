package com.liu.imagepref.dto.tx;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @Author: hollow
 * @Date: 2022/5/24 16:16
 * RGBA通道信息
 */
@Data
public class RGBAInfoDTO {
    /**
     * R通道数值。[0,255]。
     */
    @Range(min = 0,max = 255,message = "必须在0-255之间")
    private Long r;

    /**
     * G通道数值。[0,255]。
     */
    @Range(min = 0,max = 255,message = "必须在0-255之间")
    private Long g;

    /**
     * B通道数值。[0,255]。
     */
    @Range(min = 0,max = 255,message = "必须在0-255之间")
    private Long b;

    /**
     * A通道数值。[0,100]。建议取值50。
     */
    @Range(min = 0,max = 100,message = "必须在0-100之间")
    private Long a;
}
