package com.blogWebAutoTest.Tests;

import com.blogWebAutoTest.common.autoTestUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2023-05-30
 * Time: 15:17
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class blogEditTest extends autoTestUtils {
    //    public static EdgeDriver driver;

    @BeforeAll
    static private void baseControl(){
//        driver = createDriver();
        driver.get("http://101.43.47.117:8232/myblog/blog_add.html");
    }

    /*
     * 页面是否正确打开
     * 检查点：主页、我的博客、退出登录元素是否存在
     * */
    @Test
    @Order(1)
    public void loginPageLoadRight() throws IOException {
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(4)"));
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(5)"));
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(6)"));
        getScreenShot(getClass().getName());
    }

    @Test
    @Order(2)
    public void editAndSubmitBlog() throws IOException, InterruptedException {
        driver.findElement(By.cssSelector("#title")).sendKeys("测试执行自动化测试脚本");
        driver.findElement(By.cssSelector("#editorDiv > div.editormd-toolbar > div > ul > li:nth-child(21) > a > i")).click();
        driver.findElement(By.cssSelector("#editorDiv > div.editormd-toolbar > div > ul > li:nth-child(12) > a > i")).click();
        driver.findElement(By.cssSelector("#editorDiv > div.editormd-toolbar > div > ul > li:nth-child(12) > a > i")).click();
        driver.findElement(By.cssSelector("#editorDiv > div.editormd-toolbar > div > ul > li:nth-child(12) > a > i")).click();
        driver.findElement(By.cssSelector("#editorDiv > div.editormd-toolbar > div > ul > li:nth-child(12) > a > i")).click();
        driver.findElement(By.cssSelector("#editorDiv > div.editormd-toolbar > div > ul > li:nth-child(21) > a > i")).click();
        driver.findElement(By.cssSelector("#editorDiv > div.editormd-toolbar > div > ul > li:nth-child(13) > a > i")).click();
        driver.findElement(By.cssSelector("#editorDiv > div.editormd-toolbar > div > ul > li:nth-child(13) > a > i")).click();
        driver.findElement(By.cssSelector("#editorDiv > div.editormd-toolbar > div > ul > li:nth-child(21) > a > i")).click();
        driver.findElement(By.cssSelector("body > div.blog-edit-container > div.title > button")).click();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

    }
    @Order(3)
    @Test
    public void blogDetailLoadRight() throws IOException {

        driver.get("http://101.43.47.117:8232/myblog/blog_content.html?id=13");
        driver.findElement(By.cssSelector("#title"));
        driver.findElement(By.cssSelector("#context"));
        getScreenShot(getClass().getName());

    }


    @Order(4)
    @Test
    public void quitt(){
        driver.quit();
    }

}
