package com.allurejava.listener;

import com.allurejava.base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;

public class TestFailListener  extends TestListenerAdapter {
    public void onTestFailure(ITestResult result) {
        System.out.println("*** 测试执行 " + result.getMethod().getMethodName() + " 失败...");
        System.out.println(result.getMethod().getMethodName() + " 失败!");
        super.onTestFailure(result);
        TestBase testBase = (TestBase) result.getInstance();
        //获取驱动
        WebDriver driver = testBase.getDriver();
        // 在报告中附加屏幕截图
        saveFailureScreenShot(driver);
    }
    @Attachment(value = "失败截图如下：",type = "image/png")
    public void saveFailureScreenShot(WebDriver driver) {
        byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("失败截图", new ByteArrayInputStream(screenshotAs));
    }
}
