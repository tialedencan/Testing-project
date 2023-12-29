package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SurnameExplorer {
    private WebDriver driver;

    public SurnameExplorer(WebDriver driver) {
        this.driver = driver;
    }

    By projectsBtn = By.xpath("//*[@id=\"hero-copy\"]/div/div/div/a[4]/div");
    By searchSurnamesBtn = By.xpath("//*[@id=\"stage\"]/div[3]/div/div[2]/div[2]/p[2]/a");
    By searchSurnameTextBox = By.name("q");
    By surnameLink = By.xpath("//*[@id=\"stage\"]/div[1]/div[2]/div/div/ul/li[1]/h3/a");
    By surnameHorvat = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[1]/div/p");

    public void clickProjectsButton(){
        driver.findElement(projectsBtn).click();
    }
    public void clickSearchSurnamesBtn() {
        driver.findElement(searchSurnamesBtn).click();
    }
    public void enterSurname(String surname) {
        WebElement searchNameTextBox = driver.findElement(this.searchSurnameTextBox);
        searchNameTextBox.sendKeys(surname);
        searchNameTextBox.submit();
    }

    public void clickSurnameLink() {
        driver.findElement(surnameLink).click();
    }

    public String getExploredSurnameResult() {
        return driver.findElement(surnameHorvat).getText();
    }

}
