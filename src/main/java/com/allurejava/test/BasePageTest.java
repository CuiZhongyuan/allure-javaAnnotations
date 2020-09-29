package com.allurejava.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasePageTest extends TestBase  {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("测试主页标题")
    @Story("测试验证基本页面标题")
    @Test
    public void verifyHomePage() {
        System.out.println("主页面测试...");
        BasePage basePage = new BasePage(driver);
        Assert.assertTrue(basePage.verifyBasePageTitle("谷歌"), "首页标题不匹配");
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Description("验证主页测试1")
    @Story("测试验证基础Test1")
    @Test
    public void baseTest1() {

        System.out.println("我在test1测试中");

    }

    @Severity(SeverityLevel.TRIVIAL)
    @Description("验证主页面 test 2")
    @Story("基础测试")
    @Test
    public void baseTest2() throws InterruptedException {
        Assert.assertTrue(true, "测试示例 ");
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Description("验证主页面 test 3")
    @Story("验证基础试验")
    @Test
    public void baseTest3() {
        Assert.assertTrue(false, "这是预期的失败");
    }
}
