package steps;

import java.util.ArrayList;
import java.util.List;

import com.clearTrip.pages.actions.FlightSearchResultsPageActions;
import com.clearTrip.pages.actions.ItineraryPageActions;
import com.clearTrip.pages.locators.ItineraryPageLocators;
import com.clearTrip.utils.CommonMethods;
import com.clearTrip.utils.GetScreenShot;
import com.clearTrip.utils.SeleniumDriver;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;

public class FlightsSearchResults {
	
	public static List<String> onWardFlightDetails=new ArrayList<String>();
	public static List<String> returnFlightDetails=new ArrayList<String>();
	
	FlightSearchResultsPageActions searchActions=new FlightSearchResultsPageActions();
	
	@Then("^I wait For Results to Apper on the Screen$")
	public void i_wait_For_Results_to_Apper_on_the_Screen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Then("^I select (\\d+) Flight and (\\d+) flight to book tickets$")
	public void i_select_Flight_and_flight_to_book_tickets(int depart, int retr) throws Throwable {
	    
		String beforeSelect=new GetScreenShot().capture(SeleniumDriver.getDriver(), "beforeSelect");
		Reporter.addScreenCaptureFromPath(beforeSelect, "Before selection of Flights");
		searchActions.clickToChooseDeparture_ReturnFlights(searchActions.getDepartureFlightsList(), searchActions.getReturnFlightsList(), depart, retr);
		Reporter.addStepLog("After Selecting From and To Flights");
		String AfterSelect=new GetScreenShot().capture(SeleniumDriver.getDriver(), "AfterSelect");
		Reporter.addScreenCaptureFromPath(AfterSelect, "After selection of Flights");
	}

	@Then("^I read departure Flights (\\d+) rowData$")
	public void i_read_DepartureFlights_rowData(int row) throws Throwable {
	   
		
		onWardFlightDetails=searchActions.getSelectedRowData(searchActions.getDepartureFlightsList(),row);
	}
	
	@Then("^I read Return Flights (\\d+) rowData$")
	public void i_read_ReturnFlights_rowData(int row) throws Throwable {
	   
		returnFlightDetails=searchActions.getSelectedRowData(searchActions.getReturnFlightsList(),row);
	}
	@Then("^I Book the Tickets$")
	public void i_Book_Tickets() throws Throwable {
	   
		searchActions.clickBookTikcetsButton();
		new CommonMethods().waitFor(20000);
		String reivewPage=new GetScreenShot().capture(SeleniumDriver.getDriver(), "reivewPage");
		Reporter.addScreenCaptureFromPath(reivewPage, "Checkout Page");
	}
	
	@Then("^I read ItenaryDetails$")
	public void i_Read_ItineraryDetails() throws Throwable {
	   
		new ItineraryPageActions().getOnwardJourneyFlightDetails();
		new ItineraryPageActions().getReturnJourneyFlightDetails();
		new ItineraryPageActions().verifyItineraryOnWardFlightDetails_With_SearchPageOnwardFlightDetails();
		new ItineraryPageActions().verifyItineraryReturnFlightDetails_With_SearchPageRetunFlightDetails();
		
	}
	 

}
