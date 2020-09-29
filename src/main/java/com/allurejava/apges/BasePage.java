package com.allurejava.apges;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    private By signInButton = By.linkText("登录");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("点击登录按钮")
    public SignInPage clickSignInBtn() {
        System.out.println("点击登录按钮");
        WebElement signInBtnElement = driver.findElement(signInButton);
        if (signInBtnElement.isDisplayed() || signInBtnElement.isEnabled())
            signInBtnElement.click();
        else
            System.out.println("未找到元素");
        return new SignInPage(driver);
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
