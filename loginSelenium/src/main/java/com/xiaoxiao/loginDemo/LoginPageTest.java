package com.xiaoxiao.loginDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTest {
    private static final String URL="http://47.98.101.146:8080/xgj/page/login.jsp";
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
//		System.setProperty("webdriver.firefox.marionette", "c:\\Program Files\\Mozilla Firefox\\gexkodriver.exe");
//        说明驱动程序不一定要 安装在狐火网上，可以将驱动gexkodriver.exe单独放在某个文件下，将其路径写在 如上的 c:\\...\\...\\gexkodriver.exe即可
//		System.setProperty("webdriver.firefox.marionette", "c:\\Program Files (x86)\\Mozilla Firefox\\gexkodriver.exe");
        System.setProperty("webdriver.chrome.driver", "c:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver=new ChromeDriver();
//		this.driver=new FirefoxDriver(); //这是Firefox浏览器的驱动
        this.loginPage=new LoginPage(this.driver, URL); //这里的URL应该可以用 this.url
    }

    @Test
    public void testLogin0() throws InterruptedException{
        assertEquals(false, this.loginPage.login("1", "1"));  //false的原因是 title的值不一致，反正xgj这个项目登陆页面是没有title的值，即值为null
        Thread.sleep(8000);
    }


    @Test
    public void testLogin1() throws InterruptedException{
        assertEquals(false, this.loginPage.login("123456", "123456"));
        Thread.sleep(8000);
    }

    @Test
    public void testLogin2() throws InterruptedException{
        assertEquals(false, this.loginPage.login("1", "123456"));
        Thread.sleep(8000);
    }


    @Test
    public void testLogin3() throws InterruptedException{
        assertEquals(false, this.loginPage.login("123456789", "123456789"));
        Thread.sleep(8000);
    }


    //	关闭浏览器
    @AfterMethod
    public void shutDown(){
        System.out.println("关闭浏览器");
        driver.quit();
    }
}
