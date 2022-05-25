package com.liu.imagepref.params.tx.faceChange;

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
public class ChangeAgePicParams {
    /**
     * 图片路径
     */
    @NotBlank(message = "图片路径不能为空")
    private String imgUrl;

    /**
     * 人脸变老变年轻信息。 您可以输入最多3个 AgeInfo 来实现给一张图中的最多3张人脸变老变年轻。
     */
    @NotNull(message = "人脸信息不为空")
    @Size(max = 3,message = "最多识别三张人脸")
    private ArrayList<AgeInfoDTO> ageInfos;
}
