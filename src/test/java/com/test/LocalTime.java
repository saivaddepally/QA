package com.test;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LocalTime {
    WebDriver webDriver;
    @BeforeClass

    public void LocalTIme()
    {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://savvytime.com/local");

    }
    @Test
    public void searchCity()
    {
        webDriver.findElement(By.xpath("//input[@id='place-search']")).sendKeys("Singapore");
        webDriver.findElements(By.xpath("//div[@id='home-quick-search-result']")).get(0).click();
        //WebElement element = webDriver.findElement(By.xpath("//a[@class='list-group-item']"));
        //Assert.assertTrue(element.getText().contains("Singapore"),"Sucessfull");
    }

}
