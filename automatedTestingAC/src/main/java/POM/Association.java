package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Association {

    private WebDriver driver;

    public Association( WebDriver driver){
        this.driver = driver;
    }

    By projectsLink = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li[3]/a ");
    By croOrganizationsLink = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li[3]/ul/li[3]/a");
    By educationOrganizationsLink = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[2]/div[2]/ul/li[13]/a");
    By croStudiesAssociationLink = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[2]/div[1]/h4[1]/a/b");
    By associationTitle = By.xpath("//*[@id=\"stage\"]/div[1]/div/div[1]/div/p/strong");
    By profileLink = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li/a");

    public void goToProfile() {
        driver.findElement(profileLink).click();
    }
    public void navigateToAssociationPage() {
        driver.findElement(projectsLink).click();
        driver.findElement(croOrganizationsLink).click();
        driver.findElement(educationOrganizationsLink).click();
        driver.findElement(croStudiesAssociationLink).click();
    }

    public String getAssociationTitle() {
        return driver.findElement(associationTitle).getText();
    }
}
