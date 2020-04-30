package youtubetest;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.net.URLCodec;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class StepDefs extends RunCucumberTest {
    public static final String USERNAME = System.getenv("USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("AUTOMATE_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + System.getenv("URL");

    @After
    public void afterScenario(){
        driver.quit();
    }

    @Given("^I have opened the browser")
    public void openBrowser() throws MalformedURLException {


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "50");
        caps.setCapability("name", "Test' Youtube");

        driver = new RemoteWebDriver(new URL(URL), caps);



       // WebDriverManager.firefoxdriver().setup();
       // driver = new FirefoxDriver();
    }
    @When("^I open the youtube website$")
    public void goToYoutube(){
        driver.navigate().to("https://youtube.com");
    }

    @When("^I maximize the window$")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @When("I click on the Log In button")
    public void iClickOnTheLogInButton() {
        String xpath = "/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/a/paper-button";
        driver.findElement(By.xpath(xpath)).click();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        try {
            Thread.sleep(1000);
            assertTrue(driver.findElement(By.id("identifierId")).isDisplayed());
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

    }


    @When("I click the first video")
    public void iClickFirstVideo() {
        String xpath = "//*[@id='thumbnail']";
        driver.findElements(By.xpath(xpath)).get(0).click();
    }

    @Then("It should be display the video")
    public void navigatedToTheFirstVideo() {
        assertTrue(driver.getCurrentUrl().startsWith("https://www.youtube.com/watch?"));
    }

}
