package com.skkj.ws.sdk;

import com.skkj.ws.sdk.config.WsProperties;
import com.skkj.ws.sdk.config.WsRestTemplateConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: yun
 * @createdOn: 2019-05-30 13:05.
 */

@Configuration
@EnableConfigurationProperties(WsProperties.class)
@Import({WsRestTemplateConfig.class})
public class WsSdkAutoConfiguration {
}
