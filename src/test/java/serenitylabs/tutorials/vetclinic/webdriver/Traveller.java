package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;

public class Traveller {
    private final WebDriver driver;
    TripPlannerForm tripPlannerForm;

    public Traveller(WebDriver driver) {

        this.driver = driver;
        tripPlannerForm = new TripPlannerForm();
        PageFactory.initElements(driver, tripPlannerForm);
    }


    public void planTrip() {
    	tripPlannerForm.SUBMIT_BUTTON.click();
    }

    private static final DecimalFormat TIME_UNIT_FORMAT = new DecimalFormat("##");

    public void theTrainShould(DeparturePreference departurePreference,
                                int hour,
                                int minute,
                                TravelDay travelDay) {
        driver.findElement(TripPlannerForm.departureButtonFor(departurePreference)).click();

        new Select(tripPlannerForm.TRAVEL_DAY)
                .selectByIndex(travelDay.getDaysInFuture());

        Select hourList = new Select(tripPlannerForm.TIME_HOUR);
        hourList.selectByVisibleText(TIME_UNIT_FORMAT.format(hour));

        Select minuteList = new Select(tripPlannerForm.TIME_MINUTE);
        minuteList.selectByVisibleText(TIME_UNIT_FORMAT.format(minute));

    }

    public void destinationStationIs(String station) {
        tripPlannerForm.DESTINATION.sendKeys(station);
    }

    public void departureStationIs(String station) {
        tripPlannerForm.DEPARTURE.sendKeys(station);
    }


    public TripPreferences displayedTripPreferences() {

        String arriveOrDepart = new Select(driver.findElement(TripSummaryView.ARRIVE_OR_DEPART)).getFirstSelectedOption().getText();
        String displayedOrigin = driver.findElement(TripSummaryView.ORIGIN).getAttribute("value");
        String displayedDestination = driver.findElement(TripSummaryView.DESTINATION).getAttribute("value");
        String arrivalDay = new Select(driver.findElement(TripSummaryView.DAY)).getFirstSelectedOption().getText();
        String arrivalHour = new Select(driver.findElement(TripSummaryView.HOUR)).getFirstSelectedOption().getText();
        String arrivalMinute = new Select(driver.findElement(TripSummaryView.MINUTE)).getFirstSelectedOption().getText();

        return TripPreferences.arrivingOrDeparting(arriveOrDepart)
                .from(displayedOrigin)
                .to(displayedDestination)
                .arrivingOn(arrivalDay)
                .at(arrivalHour, arrivalMinute);
    }
}
