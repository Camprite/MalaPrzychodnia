import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Frame extends JFrame  implements Serializable{

    //Panel admienistratora
    public ArrayList<String> docPermisionsArr;
//    public JMenu rootMenu;
    public JMenuBar rootMenuBar;
    public JMenuItem rootDodajUprawnienie;
//    public JMenuItem otworzPrzychodnieZPliku;
    public JPanel rootLoggedInPane;
    public JPanel rootAddDocPane;
    public JPanel rootAddDocPane1;
    public JPanel rootAddDocPane2;
//    public JPanel rootAddPermissionPane;
//    public JPanel rootAddNursePane;
//    rootAdd
    public JLabel rootAddDocNameLabel;
    public JTextField rootAddDocNameTF;
    public JLabel rootAddDocSurnameLabel;
    public JTextField rootAddDocSurnameTF;
    public JLabel rootAddDocPESELLabel;
    public JTextField rootAddDocPESELTF;
    public JLabel rootAddDocLoginLabel;
    public JTextField rootAddDocLoginTF;
    public JLabel rootAddDocPasswordLabel;
    public JPasswordField rootAddDocPasswordPF;
    public JLabel rootAddDocPermissionsLabel;
    public JList rootAddDocPermissionsJL;
    public JButton rootAddDocAddButton;
    public JButton rootAddNurseAddButton;
    public JButton rootAddDocPermissionsJLClearButton;

//    public JLabel docLabel;
    public JLabel rootAddDocNewPermissionsLabel;
    public JTextField rootAddDocNewPermissionTF;
    public JButton rootAddDocAddNewPermission;

    //Panel lekarza
    public JPanel doctorLoggedInPane;

    //Panel pielegniarki
    public JPanel nurseLoggedInPane;

    //Panel pacjenta
    public JPanel patientLoggedInPane;



    //Przychodnia
//TEMPORARY
    public  Przychodnia przychodnia = new Przychodnia("root","root","przychodnie/root.przychodnia","root");
//TEMPORARY
    public  Osoba zalogowany = null;

    //MenuBar
    public JMenuBar loginMenuBar;
    public JMenu loginMenu;
    public JMenuItem stronaLogowania;
    public JMenuItem otworzPrzychodnieZPliku;
    public JMenuItem stworzNowaPrzychodnie;
    public JMenuItem zamknijZapiszPrzychodnie;

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
        Color backgound = new Color(0,191,255);

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
//        TEMPORARY
        username.setText("root");
        loginPasswordPane.add(passwordLabel = new JLabel("Hasło"));
        loginPasswordPane.add(password = new JPasswordField("",20));
//        TEMPORARY
        password.setText("root");
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


        //Root pane
        rootLoggedInPane = new JPanel();
        rootLoggedInPane.setBorder(BorderFactory.createEmptyBorder(100, //top
                0, //left
                0, //bottom
                0) //right
        );
        rootLoggedInPane.setLayout(new BoxLayout(rootLoggedInPane,BoxLayout.PAGE_AXIS));
        rootLoggedInPane.setBackground(backgound);
//        Dodawanie Lekarza
        rootAddDocPane = new JPanel();
        rootAddDocPane.setLayout(new FlowLayout());
        rootAddDocPane.setBackground(backgound);
        rootAddDocPane1 = new JPanel();
        rootAddDocPane1.setLayout(new FlowLayout());
        rootAddDocPane1.setBackground(backgound);
        rootAddDocPane2 = new JPanel();
        rootAddDocPane2.setLayout(new FlowLayout());
        rootAddDocPane2.setBackground(backgound);


        rootAddDocNameLabel = new JLabel("Imie");
        rootAddDocPane.add(rootAddDocNameLabel);
        rootAddDocNameTF = new JTextField("",20);
        rootAddDocPane.add(rootAddDocNameTF);
        rootAddDocSurnameLabel = new JLabel("Nazwisko");
        rootAddDocPane.add(rootAddDocSurnameLabel);
        rootAddDocSurnameTF = new JTextField("",20);
        rootAddDocPane.add(rootAddDocSurnameTF);
        rootAddDocPESELLabel = new JLabel("PESEL");
        rootAddDocPane1.add(rootAddDocPESELLabel);
        rootAddDocPESELTF = new JTextField("",20);
        rootAddDocPane1.add(rootAddDocPESELTF);
        rootAddDocLoginLabel = new JLabel("Login");
        rootAddDocPane1.add(rootAddDocLoginLabel);
        rootAddDocLoginTF = new JTextField("",20);
        rootAddDocPane1.add(rootAddDocLoginTF);
        rootAddDocPasswordLabel = new JLabel("Hasło");
        rootAddDocPane1.add(rootAddDocPasswordLabel);
        rootAddDocPasswordPF = new JPasswordField("",20);
        rootAddDocPane1.add(rootAddDocPasswordPF);

//Temporary added basic doc permissions
        przychodnia.addPermission("USG");
        przychodnia.addPermission("DSG");



        rootAddDocPermissionsLabel = new JLabel("<html>Wybierz uprawnienia <br> jeśli chcesz dodać doktora <br> (By wybrać więcej niż jedno przytrzymaj CTRL)</html>");
        rootAddDocPane2.add(rootAddDocPermissionsLabel);
        docPermisionsArr = przychodnia.getUprawnieniaAsArrayOfString();

        JPanel rootAddDocPermissionsJLPane = new JPanel();
        rootAddDocPermissionsJLPane.setLayout(new FlowLayout());
        rootAddDocPane2.add(rootAddDocPermissionsJLPane);


        rootAddDocPermissionsJL = new JList(docPermisionsArr.toArray(new String[docPermisionsArr.size()]));
        rootAddDocPermissionsJL.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        rootAddDocPermissionsJL.setSize(new Dimension(200,200));
        rootAddDocPermissionsJL.setPreferredSize(new Dimension(100,100));
        rootAddDocPermissionsJLPane.add(rootAddDocPermissionsJL);

        rootAddDocAddButton = new JButton("Dodaj lekarza");
        rootAddDocPane2.add(rootAddDocAddButton);
        rootAddNurseAddButton = new JButton("Dodaj pielęgniarke");;
        rootAddDocPane2.add(rootAddNurseAddButton);


        rootAddDocPermissionsJLClearButton = new JButton("Wyczyść zaznaczanie");



        rootLoggedInPane.add(rootAddDocPane);
        rootLoggedInPane.add(rootAddDocPane1);
        rootLoggedInPane.add(rootAddDocPane2);
        rootDodajUprawnienie = new JMenuItem("Dodaj nowe uprawnienie");
        rootMenuBar = new JMenuBar();
        rootMenuBar.add(rootDodajUprawnienie);



        //MENU BAR


        loginMenuBar = new JMenuBar();
        loginMenu = new JMenu("Menu");
        stronaLogowania = new JMenuItem("Strona logowania");
        otworzPrzychodnieZPliku = new JMenuItem("Otwórz baze przychodni z pliku");
        stworzNowaPrzychodnie = new JMenuItem("Stworz nową baze przychodni");
        zamknijZapiszPrzychodnie = new JMenuItem("Zamknij i zapisz przychodnie ");
        loginMenuBar.add(stronaLogowania);
        loginMenuBar.add(otworzPrzychodnieZPliku);
        loginMenuBar.add(stworzNowaPrzychodnie);
        loginMenuBar.add(zamknijZapiszPrzychodnie);
//        loginMenuBar.add(loginMenu);
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
                    try{
                        if(zalogowany!=null){
                            throw new InputMismatchException("Użytkownik jest juz zalogowany");
                        }
                        if (password.getPassword()==null) throw new InputMismatchException("Podaj hasło");
                        if (username.getText()==null) throw new InputMismatchException("Podaj nazwe użytkownika");
//                        System.out.println("login input");
//                        System.out.println(username.getText());
//                        System.out.println("haslo input");
//                        System.out.println(password.getPassword());
                        String passwordToString = new String(password.getPassword());
                        zalogowany = przychodnia.login(username.getText(), passwordToString);
                            if(zalogowany == null) {
                                throw new InputMismatchException("Brak podanego użytkownika w bazie");
                            }else {
//                                JOptionPane.showMessageDialog(null,"znaleziono "+ zalogowany.getImie());
                            }

                        getContentPane().removeAll();
                        getJMenuBar().removeAll();


                        if(zalogowany.getClass().getSimpleName().equals("Root")){
                            getContentPane().add(rootLoggedInPane);
                            rootLoggedInPane.setVisible(true);
                            setJMenuBar(rootMenuBar);
                        }
                        if(zalogowany.getClass().getSimpleName().equals("Pielegniarka")){
                            getContentPane().add(nurseLoggedInPane);
                            nurseLoggedInPane.setVisible(true);
                        }
                        if(zalogowany.getClass().getSimpleName().equals("Lekarz")){
                            getContentPane().add(doctorLoggedInPane);
                            doctorLoggedInPane.setVisible(true);
                        }
                        if(zalogowany.getClass().getSimpleName().equals("Pacjent")){
                            getContentPane().add(patientLoggedInPane);
                            patientLoggedInPane.setVisible(true);
                        }

                        getContentPane().revalidate();
                        getContentPane().repaint();



                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                        ex.printStackTrace();
//                        System.out.println(ex.printStackTrace());
                    }
                    
                    
                    
                }



            }
        });
        rootDodajUprawnienie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String input = (String) JOptionPane.showInputDialog(null,"Podaj nazwe uprawnienia");
//                System.out.println(input);
                przychodnia.addPermission(input);
                docPermisionsArr = przychodnia.getUprawnieniaAsArrayOfString();


                rootAddDocPermissionsJL = new JList(docPermisionsArr.toArray(new String[docPermisionsArr.size()]));
                rootAddDocPermissionsJL.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                rootAddDocPermissionsJL.setSize(new Dimension(200,200));
                rootAddDocPermissionsJL.setPreferredSize(new Dimension(100,100));
                rootAddDocPermissionsJLPane.removeAll();
                rootAddDocPermissionsJLPane.add(rootAddDocPermissionsJL);

                getContentPane().revalidate();
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
                String adminPassword = new String(hasloAdministratora.getPassword());
                przychodnia = new Przychodnia(nazwaNowejPrzychodni.getText(),nazwaAdministratora.getText(),"przychodnie/" +nazwaNowejPrzychodni.getText()+".przychodnia",adminPassword);
                try {
                    //Dodanie foledru przychodnie
                    File dir = new File("przychodnie/");
                    if (!dir.exists()) dir.mkdirs();
                    new File("przychodnie/" );

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

        rootAddDocPermissionsJLClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rootAddDocPermissionsJL.clearSelection();
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
//                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,"Baza niezdatna do odczytu");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Nie znaleziono pliku");
                }

            }
        });
        zamknijZapiszPrzychodnie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(przychodnia!=null){
                String filename = przychodnia.getFilename();
                try {
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(filename)));
                    out.writeObject(przychodnia);
                    JOptionPane.showMessageDialog(null,"Zapisano i zamknięto przyychodnie w pliku:" + filename);
                    System.exit(0);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                przychodnia = null;}
                else {
                    JOptionPane.showMessageDialog(null,"Brak wybranej przychodni");

                }
            }
        });
        rootAddNurseAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(rootAddDocNameTF.getText().isBlank() || rootAddDocSurnameTF.getText().isBlank() || rootAddDocPESELTF.getText().isBlank() || rootAddDocLoginTF.getText().isBlank() || rootAddDocPasswordPF.getPassword().toString().isBlank()) throw new AddingUserExceprion("Żadne pole nie może być puste");
                    if(Long.valueOf(rootAddDocPESELTF.getText())<10000000000L || Long.valueOf(rootAddDocPESELTF.getText())>=100000000000L)throw new AddingUserExceprion("Niezgodny pesel");

                    przychodnia.addNewNurse(rootAddDocNameTF.getText(),rootAddDocSurnameTF.getText(), Long.valueOf(rootAddDocPESELTF.getText()) ,rootAddDocLoginTF.getText(),rootAddDocPasswordPF.getPassword().toString());
                    JOptionPane.showMessageDialog(null,"Dodano pielęgniarke");
                }catch (AddingUserExceprion ex){
                    ex.getMessage();
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        rootAddDocAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Uprawnienia> u = new ArrayList<>();
                  int[] selectedIx =  rootAddDocPermissionsJL.getSelectedIndices();
                    String sel;
                    for (int i = 0; i < selectedIx.length; i++) {
                        sel = rootAddDocPermissionsJL.getModel().getElementAt(selectedIx[i]).toString();
                        System.out.println(sel);
                        Uprawnienia u1 = przychodnia.getUprawnienie(sel);
                        if(u1!=null){
                            u.add(u1);
                        }

                    }

                    if(rootAddDocNameTF.getText().isBlank() || rootAddDocSurnameTF.getText().isBlank() || rootAddDocPESELTF.getText().isBlank() || rootAddDocLoginTF.getText().isBlank() || rootAddDocPasswordPF.getPassword().toString().isBlank()) throw new AddingUserExceprion("Żadne pole nie może być puste");
                    if(Long.valueOf(rootAddDocPESELTF.getText())<10000000000L || Long.valueOf(rootAddDocPESELTF.getText())>=100000000000L)throw new AddingUserExceprion("Niezgodny pesel");

                    przychodnia.addNewDoc(rootAddDocNameTF.getText(),rootAddDocSurnameTF.getText(), Long.valueOf(rootAddDocPESELTF.getText()) ,rootAddDocLoginTF.getText(),rootAddDocPasswordPF.getPassword().toString(),u);
                    JOptionPane.showMessageDialog(null,"Dodano lekarza");
                }catch (AddingUserExceprion ex){
                    ex.getMessage();
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }


            }
        });
    }
}
