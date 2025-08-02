package Lambda_Test_case.Lambda_assignment;

//public class Testcase_amz {
//	package Lambda_Test_case.Lambda_assignment;

	import java.time.Duration;

	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.*;

	public class Testcase_amz {

	    WebDriver driver;

	    @Parameters("browser")
	    @BeforeMethod
	    public void setup(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	        } else {
	            throw new IllegalArgumentException("Browser not supported: " + browser);
	        }

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().deleteAllCookies();
	    }

	    @Test
	    public void testAmazonMobilePrices() {
	        driver.get("https://www.amazon.in/");
	        try {
	            driver.findElement(By.xpath("//button[@type='submit']")).click(); // dismiss popup if any
	        } catch (Exception e) {
	            // ignore if not present
	        }

	        // Search for iPhone
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	        driver.findElement(By.id("nav-search-submit-button")).click();
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

	        // Add to cart steps (dummy - adapt as per actual button logic)
	        driver.findElement(By.id("a-autoid-1-announce")).click();
	        driver.findElement(By.linkText("Go to Cart")).click();

	        WebElement priceElement = driver.findElement(By.xpath("(//span[contains(@class,'sc-price')])[1]"));
	        System.out.println("Mobile price of iPhone: " + priceElement.getText());

	        // Search for Samsung
	        driver.findElement(By.id("twotabsearchtextbox")).clear();
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung galaxy");
	        driver.findElement(By.id("nav-search-submit-button")).click();
	        driver.findElement(By.id("a-autoid-1-announce")).click();
	        driver.findElement(By.linkText("Go to Cart")).click();

	        WebElement priceElement1 = driver.findElement(By.xpath("(//span[contains(@class,'sc-price')])[1]"));
	        System.out.println("Mobile price of Samsung Galaxy: " + priceElement1.getText());
	    }

	    @AfterMethod
	    public void tearDown() {
	        //driver.quit();
	    }
	}



