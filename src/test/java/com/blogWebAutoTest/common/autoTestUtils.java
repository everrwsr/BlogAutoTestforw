package com.blogWebAutoTest.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class autoTestUtils {
    public static EdgeDriver driver;

    //创建驱动对象
    public static EdgeDriver createDriver(){
        if(driver == null){
            System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(options);

            //创建隐式等待
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    //使用时间戳动态生成图片名
    public List<String> getTime(){
        //以天的维度按照文件夹进行保存
        List<String> list = new ArrayList<>();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd-HHmmssSS");
        String dirname = simpleDateFormat1.format(System.currentTimeMillis());
        String filename = simpleDateFormat2.format(System.currentTimeMillis());
        list.add(dirname);
        list.add(filename);
        return list;
    }

    //获取屏幕截图，把所有用例结果保存下来（非常适用于无头模式）
    public void getScreenShot(String s) throws IOException {
        List<String> list = getTime();
        String filename = "./src/test/java/com/blogWebAutoTest/" + list.get(0) + "/" + s + "_" + list.get(1) + ".png";
        File file = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(filename));
    }
}
