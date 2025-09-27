package Race;

import java.time.LocalTime;

public class BasicRace implements RaceComponent{
    private final String raceID;
    private final String raceName;
    private final String raceType;
    private final LocalTime raceDate;
    private final int miles;
    private final int registrationLimit;
    private final LocalTime lastRegistrationDate;
    private boolean isOfficial;
    private final int category;
    private int registeredRacers;

    public BasicRace(String raceID, String raceName, String raceType, LocalTime raceDate, int miles,
                     int registrationLimit, LocalTime lastRegistrationDate, boolean isOfficial, int category) {
        this.raceID = raceID;
        this.raceName = raceName;
        this.raceType = raceType;
        this.raceDate = raceDate;
        this.miles = miles;
        this.registrationLimit = registrationLimit;
        this.lastRegistrationDate = lastRegistrationDate;
        this.isOfficial = isOfficial;
        this.category = category;
        this.registeredRacers = 0;
    }

    public BasicRace(){
        this.raceID = "iAMspeed";
        this.raceName = "Kachow";
        this.raceType = "Basic";
        this.raceDate = null;
        this.miles = 3;
        this.registrationLimit = 2;
        this.lastRegistrationDate = null;
        this.isOfficial = false;
        this.category = 5;
        this.registeredRacers = 0;
    }

    @Override
    public String getDescription() {
        return "Race ID: " + raceID + "\n" + "Race Name: " + raceName + "\n" + "Race Type: " + raceType + "\n" +
                "Distance: " + miles + "\n" + "Registration Limit: " + registrationLimit + "\n" + "Last Registration Date: "
                + lastRegistrationDate + "\n" + "Official: " + isOfficial + "\n" + "Category: " + category;
    }

    @Override
    public double getCost() {
        return 10.0;
    }

    @Override
    public int getAvailableSpots() {
        return registrationLimit - registeredRacers;
    }

    @Override
    public void startRace() {
        System.out.println("Race Started");
    }

    public void trackRegistration(){
        registeredRacers++;
    }

    public String getRaceID() {
        return raceID;
    }
    public String getRaceName() {
        return raceName;
    }
}
