import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();

	String theWebsite = "https://www.saucedemo.com/";

	String TheUserName = "standard_user";
	String TheUserPassword = "secret_sauce";
	Random rand = new Random();

	@BeforeTest
	public void mySetup() {
		driver.get(theWebsite);

		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void login() {
		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		UserNameInput.sendKeys(TheUserName);

		WebElement PasswordInput = driver.findElement(By.id("password"));
		PasswordInput.sendKeys(TheUserPassword);

		WebElement LoginButton = driver.findElement(By.id("login-button"));
		LoginButton.click();

	}

	@Test(priority = 2, enabled = false)
	public void AddItem() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();

		}
	}

	@Test(priority = 3, enabled = false)
	public void AddRightItem() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> addToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < addToCartButtons.size(); i++) {

			if (i == 0 || i == 2)
				;
			{
				continue;
			}
		}

	}

	@Test(priority = 4)
	public void addLeftSideItems() throws InterruptedException {
		Thread.sleep(2000);

		List<WebElement> addToCartButtons = driver.findElements(By.className("btn"));
		int randomindex = rand.nextInt(addToCartButtons.size());
		System.out.println(randomindex);
		addToCartButtons.get(randomindex).click();
	}

	@Test(priority = 5)
	public void checkout() throws InterruptedException {
		Thread.sleep(3000);
		WebElement shopingCartButton = driver.findElement(By.className("shopping_cart_link"));

		shopingCartButton.click();

		WebElement CheckOutButton = driver.findElement(By.id("checkout"));
		CheckOutButton.click();

		String[] firstname = { "Majd", "Rahaf", "Zenab", "Ziad", "Ahmad", "Othman" };
		String[] Lasttname = { "Mohamd", "Raashed", "Zeyad", "Shaker", "Salameh", "Fares" };

		String[] postalCodes = { "12345", "67890", "54321", "98765", "11223" };

		int randominddexfirst = rand.nextInt(firstname.length);
		int randomindexlast = rand.nextInt(Lasttname.length);
		int randomindexcode = rand.nextInt(postalCodes.length);
		WebElement firstnamebutton = driver.findElement(By.id("first-name"));
		firstnamebutton.sendKeys(firstname[randominddexfirst]);
		;
		WebElement lastnamebutton = driver.findElement(By.id("last-name"));
		lastnamebutton.sendKeys(Lasttname[randomindexlast]);
		WebElement codebutton = driver.findElement(By.id("postal-code"));
		codebutton.sendKeys(postalCodes[randomindexcode]);
		Thread.sleep(3000);
		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();

		WebElement finshButton = driver.findElement(By.id("finish"));
		finshButton.click();
	}

}