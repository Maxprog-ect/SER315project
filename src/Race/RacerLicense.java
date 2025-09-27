package Race;

import Users.Racer;

import java.time.LocalDate;

public class RacerLicense {
    private final String licenseID;
    private int category;
    private final LocalDate issueDate;
    private final LocalDate expiryDate;
    private final Racer racer;


    public RacerLicense(Racer racer){
        this.racer = racer;
        licenseID = racer.getName()  + "_Kachow";
        issueDate = LocalDate.now();
        expiryDate = LocalDate.now().plusDays(365);
        category = racer.getCategory();
    }
    public boolean isValid() {
        LocalDate now = LocalDate.now();
        return now.isBefore(expiryDate);
    }
    public int checkLicenseValid() {
        if (!isValid()) {
            return -1;
        }
        return 0;
    }
    public String getLicenseID() {
        return licenseID;
    }
    public int getCategory() {
        return category;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public Racer getRacer() {
        return racer;
    }
    public void setCategory(int category) {
        this.category = category;
    }
}
