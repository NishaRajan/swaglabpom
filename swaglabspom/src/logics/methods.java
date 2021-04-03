package logics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Scanner;

public class methods {
    public void successfulLogin(WebDriver driver, String txt){
        String actualTitle= driver.getTitle();
        if(txt.equals(actualTitle)){
            System.out.println("Login Successful");
        }else{
            System.out.println("Login Failed");
        }
    }
    public void getText(WebDriver driver, By locator1, By locator2, By locator3, By locator4, By locator5) {
        String text = driver.findElement(locator1).getText();
        String amt = driver.findElement(locator2).getText();
        String cart = driver.findElement(locator3).getText();
        if (text.equals("Sauce Labs Backpack") && amt.equals("$29.99") && cart.equals("1")) {
            driver.findElement(locator4).click();
            System.out.println("Selected Item Matches ");
        } else {
            driver.findElement(locator5).click();
            System.out.println("Selected Item Did Not Match.");
        }

    }
    public void expectedProductAvailability(WebDriver driver,By locator1,By locator2,By locator3){
        if(driver.findElement(locator1).isDisplayed()) {
            WebElement btn1 = driver.findElement(locator2);
            btn1.click();
            System.out.println("Expected Product is Present");
            WebElement cart = driver.findElement(locator3);
            cart.click();
        }else{
            System.out.println("Expected Product Not Present");
        }
    }

    public void getInputFromUser(WebDriver driver, By locator, By locator1) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Full Name");
        String name = sc.nextLine();
        int half = name.length() / 2;
        String part1 = name.substring(0, half);
        String part2 = name.substring(half);
        System.out.println(part1);
        System.out.println(part2);
        driver.findElement(locator).sendKeys(part1);
        driver.findElement(locator1).sendKeys(part2);
    }

    public void elementIsDisplayed(WebDriver driver, By locator1, By locator2) {
        if (driver.findElement(locator1).isDisplayed()) {
            String payment = driver.findElement(locator2).getText();
            System.out.println(payment);
        } else {
            System.out.println("Error");
        }

    }
}
