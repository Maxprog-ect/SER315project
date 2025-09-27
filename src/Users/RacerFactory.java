package Users;

public class RacerFactory implements UserFactory {
    int id;

    public RacerFactory() {
        id = 1;
    }
    @Override
    public Racer createUser(String name, String email, String password) {
        return new Racer("Racer" + id++, name, email, password);
    }
}
