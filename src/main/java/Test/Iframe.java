package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Iframe {
	
	
public static void main(String [] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://kitchen.applitools.com/");
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='iFrame']"))).click();
		
		WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='the-kitchen-table']")));
		driver.switchTo().frame(frame);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='column-button-name']"))).click();
		
		driver.close();
		
		
		
}
}
