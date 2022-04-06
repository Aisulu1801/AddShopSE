import javax.swing.*;

public class AdminFrame extends JFrame {

    public Menu menu;
    public AddShop addShopPage;
    public ListShop listShopPage;
    public DeleteShop deleteShopPage;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public AddShop getAddShopPage() {
        return addShopPage;
    }

    public void setAddShopPage(AddShop addShopPage) {
        this.addShopPage = addShopPage;
    }

    public ListShop getListShopPage() {
        return listShopPage;
    }

    public void setListShopPage(ListShop listShopPage) {
        this.listShopPage = listShopPage;
    }

    public DeleteShop getDeleteShopPage() {
        return deleteShopPage;
    }

    public void setDeleteShopPage(DeleteShop deleteShopPage) {
        this.deleteShopPage = deleteShopPage;
    }

    public AdminFrame() {

        setTitle("My Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);

        menu = new Menu();
        menu.setLocation(0, 0);
        menu.setVisible(true);
        add(menu);

        addShopPage = new AddShop();
        addShopPage.setLocation(0, 0);
        addShopPage.setVisible(false);
        add(addShopPage);

        listShopPage = new ListShop();
        listShopPage.setLocation(0, 0);
        listShopPage.setVisible(false);
        add(listShopPage);

        deleteShopPage = new DeleteShop();
        deleteShopPage.setLocation(0, 0);
        deleteShopPage.setVisible(false);
        add(deleteShopPage);


    }

}
