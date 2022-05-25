package com.liu.imagepref.controller;

import com.liu.imagepref.params.tx.faceChange.ChangeAgePicParams;
import com.liu.imagepref.params.tx.faceDecorate.FaceBeautyParams;
import com.liu.imagepref.params.tx.faceDecorate.StyleImageProParams;
import com.liu.imagepref.params.tx.faceDecorate.TryLipstickPicParams;
import com.liu.imagepref.third.tx.service.FaceChangeService;
import com.liu.imagepref.third.tx.service.FaceDecorateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author YHB0731
 */
@Slf4j
@RestController
@RequestMapping("/tx")
public class TxSdkController {
    @Autowired
    private FaceDecorateService fadeDecorateService;
    @Autowired
    private FaceChangeService faceChangeService;

    @GetMapping("/beauty")
    public String faceBeauty(@RequestBody @Valid FaceBeautyParams faceBeautyParams) {
        return fadeDecorateService.faceBeauty(faceBeautyParams);
    }

    @GetMapping("/styleImage")
    public String styleImagePro(@RequestBody @Valid StyleImageProParams styleImageProParams) {
        return fadeDecorateService.styleImagePro(styleImageProParams);
    }

    @GetMapping("/tryLipstickPic")
    public String tryLipstickPic(@RequestBody @Valid TryLipstickPicParams tryLipstickPicParams) {
        return fadeDecorateService.tryLipstickPic(tryLipstickPicParams);
    }

    @GetMapping("/changeAgePic")
    public String changeAgePic(@RequestBody @Valid ChangeAgePicParams changeAgePicParams) {
        return faceChangeService.changeAgePic(changeAgePicParams);
    }
}
