/**
 * A concrete product, Racer, that extends the abstract user class
 */
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

    /**
     *  a method used to set the category of the racer
     * @param category the new category the racer will be set to
     */
    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * returns the category of the racer
     * @return the category the racer is currently in
     */
    public int getCategory() {
        return category;
    }

    /**
     * sets the category of the racer to 5
     */
    public void defaultCategory() {
        setCategory(5);
    }

    /**
     * updates the racer category to the next highest category
     */
    public void updateCategory() {
        if (category == 1){
            return;
        }else{
            setCategory(category-1);
            racerLicense.setCategory(category-1);
        }
    }

    /**
     * creates and associates a license to the racer
     * @return the license created for the racer
     */
    public RacerLicense setRacerLicense(){
        racerLicense = new RacerLicense(this);
        return racerLicense;
    }

    /**
     * returns the racer license associated with the racer
     * @return the racer license
     */
    public RacerLicense getRacerLicense(){
        return racerLicense;
    }
}
