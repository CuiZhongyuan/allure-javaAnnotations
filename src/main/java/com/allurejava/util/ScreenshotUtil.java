package com.allurejava.util;

/**
 * 截图工具类
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/8/1 23:30
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * 截图工具
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/1/22
 */
public class ScreenshotUtil {
    public static void snapshot(WebDriver driver) {
        String currentPath = "F:\\00_3IdeaProjects\\gitHubers\\AppAutomation\\src\\main\\resources\\img";
        String imgName = DateUtils.getTimeMillis();
        File screenShotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(currentPath+"\\"+imgName + "test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}