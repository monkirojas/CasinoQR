package app.inacap.casinoqr.com.casinoqr.Modelo;

public class User {

    private String name;
    private String last_name;
    private String second_last_name;
    private String password;
    private String email;



    public User() {
    }

    public User(String name, String last_name, String second_last_name, String password, String email) {
        this.name = name;
        this.last_name = last_name;
        this.second_last_name = second_last_name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSecond_last_name() {
        return second_last_name;
    }

    public void setSecond_last_name(String second_last_name) {
        this.second_last_name = second_last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
