package org.example.Classes;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class JSPLoginTest {

    public void testLoginJSP() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get("https://modus.ad.modus.com:34000/fininfra/ui/SSOLogin.jsp");

        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();


        driver.switchTo().frame(0);

        driver.findElement(By.id("usertxt")).sendKeys("IND106");
        driver.findElement(By.id("passtxt")).sendKeys("mod@123");
        driver.findElement(By.id("Submit")).click();


        driver.switchTo().defaultContent();


        String originalWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                System.out.println("Switched to new window: " + window);
            }
        }

        Thread.sleep(3000);


        WebElement dropdown = null;
        try {
            dropdown = driver.findElement(By.id("appSelect"));
            System.out.println("Dropdown found in MAIN PAGE");
        } catch (Exception ignored) {}


        if (dropdown == null) {
            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            System.out.println("Total IFRAMES: " + iframes.size());

            for (int i = 0; i < iframes.size(); i++) {
                try {
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame(i);

                    dropdown = driver.findElement(By.id("appSelect"));
                    System.out.println("Dropdown found in IFRAME index: " + i);
                    break;
                } catch (Exception ignored) {}
            }
        }


        if (dropdown == null) {
            List<WebElement> frames = driver.findElements(By.tagName("frame"));
            System.out.println("Total FRAMESET FRAMES: " + frames.size());

            for (int i = 0; i < frames.size(); i++) {
                try {
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame(i);

                    dropdown = driver.findElement(By.id("appSelect"));
                    System.out.println("Dropdown found in FRAME index: " + i);
                    break;
                } catch (Exception ignored) {}
            }
        }


        if (dropdown == null) {
            throw new RuntimeException("ERROR: Could not locate appSelect in ANY frame or window.");
        }





        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert Message: " + alert.getText());
            alert.accept();
            System.out.println("Alert accepted successfully.");
        } catch (NoAlertPresentException e) {
            System.out.println("No alert appeared after dropdown selection.");
        }


    }
}
