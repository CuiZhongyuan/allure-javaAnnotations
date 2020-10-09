package com.allurejava.test;

import com.allurejava.listener.TestFailListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners( TestFailListener.class)
@Epic("Epic示例")
@Feature("testNG+allure集成")
public class EpicTest {
    @Test
    @Story("对story注释的基本支持")
    @Story("对story注释的高级支持")
    public void testSomething() throws Exception {
        System.out.println("Epic注解使用");
    }
    @Test
    @Story("接口测试响应数据")
    public void test1() {
        try {
            String url = "www.baidu.com";
            String header = "accept: application/json";
            String body = "{t: 1585926656064}";
            String response = "{\"status\":200,\"message\":\"success\",\"data\":{\"session\":\"e6530619f00b6e27f58d5c251a9c7b07\",\"id\":\"bc5a637f976db9779cc8ec56dbc5f418\",\"challenge\":\"e6530619f00b6e27f58d5c251a9c7b07\",\"provider\":\"gt\",\"failback\":false},\"timestamp\":\"1585926656203\",\"version\":4}";
            caseStep(url,header,body,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试步骤
    public void caseStep(String url, String header, String body, String response)
    {
        Allure.addAttachment("请求地址", url);
        Allure.addAttachment("请求头", header);
        Allure.addAttachment("请求体", body);
        Allure.addAttachment("请求响应", response);
    }

}
