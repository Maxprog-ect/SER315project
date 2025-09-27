package Race;
import Users.Racer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Registration {
    private final String regID;
    private LocalDate regDate;
    private boolean isPaid;
    private final Racer racer;
    private final int category;

    public Registration(BasicRace race, Racer racer, int category) {
        this.regID = race.getRaceID() + race.getRaceName() + racer.getName();
        this.racer = racer;
        this.regDate = LocalDate.now();
        this.isPaid = false;
        this.category = category;
    }

    public void processPayment(){
        System.out.println("Processing Payment for Race ");
        isPaid = true;
        System.out.println(notifyRacer());
    }

    public String notifyRacer(){

        if (isPaid) {
            return regID + ": registration successful";
        } else {
            return regID + ": payment needed";
        }
    }

    public String getRegID() {
        return regID;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public Racer getRacer() {
        return racer;
    }

    public int getCategory() {
        return category;
    }
}
