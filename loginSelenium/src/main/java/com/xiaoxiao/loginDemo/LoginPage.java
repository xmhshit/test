package com.xiaoxiao.loginDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //	private static final String URL="https://graph.qq.com/oauth/show?which=Login&display=pc&response_type=code&client_id=100423789&redirect_uri=http%3a%2f%2fwww.btc38.com%2fqq_login_callback.php&state=t";
    private WebDriver driver;
    private String url;

    public LoginPage(WebDriver driver, String url){
        this.driver=driver;
        this.url=url;
        this.driver.get(this.url); //加载页面，登陆为url的页面
    }

    //	获取页面标题
    public String getTitle(){
        return this.driver.getTitle();
    }

    //	检测页面是否加载，判断title是否相等，返回值是   ture 或者 false
    public boolean isLoaded(){
        System.out.println(this.getTitle());
        return LoginPage.Contants.TITLE.equals(this.getTitle());
    }

    //	登陆函数，传入用户名和密码，并点击按钮
    public boolean login(String username,String password){
        this.driver.findElement(By.xpath(LoginPage.Contants.USERNAME_XPATH)).sendKeys(username);
        this.driver.findElement(By.xpath(LoginPage.Contants.PASSWORD_XPATH)).sendKeys(password);
        this.driver.findElement(By.xpath(LoginPage.Contants.LOGIN_BUTTON_XPATH)).click();
        return LoginPage.Contants.TITLE.equals(this.getTitle());
    }

    //	由于我们这个测试页面 测试是这4个元素： 页面title 、用户框 、 密码框 、登陆按钮。（Contants类属于LoginPage类的内部类，获取该类中的变量：例如LoginPage.Contants.USER_XPATH）
    public static class Contants{
        public static final String TITLE = "我的这个小管家是没有 title的，我也不知道怎么处理，因为将title设置为 null 会报空指针错误，那就这样吧";
        //通过XPATH获取页面元素
        public static final String USERNAME_XPATH = ".//*[@id='username']";
        public static final String PASSWORD_XPATH = ".//*[@id='password']";
        public static final String LOGIN_BUTTON_XPATH = ".//*[@id='login']";
    }
}
