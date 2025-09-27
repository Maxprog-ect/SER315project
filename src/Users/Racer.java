package Users;

public class Racer extends User {
    private int category;
    public Racer(String userID, String name, String email, String password) {
        super(userID, name, email, password);
        defaultCategory();
    }

    public void setCategory(int category) {
        this.category = category;
    }
    public int getCategory() {
        return category;
    }
    public void defaultCategory() {
        setCategory(5);
    }
    public void updateCategory() {
        if (category == 1){
            return;
        }else{
            setCategory(category-1);
        }
    }
}
