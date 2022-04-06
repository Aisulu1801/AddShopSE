import javax.swing.*;

public class UserFrame extends JFrame {
    public UserAuthorization autorization;
    public UserRegistration registration;
    public UserMenu menu;
    public UserBookItem bookPage;
    public UserListBookings listBookings;

    public UserFrame(){
        setTitle("My Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);

        autorization = new UserAuthorization();
        autorization.setLocation(0,0);
        autorization.setVisible(true);
        add(autorization);

        registration = new UserRegistration();
        registration.setLocation(0,0);
        registration.setVisible(false);
        add(registration);

        menu = new UserMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        bookPage = new UserBookItem();
        bookPage.setLocation(0,0);
        bookPage.setVisible(false);
        add(bookPage);

        listBookings = new UserListBookings();
        listBookings.setLocation(0,0);
        listBookings.setVisible(false);
        add(listBookings);

    }
    public UserAuthorization getAutorization() {
        return autorization;
    }

    public void setAutorization(UserAuthorization autorization) {
        this.autorization = autorization;
    }

    public UserRegistration getRegistration() {
        return registration;
    }

    public void setRegistration(UserRegistration registration) {
        this.registration = registration;
    }
}

