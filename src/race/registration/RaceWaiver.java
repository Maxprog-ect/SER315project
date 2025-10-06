package race.registration;

public class RaceWaiver {
    boolean isSigned;

    public RaceWaiver() {
        isSigned = false;
    }
    public boolean isSigned() {
        return isSigned;
    }
    public void signWaiver() {
        isSigned = true;
    }
}
