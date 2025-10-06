package Race;

import Race.Registration.RaceWaiver;
import Race.Registration.Registration;
import Race.Registration.RegistrationListener;
import Users.Racer;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class BasicRace implements RaceComponent {
    private final String raceID;
    private final String raceName;
    private  String raceType;
    private final LocalDate raceDate;
    private final int miles;
    private final int registrationLimit;
    private final LocalDate lastRegistrationDate;
    private int registeredRacers;
    private HashMap<String, Registration> raceRegistration;
    private List<RegistrationListener> listeners = new ArrayList<>();
    private boolean isOfficial = false;
    private List<RegistrationListener> raceWaiverListeners = new ArrayList<>();

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
        this.raceID = "3728";
        this.raceName = "iAMSpeed";
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

    @Override
    public boolean isOfficial(){
        return isOfficial;
    }

    @Override
    public void setType(String type){
        raceType = type;
    }
    public String getType(){
        return raceType;
    }
    public void setOfficial(boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    public void registerRacer(Racer racer, int category) {
        String key;
        if(isOfficial()) {
            //check if racer is already registered
            if(racer.getRacerLicense() != null) {
                //official race key
                key = getRaceName() + racer.getRacerLicense().getLicenseID();
                if (raceRegistration.containsKey(key)) {
                    System.out.println("ERROR: You cannot register more than once per race");
                    return;
                }
            }
            //check racer category
            if (racer.getCategory() != category) {
                System.out.println("ERROR: Racer does not have correct category");
                return;
            }
            //check license
            if(racer.getRacerLicense() == null){
                System.out.println("ERROR: Racer does not have a license.");
                return;
            }else if(racer.getRacerLicense().checkLicenseValid() == -1) {
                System.out.println("ERROR: License for Racer " + racer.getName() + " is invalid.");
                return;
            }
        }else{
            //check if racer is already registered
            //unofficial race key
            key = racer.getName() + " " + getRaceName();
            if (raceRegistration.containsKey(key)) {
                System.out.println("ERROR: You cannot register more than once per race");
                return;
            }
        }

        //check registration limit
        if (registeredRacers >= registrationLimit) {
            System.out.println("ERROR: Cannot complete registration -- race is full.");
            return;
        }

        //Racer must have a signed waiver to race
        notifyWaiverListeners(racer.getRaceWaiver());

        //register racer
        Registration newReg = new Registration(this, racer, category);
        newReg.processPayment();
        raceRegistration.put(newReg.getRegID(), newReg);
        trackRegistration();

        notifyRegistrationListeners(newReg);
    }


    public void addRegistrationListener(RegistrationListener listener) {
        listeners.add(listener);
    }

    private void notifyRegistrationListeners(Registration registration) {
        for (RegistrationListener listener : listeners) {
            listener.onRegistrationComplete(registration);
        }
    }

    public void addWaiverListener(RegistrationListener listener) {
        raceWaiverListeners.add(listener);
    }

    private void notifyWaiverListeners(RaceWaiver waiver) {
        for(RegistrationListener w : raceWaiverListeners){
            w.onWaiverInitiate(waiver);
        }
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