import Race.BasicRace;
import Race.Decorator.CategoryDecorator;
import Race.Decorator.OfficialRaceDecorator;
import Race.RacerLicense;
import Race.RegistrationNotifier;
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

        // create race
        BasicRace testRace = new BasicRace();
        testRace.addRegistrationListener(new RegistrationNotifier());

        CategoryDecorator officialTestRace = new CategoryDecorator(new OfficialRaceDecorator(testRace));
        officialTestRace.setCategory(5);

        do {
            System.out.println();
            System.out.print(" Enter Email: ");
            email = sc.nextLine();

            System.out.print(" Enter Password: ");
            password = sc.nextLine();

            if (!testRacer.login(email, password)) {System.out.println("incorrect username or password\n");}

        } while (!testRacer.login(email, password));

        System.out.println("login successful\n");

        while (running) {
            System.out.println("What would you like to do?");
            System.out.println(" 1. Registration");
            System.out.println(" 2. Get License");
            System.out.println(" 3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Which race do you want to register for?\n");
                    System.out.println( "1: " +  officialTestRace.getDescription());
                    System.out.print( "Choose race: ");
                    int race = sc.nextInt();

                    if (race == 1) {
                        // listener
                        testRace.registerRacer((Racer) testRacer, officialTestRace.getCategory());
                    }

                    // available spots
                    System.out.println("Available spots in Race:");
                    System.out.println(officialTestRace.getAvailableSpots());
                    System.out.println();

                    break;

                case 2:
                    //license for racer
                    sc.nextLine();
                    System.out.println("Do you need a license? (y/n)");
                    String license = sc.nextLine();

                    if (license.equalsIgnoreCase("y")) {
                        RacerLicense testLicense = ((Racer)testRacer).setRacerLicense();
                        System.out.println("License made: " + testLicense.getLicenseID() + " " + testLicense.getExpiryDate() + "\n");
                    } else if (license.equalsIgnoreCase("n")) {
                        System.out.println("Let's register for a race!\n");
                    } else {
                        System.out.println("Invalid answer\n");
                    }
                    break;

                case 3:
                    running = false;
                    sc.close();
                    break;
            }
        }
    }
}
