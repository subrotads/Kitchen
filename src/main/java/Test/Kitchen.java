package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Kitchen {
	
	
	public static void main(String [] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://kitchen.applitools.com/");
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.//h3[text()='Alert']]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='alert-button']"))).click();
		driver.switchTo().alert().accept();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='confirm-button']"))).click();
		driver.switchTo().alert().dismiss();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='prompt-button']"))).click();
		driver.switchTo().alert().sendKeys("Mutton");
		driver.switchTo().alert().accept();
		
		driver.close();
	}

}
