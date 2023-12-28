package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameExplorer {
    private WebDriver driver;

    public NameExplorer(WebDriver driver) {
        this.driver = driver;
    }

    By exploreBtn = By.xpath("//*[@id=\"hero-copy\"]/div/div/div/a[2]/div");
    By searchNameTextBox = By.name("q");
    By nameLink = By.xpath("//*[@id=\"stage\"]/div[1]/div[2]/div/div/ul/li[2]/h3/a");
    By nameResult = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[1]/div/p");

    public void clickExploreButton(){
        driver.findElement(exploreBtn).click();
    }

    public void enterName(String name) {
        WebElement searchNameTextBox = driver.findElement(this.searchNameTextBox);
        searchNameTextBox.sendKeys(name);
        searchNameTextBox.submit();
    }

    public void clickNameLink() {
        driver.findElement(nameLink).click();
    }

    public String getExploredNameResult() {
        return driver.findElement(nameResult).getText();
    }

}
