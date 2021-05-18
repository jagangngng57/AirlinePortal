package com.clearTrip.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItineraryPageLocators {
	
	@FindBy(xpath="//*[text()=' Itinerary']")
	public WebElement itinerary_heading;
	
	@FindBy(xpath="//div[@class='itinerary clearFix onwBlock']//ul")
	public WebElement itinerary_onWardJourney;
	
	@FindBy(xpath="//div[@class='itinerary clearFix retBlock']//ul")
	public WebElement itinerary_returnJourney;
	
	
	
	
}
