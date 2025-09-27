package Race;

import Users.Racer;

import java.time.LocalDate;
import java.time.LocalTime;

public class Registration {
    private final String regID;
    private LocalDate regDate;
    private boolean isPaid;
    private final Racer racer;

    public Registration(BasicRace race, Racer racer) {
        regID = race.getRaceID() + race.getRaceName() + racer.getName();
        this.racer = racer;
        regDate = LocalDate.now();
        isPaid = false;
    }

    public void processPayment(){
        System.out.println("Processing Payment for Race ");
        isPaid = true;
        System.out.println(notifyRacer());
    }

    public String notifyRacer(){
        String notifyRacer = "";
        if(isPaid){
            notifyRacer = regID+ ": registration successful";
        }
        else{
            notifyRacer = regID + ": payment needed";
        }
        return notifyRacer;
    }
}
