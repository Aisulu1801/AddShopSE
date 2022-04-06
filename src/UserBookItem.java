import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserBookItem extends Container {

    public static ArrayList <Goods> goods = new ArrayList<>();
    public static Goods array[]=new Goods[goods.size()];
    public JComboBox goodList = new JComboBox (array);
    private JLabel goodId_label;
    private JLabel name_label;
    private JTextField name;
    private JLabel surname_label;
    private JTextField surname;
    private JLabel password_label;
    private JTextField password;
    private JButton add;
    private JButton back;
    private JLabel feedback;


    public UserBookItem() {
        setSize(600, 600);
        setLayout(null);

        goodId_label = new JLabel("Items list: ");
        goodId_label.setBounds(100, 130, 100, 30);
        add(goodId_label);

        goodList.setBounds(180, 130, 350, 30);
        add(goodList);

        name_label = new JLabel("Name: ");
        name_label.setBounds(100, 160, 100, 30);
        add(name_label);

        name = new JTextField();
        name.setBounds(180, 160, 350, 30);
        add(name);

        surname_label = new JLabel("Surname: ");
        surname_label.setBounds(100, 190, 100, 30);
        add(surname_label);

        surname = new JTextField();
        surname.setBounds(180, 190, 350, 30);
        add(surname);

        password_label = new JLabel("Password: ");
        password_label.setBounds(100, 220, 100, 30);
        add(password_label);

        password = new JTextField();
        password.setBounds(180, 220, 350, 30);
        add(password);

        feedback = new JLabel("");
        feedback.setBounds(180, 310, 200, 30);
        add(feedback);

        add = new JButton("ADD");
        add.setBounds(150, 270, 100, 30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id;
                try {
                    id = Long.parseLong(String.valueOf(goodList.getSelectedIndex())) + 1;
                    Booking newBook = new Booking(null, id, name.getText(), surname.getText(), password.getText());
                    System.out.println("newbook" + newBook);
                    Client.bookItem(newBook);
                    feedback.setText("You booked the item!");
                    Client.showUserMenu();
                } catch (Exception ex){ex.printStackTrace();}
            }
        });
        add(add);

        back = new JButton("BACK");
        back.setBounds(290, 270, 100, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.frame.menu.setVisible(true);
                Client.frame.bookPage.setVisible(false);
            }
        });
        add(back);
    }

    public void updateCombobox(ArrayList<Goods> goods) {
        goodList.removeAllItems();
        for (Goods g : goods){
            goodList.addItem(g.getGoods());
        }
    }
}

