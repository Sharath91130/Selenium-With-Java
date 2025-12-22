package org.example.Locators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LinkTextAndPartialText {

    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");


        driver.findElement(By.linkText("Download Files")).click();


    }

    }

