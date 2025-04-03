package monpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NJclass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//
//		driver.get("https://admin-demo.nopcommerce.com/login");
//
//		String webpagename = driver.getTitle();
//
//		System.out.println("name of the webpage : "+webpagename);
//
//		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
//		WebElement emailbox=driver.findElement(By.id("Email"));
//
//		emailbox.clear();
//		emailbox.sendKeys("admin@yourstore.com");
//
//		WebElement password=driver.findElement(By.id("Password"));
//		password.clear();
//		password.sendKeys("admin");
//		driver.findElement(By.id("Password")).sendKeys("admin");
//		driver.findElement(By.cssSelector("button")).click();

		// google search
		
		driver.get("https://www.google.com");
		WebElement searchbox = driver.findElement(By.id("APjFqb"));
		searchbox.sendKeys("testing");
		driver.findElement(By.name("btnK")).click();
		  

		// Edge
		WebDriver edriver = new FirefoxDriver();

		edriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		edriver.get("https://www.google.com");
		//WebElement Iesearch = edriver.findElement(By.id("uh-sbq"));
		WebElement Iesearch = edriver.findElement(By.id("APjFqb"));
		//Iesearch.clear();
		Iesearch.sendKeys("software");
		
		//edriver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/form/div[3]/button")).click();
		WebDriverWait wait = new WebDriverWait(edriver, Duration.ofSeconds(10));
		edriver.findElement(By.name("btnK")).click();
		
//		WebDriverWait wait = new WebDriverWait(edriver, Duration.ofSeconds(10));
//        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
//        searchButton.click();

	}

}
