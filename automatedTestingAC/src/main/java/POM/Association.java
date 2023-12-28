package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Association {

    private WebDriver driver;

    public Association( WebDriver driver){
        this.driver = driver;
    }

    By chromeProjectsLink = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li[3]/a ");
    By chromeCroOrganizationsLink = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li[3]/ul/li[3]/a");
    By chromeEducationOrganizationsLink = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[2]/div[2]/ul/li[13]/a");
    By chromeCroStudiesAssociationLink = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[2]/div[1]/h4[1]/a/b");
    By chromeAssociationTitle = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[1]/div/p/strong");
    By chromeProfileLink = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li/a");

    public void goToProfile() {
        driver.findElement(chromeProfileLink).click();
    }
    public void navigateToAssociationPage() {
        driver.findElement(chromeProjectsLink).click();
        driver.findElement(chromeCroOrganizationsLink).click();
        driver.findElement(chromeEducationOrganizationsLink).click();
        driver.findElement(chromeCroStudiesAssociationLink).click();
    }

    public String getAssociationTitle() {
        return driver.findElement(chromeAssociationTitle).getText();
    }
}
