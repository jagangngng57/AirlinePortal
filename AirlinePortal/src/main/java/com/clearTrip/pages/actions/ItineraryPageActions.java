package com.clearTrip.pages.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.clearTrip.pages.locators.ItineraryPageLocators;
import com.clearTrip.utils.SeleniumDriver;
import com.cucumber.listener.Reporter;

import steps.FlightsSearchResults;

public class ItineraryPageActions {
	public static List<String> onWardFlightDetailsItineraryPage=new ArrayList<String>();
	public static List<String> returnFlightDetailsItineraryPage=new ArrayList<String>();
	ItineraryPageLocators itinaryPageloc=null;
	
	public ItineraryPageActions()
	{
		itinaryPageloc=new ItineraryPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), itinaryPageloc);
	}
	
	public void getOnwardJourneyFlightDetails()
	{
		List<WebElement>details=itinaryPageloc.itinerary_onWardJourney.findElements(By.tagName("li"));
		System.err.println("count:"+details.size());
		onWardFlightDetailsItineraryPage.add(details.get(0).findElement(By.cssSelector("span.name")).getText());
		onWardFlightDetailsItineraryPage.add(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
		onWardFlightDetailsItineraryPage.add(details.get(2).getText());
		onWardFlightDetailsItineraryPage.add(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
	
	//	Reporter.addStepLog("Itinerary Page onWard Flight Details:"+onWardFlightDetailsItineraryPage.toString());
		System.err.println(details.get(0).findElement(By.cssSelector("span.name")).getText());
		System.err.println(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
		System.err.println(details.get(2).getText());
		System.err.println(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
		/*System.err.println("------------------------");
		for(WebElement ele:details)
				System.err.println(ele.getText());
		
		System.err.println("------------------------");*/
	}

	public void getReturnJourneyFlightDetails()
	{
		List<WebElement>details=itinaryPageloc.itinerary_returnJourney.findElements(By.tagName("li"));
		System.err.println("count:"+details.size());
		returnFlightDetailsItineraryPage.add(details.get(0).findElement(By.cssSelector("span.name")).getText());
		returnFlightDetailsItineraryPage.add(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
		returnFlightDetailsItineraryPage.add(details.get(2).getText());
		returnFlightDetailsItineraryPage.add(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
		
	//	Reporter.addStepLog("Itinerary Page return Flight Details:"+returnFlightDetailsItineraryPage.toString());
		
		System.err.println(details.get(0).findElement(By.cssSelector("span.name")).getText());
		System.err.println(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
		System.err.println(details.get(2).getText());
		System.err.println(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
		/*System.err.println("------------------------");
		for(WebElement ele:details)
				System.err.println(ele.getText());
		
		System.err.println("------------------------");*/
	}
	
	
	public void verifyItineraryOnWardFlightDetails_With_SearchPageOnwardFlightDetails()
	{
		System.err.println(onWardFlightDetailsItineraryPage.contains(new FlightsSearchResults().onWardFlightDetails));
		Reporter.addStepLog("Search Page onWard Flight Details:" +new FlightsSearchResults().onWardFlightDetails );
		Reporter.addStepLog("Itinerary Page onWard Flight Details:"+onWardFlightDetailsItineraryPage);
	}
	
	public void verifyItineraryReturnFlightDetails_With_SearchPageRetunFlightDetails()
	{
		System.err.println(returnFlightDetailsItineraryPage.contains(new FlightsSearchResults().returnFlightDetails));
		Reporter.addStepLog("Search Page onWard Flight Details:" +new FlightsSearchResults().returnFlightDetails);
		Reporter.addStepLog("Itinerary Page return Flight Details:"+returnFlightDetailsItineraryPage);
	}
	
	
}
