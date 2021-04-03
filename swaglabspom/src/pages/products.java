package pages;

import org.openqa.selenium.By;

public class products {
    public By items=By.xpath("//div[@class='inventory_item_name']");
    public By description=By.xpath("//div[@class='inventory_item_desc' and contains(text(),'carry')]");
    public By pdtHeading=By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
    public By addToCart=By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public By price=By.xpath("//div[@class='inventory_item_price']");
    public By cart=By.xpath("//div[contains(@id,'shopping')]");

}
