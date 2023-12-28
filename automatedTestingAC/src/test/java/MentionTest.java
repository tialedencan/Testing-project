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
        String chromeDriverPath = System.getenv("ChromeDriverTesting");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.navigate().to(testURL);
    }

    @Test
    public void getToMentionPage() {
        driver.manage().window().maximize();
        Mention mention = new Mention(driver);
        mention.clickPreserveMemoryButton();
        String result = mention.getMentionTitle();
        Assert.assertEquals(result, "Spomen");
        System.out.print(result);
    }

    @Test
    public void findMention() {
        driver.manage().window().maximize();
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
