package Users;

import java.time.LocalDateTime;

public abstract class User {
    private String userID;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public boolean login(String username, String password) {
        return (username.equals(this.name) && password.equals(this.password));
    }

    public void logout() {}

    public void updateProfile(User user) {}
}
