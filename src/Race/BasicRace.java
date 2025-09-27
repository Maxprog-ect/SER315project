package Race;

import Users.Racer;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class BasicRace implements RaceComponent {
    private final String raceID;
    private final String raceName;
    private final String raceType;
    private final LocalDate raceDate;
    private final int miles;
    private final int registrationLimit;
    private final LocalDate lastRegistrationDate;
    private int registeredRacers;
    private HashMap<String, Registration> raceRegistration;
    private List<RegistrationListener> listeners = new ArrayList<>();

    public BasicRace(String raceID, String raceName, String raceType, LocalDate raceDate, int miles,
                     int registrationLimit, LocalDate lastRegistrationDate) {
        this.raceID = raceID;
        this.raceName = raceName;
        this.raceType = raceType;
        this.raceDate = raceDate;
        this.miles = miles;
        this.registrationLimit = registrationLimit;
        this.lastRegistrationDate = lastRegistrationDate;
        this.registeredRacers = 0;
        this.raceRegistration = new HashMap<>();
    }

    public BasicRace(){
        this.raceID = "iAMspeed";
        this.raceName = "Kachow";
        this.raceType = "Basic";
        LocalDate now = LocalDate.now();
        this.raceDate = now.plusDays(30);
        this.miles = 3;
        this.registrationLimit = 2;
        LocalDate today = LocalDate.now();
        this.lastRegistrationDate = today.plusDays(14);
        this.registeredRacers = 0;
        raceRegistration = new HashMap<>();
    }

    @Override
    public String getDescription() {
        return "Race ID: " + raceID + "\n" + "Race Name: " + raceName + "\n" + "Race Type: " + raceType + "\n" +
                "Distance: " + miles + "\n" + "Registration Limit: " + registrationLimit + "\n" + "Last Registration Date: "
                + lastRegistrationDate + "\n";
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

    public void registerRacer(Racer racer, int category) {
        if(racer.getRacerLicense() == null){
            System.out.println("ERROR: Racer does not have a license.");
            return;
        }else if(racer.getRacerLicense().checkLicenseValid() == -1) {
            System.out.println("ERROR: License for Racer " + racer.getName() + " is invalid.");
            return;
        }

        if (registeredRacers >= registrationLimit) {
            System.out.println("ERROR: Cannot complete registration -- race is full.");
            return;
        }
        if(racer.getCategory() != category) {
            System.out.println("ERROR: Racer does not have correct category");
            return;
        }
            Registration newReg = new Registration(this, racer, category);
            newReg.processPayment();
            raceRegistration.put(newReg.getRegID(), newReg);
            trackRegistration();

            notifyRegistrationListeners(newReg);
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

    public void addRegistrationListener(RegistrationListener listener) {
        listeners.add(listener);
    }

    private void notifyRegistrationListeners(Registration registration) {
        for (RegistrationListener listener : listeners) {
            listener.onRegistrationComplete(registration);
        }
    }
}
