package manhanlou.common;

public class User {
    String username;
    String passed;

    public User(String username, String passed) {
        this.username = username;
        this.passed = passed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }
}
