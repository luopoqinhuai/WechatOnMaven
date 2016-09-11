package com.reno.testSpring.utils;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reno.testSpring.utils.robot.Turing;

import java.io.IOException;

/**
 * Created by Reno on 2016/8/26.
 */
@Component
public class parseXML {
    @Autowired
    returnXML xmlFormat;

    @Autowired
    Turing robot;
    public String parseByString(String datas){
        try {
            Document document = DocumentHelper.parseText(datas);
            Element root = document.getRootElement();
            Element msgType = root.element("MsgType");
            if(msgType.getText().equals("text")){
                Element ToUser = root.element("ToUserName");
                Element FromUserName = root.element("FromUserName");
                Element question = root.element("Content");
                String res="robot is broken";
                try{
                    res=robot.askRobot_GET(question.getText());
                }catch(IOException e){
                    e.printStackTrace();
                }
                return xmlFormat.msgBackBuilder(FromUserName.getText(),ToUser.getText(),res,System.nanoTime());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return "";
    }
}
