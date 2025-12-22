package org.example.CssSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CssSelectorExample {
    public static void main(String[] args) {
      WebDriver driver=new ChromeDriver();
//        driver.get("https://demo.nopcommerce.com/");
//        driver.manage().window().maximize();
//        // Select Tag example
//
////        Select select=new Select(driver.findElement(By.cssSelector("select#customerCurrency")));
////
////        if(select==null){
////            System.out.println("not find");
////        }
////
////
////        select.selectByVisibleText("Euro");
//
//
//        // tag.classname
//
//
//       // driver.findElement(By.cssSelector(".search-box-text")).sendKeys("sharath");
//
////        driver.findElement(
////                By.cssSelector("input[name='pollanswers-1'][value='1']")
////        ).click();
//
//
//
//        //menu__item menu-dropdown
//
//        WebElement element = driver.findElement(
//                By.cssSelector("a.menu__link[href='/computers']")
//        );
//
//       element.click();
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", element);
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");



        WebElement element = driver.findElement(By.cssSelector("button.dropbtn"));
        element.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click();", element);


    }
}

