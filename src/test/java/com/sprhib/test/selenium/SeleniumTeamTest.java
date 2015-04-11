package com.sprhib.test.selenium;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumTeamTest {
	@Test
    public void seleniumTeamModifyTest() {
		
        WebDriver driver = new HtmlUnitDriver();
        
        driver.get("http://localhost:8090/spr-mvc-hib/team/list.html");
        
        WebElement tdContent = driver.findElement(By.xpath("//td[contains(.,'Business Analysts Team Two')]"));
        WebElement trParent = tdContent.findElement(By.xpath(".."));
        WebElement editButton = trParent.findElement(By.className("btn btn-primary"));
        
        editButton.click();
        
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.clear();
        nameField.sendKeys("Business Analysts Team Two Modified");
        
        WebElement saveButton = driver.findElement(By.className("btn"));
        saveButton.click();
        
        tdContent = driver.findElement(By.xpath("//td[contains(.,'Business Analysts Team Two Modified')]"));
        assertNotNull(tdContent);
        driver.quit();
    }

}
