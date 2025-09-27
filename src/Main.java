import Users.*;

public class Main {
    public static void main(String[] args) {
        UserFactory racerFactory = new RacerFactory();

        User testRacer = racerFactory.createUser("John Doe", "Doe@yahoo.com", "password1234");
        System.out.println(testRacer.login("Doe@yahoo.com", "password1234"));
    }
}
