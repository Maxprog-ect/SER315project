package race.registration;

public class RegistrationNotifier implements RegistrationListener {
    @Override
    public void onRegistrationComplete(Registration registration) {
        System.out.println(registration.getRacer().getName()
                + " has successfully registered with ID "
                + registration.getRegID() + " on " + registration.getRegDate());
    }
    @Override
    public void onWaiverInitiate(RaceWaiver waiver) {
        System.out.println("\nRace Liability Waiver: ");
        if (!waiver.isSigned()) {
            System.out.println("Racer must sign a liability waiver to complete registration.");
            System.out.println("Signing liability waiver....\n");
            waiver.signWaiver();
            System.out.println("Thank you, your waiver has been signed.\n");
        } else {
            System.out.println("You have a liability waiver signed on file.\n");
        }
    }
}