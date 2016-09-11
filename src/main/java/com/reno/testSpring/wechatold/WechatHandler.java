package  com.reno.testSpring.wechatold;


import com.reno.testSpring.utils.handleRequest;
import com.reno.testSpring.utils.parseXML;
import com.reno.testSpring.utils.wechatConn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Reno on 2016/8/10.
 */
@RestController
@RequestMapping(value = "/wechathandler")
public class WechatHandler {
    @Autowired
    private wechatConn conn;

    @Autowired
    private handleRequest rqHandler;

    @Autowired
    private parseXML parser;
    
    @Value("${reno.test}")
    private String msg;
    

    public WechatHandler(){
    	System.out.println("wechat Handler Construct\n\n\n");
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String connectWithWechat(@RequestParam("echostr") String echostr,
                                    @RequestParam("timestamp") String timestamp,
                                    @RequestParam("nonce") String nonce,
                                    @RequestParam("signature") String signature) {
        if (conn.checkConnection(signature, timestamp, nonce)) {
            return echostr;
        }
        return msg;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String getName(HttpServletRequest request, HttpServletResponse response) {

        String xmlPOST= rqHandler.processRequest(request); //parse xml from request

        return parser.parseByString(xmlPOST);

    }


}
