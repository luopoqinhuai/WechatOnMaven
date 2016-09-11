package com.reno.testSpring.utils.robot;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.*;

@Component
public class Turing {
    @Value("${turing.appkey}")
    private String APIKEY;

    public String askRobot_GET(String question) throws IOException {
        String INFO = URLEncoder.encode(question, "utf-8");
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        connection.disconnect();
        String out = sb.toString();
        System.out.println(out);

        JSONObject jsonObject = JSONObject.fromObject(out);
        String text = jsonObject.optString("text");
        return text;
    }


    public String askRobot_POST(String question, long userid) throws IOException {
        String INFO = URLEncoder.encode(question, "utf-8");
        String param = "{" +
                "\"key\":\"" + APIKEY + "\"" +
                "\" info\" : \"" + INFO + "\" £¬\n" +
                "\" userid\"£º\"" + userid + "\"\n" +
                "}";


        String getURL = "http://www.tuling123.com/openapi/api";
        PrintWriter out = null;
        URL getUrl = new URL(getURL);
        BufferedReader in = null;

        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();


        connection.setDoOutput(true);
        connection.setDoInput(true);

        out = new PrintWriter(connection.getOutputStream());
        out.print(param);
        out.flush();
        in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }


        JSONObject jsonObject = JSONObject.fromObject(out);
        String text = jsonObject.optString("text");
        return text;
    }
}