package com.allurejava.base;


import com.allurejava.util.WordartDisplayer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("browser : " + browserType + " 无效，启动作Chrome为浏览器的选择..");
                driver = initFirefoxDriver(appURL);
        }
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("启动新的配置文件谷歌chrome..");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 页面加载等待
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        // JS 等待
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("启动Firefox浏览器..");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.navigate().to(appURL);
        return driver;
    }

    /**
     * 执行一个测试套之前执行
     */
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        // 显示文字 iwebui
        WordartDisplayer.display();
        // todo : 这里可以自己定制其他工具初始化操作（看需要）
    }
    @Parameters({ "browserType", "appURL" })
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            setDriver(browserType, appURL);
        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    // todo : 其他工具的释放操作（看需要）
}
