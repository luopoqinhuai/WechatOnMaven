package com.reno.testSpring.utils;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Created by Reno on 2016/8/26.
 */
@Component
public class returnXML {
    public String msgBackBuilder(String toUser,String fromUser,String Content,long MsgId){
        StringBuilder sb=new StringBuilder();
        sb.append("<xml><ToUserName><![CDATA[");
        sb.append(toUser);
        sb.append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[");
        sb.append(fromUser);
        sb.append("]]></FromUserName>");
        sb.append("<CreateTime>");
        sb.append(System.nanoTime());
        sb.append("</CreateTime>");
        sb.append("<MsgType><![CDATA[text]]></MsgType>");
        sb.append("<Content><![CDATA[");
        sb.append(Content);
        sb.append("]]></Content>");
        sb.append("<MsgId>");
        sb.append(MsgId);
        sb.append("</MsgId></xml>");
        String res=null;
        try {
            res= new String(sb.toString().getBytes(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return res;
    }
}
