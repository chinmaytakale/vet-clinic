package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LeaveAfter;

public class TripPlannerForm {
	
	@FindBy(css="#itdDate")
	public WebElement TRAVEL_DAY;
	
	@FindBy(css="#itdTimeHour")
	public WebElement TIME_HOUR;
	
	@FindBy(css="#itdTimeMinute")
	public WebElement TIME_MINUTE;
	
	@FindBy(id ="display_destination")
	public WebElement DESTINATION;
	
	@FindBy(id ="display_origin")
	public WebElement DEPARTURE;
	
	@FindBy(name = "btnTripPlannerSubmit")
    public WebElement SUBMIT_BUTTON;
	
//    public static final By TRAVEL_DAY = By.cssSelector("#itdDate");
//    public static final By TIME_HOUR = By.cssSelector("#itdTimeHour");
//    public static final By TIME_MINUTE = By.cssSelector("#itdTimeMinute");
//    public static final By DESTINATION = By.id("display_destination");
//    public static final By DEPARTURE = By.id("display_origin");
//    public static final By SUBMIT_BUTTON = By.name("btnTripPlannerSubmit");


	static final Map<DeparturePreference, By> DEPARTURE_RADIO_BUTTONS = new HashMap<>();
    static {
        DEPARTURE_RADIO_BUTTONS.put(ArriveBefore, By.id("itdTripDateTimeArr"));
        DEPARTURE_RADIO_BUTTONS.put(LeaveAfter, By.id("itdTripDateTimeDep"));
    }

    public static By departureButtonFor(DeparturePreference departurePreference) {
        return DEPARTURE_RADIO_BUTTONS.get(departurePreference);
    }
}