import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;

    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;


    public ServerThread(Socket socket, Connection connection) {
        this.connection = connection;
        this.socket = socket;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            GoodsData gd = null;

            while ((gd = (GoodsData) inputStream.readObject()) != null) {
                if (gd.getOperationType().equals("Add_Shop")) {
                    try {
                        Goods goods = gd.getGood();
                        addGoodstoDB(goods);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (gd.getOperationType().equals("Delete_Shop")) {
                    Long id = gd.getId();
                    deleteGoodfromDB(id);
                    ArrayList<Goods> goods = getAllGoods(); //с базы
                    GoodsData gd2 = new GoodsData(); //create  package
                    gd2.setAllGoods(goods); // send all to this package
                    outputStream.writeObject(gd2);
                } else if (gd.getOperationType().equals("List_Shop")) {
                    ArrayList<Goods> goods = getAllGoods(); //с базы
                    GoodsData gd2 = new GoodsData(); //create  package
                    gd2.setAllGoods(goods); // send all to this package
                    outputStream.writeObject(gd2);
                } else if (gd.getOperationType().equals("REGISTR")) {
                    try {
                        UserInformation newUser = gd.getUser();
                        addUser(newUser);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (gd.getOperationType().equals("AUTH")) {
                    try{
                        String login = gd.getUserLogin();
                        String password = gd.getUserPassword();
                        GoodsData gd2 = new GoodsData();
                        UserInformation u = authorize(login, password);

                        if(u.getLogin()!=null && u.getPassword()!=null) {
                            gd2.setUserLogin(u.getLogin());
                            gd2.setUserPassword(u.getPassword());
                        }
                        outputStream.writeObject(gd2);
                    } catch (Exception e){e.printStackTrace();}

                } else if (gd.getOperationType().equals("BOOK")){
                    try{
                        Booking newBook = gd.getBooking();
                        bookItem(newBook);
                        ArrayList<Goods> goods = getAllGoods(); //с базы
                        GoodsData gd2 = new GoodsData(); //create  package
                        gd2.setAllGoods(goods); // send all to this package
                        outputStream.writeObject(gd2);
                    }catch (Exception e){e.printStackTrace();}
                } else if (gd.getOperationType().equals("LIST_GOODS")) {
                    try {
                        GoodsData gd2 = new GoodsData(); //create  package
                        ArrayList<Goods> goods = getAllGoods(); //с базы
                        gd2.setAllGoods(goods); // send all to this package
                        outputStream.writeObject(gd2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (gd.getOperationType().equals("LIST_BOOKINGS")){
                    try{
                        ArrayList<Booking> bookings = getAllBookings();
                        System.out.println(bookings);
                        GoodsData gd2 = new GoodsData();
                        gd2.setAllBookings(bookings);
                        outputStream.writeObject(gd2);
                    } catch (Exception e){e.printStackTrace();}
                } else break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addGoodstoDB(Goods goods) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO goods (id, model, name, price) values (null, ?, ?, ?)");
            ps.setString(1, goods.getModel());
            ps.setString(2, goods.getName());
            ps.setInt(3, goods.getPrice());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGoodfromDB(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM goods WHERE id=?");
            ps.setLong(1, id);
            int rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Goods> getAllGoods() {
        ArrayList<Goods> goods = new ArrayList<>();
        try {
            Statement s = connection.createStatement();
            String sqlQuery = "SELECT * FROM goods";
            ResultSet rs = s.executeQuery(sqlQuery);
            while (rs.next()) {
                goods.add(new Goods(rs.getLong("id"), rs.getString("model"), rs.getString("name"), rs.getInt("price")));
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }

    public void addUser(UserInformation user){
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (login, password, address, phone) values (?, ?, ?, ?)");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getPhone());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public UserInformation authorize(String login, String password){
        UserInformation user = new UserInformation();
        try{
            Statement s = connection.createStatement();
            String sqlQuery = "SELECT * FROM users WHERE login='"+ login + "' AND password = '" + password + "'";
            ResultSet rs = s.executeQuery(sqlQuery);
            while (rs.next()) {
                user = new UserInformation(rs.getLong("id"), rs.getString("login"), rs.getString("password"), rs.getString("address"), rs.getString("phone"));
            }
            s.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public void bookItem(Booking newBook){
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT into bookings (good_id, user_name, user_surname, user_password) values (?, ?, ?, ?)");
            ps.setLong(1, newBook.getGoodId());
            ps.setString(2, newBook.getUserName());
            ps.setString(3, newBook.getUserSurname());
            ps.setString(4, newBook.getUserPassword());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Booking> getAllBookings(){
        ArrayList<Booking> bookings = new ArrayList<>();
        try {
            Statement s = connection.createStatement();
            String sqlQuery = "SELECT * FROM bookings";
            ResultSet rs = s.executeQuery(sqlQuery);
            while (rs.next()) {
                bookings.add(new Booking(rs.getLong("id"), rs.getLong("good_id"), rs.getString("user_name"), rs.getString("user_surname"), rs.getString("user_password")));
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }
}

