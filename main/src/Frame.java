import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Frame extends JFrame {
    //logowanie
    public final JButton enter;
    public JLabel usernameLabel;
    public JTextField username;
    public JLabel passwordLabel;
    public JPasswordField password;



    public Frame(){
        //Name of window
        setTitle("Mała przychodnia");

        //Window icon
        ImageIcon imgIcon = new ImageIcon("Icon.png");
        setIconImage(imgIcon.getImage());


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)screenSize.getWidth()/2,(int)screenSize.getHeight()/2);
        setMinimumSize(new Dimension(500,500));
        Color backgound = new Color(0,0,0);

        JPanel loginPane = new JPanel();
        loginPane.setLayout(new BoxLayout(loginPane,BoxLayout.PAGE_AXIS));
        loginPane.setBackground(backgound);

        JPanel loginHeaderPane = new JPanel();
        loginHeaderPane.setLayout(new FlowLayout());
        loginHeaderPane.setBackground(backgound);



        JPanel loginUsernamePane = new JPanel();
        loginUsernamePane.setLayout(new FlowLayout());
        loginUsernamePane.setBackground(backgound);

        JPanel loginPasswordPane = new JPanel();
        loginPasswordPane.setLayout(new FlowLayout());
        loginPasswordPane.setBackground(backgound);

        JPanel loginEnterPane = new JPanel();
        loginEnterPane.setLayout(new FlowLayout());
        loginEnterPane.setBackground(backgound);

//        loginHeaderPane.add(new Image());
        loginUsernamePane.add(usernameLabel = new JLabel("Nazwa użytkownika"));
        loginUsernamePane.add(username = new JTextField("",20));
        loginPasswordPane.add(passwordLabel = new JLabel("Hasło"));
        loginPasswordPane.add(password = new JPasswordField("",20));
        loginEnterPane.add(enter = new JButton("Zaloguj"));
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);

        loginPane.add(loginHeaderPane);
        loginPane.add(loginUsernamePane);
        loginPane.add(loginPasswordPane);
        loginPane.add(loginEnterPane);



        add(loginPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(password.getPassword());
            }
        });
    }
}
