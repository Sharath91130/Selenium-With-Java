package org.example.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class XpathDemo {
    public static void main(String[] args) {
        //input[@id='Wikipedia1_wikipedia-search-input']

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

////  single attributes using x path
//        driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("ChromeOs");
//
//
//        driver.findElement(By.xpath("//input[@id='name'][@placeholder='Enter Name']")).sendKeys("sharath");


     // driver.findElement(By.xpath("//*[text()='START']")).click();



        /*
        x path with contain method
         */

       // driver.findElement(By.xpath("//input[contains(@placeholder,'E')]")).sendKeys("Sharath");


        // x path with the startwith method

        driver.findElement(By.xpath("//input[starts-with(@placeholder,'E')]")).sendKeys("Sharath");


    }
}
