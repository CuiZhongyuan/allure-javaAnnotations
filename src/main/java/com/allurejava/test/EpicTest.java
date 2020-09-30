package com.allurejava.test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Epic示例")
@Feature("testNG+allure集成")
public class EpicTest {
    @Test
    @Story("对story注释的基本支持")
    @Story("对story注释的高级支持")
    public void testSomething() throws Exception {
        System.out.println("Epic注解使用");
    }
}
