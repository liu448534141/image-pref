package com.liu.imagepref.params.tx.faceDecorate;

import com.liu.imagepref.dto.tx.LipColorInfoDTO;
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
public class TryLipstickPicParams {
    /**
     * 图片路径
     */
    @NotBlank(message = "图片路径不能为空")
    private String imgUrl;

    /**
     * 唇色信息
     */
    @NotNull(message = "唇色信息不为空")
    @Size(max = 3,message = "唇色最多设置3位")
    private ArrayList<LipColorInfoDTO> lipColorInfos;
}
