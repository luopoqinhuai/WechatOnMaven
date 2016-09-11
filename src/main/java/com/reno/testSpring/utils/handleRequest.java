package com.reno.testSpring.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Reno on 2016/8/26.
 */
@Component
public class handleRequest {


    /**
     *
     * @param request
     * @return
     */
    public String  processRequest(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
            int size = request.getContentLength();
            InputStream is = request.getInputStream();
            byte[] reqBodyBytes = readBytes(is, size);
            String res = new String(reqBodyBytes);
            return res;
        } catch (Exception e) {
        }
        return "";
    }

    public static final byte[] readBytes(InputStream is, int contentLen) {
        if (contentLen > 0) {
            int readLen = 0;
            int readLengthThisTime = 0;
            byte[] message = new byte[contentLen];
            try {
                while (readLen != contentLen) {
                    readLengthThisTime = is.read(message, readLen, contentLen
                            - readLen);
                    if (readLengthThisTime == -1) {// Should not happen.
                        break;
                    }
                    readLen += readLengthThisTime;
                }
                return message;
            } catch (IOException e) {
                // Ignore
                // e.printStackTrace();
            }
        }
        return new byte[]{};
    }

}
