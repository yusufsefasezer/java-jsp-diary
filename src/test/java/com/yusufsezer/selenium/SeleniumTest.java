package com.yusufsezer.selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.yusufsezer.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeleniumTest {
	
	WebDriver driver;
	WebDriverWait wait;
	String baseUrl; 
	User existingUser;
	
	@BeforeEach
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		baseUrl = "http://localhost:8080/java-jsp-diary/";
		existingUser = new User(1, "berly", "diaz", "berly@gmail.com", "berly"); 
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	void getMessage() {
				   
	    driver.navigate().to(baseUrl); 
	    
	    driver.manage().window().maximize();     
	    
	    driver.findElement(By.xpath("/html/body/main/div/aside/div/div/div/ul/a[1]")).click();
    
	    String message = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/div/div[1]/p")).getText();
	       
	    assertEquals("mensaje 1", message);
	}
	
	@Test
	void createMessage() {
				   
		final String SELENIUM_MESSAGE = "nuevo mensaje desde SeleniumTest";
		
	    driver.navigate().to(baseUrl); 
	    
	    driver.manage().window().maximize();     
	    
	    driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]/a")).click();	
	    
	    driver.findElement(By.id("email")).sendKeys(existingUser.getEmail());
	    driver.findElement(By.id("password")).sendKeys(existingUser.getPassword());
	    
	    driver.findElement(By.xpath("/html/body/main/div/div/form/button")).click();
	    driver.findElement(By.xpath("/html/body/main/div/a")).click();
	    
	    driver.findElement(By.id("diaryContent")).sendKeys(SELENIUM_MESSAGE); 
	    
	    driver.findElement(By.xpath("/html/body/main/div/div/form/button")).click();   
	    
	    driver.navigate().to(baseUrl); 
	    
	    String message = driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/div/div[1]/p")).getText();
	    
	    assertEquals(SELENIUM_MESSAGE, message); 
	}
}
