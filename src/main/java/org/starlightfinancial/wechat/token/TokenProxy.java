package org.starlightfinancial.wechat.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.starlightfinancial.wechat.token.server.AccessTokenMemServer;

/**
 * AccessToken代理
 * 所有获取accessToken的地方都通过此代理获得
 * 获得方法String token = AccessTokenProxy.token()
 * Created by sili.chen on 2017/6/2.
 */
@Component
public class TokenProxy {

    @Autowired
    AccessTokenMemServer accessTokenMemServer;


    /**
     * 通过代理得到accessToken的串
     */
    public String accessToken() {
        return accessTokenMemServer.token();
    }
}
