package org.starlightfinancial.wechat.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.starlightfinancial.wechat.token.timer.AccessTokenTimer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Timer;

/**
 * Created by sili.chen on 2017/6/5.
 */
@WebListener
public class TokenListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(TokenListener.class);

    private Timer timer = new Timer();

    @Autowired
    AccessTokenTimer accessTokenTimer;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("accessToken监听器启动..........");
        registerAccessTokenTimer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
    }

    /**
     * 注册accessToken定时器
     */
    private void registerAccessTokenTimer() {
        timer.schedule(accessTokenTimer, AccessTokenTimer.DELAY, AccessTokenTimer.PERIOD);
        logger.info("accessToken定时器注册成功，执行间隔为" + AccessTokenTimer.PERIOD);
    }

}
