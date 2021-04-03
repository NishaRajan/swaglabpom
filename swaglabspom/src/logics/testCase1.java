package logics;

import org.openqa.selenium.WebDriver;
import pages.*;

public class testCase1 extends helper{

    static testCase1 tc=new testCase1();
    static login ln= new login();
    static products pdt=new products();
    static cart ct=new cart();
    static checkout co=new checkout();
    static overview ov=new overview();
    static finish fh=new finish();
    static methods mt=new methods();

    public static void main(String[] args) {

      WebDriver driver=tc.initBrowser();
        tc.launchUrl(driver);
        tc.login(driver);
        tc.itemSize(driver,pdt.items);
        tc.checkDesiredProduct(driver);
        tc.signInToCheckout(driver);
        tc.productOverview(driver);
        tc.finishCheckout(driver);
        tc.quitBrowser(driver);
    }
    public void login(WebDriver driver){
        try {
            tc.enterText1(driver, ln.name, ln.password);
            tc.clickButton(driver, ln.login);
            mt.successfulLogin(driver, "Swag Labs");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkDesiredProduct(WebDriver driver) {
        try {
            mt.expectedProductAvailability(driver, pdt.pdtHeading, pdt.addToCart, pdt.cart);
            tc.getDescription(driver, pdt.pdtHeading);
            tc.getDescription(driver, pdt.price);
            tc.getDescription(driver, ct.cartQty);
            mt.getText(driver, pdt.items, pdt.price, pdt.cart, ct.checkOut, ct.remove);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void signInToCheckout(WebDriver driver) {
        try {
            tc.waitUntil(driver, co.firstName);
            System.out.println("Sign In To CheckOut ---->");
            tc.enterText2(driver,co.firstName,co.lastName,co.postal);
            tc.clickButton(driver, co.continues1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void productOverview(WebDriver driver) {
        try {
            tc.waitUntil(driver, ov.finish);
            System.out.println("Selected Product Overview : ");
            mt.elementIsDisplayed(driver, ov.payment, ov.summaryLabel);
            mt.elementIsDisplayed(driver, ov.shipping, ov.getSummaryLabel1);
            tc.getDescription(driver, ov.subTotal);
            tc.getDescription(driver, ov.tax);
            tc.getDescription(driver, ov.total);
            tc.clickButton(driver, ov.finish);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void finishCheckout(WebDriver driver) {
        try {
            tc.waitUntil(driver, fh.img2);
            System.out.println("Order Placed !!!!!");
            tc.getDescription(driver, fh.header1);
            tc.getDescription(driver, fh.text1);
            tc.getDescription(driver, fh.subHeader);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
