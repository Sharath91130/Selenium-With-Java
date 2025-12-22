package org.example.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TagNameAndClass {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        List<WebElement> elements = driver.findElements(By.className("form-group"));
        System.out.println(elements.get(1));
        System.out.println(elements.size());


        List<WebElement> div = driver.findElements(By.tagName("div"));
        System.out.println(div.size());
    }
}
