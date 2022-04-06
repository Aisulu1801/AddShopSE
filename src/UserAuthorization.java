import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAuthorization extends Container {

    private JLabel login_label;
    private JLabel password_label;
    private JTextField login;
    private JTextField password;
    private JButton signIn;
    private JButton registration;
    private JLabel feedback;

    public UserAuthorization(){
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

        feedback = new JLabel("");
        feedback.setBounds(210,340, 250, 35);
        add(feedback);

        signIn = new JButton("Sign In");
        signIn.setBounds(240,230, 100, 35);
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Client.authorization(login.getText(), password.getText());
                if (Client.authorization(login.getText(), password.getText())=="SUCCESS") {
                    login.setText("");
                    password.setText("");
                    Client.showUserMenu();
                } else {
                    feedback.setText("AUTHORIZATION FAILED!");
                    login.setText("");
                    password.setText("");
                    Client.showAuthorizationPage();
                }
            }
        });
        add(signIn);

        registration = new JButton("Sign Up");
        registration.setBounds(240,280,100, 35);
        registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.frame.autorization.setVisible(false);
                Client.showRegistrationPage();
            }
        });
        add(registration);
    }
}

