package com.allurejava.test;

import com.allurejava.apges.BasePage;
import com.allurejava.apges.SignInPage;
import com.allurejava.listener.TestFailListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners( TestFailListener.class)
public class SignInPageTest extends TestBase {
    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @BeforeClass
    public void setUp() {
        //Get driver
        driver = getDriver();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("验证登录功能")
    @Story("测试验证登录")
    @Test
    public void verifySignInFunction() {
        System.out.println("登录功能详细信息...");
        basePage = new BasePage(driver);
        signInPage = basePage.clickSignInBtn();
        Assert.assertTrue(signInPage.verifySignInPageTitle(), "登录页面标题不匹配");
        Assert.assertTrue(signInPage.verifySignInPageText(), "页面文本不匹配");
        Assert.assertTrue(signInPage.verifySignIn("usertest", "p123"), "登录失败");
    }

    @Story("测试验证test1登录")
    @Test
    public void SignInPageTestOne() {
        Assert.assertTrue(true, "简单示例");
    }

    @Story("测试验证test2登录")
    @Test
    public void SignInPageTestTwo() {
        Assert.assertTrue(false, "这是预期的失败");
    }

    @Story("测试验证test3登录")
    @Test
    public void SignInPageTestThree() {
        Assert.assertTrue(true, "这不是预期的失败");
    }
}
