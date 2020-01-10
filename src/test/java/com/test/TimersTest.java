package com.test;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TimersTest {
    WebDriver webDriver;
    @BeforeClass
    public void search()
    {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://savvytime.com/timers");
    }
    @Test
    public void selectTimer()
    {
        webDriver.findElement(By.xpath("//h4[@class='title']")).click();
        webDriver.findElement(By.xpath("//input[@id='timer-input']")).click();
        webDriver.findElement(By.xpath("//span[@class='county-hours']")).click();
//      webDriver.findElement(By.xpath("//span[@class='county-minutes']")).click().sendKeys(String.valueOf(20));
//      webDriver.findElement(By.xpath("//span[@class='county-seconds']")).click().sendKeys(String.valueOf(30));
    }
}
