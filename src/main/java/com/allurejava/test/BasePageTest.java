package com.allurejava.test;

import com.allurejava.apges.BasePage;
import com.allurejava.listener.TestFailListener;
import com.allurejava.util.ScreenshotUtil;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class BasePageTest extends TestBase  {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Description注解：测试主页标题")
    @Story("测试验证基本页面标题")
    @Test
    public void verifyHomePage() {
        System.out.println("主页面测试...");
        BasePage basePage = new BasePage(driver);
        Assert.assertTrue(basePage.verifyBasePageTitle("百度"), "首页标题不匹配");
    }

    @Link("www.baidu.com")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Description注解：验证主页测试1")
    @Story("基础测试")
    @Test
    public void baseTest1() {

        System.out.println("我在test1测试中");

    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Description注解：验证主页面 test 2")
    @Story("基础测试")
    @Test
    public void baseTest2() {
        Assert.assertTrue(true, "测试示例 ");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Description注解：验证主页面 test 3")
    @Story("基础测试")
    @Attachment
    @Test
    public void baseTest3() {
        Assert.assertTrue(false, "这是预期的失败");
        ScreenshotUtil.snapshot(driver);
    }
}
