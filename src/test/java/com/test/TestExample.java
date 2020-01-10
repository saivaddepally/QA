package com.test;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestExample {
    WebDriver webDriver;

    @BeforeClass
    public void googleSearch() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeMethod(description = "for adding city")
    public void addCity() {
        webDriver.get("https://savvytime.com/converter");
        webDriver.findElement(By.xpath("//input[@id='time-search']")).sendKeys("Hyderabad");
        webDriver.findElements(By.xpath("//a[@data-id='india-hyderabad']")).get(0).click();
        webDriver.findElement(By.xpath("//input[@id='time-search']")).sendKeys("Fresno");
        webDriver.findElements(By.xpath("//div[@id='converter-quick-search-result']//a")).get(0).click();
//        WebElement element = webDriver.findElement(By.xpath("//h1[@class='title']"));
//        Assert.assertTrue(element.getText().contains("Hyderabad"),"wrqr");
    }


    @Test(priority = 1,description = "checking swap button")
    public void swapCities() {
        List<WebElement> beforeSwap=webDriver.findElements(By.xpath("//a[@class='time-abb']"));
        List<String> bs=new ArrayList<String>();

        for(WebElement webElement:beforeSwap)
        {
            bs.add(webElement.getText());
        }

        webDriver.findElement(By.xpath("//a[@class='swap-tz btn']")).click();
        List<WebElement> afterSwap=webDriver.findElements(By.xpath("//a[@class='time-abb']"));
        List<String> as=new ArrayList<String>();
        for(WebElement webElement:afterSwap)
        {
            as.add(webElement.getText());
        }
        Collections.reverse(as);
        Assert.assertEquals(bs,as);
    }

    @Test(priority = 2,description = "checking delete operation after selection")
    public void deleteCity() {
        webDriver.findElement(By.xpath("//div[@data-id='india-hyderabad']")).click();
        webDriver.findElement(By.xpath("//a[@class='delete-btn btn']")).click();
    }

    @Test(priority = 3,description = "redirecting to reference on selecting the city")
    public void newPage() {
        webDriver.findElement(By.xpath("//a[@class='time-abb']")).click();
    }

    @Test(priority = 4,description = "closing the browser")
    public void closeBrowser() {
        webDriver.close();
    }
}