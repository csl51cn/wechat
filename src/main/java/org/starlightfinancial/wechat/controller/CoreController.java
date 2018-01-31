package org.starlightfinancial.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.starlightfinancial.wechat.common.ValidateSignature;
import org.starlightfinancial.wechat.service.CoreService;
import org.starlightfinancial.wechat.user.AccountManager;
import org.starlightfinancial.wechat.user.Qrcode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sili.chen on 2017/6/8.
 */
@Controller
public class CoreController {

    @Autowired
    CoreService coreService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    @ResponseBody
    String checkSignature(@RequestParam(value = "signature", required = false) String signature,
                          @RequestParam(value = "timestamp", required = false) String timestamp,
                          @RequestParam(value = "nonce", required = false) String nonce,
                          @RequestParam(value = "echostr", required = false) String echostr, Model model) {
        ValidateSignature validateSignature = new ValidateSignature(signature, timestamp, nonce, echostr);
        if (validateSignature.check())
            return echostr;
        return echostr;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    @ResponseBody
    String post(HttpServletRequest req, HttpServletResponse res) {
        coreService.setRequest(req);
        return coreService.execute();
    }

    @RequestMapping(path = "/getQrcode", method = RequestMethod.GET)
    @ResponseBody
    String getQrcode(@RequestParam(value = "userid", required = true) long userId, Model model) {
        AccountManager accountManager = new AccountManager();
        Qrcode qrcode = accountManager.createQrcodeTemporary(userId, 2592000);
        return qrcode.getQrcodeUrl();
    }
}
