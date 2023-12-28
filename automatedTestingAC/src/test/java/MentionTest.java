import POM.Mention;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MentionTest {

    public WebDriver driver;
    public String testURL = "https://actacroatica.com/hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Faks\\DIPLOMSKI\\1.semestar\\MTTPP\\projekt\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.navigate().to(testURL);
    }

    @Test
    public void findMention() {
        Mention mention = new Mention(driver);
        mention.clickPreserveMemoryButton();
        String result = mention.getMentionVinaj();
        Assert.assertEquals(result,"Vinaj");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
