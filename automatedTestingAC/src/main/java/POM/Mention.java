package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Mention {
    private final WebDriver driver;

    public Mention(WebDriver driver) {
        this.driver = driver;
    }

    By preserveMemoryBtn = By.xpath("//*[@id=\"hero-copy\"]/div/div/div/a[3]/div");
    By mentionTitle = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[1]/h3");

    public void clickPreserveMemoryButton(){
        driver.findElement(preserveMemoryBtn).click();
    }


    public String getMentionTitle() {
        return driver.findElement(mentionTitle).getText();
    }

}
