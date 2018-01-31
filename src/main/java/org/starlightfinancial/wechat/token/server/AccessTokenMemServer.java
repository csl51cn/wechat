package org.starlightfinancial.wechat.token.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.starlightfinancial.wechat.token.AccessToken;

/**
 * 内存中控服务器
 * access_token 中控服务器
 * access_token保存在内存中,过期则自动刷新
 * 此中控服务器采用单例模式，提供单一的访问点，并且持有全局唯一的accessToken对象
 * 采用这种模式而不是AccessToken提供全局唯一访问是
 * 因为AccessToken需要为其他类型的中控服务器提供服务，
 * 比如是定时器刷新存数据库或者文件之类的就不需要提供全局唯一
 * Created by sili.chen on 2017/6/2.
 */
@Component
public class AccessTokenMemServer implements IServer {

    @Autowired
    private AccessToken accessToken;

    private int requestTimes = 1;//token请求失败后重新请求的次数

    /**
     * 通过中控服务器得到token
     *
     * @return
     */
    private AccessToken accessToken() {
        //没有可用的token，则去刷新
        if (!accessToken.isValid()) {
            refresh();
        }
        return this.accessToken;
    }

    /**
     * 通过中控服务器得到accessToken
     *
     * @return
     */
    public String token() {
        return accessToken().getToken();
    }

    /**
     * 服务器刷新token
     */
    private void refresh() {
        for (int i = 0; i < requestTimes; i++) {
            //请求成功则退出
            if (accessToken.request())
                break;
        }
    }
}
