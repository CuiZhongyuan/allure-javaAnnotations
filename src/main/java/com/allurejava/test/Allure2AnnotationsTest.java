package com.allurejava.test;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class Allure2AnnotationsTest {
    //用例编号
    @TmsLink("562")
    //bug编号
    @Issue("4042")
    //bug严重等级,优先级，包含blocker, critical, normal, minor, trivial 几个不同的等级
    @Severity(SeverityLevel.TRIVIAL)
    //用例描述
    @Description("测试一个流程，用作回归冒烟测试")
    /**
     *功能块，具有相同feature或astory的用例将规整到相同模块下,执行时可用于筛选
     */
    @Story("查询场景-正向查询功能")
    @Test(description = "验证百度查询功能")
    public void testDemo()  {
        System.out.println("test");
    }

    @Step("usename{0} and password{1}")
    @Test
    public void case2(){
        System.out.println("username");
    }

}
