package com.allurejava.testcase;

import com.allurejava.listener.TestFailListener;
import com.allurejava.pages.element.Login;
import com.allurejava.base.TestBase;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners( TestFailListener.class )
public class ChaoNaoTestCase  extends TestBase {
    private Login login ;
    @Test
    @Story("角色登录测试")
    public void loginCase(){
        login = new Login(getDriver());
        login.clickRole();
    }
}
