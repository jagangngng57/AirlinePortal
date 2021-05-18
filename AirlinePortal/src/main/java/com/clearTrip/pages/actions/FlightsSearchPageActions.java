package com.clearTrip.pages.actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;
import com.clearTrip.pages.locators.FlightsSearchPageLocators;
import com.clearTrip.utils.CommonMethods;
import com.clearTrip.utils.SeleniumDriver;

public class FlightsSearchPageActions {
	
	FlightsSearchPageLocators flightSearchPageLoc=null;
	
	public FlightsSearchPageActions()
	{
		flightSearchPageLoc=new FlightsSearchPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), flightSearchPageLoc);
	}
	
	public void clickonFlights()
	{
		try {
			Thread.sleep(20000);
			flightSearchPageLoc.searchPage_FlightsBtn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chooseToHaveRoundTripJourney() {
		flightSearchPageLoc.searchPage_RoundTripRadioBtn.click();
    }
	
	public void enterSourceAs(String destination) {
		flightSearchPageLoc.searchPage_FromTag.clear();
		flightSearchPageLoc.searchPage_FromTag.sendKeys(destination);
    }


    public void enterDestinationAs(String origin) {
    	flightSearchPageLoc.searchPage_ToTag.clear();
    	flightSearchPageLoc.searchPage_ToTag.sendKeys(origin);
    }
    
    
    public void enterDepartureDateAs(String date) {
    	flightSearchPageLoc.searchPage_DepartDate.clear();
    	flightSearchPageLoc.searchPage_DepartDate.sendKeys(date);
    }

    public void enterReturnDateAs(String date) {
    	flightSearchPageLoc.searchPage_ReturnDate.clear();
    	flightSearchPageLoc.searchPage_ReturnDate.sendKeys(date);
    	SeleniumDriver.getDriver().findElement(By.xpath("//*[@class='monthBlock last']//a[text()='"+date.split("/")[0]+"'] ")).click();
    }
    
    public void selectNumberOfAdults(String adults)
    {
    	Select select=new Select(flightSearchPageLoc.searchPage_Adults);
    	select.selectByValue(adults);
    }
    
    public void selectNumberOfChilds(String childs)
    {
    	Select select=new Select(flightSearchPageLoc.searchPage_Children);
    	select.selectByValue(childs);
    }
    
    public void clickSearchButton()
    {
    	flightSearchPageLoc.searchPage_SearchBtn.click();
    	new CommonMethods().waitFor(60000);
    	clickDepartFlightPriceInDesc();
    }
    
    
    public void clickDepartFlightPriceInDesc()
    {
    	List<WebElement>elements=SeleniumDriver.getDriver().findElements(By.xpath("//a[text()='Price']"));
    	System.err.println("count:"+elements.size());
    	System.err.println(elements.get(0).getAttribute("class"));
    	System.err.println(elements.get(1).getAttribute("class"));
    	if(elements.get(0).getAttribute("class").equalsIgnoreCase("current sortAsc"))
    		elements.get(0).click();
    	if(elements.get(1).getAttribute("class").equalsIgnoreCase("current sortAsc"))
    		elements.get(1).click();
    	
    	
    }
    
    public void selectTheFirstAvailableAutoCompleteOptionFromSource() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SeleniumDriver.getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement optionListElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("#ui-id-1"));
            }
        });

        //select the first item from the auto complete list
        WebElement originOptionsElement = optionListElement;
        List<WebElement> originOptions = originOptionsElement.findElements(By.tagName("li"));
        originOptions.get(0).click();
    }
    
    public void selectTheFirstAvailableAutoCompleteOptionFromDestination() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SeleniumDriver.getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement optionListElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("#ui-id-2"));
            }
        });

        //select the first item from the auto complete list
        WebElement originOptionsElement = optionListElement;
        List<WebElement> originOptions = originOptionsElement.findElements(By.tagName("li"));
        originOptions.get(0).click();
    }

}
