package pages;

import org.openqa.selenium.By;

public class overview {
    public By payment=By.xpath("//div[contains(text(),'Payment Information')]");
    public By summaryLabel=By.xpath("(//div[@class='summary_value_label'])[1]");
    public By shipping=By.xpath("//div[contains(text(),'Shipping Information')]");
    public By getSummaryLabel1=By.xpath("(//div[@class='summary_value_label'])[2]");
    public By subTotal=By.xpath("//div[@class='summary_subtotal_label']");
    public By tax=By.xpath("//div[@class='summary_tax_label']");
    public By total=By.xpath("//div[@class='summary_total_label']");
    public By finish=By.xpath("//button[@id='finish']");

}
