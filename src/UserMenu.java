

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends Container {

    private JButton addReservation;
    private JButton listReservation;
    private JButton exit;

    public UserMenu(){
        setSize(600, 600);
        setLayout(null);

        addReservation = new JButton("Book item");
        addReservation.setBounds(160, 150, 250, 30);
        addReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.showUserBookPage();
            }
        });
        add(addReservation);

        listReservation = new JButton("List my bookings");
        listReservation.setBounds(160, 190, 250, 30);
        listReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.showUserBookListPage();
            }
        });
        add(listReservation);

        exit = new JButton("EXIT");
        exit.setBounds(160, 250, 250, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.frame.menu.setVisible(false);
                Client.frame.autorization.setVisible(true);
            }
        });
        add(exit);
    }
}

