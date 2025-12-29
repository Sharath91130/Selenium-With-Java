package org.example.Classes.HandleWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();

       driver.navigate().to("https://testautomationpractice.blogspot.com/");
        System.out.println("step 1"+driver.getCurrentUrl());
       driver.navigate().to("https://www.amazon.com/");
        System.out.println("step 2"+driver.getCurrentUrl());

       driver.navigate().back();
        System.out.println("step 3"+driver.getCurrentUrl());
       driver.navigate().forward();
        System.out.println("step 2"+driver.getCurrentUrl());
    }
}
