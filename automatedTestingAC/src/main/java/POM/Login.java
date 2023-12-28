package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    private  WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    By loginBtn = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li[1]/a");
    By chromeEmailInputField = By.name("login");
    By chromePasswordInputField = By.name("password");
    By chromeSubmitBtn = By.name("submit");
    By profileIconAndName = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li/a");

    public void getToLoginForm() throws InterruptedException {
        driver.findElement(loginBtn).click();
        Thread.sleep(5000);
    }

    public void enterLoginInformation() {
        String email = System.getenv("EmailAC");
        String password = System.getenv("PasswordAC");
        driver.findElement(chromeEmailInputField).sendKeys(email);
        driver.findElement(chromePasswordInputField).sendKeys(password);
        driver.findElement(chromeSubmitBtn).click();
    }

    public WebElement getProfileIconAndNameElement() {
        return driver.findElement(profileIconAndName);
    }

}
