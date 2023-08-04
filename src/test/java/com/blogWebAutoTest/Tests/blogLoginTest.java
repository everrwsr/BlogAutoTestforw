package com.blogWebAutoTest.Tests;

import com.blogWebAutoTest.common.autoTestUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class blogLoginTest extends autoTestUtils {
    public static EdgeDriver driver;

    @BeforeAll
    static private void baseControl(){
        driver = createDriver();
        driver.get("http://101.43.47.117:8232/myblog/login.html");
    }

    /*
    * 页面是否正确打开
    * 检查点：主页、注册元素是否存在
    * */
    @Test
    @Order(1)
    public void loginPageLoadRight() throws IOException {

        getScreenShot(getClass().getName());
    }

    /*
    * 检查正常登录情况
    * */
    @ParameterizedTest
    @CsvSource({"admin, 12345678"})
    @Order(3)
    public void loginSuccess(String username, String password) throws InterruptedException, IOException {
        driver.findElement(By.cssSelector("#username")).clear();
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#username")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#submit")).click();
        //对登录结果进行检查
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("body > div.nav"));
        getScreenShot(getClass().getName());
        driver.navigate().back();
        Thread.sleep(3000);
    }

    /*
    * 检查异常的登录情况
    * */
    @ParameterizedTest
    @CsvSource({"admin, 123"})
    @Order(2)
    public void loginFail(String username, String password) throws IOException, InterruptedException {
        driver.findElement(By.cssSelector("#username")).clear();
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#username")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#submit")).click();
        //对登录结果进行检查
        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        getScreenShot(getClass().getName());
        Thread.sleep(3000);
    }

}
