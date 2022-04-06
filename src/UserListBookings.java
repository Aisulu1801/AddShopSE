import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserListBookings extends Container {
    public static JTextArea area = new JTextArea();
    public static JButton back;

    public UserListBookings(){
        setSize(600, 600);
        setLayout(null);

        area.setEditable(false);
        area.setBounds(75,75, 450, 300);
        add(area);

        back = new JButton("BACK");
        back.setBounds(250, 400, 100, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.frame.menu.setVisible(true);
                Client.frame.listBookings.setVisible(false);
            }
        });
        add(back);
    }

    public void updateArea(ArrayList<Booking> allBookings) {
        area.setText("");
        for (Booking b : allBookings) {
            area.append(b.getBooking() + "\n");
        }
    }
}

