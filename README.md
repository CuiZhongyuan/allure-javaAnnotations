## testNG集成Allure报告--注释使用说明
##### 前置条件
- 首先需要下载allure的zip包解压，然后配置环境变量即可（win）。[allure的GitHub下载地址：](https://github.com/allure-framework/allure2/releases/tag/2.13.5)
- 然后执行testn.xml或者是单元测试下的runCase方法，两者任选其一。测试用例执行完成后会在项目目录下生成：allure-results文件夹
- 最后通过cmd或者IDEA 的Terminal功能，在当前项目下执行如下命令
```
allure serve allure-results
```
即可自动打开web页面测报告
![](https://upload-images.jianshu.io/upload_images/16753854-34d76865f3b093f1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### 下面详解下java版allure的注解使用
- allure简介就不多说了官网介绍很详细，
[Allure官方地址,需要了解更多详情异步这里](https://docs.qameta.io/allure/#_testng)

 本次demo使用技术如下
- 使用springboot框架+testNG框架+Allure报告框架+管理Selenium WebDriver所需的驱动程序webdrivermanager库+log4j2日志
 
- 引入上面的依赖，具体allure-javaAnnotations项目pom文件如下：
 ```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>allure2test</artifactId>
    <version>1.0-SNAPSHOT</version>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.6.RELEASE</version>
    </parent>
    <!--引入spingboot框架-->
    <dependencies>
        <!-- springboot starter依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <exclusions>
                <!-- 移除自带的log -->
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-log4j -->
        <!--引入支持的log4j2日志依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-log4j2</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!--引入allure2的依赖-->
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-testng</artifactId>
            <version>2.10.0</version>
        </dependency>
        <!-- testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.14.3</version>
        </dependency>
        <!--WebDriverManager是一个库，它可以自动管理Selenium WebDriver所需的驱动程序（例如chromedriver，geckodriver等）-->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>3.0.0</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
-  Allure注释大致可分类如下：
```
/**@Epic -Epics可用作您的产品或项目的大量需求的占位符。Epic将在适当的时候分为较小的用户故事。
*用户故事可以拆分为较小的任务，并且可以是较大的Feature和Epic的一部分。
*/
@Epic
@Features
//是一个标注信息注解，但是改标注可以把相同的标注统一到相同模块下用于筛选
@Stories/@Story
//使用@Severity批注测试缺陷等级，例如BLOCKER，CRITICAL，NORMAL，MINOR，TRIVIAL
@Severity(SeverityLevel.BLOCKER)
//测试方法描述
@Description("测试流程描述")
//@Step注释是对任何（公共，私有，受保护）对任何方法进行注释。例如- @Step（“输入{0}和{1}”）
@Step
//@Attachment-附件只是带有注释的方法，@Attachment该方法返回String或byte []，应将其添加到报表中。我们可以将故障屏幕截图作为附件
@Attachment
//@Links-我们可以将测试链接到某些资源，例如TMS（测试管理系统）或错误跟踪器。将测试用例链接到测试方法总是有帮助的。
@Link
```
---
##### 下面介绍每种注解的示例及报告展示
- @Description注解：描述性注解
    - 示例--位置test包下的BasePageTest类中每个测试方法都加了@Description，如：
```
    @Description("Description注解：验证主页面 test 2")
    @Test
    public void baseTest2() throws InterruptedException {
        Assert.assertTrue(true, "测试示例 ");
    }
```
对应allure报告位置截图如下：
![](https://upload-images.jianshu.io/upload_images/16753854-7676dd1eee8a97fe.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
- @Stories/@Story注解使用（该注解可以管理同一模块，及分组展示）
  - 示例--位置同上
```
    @Description("Description注解：验证主页测试1")
    @Story("基础测试")
    @Test
    public void baseTest1() {

        System.out.println("我在test1测试中");

    }
    @Description("Description注解：验证主页面 test 2")
    @Story("基础测试")
    @Test
    public void baseTest2()  {
        Assert.assertTrue(true, "测试示例 ");
    }
```
对应allure报告展示如下：
![](https://upload-images.jianshu.io/upload_images/16753854-1eb6a7e22198d075.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
- @Severity注解（@Severity注解：测试的严重程度划分BLOCKER，CRITICAL，NORMAL，MINOR，TRIVIAL。通过查看此信息，我们可以了解测试失败的严重性。）
- 示例
```
@Severity(SeverityLevel.TRIVIAL)
    @Description("Description注解：验证主页测试1")
    @Story("基础测试")
    @Test
    public void baseTest1() {
        System.out.println("我在test1测试中");
    }
    @Severity(SeverityLevel.BLOCKER)
    @Description("Description注解：验证主页面 test 2")
    @Story("基础测试")
    @Test
    public void baseTest2()  {
        Assert.assertTrue(true, "测试示例 ");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description注解：验证主页面 test 3")
    @Story("基础测试")
    @Test
    public void baseTest3() {
        Assert.assertTrue(false, "这是预期的失败");
    }
```
对应allure报告展示如下：
![](https://upload-images.jianshu.io/upload_images/16753854-76b273219d6b167f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
- @Step注解（ @Step注解可以对参数化进行检查）
  - 示例
```
@Step("验证参数 uname {0} and password {1}")
    public boolean verifySignIn(String uname, String pwd) {
        enterUserName(uname);
        enterPassword(pwd);
        clickOnSignIn();
        return getErrorMessage().contains("不正确的");
    }
    @Step("输入 username {0}")
    public void enterUserName(String userName) {
        WebElement emailTxtBox = driver.findElement(emailTextBox);
        if (emailTxtBox.isDisplayed())
            emailTxtBox.sendKeys(userName);
    }
//SignInPageTest测试类
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
```
对应allure报告展示如下：
![](https://upload-images.jianshu.io/upload_images/16753854-cdbb68815d02495e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- @Epic注解（在敏捷中，测试也可以按Epic，Theme和story进行分类，allure中也可以这样标注映射关系）
![图片来源于网络](https://upload-images.jianshu.io/upload_images/16753854-8c36f8e2c95f78c7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
  - 示例
```
@Epic("Epic示例")
@Feature("testNG+allure集成")
public class EpicTest {
    @Test
    @Story("对story注释的基本支持")
    @Story("对story注释的高级支持")
    public void testSomething() throws Exception {
        System.out.println("Epic注解使用");
    }
}
```
对应allure报告展示如下：
![](https://upload-images.jianshu.io/upload_images/16753854-1ab6861f0d29469a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- @Links注解（@Links可以将测试链接到某些资源，例如TMS（测试管理系统）或错误跟踪器等
  - 示例
```
    @Link("www.baidu.com")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Description注解：验证主页测试1")
    @Story("基础测试")
    @Test
    public void baseTest1() {
        System.out.println("我在test1测试中");
    }
```
对应allure报告展示如下：
![](https://upload-images.jianshu.io/upload_images/16753854-39a5db2ab2ca26c7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- @Attachment注解（@Attachment该方法返回String或byte []，应将其添加到报表中。我们可以使用该注解将异常屏幕截图作为附件展示）


---
allure是一种灵活的轻量级多语言测试报告工具，它不仅可以以简洁的网络报告形式非常简洁地显示已测试的内容，而且还允许参与开发过程的每个人从日常执行中提取最大的有用信息，详细的了解注解使用会使你的测试报告更加易读直观！

*更多测试技术分享、学习资源以及一些其他福利可关注公众号：【Coding测试】获取：*
![Coding测试](https://upload.jianshu.io/collections/images/1854400/16753854-59afbc90a194785d.webp.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240)
