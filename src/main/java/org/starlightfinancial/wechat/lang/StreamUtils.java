package org.starlightfinancial.wechat.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sili.chen on 2017/6/7.
 */
public class StreamUtils {
    /**
     * stream to string
     *
     * @param is
     * @return
     */
    public static String streamToString(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        try {
            while ((i = is.read()) != -1) {
                baos.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toString();
    }

    /**
     * string to stream
     *
     * @param str
     * @return
     */
    public static InputStream strToStream(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return is;
    }
}
