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

    }
}
