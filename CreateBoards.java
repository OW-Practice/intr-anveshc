package Boards;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateBoards {
//	public static WebDriver driver;
	public static WebDriver driver = new ChromeDriver();
	public static WebDriverWait wait;
	static int n = 2;

	public static void Registration() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://trello.com/home");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("username")).sendKeys("chandupatlaanvesh@gmail.com");
		driver.findElement(By.id("login-submit")).click();
		driver.findElement(By.id("password")).sendKeys("Chandu@528");
		driver.findElement(By.id("login-submit")).click();
	}

	public static void createboard() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("X7iA6JJNiXCA2r")).click();
		driver.findElement(By.className("gJDsPins_eYkBM")).click();
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("test1");
		driver.findElement(By.xpath("(//button[contains(@type,'button')])[23]")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@class=\"hY6kPzdkHFJhfG bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc\"]")).click();
		for (int i = 1; i <= n; i++) {
			WebElement Addboard = driver.findElement(By.xpath("//textarea[@class=\"oe8RymzptORQ7h\"]"));
			Addboard.click();
			String Boardnames = "Board" + (i);

			// Addlist button
			driver.findElement(By.xpath("//textarea[contains(@name,\"Enter list title…\")]")).sendKeys(Boardnames);
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		}
		// Addcard button
		for (int i = 1; i <= 4; i++) {
			WebElement Addcard = driver.findElement(By.xpath(
					"//button[@class=\"O9vivwyDxMqo3q bxgKMAm3lq5BpA iUcMblFAuq9LKn PnEv2xIWy3eSui SEj5vUdI3VvxDc\"]"));
			Addcard.click();
			String Cardnames = "Card" + (i);
			driver.findElement(By.xpath("//button[@data-testid=\"list-add-card-button\"]")).click();
			driver.findElement(By.xpath("//textarea[@class=\"qJv26NWQGVKzI9\"]")).sendKeys(Cardnames);
			driver.findElement(By.xpath("//button[@class=\"bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc\"]")).click();
			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[@class=\"bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc\"]")).click();
//			driver.findElement(By.xpath("//span[@data-testid=\"CloseIcon\"]")).click();

		}
		WebElement draggable = driver.findElement(By.xpath("//a[contains(text(),\"Card4\")]"));
		WebElement droppable = driver.findElement(By.className("Sb_QqNKeadm2oq"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(draggable, droppable).perform();
		
		driver.findElement(By.xpath("(//button[@aria-label=\"Edit card\"])[1]")).click();
		driver.findElement(By.xpath("(//button[@data-testid=\"quick-card-editor-change-cover\"])")).click();
		driver.findElement(By.xpath("(//button[@class=\"mQG6d96uKqvkeU ccKK61gi4PnIKL color-blind-pattern-red\"])")).click();
		actions.sendKeys(Keys.ESCAPE).build().perform();
//		driver.findElement(By.xpath("(//a[@class=\"pop-over-header-close-btn icon-sm icon-close\"])")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Registration();
		createboard();

	}

}
