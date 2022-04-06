import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class Server {
    public static Connection connection;

    public static void main(String[] args) {

        try {
            connect();
            ServerSocket server = new ServerSocket(1988);

            while (true){
                System.out.println("Waiting for the adminFrame.Admin");
                Socket socket = server.accept();
                System.out.println("adminFrame.Admin is connected");
                ServerThread st = new ServerThread(socket, connection);
                st.start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //проверяем подключение к дб
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_store?useUnicode=true&serverTimezone=UTC", "root", "");
            System.out.println("CONNECTED");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

