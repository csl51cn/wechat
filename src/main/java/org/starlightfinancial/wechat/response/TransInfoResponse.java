package org.starlightfinancial.wechat.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * 指定客服
 * Created by sili.chen on 2017/6/7.
 */
public class TransInfoResponse {
    private String KfAccount;//指定会话接入的客服账号

    public TransInfoResponse() {
        super();
    }

    public TransInfoResponse(String kfAccount) {
        super();
        KfAccount = kfAccount;
    }

    @XmlElement(name = "KfAccount")
    public String getKfAccount() {
        return KfAccount;
    }

    public void setKfAccount(String kfAccount) {
        KfAccount = kfAccount;
    }
}
