package com.liu.imagepref.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YHB0731
 */
@Slf4j
@RestController
@RequestMapping("/health-check")
public class HealthController {

    @GetMapping
    public String health() {
        return "成功";
    }


}
