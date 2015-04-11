package com.sprhib.test.selenium;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumMemberTest {
	
	@Test
    public void seleniumMemeberAddTest() {
		
        WebDriver driver = new HtmlUnitDriver();
        
        driver.get("http://localhost:8090/spr-mvc-hib/member/add.html");
        
        WebElement nameField1 = driver.findElement(By.id("firstName"));
        nameField1.clear();
        nameField1.sendKeys("First Name Selenium");
        
        WebElement nameField2 = driver.findElement(By.id("lastName"));
        nameField2.clear();
        nameField2.sendKeys("Last Name Selenium");
        
        Select dropdown = new Select(driver.findElement(By.id("teamsIds")));
        dropdown.selectByIndex(1);
        
        WebElement addButton = driver.findElement(By.className("btn")); 
        addButton.click();
        
        WebElement tdContent = driver.findElement(By.xpath("//td[contains(.,'First Name Selenium')]"));
        assertNotNull(tdContent);
        driver.quit();
    }

}
