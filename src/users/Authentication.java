package users;

import java.util.Scanner;

public class Authentication {
    private Scanner scanner = new Scanner(System.in);
    private Racer testRacer;
    public Authentication(Scanner in, Racer racer) {
        this.scanner = in;
        this.testRacer = racer;
    }
    public void login() {
        String email;
        String password;
        do {
            System.out.println();
            System.out.print(" Enter Email: ");
            email = scanner.nextLine();

            System.out.print(" Enter Password: ");
            password = scanner.nextLine();

            if (!testRacer.login(email, password)) {System.out.println("incorrect username or password\n");}

        } while (!testRacer.login(email, password));
    }
}
