import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteShop extends Container {

    public static JLabel insert_label;
    public static JTextField insert_id;
    public static JButton delete;
    public static JTextArea list;
    public static JLabel label_list;
    public static JButton back;

    public DeleteShop() {
        setSize(600, 600);
        setLayout(null);

        label_list = new JLabel("List of items");
        label_list.setBounds(290, 10, 150, 60);
        add(label_list);


        list = new JTextArea();
        list.setLocation(50, 70);
        list.setSize(400, 270);
        list.setEditable(false);
        add(list);

        insert_label = new JLabel("INSERT ID");
        insert_label.setBounds(230, 350, 100, 30);
        add(insert_label);

        insert_id = new JTextField("");
        insert_id.setBounds(300, 350, 100, 30);
        add(insert_id);

        delete = new JButton("DELETE");
        delete.setBounds(180, 400, 100, 30);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id;
                try {
                    id = Long.parseLong(insert_id.getText());
                    Admin.deleteGoods(id);
                    insert_id.setText("");
                    Admin.showMenu();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(delete);

        back = new JButton("BACK");
        back.setBounds(310, 400, 100, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.adminFrame.menu.setVisible(true);
                Admin.adminFrame.deleteShopPage.setVisible(false);
            }
        });
        add(back);

    }

    public void updateArea(ArrayList<Goods> goods) {
        list.setText("");
        int id = 1;
        for (Goods g : goods) {
            list.append(g.getGoods() + "\n");
        }
    }
}

