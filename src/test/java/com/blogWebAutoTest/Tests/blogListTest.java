package com.blogWebAutoTest.Tests;

import com.blogWebAutoTest.common.autoTestUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;


public class blogListTest extends autoTestUtils {
//    public static EdgeDriver driver;

    @BeforeAll
    static private void baseControl(){
//        driver = createDriver();
        driver.get("http://101.43.47.117:8232/myblog/myblog_list.html");
    }

    /*
     * 页面是否正确打开
     * 检查点：创作数、github地址、写博客元素是否存在
     * */
    @Test
    public void loginPageLoadRight() throws IOException {
        driver.findElement(By.cssSelector("body > div.container > div.container-left > div > a"));
        driver.findElement(By.cssSelector("#acount"));
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(5)"));
        getScreenShot(getClass().getName());
    }
}
