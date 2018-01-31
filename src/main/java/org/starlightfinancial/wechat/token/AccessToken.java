package org.starlightfinancial.wechat.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.starlightfinancial.wechat.common.Config;


/**
 * Created by sili.chen on 2017/6/2.
 */
@Component
public class AccessToken extends Token {

    private static final Logger logger = LoggerFactory.getLogger(AccessToken.class);
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

    @Autowired
    Config config;

    @Override
    protected String tokenName() {
        return "access_token";
    }

    @Override
    protected String expiresInName() {
        return "expires_in";
    }

    /**
     * 组织accesstoken的请求utl
     */
    @Override
    protected String accessTokenUrl() {
        String appId = config.getAppId();
        String appSecret = config.getAppSecret();
        String url = ACCESS_TOKEN_URL + "&appid=" + appId + "&secret=" + appSecret;
        logger.info("创建获取access_token url");
        return url;
    }
}
