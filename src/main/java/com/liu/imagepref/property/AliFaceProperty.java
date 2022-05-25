package com.liu.imagepref.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jon
 */
@Data
@Configuration("AliFaceProperty")
@ConfigurationProperties(prefix = "ali.face")
public class AliFaceProperty {
    private String secretId;
    private String secretKey;
}
