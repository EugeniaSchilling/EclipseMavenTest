package EclipseMavenTest.EclipseMavenTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SkypeTest {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
//		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Kommetar 111
	 * @throws Exception
	 */
	@Test
	public void testSkypeLoginWithoutAll() throws Exception {
		driver.get("https://www.skype.com/de/new/");
		driver.findElement(
				By.xpath("//div[@id='nav-buttons-wrapper']/nav/ul/li[4]/a/span"))
				.click();
		driver.findElement(By.xpath("(//a[contains(text(),'Mein Konto')])[3]"))
				.click();
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.id("usernameError")).click();
		try {
			assertEquals(
					driver.findElement(By.id("usernameError")).getText(),
					"Geben Sie eine g�ltige E-Mail-Adresse, eine Telefonnummer oder einen Skype-Namen ein.");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	/**
	 * Kommentar Test
	 * @throws Exception
	 */
	@Test
	public void testSkypeLoginWithoutPassword() throws Exception {
		driver.get("https://www.skype.com/de/new/");
		driver.findElement(
				By.xpath("//div[@id='nav-buttons-wrapper']/nav/ul/li[4]/a/span[2]"))
				.click();
		driver.findElement(By.xpath("(//a[contains(text(),'Mein Konto')])[3]"))
				.click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("evgenia.shiling");
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.id("passwordError")).click();
		try {
			assertEquals(driver.findElement(By.id("passwordError")).getText(),
					"Bitte geben Sie das Kennwort f�r Ihr Microsoft-Konto ein.");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
