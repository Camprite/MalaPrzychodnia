import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Frame extends JFrame {
    //Przychodnia
    public  Przychodnia przychodnia = null;

    //MenuBar
    public JMenuBar loginMenuBar;
    public JMenu loginMenu;
    public JMenuItem stronaLogowania;
    public JMenuItem otworzPrzychodnieZPliku;
    public JMenuItem stworzNowaPrzychodnie;

    //logowanie
    public final JButton enter;
    public JLabel usernameLabel;
    public JTextField username;
    public JLabel passwordLabel;
    public JPasswordField password;

    //Otwieranie lub tworzenie przychodni
    public JPanel openFromFilePane;
    public JPanel createNewFilePane;
    public JLabel nazwaPrzychodniLabel;
    public JTextField nazwaPrzychodni;
    public JButton otworzPrzychodnieZPlikuButton;
    public JLabel nazwaAdministratoraLabel;
    public JTextField nazwaAdministratora;
    public JLabel hasloAdministratoraLabel;
    public JPasswordField hasloAdministratora;
    public JLabel nazwaNowejPrzychodniLabel;
    public JTextField nazwaNowejPrzychodni;
    public JButton  stworzNowaPrzychodnieButton;




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

//        OTWIERANIE PRZYCHODNI Z PLIKU ORAZ TWORZENIE NOWEJ
        openFromFilePane = new JPanel();
        openFromFilePane.setBorder(BorderFactory.createEmptyBorder(100, //top
                0, //left
                0, //bottom
                0) //right
        );
        JPanel openFromFilePaneFL1 = new JPanel();
        JPanel openFromFilePaneFL2 = new JPanel();
        createNewFilePane = new JPanel();
        createNewFilePane.setBorder(BorderFactory.createEmptyBorder(100, //top
                0, //left
                0, //bottom
                0) //right
        );
        JPanel  createNewFilePaneFL1 = new JPanel();
        JPanel createNewFilePaneFL2 = new JPanel();
        JPanel createNewFilePaneFL3 = new JPanel();
        JPanel createNewFilePaneFL4 = new JPanel();

        openFromFilePaneFL1.setLayout(new FlowLayout());
        openFromFilePaneFL2.setLayout(new FlowLayout());
        openFromFilePaneFL1.setBackground(backgound);
        openFromFilePaneFL2.setBackground(backgound);
        createNewFilePaneFL1.setLayout(new FlowLayout());
        createNewFilePaneFL2.setLayout(new FlowLayout());
        createNewFilePaneFL3.setLayout(new FlowLayout());
        createNewFilePaneFL4.setLayout(new FlowLayout());
        createNewFilePaneFL1.setBackground(backgound);
        createNewFilePaneFL2.setBackground(backgound);
        createNewFilePaneFL3.setBackground(backgound);
        createNewFilePaneFL4.setBackground(backgound);
        openFromFilePane.add(openFromFilePaneFL1);
        openFromFilePane.add(openFromFilePaneFL2);
        createNewFilePane.add(createNewFilePaneFL1);
        createNewFilePane.add(createNewFilePaneFL2);
        createNewFilePane.add(createNewFilePaneFL3);
        createNewFilePane.add(createNewFilePaneFL4);

        openFromFilePane.setLayout(new BoxLayout(openFromFilePane, BoxLayout.Y_AXIS));
        createNewFilePane.setLayout(new BoxLayout(createNewFilePane, BoxLayout.Y_AXIS));
        openFromFilePane.setBackground(backgound);
        createNewFilePane.setBackground(backgound);

        nazwaPrzychodniLabel = new JLabel("Nazwa przychodni");
        nazwaPrzychodniLabel.setForeground(Color.WHITE);
        nazwaPrzychodni = new JTextField("",20);
        otworzPrzychodnieZPlikuButton = new JButton("Otworz przychodnie z pliku");

        openFromFilePaneFL1.add(nazwaPrzychodniLabel);
        openFromFilePaneFL1.add(nazwaPrzychodni);
        openFromFilePaneFL2.add(otworzPrzychodnieZPlikuButton);



        nazwaNowejPrzychodniLabel = new JLabel("Nazwa przychodni");
        nazwaNowejPrzychodniLabel.setForeground(Color.WHITE);
        nazwaNowejPrzychodni = new JTextField("",20);
        nazwaAdministratoraLabel = new JLabel("Podaj nazwe administratora przychodni");
        nazwaAdministratoraLabel.setForeground(Color.WHITE);
        nazwaAdministratora = new JTextField("",20);
        hasloAdministratoraLabel = new JLabel("Podaj hasło administratora przychodni");
        hasloAdministratoraLabel.setForeground(Color.WHITE);
        hasloAdministratora = new JPasswordField("",20);
        stworzNowaPrzychodnieButton = new JButton("Stworz nową przychodnie");

        createNewFilePaneFL1.add(nazwaNowejPrzychodniLabel);
        createNewFilePaneFL1.add(nazwaNowejPrzychodni);
        createNewFilePaneFL2.add(nazwaAdministratoraLabel);
        createNewFilePaneFL2.add(nazwaAdministratora);
        createNewFilePaneFL3.add(hasloAdministratoraLabel);
        createNewFilePaneFL3.add(hasloAdministratora);
        createNewFilePaneFL4.add(stworzNowaPrzychodnieButton);


        loginMenuBar = new JMenuBar();
        loginMenu = new JMenu("Menu");
        stronaLogowania = new JMenuItem("Strona logowania");
        otworzPrzychodnieZPliku = new JMenuItem("Otwórz baze przychodni z pliku");
        stworzNowaPrzychodnie = new JMenuItem("Stworz nową baze przychodni");
        loginMenu.add(stronaLogowania);
        loginMenu.add(otworzPrzychodnieZPliku);
        loginMenu.add(stworzNowaPrzychodnie);
        loginMenuBar.add(loginMenu);
        this.setJMenuBar(loginMenuBar);




        add(loginPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(przychodnia == null){
                    JOptionPane.showMessageDialog(null,"Brak wybranej przychodni");
                }else {
                    System.out.println(password.getPassword());
                }



            }
        });
        otworzPrzychodnieZPliku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               getContentPane().removeAll();
               getContentPane().add(openFromFilePane);
                openFromFilePane.setVisible(true);
                getContentPane().revalidate();
                getContentPane().repaint();
            }
        });
        stworzNowaPrzychodnie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(createNewFilePane);
                createNewFilePane.setVisible(true);
                getContentPane().revalidate();
                getContentPane().repaint();
            }
        });
        stronaLogowania.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(loginPane);
                loginPane.setVisible(true);
                getContentPane().revalidate();
                getContentPane().repaint();
            }
        });
        stworzNowaPrzychodnieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                przychodnia = new Przychodnia(nazwaNowejPrzychodni.getText(),nazwaAdministratora.getText(),hasloAdministratora.getPassword());
                try {
                    File f = new File("przychodnie/" +nazwaNowejPrzychodni.getText()+".przychodnia");
                    if(f.exists()) {
                        JOptionPane.showMessageDialog(null,"Plik o podanej nazwie już istnieje");
                    }else {
                        ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(f));
                        file.writeObject(przychodnia);
                        JOptionPane.showMessageDialog(null,"Utworzono przychodnie");

                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        otworzPrzychodnieZPlikuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f = new File("przychodnie/" +nazwaPrzychodni.getText()+".przychodnia");
                if(f.exists()){
                    try {
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
                        przychodnia = (Przychodnia) in.readObject();
                        JOptionPane.showMessageDialog(null,"Dane przychodni zostały wczytane.");
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Nie znaleziono pliku");
                }

            }
        });

    }
}
