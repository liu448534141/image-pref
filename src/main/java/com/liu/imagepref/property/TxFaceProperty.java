package com.liu.imagepref.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jon
 */
@Data
@Configuration("TxFaceProperty")
@ConfigurationProperties(prefix = "tx.face")
public class TxFaceProperty {
    private String secretId;
    private String secretKey;
}
