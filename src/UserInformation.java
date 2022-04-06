import java.io.Serializable;

public class UserInformation implements Serializable {
    private Long userID;
    private String login;
    private String password;
    private String address;
    private String phone;

    public UserInformation(){}

    public UserInformation(Long id, String login, String password, String address, String phone) {
        this.userID = id;
        this.login = login;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser() {
        return "model.UserInformation{" +
                "userID=" + userID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

