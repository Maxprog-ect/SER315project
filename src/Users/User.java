package Users;

import java.time.LocalDateTime;

public abstract class User {
    private String userID;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public User(String userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        createdAt = LocalDateTime.now();
    }

    public boolean login(String username, String password) {
        return (username.equals(this.email) && password.equals(this.password));
    }

    public void logout() {}

    public void updateProfile(User user) {}

    public String getName(){
        return name;
    }
}
