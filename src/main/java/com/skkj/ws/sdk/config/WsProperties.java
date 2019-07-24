package com.skkj.ws.sdk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: yun
 * @createdOn: 2019-07-15 10:45.
 */

@Component
@ConfigurationProperties(prefix = "ws-api")
public class WsProperties {
    private String host;
    private String apiKey;
    private String accessKey;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}