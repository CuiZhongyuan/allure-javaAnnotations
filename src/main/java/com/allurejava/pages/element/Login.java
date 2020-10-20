package com.allurejava.pages.element;

import com.allurejava.base.BasePage;
import com.allurejava.pages.data.CssXpathData;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

@Slf4j
public class Login extends BasePage {

    public Login(WebDriver driver) {
        super(driver);
    }
    @Step("点击输入框")
    public void clickRole() {
        log.info("点击角色登录");
        WebElement clickRole = driver.findElement(CssXpathData.LOGIN);
        if (clickRole.isDisplayed() || clickRole.isEnabled()){
            clickButton(CssXpathData.LOGIN);
            WebElement css = driver.findElement(CssXpathData.PHONE);
            if (css.isDisplayed()||css.isEnabled()){
                Assert.assertTrue(false, "这是预期的失败");
            }
        }
        else
            System.out.println("未找到元素");
    }
    public void clickImagesLink() {
        //它应该有一个点击图像链接的逻辑
        //它应该导航到谷歌图像页面
    }

    @Step("获取页面标题")
    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    @Step("验证基本页面标题{0}")
    public boolean verifyBasePageTitle(String title) {
        return getPageTitle().contains(title);
    }
}
