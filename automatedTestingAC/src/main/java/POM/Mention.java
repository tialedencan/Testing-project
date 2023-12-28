package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mention {
    private final WebDriver driver;

    public Mention(WebDriver driver) {
        this.driver = driver;
    }

    By chromePreserveMemoryBtn = By.xpath("//*[@id=\"hero-copy\"]/div/div/div/a[3]/div");
    By chromeVinajMention = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[2]/div[1]/ul/li[3]/h3");

    By chromeMentionTitle = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[1]/h3");

    public void clickPreserveMemoryButton(){
        driver.findElement(chromePreserveMemoryBtn).click();
    }

    public String getMentionVinaj() {
        return driver.findElement(chromeVinajMention).getText();
    }

    public String getMentionTitle() {
        return driver.findElement(chromeMentionTitle).getText();
    }

}
