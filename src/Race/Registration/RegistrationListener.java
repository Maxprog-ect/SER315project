package Race.Registration;

public interface RegistrationListener {
    void onRegistrationComplete(Registration registration);
    void onWaiverInitiate(RaceWaiver waiver);
}