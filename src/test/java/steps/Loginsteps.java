package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Loginsteps {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriver getDriver() {
        return driver.get();
    }

    private void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    private void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    @Given("User should navigate to app")
    public void userShouldNavigate() {
        WebDriver newDriver = new ChromeDriver();
        setDriver(newDriver);
        getDriver().get("https://admin-demo.nopcommerce.com/login");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("enter username {string}")
    public void userClicksOnLoginBut(String akuser) {
        System.out.println(akuser + ":actual user taken");
        getDriver().findElement(By.id("Email")).clear();
        getDriver().findElement(By.id("Email")).sendKeys(akuser);
    }

    @Given("enter password {string}")
    public void enterPasswordPass(String akpass) {
        getDriver().findElement(By.id("Password")).clear();
        getDriver().findElement(By.id("Password")).sendKeys(akpass);
    }

    @When("user click login")
    public void userClickLogin() {
        getDriver().findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
    }

    @Then("login should go")
    public void loginShouldGo() {
        WebDriverWait akwait = new WebDriverWait(getDriver(), java.time.Duration.ofSeconds(10));
        try {
            akwait.until(ExpectedConditions.urlMatches("https://admin-demo.nopcommerce.com/admin/"));
            System.out.println("Admin page loaded successfully.");
        } catch (Exception e) {
            String akerrormessage = getDriver().findElement(By.id("Email-error")).getText();
            System.out.println("Execution done & fail:" + akerrormessage);
            SoftAssert sa = new SoftAssert();
            sa.assertEquals(akerrormessage, "Please enter a valid email address.");
            sa.assertAll();
        } finally {
            quitDriver(); // Always quit the driver after each scenario.
        }
    }
}

//
//
//
//
//
//
//
//
//
//
//
//
//package steps;
//
//
//
//import java.util.concurrent.TimeUnit;
//
//import java.util.concurrent.TimeoutException;
//
//
//
//import org.openqa.selenium.By;
//
//import org.openqa.selenium.WebDriver;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import org.openqa.selenium.support.ui.ExpectedCondition;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import org.testng.asserts.SoftAssert;
//
//
//
//import com.aventstack.extentreports.util.Assert;
//
//
//
//import cucumber.api.java.en.But;
//
//import cucumber.api.java.en.Given;
//
//import cucumber.api.java.en.Then;
//
//import cucumber.api.java.en.When;
//
//import groovy.time.Duration;
//
//
//
//public class Loginsteps {
//
//
//WebDriver ak;
//
//
//
//@Given("User should navigate to app")
//
//public void userShouldNavigate() {
//
//ak=new ChromeDriver();
//
//ak.get("https://admin-demo.nopcommerce.com/login");
//
//ak.manage().window().maximize();
//
//ak.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//
//// System.out.println("I am here");
//
//}
//
//
//@Given("enter username {string}")
//
//public void userClicksOnLoginBut(String akuser) {
//
//System.out.println(akuser+ ":actual user taken");
//
//ak.findElement(By.id("Email")).clear();
//
//ak.findElement(By.id("Email")).sendKeys(akuser);
//
//
//
//}
//
//
//
//
//@Given("enter password {string}")
//
//public void enterPasswordPass(String akpass) {
//
//ak.findElement(By.id("Password")).clear();
//
//ak.findElement(By.id("Password")).sendKeys(akpass);
//
//
//
//
//}
//
//
//
//@When("user click login")
//
//public void userClickLogin() {
//
//
//ak.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
//
//
//}
//
//
//
//@Then("login should go")
//
//public void loginShouldGo() {
//
//WebDriverWait akwait= new WebDriverWait(ak, java.time.Duration.ofSeconds(10));
//
//try {
//
//akwait.until(ExpectedConditions.urlMatches("https://admin-demo.nopcommerce.com/admin/"));
//
//System.out.println("Admin page loaded successfully."); // Optional: Indicate success
//
//ak.quit();
//
//} catch (Exception e) {
//
//
//String akerrormessage = ak.findElement(By.id("Email-error")).getText();
//
//
//System.out.println("Execution done & fail:" +akerrormessage);
//
//// org.testng.Assert.assertEquals(akerrormessage, "Please enter a valid email address.");
//
//SoftAssert sa = new SoftAssert();
//
//sa.assertEquals(akerrormessage, "Please enter a valid email address.");
//
//sa.assertAll();
//
//
//
//}
//
//
//
//
//}
//
//
//
//
//
//
//} make this as a thread safe