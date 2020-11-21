package com.rappi.automationTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarnivalTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.carnival.com/");
	}
	
	
	public void userStory1() {
		
		WebElement close_cookies = driver.findElement(By.cssSelector("path"));
		WebElement cdc_destinations = driver.findElement(By.id("cdc-destinations"));
		WebElement cdc_ports = driver.findElement(By.id("cdc-ports"));
		WebElement cdc_durations = driver.findElement(By.id("cdc-durations"));
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("document.querySelector('#MainBody > div.vifp-sweeps-modal > div > div.vifp-close').click()");
		
		ewait.until(ExpectedConditions.elementToBeClickable(close_cookies));
		close_cookies.click();
		
		cdc_destinations.click();
		WebElement destination_theBahamas = driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div[1]/div[1]/div/div/div[2]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/ccl-search-bar-expandable-filter/div/ul/li[2]/button"));
		destination_theBahamas.click();
		
		cdc_ports.click();
		WebElement port_baltimoreMD = driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div[1]/div[1]/div/div/div[2]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/ccl-search-bar-expandable-filter/div/ul/li[1]/button"));
		port_baltimoreMD.click();
		
		cdc_durations.click();
		WebElement duration_6_9_days = driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div[1]/div[1]/div/div/div[2]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/ul/li[2]/button"));
		duration_6_9_days.click();
		
		WebElement button_search_cruises = driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div[1]/div[1]/div/div/div[2]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/ul/li[5]/a"));
		button_search_cruises.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement label_results = driver.findElement(By.xpath("/html/body/div[5]/form/div[3]/div/div/div/div/div/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div[2]/ccl-cruise-search-bar-count-and-options/div/span[2]"));
		assertTrue(label_results.getText().contains("Results"));
	}
	
	@Test
	public void userStory2() {
		userStory1();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement learnMore_button = driver.findElement(By.xpath("/html/body/div[5]/form/div[3]/div/div/div/div/div/ccl-cruise-search/div[3]/ccl-view-result-container/div/ccl-view-result-grid/article[1]/ccl-view-result-grid-item/div/div[1]/ccl-view-result-grid-footer/div/div[2]"));
		learnMore_button.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		assertTrue(driver.getCurrentUrl().contains("itinerary"));
	}

}
