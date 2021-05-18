package steps;




import cucumber.api.java.Before;
import com.clearTrip.utils.SeleniumDriver;

public class BeforeActions  {

	@Before
    public static void setUp() {
		//ExtentCucumberFormatter.initiateExtentCucumberFormatter();
    	System.out.println("Before");
       SeleniumDriver.setUpDriver();
    }
}
