package com.sprhib.test.selenium;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumOrganizationTest {
	
	@Test
    public void seleniumTeamAddTest() {
		
        WebDriver driver = new HtmlUnitDriver();
        
        driver.get("http://localhost:8090/spr-mvc-hib/organization/add.html");
        
        WebElement nameField = driver.findElement(By.id("orgName"));
        nameField.clear();
        nameField.sendKeys("New Organization Selenium");
        
        WebElement addButton = driver.findElement(By.className("btn")); 
        addButton.click();
        
        WebElement tdContent = driver.findElement(By.xpath("//td[contains(.,'New Organization Selenium')]"));
        assertNotNull(tdContent);
        
        driver.quit();
    }

}
