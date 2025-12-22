package org.example.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChainedXpath {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        String text = driver.findElement(By.xpath("//div[@id='blog-pager']//a[@href]")).getText();
        System.out.println(text);
    }
}
