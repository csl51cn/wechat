package org.starlightfinancial.wechat.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by sili.chen on 2017/6/7.
 */
public class VoiceResponse {
    private String MediaId;

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
