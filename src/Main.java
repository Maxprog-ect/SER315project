import Race.BasicRace;
import Race.Decorator.OffRoadDecorator;
import Race.Decorator.OfficialRaceDecorator;
import Race.RacerLicense;
import Race.Registration.RegistrationNotifier;
import Users.*;

import java.time.LocalDate;

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
        testRace.addWaiverListener(new RegistrationNotifier());
        //make race official
        OfficialRaceDecorator officialTestRace = new OfficialRaceDecorator(testRace);
        officialTestRace.setCategory(5);

        //create 2nd race
        BasicRace testRace2 = new BasicRace("ID4Race", "Name4Race", "Track",
                LocalDate.now().plusDays(45), 6, 10, LocalDate.now().plusDays(20));
        testRace2.addRegistrationListener(new RegistrationNotifier());
        testRace2.addWaiverListener(new RegistrationNotifier());
        //make race official
        OfficialRaceDecorator testRace25 = new OfficialRaceDecorator(testRace2);
        //make race type offroad
        OffRoadDecorator testRace255 = new OffRoadDecorator(testRace2);
        testRace25.setCategory(4);

        //create unofficial race
        BasicRace testRace3 = new BasicRace();
        testRace3.addRegistrationListener(new RegistrationNotifier());
        testRace3.addWaiverListener(new RegistrationNotifier());

        Authentication auth = new Authentication(sc, (Racer)testRacer);
        auth.login();

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
                    System.out.println( "2: " +  testRace25.getDescription());
                    System.out.println( "3: " +  testRace3.getDescription());
                    System.out.print( "Choose race: ");
                    int race = sc.nextInt();

                    if (race == 1) {
                        // listener
                        testRace.registerRacer((Racer) testRacer, officialTestRace.getCategory());

                        // available spots
                        System.out.println("Available spots in Race:");
                        System.out.println(officialTestRace.getAvailableSpots());
                        System.out.println();
                    }else if (race == 2) {
                        testRace2.registerRacer((Racer) testRacer, testRace25.getCategory());
                        // available spots
                        System.out.println("Available spots in Race:");
                        System.out.println(testRace2.getAvailableSpots());
                        System.out.println();
                    }else if (race == 3) {
                        testRace3.registerRacer((Racer) testRacer, testRace25.getCategory());
                        System.out.println("Available spots in Race:");
                        System.out.println(testRace3.getAvailableSpots());
                        System.out.println();
                    }

                    break;

                case 2:
                    //license for racer
                    sc.nextLine();
                    System.out.println("Do you need a license? (y/n)");
                    String license = sc.nextLine();

                    if (license.equalsIgnoreCase("y")) {
                        //check racer needs license
                        if((((Racer)testRacer).getRacerLicense() == null)|| (((Racer)testRacer).getRacerLicense().checkLicenseValid() == -1)) {
                            RacerLicense testLicense = ((Racer) testRacer).setRacerLicense();
                            System.out.println("License made: " + testLicense.getLicenseID() + " " + testLicense.getExpiryDate() + "\n");
                        }else{
                            System.out.println("Racer already has a valid license\n");
                        }
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