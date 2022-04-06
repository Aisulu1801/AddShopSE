
import java.io.Serializable;

public class Booking implements Serializable {
    private Long id;
    private Long goodId;
    private String userName;
    private  String userSurname;
    protected String userPassword;

    public Booking(){}

    public Booking(Long id, Long goodId, String userName, String userSurname, String userPassword) {
        this.id = id;
        this.goodId = goodId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPassword = userPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getBooking() {
        return  id + ")" +
                " goodId=" + goodId +
                ", name ='" + userName + '\'' +
                ", surname ='" + userSurname + '\'' +
                ", pass ='" + userPassword + '\'' +
                '}';
    }
}

