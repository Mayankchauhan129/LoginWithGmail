package com.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginPage {
	
	public static WebDriver driver;
	public static Properties prop;
	static String url ;

	public static void start(String url) throws IOException, ParseException {

		
		prop = new Properties();
		FileInputStream ip = new FileInputStream(".\\src\\main\\java\\config\\config.properties");
		prop.load(ip);

		String browserName = (String) prop.get("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		String a = url;
		
		driver.get(a);

	}
	
	public String validateLoginPage() throws InterruptedException {
		WebElement email = driver.findElement(By.xpath("//*[@type='email']"));
		email.sendKeys("qaenggtools@gmail.com");
		Thread.sleep(3000);
		WebElement SignInButton =driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		SignInButton.click();
		WebElement password =driver.findElement(By.xpath("//*[@type='password']"));
		password.sendKeys("Mayank@129");
		WebElement SignInButton1 =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		SignInButton1.click();
		WebElement element = driver.findElement(By.xpath("//*[@aria-label='Account Information']//div[@class='gb_ob']"));
		String accountEmailId = element.getText();
		return accountEmailId;

	}

}

