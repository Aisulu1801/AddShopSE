import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddShop extends Container {

    private JButton back;

    private JLabel model_label;
    private JTextField model;

    private JLabel name_label;
    private JTextField name;

    private JLabel price_label;
    private JTextField price;

    private JButton add;

    public static JLabel feedback;


    public AddShop() {
        setSize(600, 600);
        setLayout(null);

        model_label = new JLabel("Model: ");
        model_label.setBounds(200, 150, 100, 30);
        add(model_label);

        model = new JTextField("");
        model.setBounds(280, 150, 150, 30);
        add(model);

        name_label = new JLabel("Name: ");
        name_label.setBounds(200, 200, 100, 30);
        add(name_label);

        name = new JTextField("");
        name.setBounds(280, 200, 150, 30);
        add(name);

        price_label = new JLabel("Price: ");
        price_label.setBounds(200, 250, 100, 30);
        add(price_label);

        price = new JTextField("");
        price.setBounds(280, 250, 150, 30);
        add(price);

        feedback = new JLabel("");
        feedback.setBounds(220, 400, 200, 30);
        add(feedback);

        add = new JButton("ADD");
        add.setBounds(180, 350, 80, 30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pricee = 0;
                try {
                    pricee = Integer.parseInt(price.getText());
                    Goods good = new Goods(null, model.getText(), name.getText(), pricee);
                    Admin.addGoods(good);
                    model.setText("");
                    name.setText("");
                    price.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(add);

        back = new JButton("BACK");
        back.setBounds(350, 350, 80, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.adminFrame.menu.setVisible(true);
                Admin.adminFrame.addShopPage.setVisible(false);
                feedback.setText("");
            }
        });
        add(back);

    }


}

