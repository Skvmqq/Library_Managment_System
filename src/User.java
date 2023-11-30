import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class User implements Serializable {
    private String user_id;
    private String User_name;
    private int phone_number;
    private String password;
    private String email_id;

    User(String user_id,String password)

    {
        this.user_id=user_id;
        this.password=password;
    }
    User(String User_name,String email_id,int phone_number, String user_id,String password)
    {
        //this.user_id=user_id;
        this.User_name=User_name;
        this.email_id=email_id;
        this.phone_number=phone_number;
        this.user_id=user_id;
        this.password=password;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
}
