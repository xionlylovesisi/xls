package com.xlm.stream;

import com.alibaba.fastjson.JSONObject;
import com.xlm.common.util.LogUtils;
import com.xlm.stream.data.UserSessionInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@SpringBootApplication
@Slf4j
public class Java8StreamApplication {


    public static void main(String[] args) {
//        SpringApplication.run(Java8StreamApplication.class, args);
        userSessionInfoEncode();

    }

    private static void userSessionInfoEncode() {
        UserSessionInfo userSessionInfo = new UserSessionInfo();
        userSessionInfo.setObserverId(1);
        userSessionInfo.setName("");
        userSessionInfo.setEmployeeNo("");
        String userJsonStr = JSONObject.toJSONString(userSessionInfo);
        try {
            String result = URLEncoder.encode(userJsonStr, "UTF-8");
            LogUtils.info(log,"result:{}",result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
