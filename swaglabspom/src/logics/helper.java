package logics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

public class helper {
    Properties prop=new Properties();

    FileReader file;

    {
        try {
            file = new FileReader("config.properties");
            prop.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public WebDriver initBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\\\chromedriver_win32\\\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        return driver;
    }
    public void launchUrl(WebDriver driver){
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }
    public void quitBrowser(WebDriver driver){

        driver.quit();
    }
    public void waitUntil(WebDriver driver, By locator){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void enterText(WebDriver driver,By locator,String txt){
        waitUntil(driver,locator);
        driver.findElement(locator).sendKeys(txt);
    }
    public void enterText1(WebDriver driver,By locator1,By locator2){
        driver.findElement(locator1).sendKeys(prop.getProperty("username"));
        driver.findElement(locator2).sendKeys(prop.getProperty("password"));
    }
    public void enterText2(WebDriver driver,By locator1,By locator2,By locator3){
        driver.findElement(locator1).sendKeys(prop.getProperty("firstname"));
        driver.findElement(locator2).sendKeys(prop.getProperty("lastname"));
        driver.findElement(locator3).sendKeys(prop.getProperty("pin"));
    }
    public void clickButton(WebDriver driver,By locator){
        waitUntil(driver,locator);
        driver.findElement(locator).click();
    }

    public void itemSize(WebDriver driver,By locator){
        List<WebElement> item=driver.findElements(locator);
        System.out.println("Total No Of Products:"+" "+item.size());
    }
    public void getDescription(WebDriver driver,By locator){
        WebElement element=driver.findElement(locator);
        System.out.println(element.getText());
    }

    }


