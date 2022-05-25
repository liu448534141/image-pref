package com.liu.imagepref.params.ali.faceBody;

import com.liu.imagepref.dto.tx.AgeInfoDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * @Author: hollow
 * @Date: 2022/5/24 14:52
 */
@Data
@Accessors(chain = true)
public class GenerateHumanAnimeStyleParams {
    /**
     * 图片路径
     */
    @NotBlank(message = "图片路径不能为空")
    private String imageUrl;

    /**
     * 卡通效果配置参数
     * anime：日漫风
     * 3d：3D特效
     * handdrawn：手绘风
     * sketch：铅笔画
     * artstyle：艺术特效
     */
    @NotNull(message = "卡通效果配置参数不为空")
    private String algoType;
}
