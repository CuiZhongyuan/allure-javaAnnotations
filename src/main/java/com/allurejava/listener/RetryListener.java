package com.allurejava.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class RetryListener {
    public void onTestFailure(ITestResult result) {
        System.out.println("*** 测试执行 " + result.getMethod().getMethodName() + " 失败...");
        System.out.println(result.getMethod().getMethodName() + " 失败!");

        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");

        // attach screenshots to report
        saveFailureScreenShot(driver);
    }

    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
