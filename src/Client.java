
import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    public static Socket socket;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static UserFrame frame;


    public static void showAuthorizationPage(){
        Client.frame.autorization.setVisible(true);
        Client.frame.menu.setVisible(false);
        Client.frame.registration.setVisible(false);
        Client.frame.listBookings.setVisible(false);
        Client.frame.bookPage.setVisible(false);
    }

    public static void showRegistrationPage(){
        Client.frame.autorization.setVisible(false);
        Client.frame.menu.setVisible(false);
        Client.frame.registration.setVisible(true);
        Client.frame.listBookings.setVisible(false);
        Client.frame.bookPage.setVisible(false);
    }

    public static void showUserMenu(){
        Client.frame.autorization.setVisible(false);
        Client.frame.menu.setVisible(true);
        Client.frame.registration.setVisible(false);
        Client.frame.listBookings.setVisible(false);
        Client.frame.bookPage.setVisible(false);
    }

    public static void showUserBookPage(){
        ArrayList<Goods> list = listGoods();
        Client.frame.bookPage.updateCombobox(list);
        Client.frame.autorization.setVisible(false);
        Client.frame.menu.setVisible(false);
        Client.frame.registration.setVisible(false);
        Client.frame.listBookings.setVisible(false);
        Client.frame.bookPage.setVisible(true);
    }

    public static void showUserBookListPage(){
        ArrayList<Booking> allBookings = listBookings();
        Client.frame.listBookings.updateArea(allBookings);
        Client.frame.autorization.setVisible(false);
        Client.frame.menu.setVisible(false);
        Client.frame.registration.setVisible(false);
        Client.frame.listBookings.setVisible(true);
        Client.frame.bookPage.setVisible(false);
    }

    public static void main(String[] args) {
        frame = new UserFrame();
        frame.setVisible(true);
        connectToServer();
    }

    public static void connectToServer() {
        try {
            socket = new Socket("127.0.0.1", 1988);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registration(UserInformation newUser){
        GoodsData ud = new GoodsData();
        ud.setOperationType("REGISTR");
        ud.setUser(newUser);
        try {
            outputStream.writeObject(ud);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String authorization (String login, String password){
        GoodsData ud = new GoodsData();
        ud.setOperationType("AUTH");
        ud.setUserLogin(login);
        ud.setUserPassword(password);
        String result = "";
        System.out.println(ud.getUserLogin());
        try {
            outputStream.writeObject(ud);
            System.out.println(result+"g5h5");
            if ((ud = (GoodsData) inputStream.readObject()) != null && ud.getUserLogin() != null && ud.getUserPassword() != null) {
                result = "SUCCESS";
            } else result = "FAIL";
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(ud.getUserLogin() + "login from base");
        return result;
    }

    public static void bookItem (Booking newBook){
        GoodsData ud = new GoodsData();
        ud.setOperationType("BOOK");
        ud.setBooking(newBook);
        try {
            outputStream.writeObject(ud);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Goods> listGoods() {
        GoodsData gd = new GoodsData();
        gd.setOperationType("LIST_GOODS");
        ArrayList<Goods> goods = new ArrayList<Goods>();
        gd.setAllGoods(goods);
        try {
            outputStream.writeObject(gd);
            if ((gd = (GoodsData) inputStream.readObject()) != null) {
                goods = gd.getAllGoods();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gd.getAllGoods();
    }

    public static ArrayList<Booking> listBookings() {
        GoodsData gd = new GoodsData();
        gd.setOperationType("LIST_BOOKINGS");
        ArrayList<Booking> bookings = new ArrayList<>();
        gd.setAllBookings(bookings);
        try {
            outputStream.writeObject(gd);
            if ((gd = (GoodsData) inputStream.readObject()) != null) {
                bookings = gd.getAllBookings();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gd.getAllBookings();
    }
}

