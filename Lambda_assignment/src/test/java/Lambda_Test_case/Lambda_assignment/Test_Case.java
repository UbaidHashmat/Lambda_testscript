package Lambda_Test_case.Lambda_assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case {

	public static void main(String[] args) {
		
		//Chrome driver initialization
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.id("a-autoid-1-announce")).click();
		driver.findElement(By.linkText("Go to Cart")).click();
		WebElement priceElement= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]"));
		String price = priceElement.getText();
		System.out.println("Mobile price of iphone is: " + price);
		
		
		//Test case for samsung galaxy
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung galaxy");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.id("a-autoid-1-announce")).click();
		driver.findElement(By.linkText("Go to Cart")).click();
		WebElement priceElement1= driver.findElement(By.xpath("(//span[@class='a-price a-text-price sc-product-price sc-white-space-nowrap a-size-medium'])[1]"));
		 String price2 =priceElement1.getText();
		 System.out.println("Mbile price of Samsung Galaxy is:" + price2);
		 
		 driver.quit();
		
		

	}

}
