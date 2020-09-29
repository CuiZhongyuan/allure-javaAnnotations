#### testNG集成Allure报告--注释使用说明
[Allure官方地址,有兴趣的可以去了解更多](https://docs.qameta.io/allure/#_testng)
- 使用springboot框架+testNG框架+Allure报告框架引入
    - allure2test项目pom文件如下：
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
            <!--            <scope>test</scope>-->
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

- Allure 注释大致可分类如下：
```
@Epic
@Features
//是一个标注信息注解，但是改标注可以把相同的标注统一到相同模块下用于筛选
@Stories/@Story
//使用@Severity批注测试缺陷等级，例如BLOCKER，CRITICAL，NORMAL，MINOR，TRIVIAL
@Severity(SeverityLevel.BLOCKER)
//测试方法描述
@Description("测试流程描述")
//
@Step
@Attachment
@Link
```

- 使用先下载allure的zip包解压，然后配置环境变量即可
- 然后通过cmd或者IDEA 的Terminal功能，在当前项目下运行命令
```$xslt
allure serve allure-results
```
即可自动打开web页面测报告
![](https://img2020.cnblogs.com/blog/1891174/202009/1891174-20200929155736438-342403854.jpg)