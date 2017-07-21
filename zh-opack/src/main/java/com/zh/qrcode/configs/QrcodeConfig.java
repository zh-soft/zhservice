package com.zh.qrcode.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Lait on 2017/7/20.
 */
@Data
@Configuration
public class QrcodeConfig {

    @Value("${qrcode.width}")
    private int qrcodeWidth = 400;

    @Value("${qrcode.height}")
    private int qrcodeHeight = 400;

    @Value("${qrcode.storePath}")
    private String qrcodeStorePath;

    @Value("${qrcode.fileExt}")
    private String qrcodeExt;
}
