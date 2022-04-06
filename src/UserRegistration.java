import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistration extends Container {

    private JLabel login_label;
    private JLabel password_label;
    private JTextField login;
    private JTextField password;
    private JLabel address_label;
    private JLabel phone_label;
    private JTextField address;
    private JTextField phone;
    private JButton back;
    private JButton registration;
    private JLabel feedback;

    public UserRegistration(){
        setSize(600, 600);
        setLayout(null);

        login_label = new JLabel("Login: ");
        login_label.setBounds(170, 130, 70, 20);
        add(login_label);

        password_label = new JLabel("Password: ");
        password_label.setBounds(170,160,70,20);
        add(password_label);

        login = new JTextField();
        login.setBounds(250, 130, 150, 20);
        add(login);

        password = new JTextField();
        password.setBounds(250, 160, 150, 20);
        add(password);

        address_label = new JLabel("Address: ");
        address_label.setBounds(170, 190, 70, 20);
        add(address_label);

        phone_label = new JLabel("Phone: ");
        phone_label.setBounds(170,220,70,20);
        add(phone_label);

        address = new JTextField();
        address.setBounds(250, 190, 150, 20);
        add(address);

        phone = new JTextField();
        phone.setBounds(250, 220, 150, 20);
        add(phone);


        registration = new JButton("Register");
        registration.setBounds(240,260,100, 35);
        registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserInformation newUser = new UserInformation(null, login.getText(), password.getText(), address.getText(), phone.getText());
                    Client.registration(newUser);
                    feedback.setText("You have successfully registered!");
                    login.setText("");
                    password.setText("");
                    address.setText("");
                    phone.setText("");
                    Client.showAuthorizationPage();
                } catch (Exception ex){ex.printStackTrace();}
            }
        });
        add(registration);

        back = new JButton("Back");
        back.setBounds(240,310, 100, 35);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.frame.registration.setVisible(false);
                Client.frame.autorization.setVisible(true);
            }
        });
        add(back);

        feedback = new JLabel("");
        feedback.setBounds(200, 340, 200,30);
        add(feedback);
    }

}

