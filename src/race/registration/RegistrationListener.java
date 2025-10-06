package race.registration;

public interface RegistrationListener {
    void onRegistrationComplete(Registration registration);
    void onWaiverInitiate(RaceWaiver waiver);
}