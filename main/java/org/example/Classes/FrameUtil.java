package org.example.Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FrameUtil {

    public static boolean switchToFrameContainingElement(
            WebDriver driver,
            By locator,
            int depth
    ) {
        if (depth > 10) return false; // safety limit


        if (!driver.findElements(locator).isEmpty()) {
            return true;
        }

        List<WebElement> frames = new ArrayList<>();
        frames.addAll(driver.findElements(By.tagName("iframe")));
        frames.addAll(driver.findElements(By.tagName("frame")));


        for (WebElement frame : frames) {
            try {
                driver.switchTo().frame(frame);
                if (switchToFrameContainingElement(driver, locator, depth + 1)) {
                    return true;
                }
                driver.switchTo().parentFrame();
            } catch (Exception e) {
                driver.switchTo().parentFrame();
            }
        }
        return false;
    }

    public static void clickWhenClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );


        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }
    public static void printFrames(WebDriver driver, int depth) {
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        frames.addAll(driver.findElements(By.tagName("frame")));
        for (WebElement frame : frames) {
            String id = frame.getAttribute("id");
            String name = frame.getAttribute("name");
            System.out.println("Depth " + depth + " - Frame ID: " + id + ", Name: " + name);
            driver.switchTo().frame(frame);
            printFrames(driver, depth + 1);
            driver.switchTo().parentFrame();
        }
    }

    public static boolean switchToFrameContainingVisibleElement(WebDriver driver, By locator, int depth) {
        if (depth > 10) return false;

        try {
            List<WebElement> elements = driver.findElements(locator);
            for (WebElement el : elements) {
                if (el.isDisplayed()) {
                    return true;
                }
            }
        } catch (Exception e) {

        }

        List<WebElement> frames = new ArrayList<>();
        frames.addAll(driver.findElements(By.tagName("iframe")));
        frames.addAll(driver.findElements(By.tagName("frame")));

        for (WebElement frame : frames) {
            try {
                driver.switchTo().frame(frame);
                if (switchToFrameContainingVisibleElement(driver, locator, depth + 1)) {
                    return true;
                }
                driver.switchTo().parentFrame();
            } catch (Exception e) {
                driver.switchTo().parentFrame();
            }
        }
        return false;
    }

}
 