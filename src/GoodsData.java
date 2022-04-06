import java.io.Serializable;
import java.util.ArrayList;

public class GoodsData implements Serializable {
    String operationType;
    ArrayList<Goods> allGoods;
    //добавитьеще листы - по функциям - см. operation type
    Goods good;
    Long id;
    String userLogin;
    String userPassword;
    Booking booking;
    ArrayList<Booking> allBookings;
    UserInformation user;
    public GoodsData() {
    }

    public GoodsData(String operationType, ArrayList<Goods> allGoods, Goods good, Long id) {

        this.operationType = operationType;
        this.allGoods = allGoods;
        this.good = good;
        this.id = id;
    }

    @Override
    public String toString() {
        return "model.GoodsData{" +
                "operationType='" + operationType + '\'' +
                ", allGoods=" + allGoods +
                ", good=" + good +
                ", id=" + id +
                '}';
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public UserInformation getUser() {
        return user;
    }

    public void setUser(UserInformation user) {
        this.user = user;
    }

    public String getOperationType() {
        return operationType;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public ArrayList<Goods> getAllGoods() {
        return allGoods;
    }

    public void setAllGoods(ArrayList<Goods> allGoods) {
        this.allGoods = allGoods;
    }

    public ArrayList<Booking> getAllBookings() {
        return allBookings;
    }

    public void setAllBookings(ArrayList<Booking> allBookings) {
        this.allBookings = allBookings;
    }
}

