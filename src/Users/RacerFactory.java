/**
 * a concrete factory that creates racers
 */
package Users;

public class RacerFactory implements UserFactory {
    int id; //used to create a userid for the racer

    public RacerFactory() {
        id = 1;
    }

    @Override
    public Racer createUser(String name, String email, String password) {
        return new Racer("Users.Racer" + id++, name, email, password);
    }
}
