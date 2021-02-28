package com.test;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginPageTest extends LoginPage {

	public static WebDriver driver;
	String emailId;
	String pwd;
	String url;
	
	@BeforeTest
	public void setup() throws IOException, ParseException {
	JSONParser jsonparser = new JSONParser();

	FileReader reader = new FileReader(".\\jsonfiles\\Data.json");

	JSONObject obj = (JSONObject) jsonparser.parse(reader);

	emailId = (String) obj.get("Email Id");
	pwd = (String) obj.get("Password");
	url = (String) obj.get("URL");
	start(url);
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() throws InterruptedException {
		
		validateLoginPage();
//		Assert.assertEquals(details, "qaenggtools@gmail.com");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}
	
}
