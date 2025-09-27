import Users.*;

public class Main {
    public static void main(String[] args) {
        RacerFactory userFactory = new RacerFactory();

        Racer testRacer = userFactory.createUser("John Doe", "Doe@yahoo.com", "password1234");
        System.out.println(testRacer.login("Doe@yahoo.com", "password1234"));
    }
}
