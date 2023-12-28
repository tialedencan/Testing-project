package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Login {
    private  WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    By loginBtn = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li[1]/a");
    By emailInputField = By.name("login");
    By passwordInputField = By.name("password");
    By submitBtn = By.name("submit");
    By profileIconAndName = By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li/a");

    public void getToLoginForm() {
        driver.findElement(loginBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void enterLoginInformation() {
        String email = System.getenv("EmailAC");
        String password = System.getenv("PasswordAC");
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(submitBtn).click();
    }

    public WebElement getProfileIconAndNameElement() {
        return driver.findElement(profileIconAndName);
    }

}
