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
