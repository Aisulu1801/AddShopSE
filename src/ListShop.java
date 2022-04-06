import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListShop extends Container {

    public static JTextArea area = new JTextArea();
    public static JButton back;
    public static JLabel label;


    public ListShop() {
        setSize(600, 600);
        setLayout(null);

        label = new JLabel("Our items");
        label.setBounds(290, 10, 150, 60);
        add(label);


        area = new JTextArea();
        area.setLocation(50, 70);
        area.setSize(500, 300);
        area.setEditable(false);
        add(area);


        back = new JButton("Back");
        back.setBounds(270, 420, 80, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.adminFrame.menu.setVisible(true);
                Admin.adminFrame.listShopPage.setVisible(false);

            }
        });
        add(back);
    }

    public void updateArea(ArrayList<Goods> goods) {
        area.setText("");
        int id = 1;
        for (Goods g : goods) {
            area.append(g.getGoods() + "\n");
        }
    }
}

