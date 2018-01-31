package org.starlightfinancial.wechat.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by sili.chen on 2017/6/5.
 */
@Component
@ConfigurationProperties(prefix = "wechat")
public class Config {
    private String url;
    private String token;
    private String encodingAesKey;
    private String appId;
    private String appSecret;
    private String mchId;
    private String mchKey;
    private String accessTokenServer;
    private String jsApiTicketServer;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getAccessTokenServer() {
        return accessTokenServer;
    }

    public void setAccessTokenServer(String accessTokenServer) {
        this.accessTokenServer = accessTokenServer;
    }

    public String getJsApiTicketServer() {
        return jsApiTicketServer;
    }

    public void setJsApiTicketServer(String jsApiTicketServer) {
        this.jsApiTicketServer = jsApiTicketServer;
    }
}
