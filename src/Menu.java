import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Container {

    public JButton addShop;
    public JButton listShop;
    public JButton deleteShop;
    public JButton exit;

    public Menu(){
        setSize(600,600);
        setLayout(null);

        addShop = new JButton("Add Shop");
        addShop.setBounds(200, 150, 150, 30);
        addShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showAddShopPage();
            }
        });
        add(addShop);

        listShop = new JButton("List Shop");
        listShop.setBounds(200, 200, 150, 30);
        listShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showListShopPage();
            }
        });
        add(listShop);

        deleteShop = new JButton("Delete Shop");
        deleteShop.setBounds(200, 250, 150, 30);
        deleteShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showDeleteShopPage();
            }
        });
        add(deleteShop);

        exit = new JButton("EXIT");
        exit.setBounds(200, 300, 150, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        add(exit);
    }
}

