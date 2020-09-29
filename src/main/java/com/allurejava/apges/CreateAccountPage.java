package com.allurejava.apges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
    private WebDriver driver;
    private By headerPageTxt = By.cssSelector("");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyPageTitle() {
        String pageTitle = "创建您的谷歌帐户";
        return getPageTitle().contains(pageTitle);
    }

    public boolean verifyCreateAccountPageText() {
        WebElement element = driver.findElement(headerPageTxt);
        String pageText = "创建您的谷歌帐户";
        return element.getText().contains(pageText);
    }

    public void createAccount() {
        // 需要编写创建帐户的步骤
    }
}
