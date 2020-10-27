package com.xiaoxiao.baiduTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Search {
    public static WebDriver driver;
    public static String baseURL="https://www.baidu.com/";
    public static String string=System.setProperty("webdriver.chrome.driver","c:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

    @Test
    public void testBaidu(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseURL);
        driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("肖梦含");
        driver.findElement(By.xpath(".//*[@id='su']")).click();
    }
}
