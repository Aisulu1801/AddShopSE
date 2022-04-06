import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Admin { //Class1
    public static Socket socket;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static AdminFrame adminFrame;

    public static void showMenu() {
        Admin.adminFrame.addShopPage.setVisible(false);
        Admin.adminFrame.deleteShopPage.setVisible(false);
        Admin.adminFrame.listShopPage.setVisible(false);
        Admin.adminFrame.menu.setVisible(true);
    }

    public static void showAddShopPage() {
        Admin.adminFrame.addShopPage.setVisible(true);
        Admin.adminFrame.menu.setVisible(false);
    }

    public static void showListShopPage() {
        ArrayList<Goods> list = listGoods();
        Admin.adminFrame.listShopPage.updateArea(list);
        Admin.adminFrame.listShopPage.setVisible(true);
        Admin.adminFrame.menu.setVisible(false);
    }

    public static void showDeleteShopPage() {
        ArrayList<Goods> list = listGoods();
        Admin.adminFrame.deleteShopPage.updateArea(list);
        Admin.adminFrame.deleteShopPage.setVisible(true);
        Admin.adminFrame.menu.setVisible(false);
    }

    public static void main(String[] args) {

        adminFrame = new AdminFrame();
        adminFrame.setVisible(true);
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

    public static void addGoods(Goods goods) {
        GoodsData gd = new GoodsData();
        gd.setOperationType("Add_Shop");
        gd.setGood(goods);
        try {
            outputStream.writeObject(gd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList <Goods> deleteGoods(Long id) {
        GoodsData gd = new GoodsData();
        gd.setOperationType("Delete_Shop");
        gd.setId(id);
        ArrayList<Goods> goods = new ArrayList<Goods>();
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

    public static ArrayList<Goods> listGoods() {
        GoodsData gd = new GoodsData();
        gd.setOperationType("List_Shop");
        ArrayList<Goods> goods = new ArrayList<Goods>();

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
}

