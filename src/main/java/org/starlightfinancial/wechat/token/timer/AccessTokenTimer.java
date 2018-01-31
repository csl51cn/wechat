package org.starlightfinancial.wechat.token.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.starlightfinancial.wechat.token.server.AccessTokenMemServer;

import java.util.TimerTask;

/**
 * Created by sili.chen on 2017/6/5.
 */
@Component
public class AccessTokenTimer extends TimerTask {

    private static Logger logger = LoggerFactory.getLogger(AccessTokenTimer.class);

    @Autowired
    AccessTokenMemServer accessTokenMemServer;

    //accessToken有效期7200秒,提前200秒请求新的token
    public static final long PERIOD = 7000 * 1000;
    public static final long DELAY = 0; //此任务的延迟时间为0，即立即执行

    @Override
    public void run() {
        logger.info("accessToken 定时任务启动，获取新的accessToken");
        accessTokenMemServer.token();
    }
}
