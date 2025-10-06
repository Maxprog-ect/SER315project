/**
 * abstract product, User, that specifies the behavior of Users
 */
package users;

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

    /**
     *
     * @param username the email associated with the account
     * @param password the password associated with the email
     * @return true if the email and password were correct and false otherwise
     */
    public boolean login(String username, String password) {
        return (username.equals(this.email) && password.equals(this.password));
    }

    /**
     * used to exit from the program
     */
    public void logout() {}

    /**
     *
     * @param user specifies which user to update
     */
    public void updateProfile(User user) {}

    /**
     *
     * @return the name associated with the account
     */
    public String getName(){
        return name;
    }
}