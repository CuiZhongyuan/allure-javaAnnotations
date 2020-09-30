package com.allurejava.apges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
    private WebDriver driver;
    private By headerPageTxt = By.cssSelector("#s-top-left > a:nth-child(1)");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyPageTitle() {
        String pageTitle = "查看百度Title";
        return getPageTitle().contains(pageTitle);
    }

    public boolean verifyCreateAccountPageText() {
        WebElement element = driver.findElement(headerPageTxt);
        String pageText = "点击百度新闻";
        return element.getText().contains(pageText);
    }

    public void createAccount() {
        // 需要编写创建帐户的步骤
    }
}
