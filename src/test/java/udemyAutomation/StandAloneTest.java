package udemyAutomation;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("afiyabegummohammad@gmail.com"); // username
		driver.findElement(By.id("userPassword")).sendKeys("Afiyahmad@8383"); // pwd
		driver.findElement(By.id("login")).click(); // login btn
		String product = "ADIDAS ORIGINAL";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("toast-container"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		// different products are there so taking alla in one list
		List<WebElement> pro = driver.findElements(By.cssSelector(".col-lg-4"));
		// now need to click on "Add to cart" button of specific product
		WebElement p = pro.stream().filter(s -> s.findElement(By.cssSelector("b")).getText().equals(product))
				.findFirst().orElse(null);
		p.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(driver.findElement(By.id("toast-container")).getText());
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartpro = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean value = cartpro.stream().anyMatch(s -> s.getText().equalsIgnoreCase(product));
		Assert.assertTrue(value);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("IND");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group")));
		List<WebElement> listed = driver.findElements(By.cssSelector(".list-group-item"));
		listed.stream().filter(s -> s.getText().equalsIgnoreCase("India")).findFirst()
				.orElseThrow(() -> new RuntimeException("Option not found")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String val = driver.findElement(By.className("hero-primary")).getText();
		Boolean res = val.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(res);
		System.out.println(val);
		driver.close();

	}

}
