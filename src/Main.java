import Race.BasicRace;
import Race.Decorator.CategoryDecorator;
import Race.Decorator.OfficialRaceDecorator;
import Race.RaceComponent;
import Users.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        String email;
        String password;

        UserFactory racerFactory = new RacerFactory();

        User testRacer = racerFactory.createUser("John Doe", "Doe@yahoo.com", "password1234");

        do {
            System.out.println();
            System.out.print(" Enter Email: ");
            email = sc.nextLine();

            System.out.print(" Enter Password: ");
            password = sc.nextLine();

            if (!testRacer.login(email, password)) {System.out.println("incorrect username or password");}

        } while (!testRacer.login(email, password));

        System.out.println("login successful");

        while (running) {
           break;
        }
        //license for racer
            System.out.println("Do you need a license? (y/n)");
            String license = sc.nextLine();
            if (license.equalsIgnoreCase("y")) {
                RacerLicense testLicense = new RacerLicense((Racer) testRacer);
                System.out.println(testLicense.getLicenseID() + " " + testLicense.getExpiryDate());
            }else if (license.equalsIgnoreCase("n")) {
                System.out.println("Let's register for a race!");
            }else {
                System.out.println("Invalid answer");
            }


        //create race
        BasicRace testRace = new BasicRace();
        CategoryDecorator officialTestRace = new CategoryDecorator(new OfficialRaceDecorator(testRace));
        officialTestRace.setCategory(5);
        System.out.println(officialTestRace.getDescription());

        //register for race
        testRace.registerRacer((Racer) testRacer);
        //available spots
        System.out.println(officialTestRace.getAvailableSpots());

        sc.close();

    }
}
