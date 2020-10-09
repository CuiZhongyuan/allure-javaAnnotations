package com.allurejava.test;

import com.allurejava.apges.BasePage;
import com.allurejava.apges.CreateAccountPage;
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

@Listeners(TestFailListener.class)
public class CreateAccountTest  extends TestBase {
    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;
    private CreateAccountPage createAccountPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("创建账户测试")
    @Story("测试创建帐户验证")
    @Test
    public void verifyCreateAnAccountPage() {
        System.out.println("创建一个帐户页面测试...");
        basePage = new BasePage(driver);
        signInPage = basePage.clickSignInBtn();
        createAccountPage = signInPage.clickonCreateAnAccount();
        Assert.assertTrue(createAccountPage.verifyPageTitle(), "页面标题不匹配");
        Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "页面文本不匹配");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("创建账户测试")
    @Story("测试创建账户 test1")
    @Test
    public void createAccountExample1() {
        Assert.assertTrue(false, "这是一个预期的失败结果");
    }

    @Story("测试创建账户 test2")
    @Test
    public void createAccountExample2() {
        Assert.assertTrue(false, "这是预期的失败");
    }
}
