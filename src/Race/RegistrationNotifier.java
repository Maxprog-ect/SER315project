package Race;

public class RegistrationNotifier implements RegistrationListener {
    @Override
    public void onRegistrationComplete(Registration registration) {
        System.out.println(registration.getRacer().getName()
                + " has successfully registered with ID "
                + registration.getRegID() + " on " + registration.getRegDate());
    }
}
