package com.clearTrip.utils;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	
	public void waitForElementToAppear(WebDriver driver,String loc) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loc)));
        //By.xpath("\"" + loc + "\"")
        
        
    }
	
	public void waitFortextToBePresentInElement(WebDriver driver,WebElement element,String text) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        //By.xpath("\"" + loc + "\"")
        
        
    }
	
	public WebElement presenceOfTheElement(final WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SeleniumDriver.getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });

    }

	
	public void waitFor(int milliSeconds)
	{
		try
		{
			Thread.sleep(milliSeconds);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean isAlertPresent(){
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 10 /*timeout in seconds*/);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	    }
	    return foundAlert;
	}
	
	public static boolean isElementPresent(WebElement webElement) {
        try {
            boolean isPresent = webElement.isDisplayed();
            return isPresent;
        } catch (NoSuchElementException e) {
            return false;
        }
        
    }

}
