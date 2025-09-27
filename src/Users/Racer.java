package Users;
import Race.RacerLicense;

public class Racer extends User {
    private RacerLicense racerLicense;
    private int category;
    public Racer(String userID, String name, String email, String password) {
        super(userID, name, email, password);
        defaultCategory();
        racerLicense = null;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    public int getCategory() {
        return category;
    }
    public void defaultCategory() {
        setCategory(5);
    }
    public void updateCategory() {
        if (category == 1){
            return;
        }else{
            setCategory(category-1);
        }
    }
    public RacerLicense setRacerLicense(){
        racerLicense = new RacerLicense(this);
        return racerLicense;
    }
    public RacerLicense getRacerLicense(){
        return racerLicense;
    }
}
