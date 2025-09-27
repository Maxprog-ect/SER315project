package Race;

import Users.Racer;

import java.time.LocalTime;

public class Registration {
    private final String regID;
    private LocalTime regDate;
    private boolean isPaid;
    private final Racer racer;

    public Registration(String raceID, Racer racer){
        this.racer = racer;
        this.regID = raceID + racer.getName();
        this.regDate = LocalTime.now();
        this.isPaid = false;
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
