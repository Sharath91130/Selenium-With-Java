package org.example.Classes.HandleWindows;

import com.sun.jdi.ThreadReference;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
   driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");




        driver.findElement(By.xpath("//*[@id=\"PopUp\"]")).click();;

            Thread.sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles.size());


        List<String> ids=new ArrayList<>(windowHandles);




        driver.switchTo().window(ids.get(1));

        if(driver.getCurrentUrl().equals("https://playwright.dev/")){
            System.out.println("driver not swithced");


            return;
        }

        driver.switchTo().window(ids.get(0)).close();
        driver.switchTo().window(ids.get(2)).close();
        driver.switchTo().window(ids.get(1));

        driver.manage().window().maximize();

        System.out.println(driver.getCurrentUrl());


        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main/section[2]/div/div/div[1]/div/div[2]/div/a"))).getText();

        System.out.println(text);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main/section[2]/div/div/div[1]/div/div[2]/div/a"))).click();


        System.out.println(driver.getCurrentUrl());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/main/div/p[3]/a"))).click();


        // //*[@id="docsearch-input"]  search


    }

    public static void   SeleniumDevWindow(WebDriver driver,String id){

        WebDriver window = driver.switchTo().window(id);
        System.out.println(window.getCurrentUrl());
        WebDriverWait wait=new WebDriverWait(window, Duration.ofSeconds(15));


        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main/section[2]/div/div/div[1]/div/div[2]/div/a"))).getText();




    }
}
