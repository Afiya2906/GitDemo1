//package udemyAutomation;
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import udemyAutomation.AbstractComponents.BasePage;
//import udemyAutomation.AbstractComponents.CartPage;
//import udemyAutomation.AbstractComponents.LoginPage;
//import udemyAutomation.AbstractComponents.OrderPage;
//import udemyAutomation.AbstractComponents.PaymentPage;
//import udemyAutomation.AbstractComponents.ProductsPage;
//
//public class EcommerceTest {
//	
//	
//
//	String product = "ADIDAS ORIGINAL";
//	@Test
//	public void submit()
//	{
//		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://rahulshettyacademy.com/client");
//		LoginPage loginpage = new LoginPage(driver);
//		ProductsPage productspage = loginpage.login("afiyabegummohammad@gmail.com", "Afiyahmad@8383");
//		productspage.getProList();
//		CartPage cartpage = productspage.addProToCart(product);
//		Boolean m = cartpage.VerifyProductDisplay(product);
//		Assert.assertTrue(m);
//		PaymentPage paymentpage = cartpage.checkout(product);
//		paymentpage.placeorder("Ind", "India");
//		Assert.assertTrue(paymentpage.thanks("THANKYOU FOR THE ORDER."));
//	}
//	
//	@Test()
//	public void order()
//	{
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://rahulshettyacademy.com/client");
//		LoginPage loginpage = new LoginPage(driver);
//		
//		ProductsPage productspage = loginpage.login("afiyabegummohammad@gmail.com", "Afiyahmad@8383");
//		OrderPage orderpage = productspage.gotoOrder();
//		Assert.assertTrue(orderpage.VerifyOrderDisplay(product));
//		
//	}
//	
//}
