package com.skkj.ws.sdk;

import com.skkj.ws.sdk.config.WsProperties;
import com.skkj.ws.sdk.config.WsRestTemplateConfig;
import com.skkj.ws.sdk.service.WsApiServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
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
    @Bean
    @ConditionalOnMissingBean
    public WsApiServiceImpl wsApiService() {
        WsApiServiceImpl wsApiService = new WsApiServiceImpl();

        return wsApiService;
    }
}
