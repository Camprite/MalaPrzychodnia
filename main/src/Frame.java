import javax.swing.*;
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
JPanel rootAddDocPermissionsJLPane = new JPanel();
public JMenuItem rootLogout = new JMenuItem("Wyloguj");
    public JMenuBar rootMenuBar;
    public JMenuItem rootDodajUprawnienie = new JMenuItem("Dodaj nowe uprawnienie");
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
    public JButton rootAddDocAddButton = new JButton("Dodaj lekarza");
    public JButton rootAddNurseAddButton = new JButton("Dodaj pielęgniarke");
    public JButton rootAddDocPermissionsJLClearButton = new JButton("Wyczyść zaznaczanie");

//    public JLabel docLabel;
    public JLabel rootAddDocNewPermissionsLabel;
    public JTextField rootAddDocNewPermissionTF;
    public JButton rootAddDocAddNewPermission;

    //Panel lekarza
    public JMenuItem docLogout = new JMenuItem("Wyloguj");
    public JPanel doctorLoggedInPane;

    //Panel pielegniarki
    public JMenuItem nurseLogout = new JMenuItem("Wyloguj");
    public JPanel nurseLoggedInPane;
    //default logged in pane shows duty edits
    public  JMenuBar nurseMenuBar;
    public JMenuItem nurseNewPatientMI = new JMenuItem("Dodaj pacjenta");
    public JMenuItem nurseSetPatientCardMI = new JMenuItem("Stwórz karte pacjenta");
    public JMenuItem nurseEditDeletePatientMI = new JMenuItem("Edytuj/Usuń pacjenta ");
    public JMenuItem nurseAddDutyPanelMI = new JMenuItem("Zarządzaj dyżurami");
    public JPanel nurseNewPatientPanel;
    public JPanel nurseSetPatientCardPanel;
    public JPanel nurseEditDeletePatientPanel;
    public JPanel nurseAddDutyPanel;


//                            DUTY MANIPULATION main view
    public String[] hours = {"4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",};
    public String[] days = {"Poniedzialek","Wtorek","Sroda","Czwartek","Piątek","Sobota","Niedziela"};
    public JPanel nurseDutyPanel = new JPanel();
    public JPanel nurseDutyPanel1 = new JPanel();
    public JPanel nurseDutyPanel2 = new JPanel();
    public JPanel nurseDutyPanel3 = new JPanel();
    public JPanel nurseDutyPanel4 = new JPanel();
    public JLabel nurseDutyChangeEmployee = new JLabel("Wybierz osobe");
    public ArrayList<String> empoyeesArr;
    public JList nurseDutyChangeEmployeeList ;

    public JLabel nurseDutyChangeDay = new JLabel("Wybierz dzień");
    public JList nurseDutyChangeDayList = new JList(days);
    public JLabel nurseDutyChangeTimeStart = new JLabel("Wybierz od której godziny zaczyna dyżur");
    public JList nurseDutyChangeTimeListStart = new JList(hours);
    public JLabel nurseDutyChangeTimeEnd = new JLabel("Wybierz o której godzinie kończy");
    public JList nurseDutyChangeTimeListEnd = new JList(hours);
    public JButton nurseDutyChangeApplyButton = new JButton("Zatwierdź");
    //                            END DUTY MANIPULATION

    //      PATIENT ADDING PANE
    public JPanel nurseAddPatientPane = new JPanel();
    public JPanel nurseAddPatientPane1 = new JPanel();
    public JPanel nurseAddPatientPane2 = new JPanel();
    public JPanel nurseAddPatientPane3 = new JPanel();
    public JPanel nurseAddPatientPane4 = new JPanel();
    public JPanel nurseAddPatientPane5 = new JPanel();
    public JPanel nurseAddPatientPane6 = new JPanel();
    public JLabel nurseAddPatientNameL = new JLabel("Imie");
    public JTextField nurseAddPatientName = new JTextField("",20);
    public JLabel nurseAddPatientSurnameL = new JLabel("Nazwisko");
    public JTextField nurseAddPatientSurname = new JTextField("",20);
    public JLabel nurseAddPatientLoginL = new JLabel("Login");
    public JTextField nurseAddPatientLogin = new JTextField("",20);
    public JLabel nurseAddPatientPasswordL = new JLabel("Hasło");
    public JPasswordField nurseAddPatientPassword = new JPasswordField("",20);
    public JLabel nurseAddPatientPESELL = new JLabel("PESEL");
    public JTextField nurseAddPatientPesel = new JTextField("",20);
    public JButton nurseAddPatientADDButton = new JButton("Dodaj pacjenta");

//    NURSE SET PATIENT CARD PANE

    public JPanel nurseAddPatientCardPane = new JPanel();
    public JPanel nurseAddPatientCardPane1 = new JPanel();
    public JPanel nurseAddPatientCardPane2 = new JPanel();
    public JPanel nurseAddPatientCardPane3 = new JPanel();
    public ArrayList<String> nursePatientWithoutCard = null;
    public JList<String> nurseAddPatientCardJL;
    public JButton nurseAddPatientCardButton = new JButton("Stwórz karte pacjenta");

    //NURSE EDIT/DELETE PATIENT

    public JPanel nurseEditDeletePatientPane1 = new JPanel();
    public JPanel nurseEditDeletePatientPane2 = new JPanel();
    public JPanel nurseEditDeletePatientPane3 = new JPanel();
    public JPanel nurseEditDeletePatientPane4 = new JPanel();
    public ArrayList<String> nursePatients= null;
    public JList<String> nurseEditDeletePatientsJL;

    public JLabel nurseEditDeletePatientEditNameL = new JLabel("Podaj nowe Imie");
    public JTextField nurseEditDeletePatientEditNameTF = new JTextField("",20);
    public JLabel nurseEditDeletePatientEditSurnameL = new JLabel("Podaj nowe nazwisko");
    public JTextField nurseEditDeletePatientEditSurnameTF = new JTextField("",20);
    public JLabel nurseEditDeletePatientEditLoginL = new JLabel("Podaj nowy login");
    public JTextField nurseEditDeletePatientEditLoginTF = new JTextField("",20);
    public JLabel nurseEditDeletePatientEditPasswordL = new JLabel("Podaj nowe hasło");
    public JTextField nurseEditDeletePatientEditPasswordTF = new JTextField("",20);
    public JButton nurseAddPatientCardButtonEditButton = new JButton("Edytuj Pacjenta");
    public JButton nurseAddPatientCardButtonDeleteButton = new JButton("Usuń Pacjenta");


    //Panel pacjenta
    public JMenuItem patinetLogout = new JMenuItem("Wyloguj");
    public JPanel patientLoggedInPane = new JPanel();
    public JMenuBar patientMenuBar = new JMenuBar();
    public JMenuItem patientShowVisits = new JMenuItem("Pokaż moje wizyty");
    public JPanel patientVisitsPane = new JPanel();
    public JTextArea patientVisitsArea = new JTextArea(20,50);
    public JScrollPane patientVisitsAreaSP = new JScrollPane(patientVisitsArea);
    public JPanel patientVisitsPane1 = new JPanel();
    public JPanel patientVisitsPane2 = new JPanel();
    public JPanel patientVisitsPane3 = new JPanel();
    public JMenuItem patientMakeReservation = new JMenuItem("Rezerwacja wizyty");
    public JPanel patientMakeReservationPane = new JPanel();
    public JPanel patientMakeReservationPane1 = new JPanel();
    public JPanel patientMakeReservationPane2 = new JPanel();
    public JPanel patientMakeReservationPane3 = new JPanel();
    public JPanel patientMakeReservationPane4 = new JPanel();
    public JPanel patientReservationPane = new JPanel();

    public ArrayList<String> patientReservationDocLists = null;
    public ArrayList<String> patientReservationPermissionsLists = null;
    public JList<String> patientReservationDocListsJL;
    public JList<String> patientReservationPermissionsListsJL;
    public JMenuItem patientLogout = new JMenuItem("Wyloguj");




    //Przychodnia
//TEMPORARY
    public  Przychodnia przychodnia = new Przychodnia("root","root","przychodnie/root.przychodnia","root");
//TEMPORARY
    public  Osoba zalogowany = null;

    //MenuBar
    public JMenuBar loginMenuBar = new JMenuBar();
    public JMenu loginMenu = new JMenu("Menu");
    public JMenuItem stronaLogowania = new JMenuItem("Strona logowania");
    public JMenuItem otworzPrzychodnieZPliku = new JMenuItem("Otwórz baze przychodni z pliku");
    public JMenuItem stworzNowaPrzychodnie = new JMenuItem("Stworz nową baze przychodni");
    public JMenuItem zamknijZapiszPrzychodnie = new JMenuItem("Zamknij i zapisz przychodnie ");

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





    public Frame() throws AddingUserException {



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

        //END ROOT PANE

        //NURSE PANE


        //END NURSE PANE


        //DOC PANE

        //END DOC PANE

        //PATIENT PANE

        //END PATIENT PANE



        //MENU BAR


        loginMenuBar.add(stronaLogowania);
        loginMenuBar.add(otworzPrzychodnieZPliku);
        loginMenuBar.add(stworzNowaPrzychodnie);
        loginMenuBar.add(zamknijZapiszPrzychodnie);
//        loginMenuBar.add(loginMenu);
        setJMenuBar(loginMenuBar);





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
                        System.out.println("login input");
                        System.out.println(username.getText());
                        System.out.println("haslo input");
                        System.out.println(password.getPassword());
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
                            rootLoggedInPane = new JPanel();
                            rootLoggedInPane.setBorder(BorderFactory.createEmptyBorder(100, //top
                                    0, //left
                                    0, //bottom
                                    0) //right
                            );
                            rootAddDocPermissionsJLPane.removeAll();
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
                            rootAddDocPESELTF.setText("12312312312");
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


                            rootAddDocPermissionsJLPane.setLayout(new FlowLayout());
                            rootAddDocPane2.add(rootAddDocPermissionsJLPane);
                            rootAddDocPane2.add(rootAddDocPermissionsJLClearButton);


                            rootAddDocPermissionsJL = new JList(docPermisionsArr.toArray(new String[docPermisionsArr.size()]));
                            rootAddDocPermissionsJL.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                            rootAddDocPermissionsJL.setSize(new Dimension(200,200));
                            rootAddDocPermissionsJL.setPreferredSize(new Dimension(100,100));
                            rootAddDocPermissionsJLPane.add(rootAddDocPermissionsJL);


                            rootAddDocPane2.add(rootAddDocAddButton);

                            rootAddDocPane2.add(rootAddNurseAddButton);






                            rootLoggedInPane.add(rootAddDocPane);
                            rootLoggedInPane.add(rootAddDocPane1);
                            rootLoggedInPane.add(rootAddDocPane2);

                            rootMenuBar = new JMenuBar();
                            rootMenuBar.add(rootDodajUprawnienie);
                            rootMenuBar.add(rootLogout);
                            getContentPane().add(rootLoggedInPane);
                            setJMenuBar(rootMenuBar);
//                            rootMenuBar.setVisible(true);
//                            rootLoggedInPane.setVisible(true);
                        }
                        if(zalogowany.getClass().getSimpleName().equals("Pielegniarka")){

                            nurseLoggedInPane = new JPanel();
                            nurseLoggedInPane.setBackground(backgound);

                            nurseLoggedInPane.removeAll();
                            getJMenuBar().removeAll();

                            nurseLoggedInPane.setLayout(new BoxLayout(nurseLoggedInPane,BoxLayout.PAGE_AXIS));
                            nurseLoggedInPane.setBackground(backgound);
                            nurseMenuBar = new JMenuBar();
                            nurseMenuBar.add(nurseNewPatientMI);
                            nurseMenuBar.add(nurseSetPatientCardMI);
                            nurseMenuBar.add(nurseEditDeletePatientMI);
                            nurseMenuBar.add(nurseAddDutyPanelMI);
                            nurseMenuBar.add(nurseLogout);
//
//                              DUTY MANIPULATION main view
                            empoyeesArr = przychodnia.getEmployeesAsArrayOfString();
                            nurseDutyChangeEmployeeList = new JList(empoyeesArr.toArray(new String[empoyeesArr.size()]));
                            JScrollPane nurseDutyChangeEmployeeListScrollPane = new JScrollPane(nurseDutyChangeEmployeeList);
                            nurseDutyChangeEmployeeListScrollPane.setPreferredSize(new Dimension(150,150));
                            nurseDutyPanel.add(nurseDutyChangeEmployee);
                            nurseDutyPanel.add(nurseDutyChangeEmployeeListScrollPane);

                            nurseDutyChangeDayList = new JList(days);
                            nurseDutyChangeDayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                            nurseDutyChangeTimeListStart = new JList(hours);
                            nurseDutyChangeTimeListStart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//                            nurseDutyChangeTimeListStart.setSize(new Dimension(200,200));
//                            nurseDutyChangeTimeListStart.setPreferredSize(new Dimension(50,100));

                            nurseDutyChangeTimeListEnd = new JList(hours);
                            nurseDutyChangeTimeListEnd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//                            nurseDutyChangeTimeListEnd.setSize(new Dimension(200,200));
//                            nurseDutyChangeTimeListEnd.setPreferredSize(new Dimension(50,100));

                            JScrollPane scrollPaneDay = new JScrollPane(nurseDutyChangeDayList);
                            scrollPaneDay.setPreferredSize(new Dimension(150,150));
                            scrollPaneDay.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                            nurseDutyPanel1.add(nurseDutyChangeDay);
                            nurseDutyPanel1.add(scrollPaneDay);

                            JScrollPane scrollPane = new JScrollPane(nurseDutyChangeTimeListStart);
                            scrollPane.setPreferredSize(new Dimension(150,150));
                            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                            nurseDutyPanel2.add(nurseDutyChangeTimeStart);
                            nurseDutyPanel2.add(scrollPane);

                            JScrollPane scrollPane2 = new JScrollPane(nurseDutyChangeTimeListEnd);
                            scrollPane2.setPreferredSize(new Dimension(150,150));
                            scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                            nurseDutyPanel3.add(nurseDutyChangeTimeEnd);
                            nurseDutyPanel3.add(scrollPane2);


                            nurseDutyPanel4.add(nurseDutyChangeApplyButton);

                            nurseLoggedInPane.add(nurseDutyPanel);
                            nurseLoggedInPane.add(nurseDutyPanel1);
                            nurseLoggedInPane.add(nurseDutyPanel2);
                            nurseLoggedInPane.add(nurseDutyPanel3);
                            nurseLoggedInPane.add(nurseDutyPanel4);
                            nurseDutyPanel.setBackground(backgound);
                            nurseDutyPanel1.setBackground(backgound);
                            nurseDutyPanel2.setBackground(backgound);
                            nurseDutyPanel3.setBackground(backgound);
                            nurseDutyPanel4.setBackground(backgound);
//                            END DUTY MANIPULATION


//                                NURSEPANE
//                                END NURSEPANE

//                            ADDING PATIENT
//                            END ADDING PATIENT

//                            ADDING PATIENT CARD
//                            END ADDING PATIENT CARD

//                            EDITING PATIENT
//                            END EDITING PATIENT

//                            DUTY MANIPULATION
//                            END DUTY MANIPULATION
                            repaint();
                            revalidate();
                            JScrollPane nurseMainScrollPane = new JScrollPane(nurseLoggedInPane);
                            nurseMainScrollPane.setBackground(backgound);
                            getContentPane().add(nurseMainScrollPane);
                            setJMenuBar(nurseMenuBar);
                            nurseLoggedInPane.setVisible(true);
                        }
                        if(zalogowany.getClass().getSimpleName().equals("Lekarz")){
                            getContentPane().add(doctorLoggedInPane);
                            doctorLoggedInPane.setVisible(true);
                        }
                        if(zalogowany.getClass().getSimpleName().equals("Pacjent")){
                            patientLoggedInPane = new JPanel();
                            patientLoggedInPane.setBackground(backgound);
                            patientLoggedInPane.removeAll();
                            patientLoggedInPane.setLayout(new BoxLayout(patientLoggedInPane,BoxLayout.Y_AXIS));
                            getJMenuBar().removeAll();
                            patientMenuBar.add(patientShowVisits);
                            patientMenuBar.add(patientMakeReservation);
                            patientMenuBar.add(patientLogout);
                            patientVisitsPane.setLayout(new FlowLayout());
                            patientVisitsPane1.setLayout(new FlowLayout());
                            patientVisitsPane2.setLayout(new FlowLayout());
                            patientVisitsPane3.setLayout(new FlowLayout());
                            patientVisitsPane.setBackground(backgound);
                            patientVisitsPane1.setBackground(backgound);
                            patientVisitsPane2.setBackground(backgound);
                            patientVisitsPane3.setBackground(backgound);

                            try {
                                ArrayList<String> wizytyPacjenta =  przychodnia.getPacjentVisitsAsStrings((Pacjent) zalogowany);
                                patientVisitsArea.setEditable(false);
                                String output = "";
                                for (String w:wizytyPacjenta
                                ) {
                                    output+=w;
                                }
                                patientVisitsArea.setText(output);
                                patientVisitsArea.setLineWrap(true);
                                patientVisitsArea.setWrapStyleWord(true);

                                patientVisitsArea.setPreferredSize(new Dimension(500,500));
                                patientVisitsAreaSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                                patientVisitsPane.add(patientVisitsAreaSP);

                            }catch (Exception ex){
                                JOptionPane.showMessageDialog(null,"Brak wizyt");
                            }
                            patientLoggedInPane.add(patientVisitsPane);
                            patientLoggedInPane.add(patientVisitsPane1);
                            patientLoggedInPane.add(patientVisitsPane2);
                            patientLoggedInPane.add(patientVisitsPane3);
                            repaint();
                            revalidate();
                            setJMenuBar(patientMenuBar);
                            getContentPane().add(patientLoggedInPane);
                            patientLoggedInPane.setVisible(true);
                        }

                        getContentPane().revalidate();
//                        getContentPane().repaint();
//                        getJMenuBar().revalidate();
//                        getJMenuBar().repaint();



                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                        ex.printStackTrace();
//                        System.out.println(ex.printStackTrace());
                    }



                }



            }
        });
        patientMakeReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                patientMakeReservationPane = new JPanel();
                patientMakeReservationPane.removeAll();
                patientMakeReservationPane.setBackground(backgound);
                patientMakeReservationPane.setLayout(new BoxLayout(patientMakeReservationPane,BoxLayout.Y_AXIS));
                patientMakeReservationPane1.setLayout(new FlowLayout());
                patientMakeReservationPane2.setLayout(new FlowLayout());
                patientMakeReservationPane3.setLayout(new FlowLayout());
                patientMakeReservationPane4.setLayout(new FlowLayout());

                patientMakeReservationPane1.setBackground(backgound);
                patientMakeReservationPane2.setBackground(backgound);
                patientMakeReservationPane3.setBackground(backgound);
                patientMakeReservationPane4.setBackground(backgound);
                patientReservationDocLists = przychodnia.getDocsAsStrings();
                patientReservationPermissionsLists = przychodnia.getUprawnieniaAsArrayOfString();

                patientMakeReservationPane.add(patientMakeReservationPane1);
                patientMakeReservationPane.add(patientMakeReservationPane1);
                patientMakeReservationPane.add(patientMakeReservationPane1);
                patientMakeReservationPane.add(patientMakeReservationPane1);

                repaint();
                revalidate();
                getContentPane().add(patientMakeReservationPane);
                patientLoggedInPane.setVisible(true);
                getContentPane().revalidate();
            }
        });
        patientShowVisits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientLoggedInPane = new JPanel();
                patientLoggedInPane.setBackground(backgound);
                patientLoggedInPane.removeAll();
                patientLoggedInPane.setLayout(new BoxLayout(patientLoggedInPane, BoxLayout.Y_AXIS));
//                getJMenuBar().removeAll();
                patientMenuBar.add(patientShowVisits);
                patientMenuBar.add(patientMakeReservation);
                patientMenuBar.add(patientLogout);
                patientVisitsPane.setLayout(new FlowLayout());
                patientVisitsPane1.setLayout(new FlowLayout());
                patientVisitsPane2.setLayout(new FlowLayout());
                patientVisitsPane3.setLayout(new FlowLayout());
                patientVisitsPane.setBackground(backgound);
                patientVisitsPane1.setBackground(backgound);
                patientVisitsPane2.setBackground(backgound);
                patientVisitsPane3.setBackground(backgound);

                try {
                    ArrayList<String> wizytyPacjenta = przychodnia.getPacjentVisitsAsStrings((Pacjent) zalogowany);
                    patientVisitsArea.setEditable(false);
                    String output = "";
                    for (String w : wizytyPacjenta
                    ) {
                        output += w;
                    }
                    patientVisitsArea.setText(output);
                    patientVisitsArea.setLineWrap(true);
                    patientVisitsArea.setWrapStyleWord(true);

                    patientVisitsArea.setPreferredSize(new Dimension(500, 500));
                    patientVisitsAreaSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    patientVisitsPane.add(patientVisitsAreaSP);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Brak wizyt");
                }
                patientLoggedInPane.add(patientVisitsPane);
                patientLoggedInPane.add(patientVisitsPane1);
                patientLoggedInPane.add(patientVisitsPane2);
                patientLoggedInPane.add(patientVisitsPane3);
                getContentPane().add(patientLoggedInPane);
                patientLoggedInPane.setVisible(true);
//                patientLoggedInPane.revalidate();
                patientVisitsPane.repaint();
//                repaint();
                revalidate();


            }});
        patientLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zalogowany = null;
                getContentPane().removeAll();
                getJMenuBar().removeAll();
                loginMenuBar.add(stronaLogowania);
                loginMenuBar.add(otworzPrzychodnieZPliku);
                loginMenuBar.add(stworzNowaPrzychodnie);
                loginMenuBar.add(zamknijZapiszPrzychodnie);

//        loginMenuBar.add(loginMenu);
                setJMenuBar(loginMenuBar);
                getContentPane().add(loginPane);
                loginPane.setVisible(true);
                getContentPane().revalidate();
                getContentPane().repaint();
                getJMenuBar().revalidate();
                getJMenuBar().repaint();
            }
        });
        rootLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zalogowany = null;
                getContentPane().removeAll();
                getJMenuBar().removeAll();
                loginMenuBar.add(stronaLogowania);
                loginMenuBar.add(otworzPrzychodnieZPliku);
                loginMenuBar.add(stworzNowaPrzychodnie);
                loginMenuBar.add(zamknijZapiszPrzychodnie);

//        loginMenuBar.add(loginMenu);
                setJMenuBar(loginMenuBar);
                getContentPane().add(loginPane);
                loginPane.setVisible(true);
                getContentPane().revalidate();
                getContentPane().repaint();
                getJMenuBar().revalidate();
                getJMenuBar().repaint();
            }
        });
        nurseLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    zalogowany = null;
                    getContentPane().removeAll();
                    getJMenuBar().removeAll();
                    loginMenuBar.add(stronaLogowania);
                    loginMenuBar.add(otworzPrzychodnieZPliku);
                    loginMenuBar.add(stworzNowaPrzychodnie);
                    loginMenuBar.add(zamknijZapiszPrzychodnie);
                    nurseDutyPanel.removeAll();
                    nurseDutyPanel1.removeAll();
                    nurseDutyPanel2.removeAll();
                    nurseDutyPanel3.removeAll();
                    nurseDutyPanel4.removeAll();
                    nurseLoggedInPane.revalidate();
                    nurseLoggedInPane.repaint();

//        loginMenuBar.add(loginMenu);
                    setJMenuBar(loginMenuBar);
                    getContentPane().add(loginPane);
                    loginPane.setVisible(true);
                    getContentPane().revalidate();
                    getContentPane().repaint();
                    getJMenuBar().revalidate();
                    getJMenuBar().repaint();
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
//
                getContentPane().revalidate();
                getContentPane().repaint();
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
                try {
                    przychodnia = new Przychodnia(nazwaNowejPrzychodni.getText(),nazwaAdministratora.getText(),"przychodnie/" +nazwaNowejPrzychodni.getText()+".przychodnia",adminPassword);
                } catch (AddingUserException ex) {
                    throw new RuntimeException(ex);
                }
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
                    if(rootAddDocNameTF.getText().isBlank() || rootAddDocSurnameTF.getText().isBlank() || rootAddDocPESELTF.getText().isBlank() || rootAddDocLoginTF.getText().isBlank() || rootAddDocPasswordPF.getPassword().toString().isBlank()) throw new AddingUserException("Żadne pole nie może być puste");
                    if(Long.valueOf(rootAddDocPESELTF.getText())<10000000000L || Long.valueOf(rootAddDocPESELTF.getText())>=100000000000L)throw new AddingUserException("Niezgodny pesel");
                    System.out.println("Passwordcheck");

                    przychodnia.addNewNurse(rootAddDocNameTF.getText(),rootAddDocSurnameTF.getText(), Long.valueOf(rootAddDocPESELTF.getText()) ,rootAddDocLoginTF.getText(),String.copyValueOf(rootAddDocPasswordPF.getPassword()));
                    JOptionPane.showMessageDialog(null,"Dodano pielęgniarke");
                }catch (AddingUserException ex){
                    ex.getMessage();
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        rootAddDocAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked");
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

                    if(rootAddDocNameTF.getText().isBlank() || rootAddDocSurnameTF.getText().isBlank() || rootAddDocPESELTF.getText().isBlank() || rootAddDocLoginTF.getText().isBlank() || rootAddDocPasswordPF.getPassword().toString().isBlank()) throw new AddingUserException("Żadne pole nie może być puste");
                    if(Long.valueOf(rootAddDocPESELTF.getText())<10000000000L || Long.valueOf(rootAddDocPESELTF.getText())>=100000000000L)throw new AddingUserException("Niezgodny pesel");

                    przychodnia.addNewDoc(rootAddDocNameTF.getText(),rootAddDocSurnameTF.getText(), Long.valueOf(rootAddDocPESELTF.getText()) ,rootAddDocLoginTF.getText(),rootAddDocPasswordPF.getPassword().toString(),u);
                    JOptionPane.showMessageDialog(null,"Dodano lekarza");
                }catch (AddingUserException ex){
                    ex.getMessage();
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }


            }
        });
        nurseDutyChangeApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(nurseDutyChangeDayList.getSelectedValue());
                System.out.println(nurseDutyChangeTimeListStart.getSelectedValue());
                System.out.println(nurseDutyChangeTimeListEnd.getSelectedValue());
                int hourstart = Integer.parseInt(nurseDutyChangeTimeListStart.getSelectedValue().toString());
                int hourend = Integer.parseInt(nurseDutyChangeTimeListEnd.getSelectedValue().toString());
                try {
                if(nurseDutyChangeDayList.getSelectedValue()== null || nurseDutyChangeTimeListEnd.getSelectedValue() == null || nurseDutyChangeTimeListStart.getSelectedValue() == null) {
                    throw new AddingDutyException("Żle wybrana data");
                }
                    if(hourstart >= hourend){
                        throw new AddingDutyException("Godzina nie może być ujemna");
                    }

                    } catch (AddingDutyException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());

                    }
                System.out.println("TEST");
                try {
                    przychodnia.addDuty(nurseDutyChangeEmployeeList.getSelectedValue().toString(),nurseDutyChangeDayList.getSelectedValue().toString(),hourstart,hourend);
                    JOptionPane.showMessageDialog(null,"Dodano grafik");

                }catch (AddingDutyException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

//                System.out.println(nurseDutyChangeDayList.getSelectedValue());
            }
        });
        nurseNewPatientMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TEST");
                getContentPane().removeAll();

                nurseAddPatientPane.setLayout(new BoxLayout(nurseAddPatientPane,BoxLayout.PAGE_AXIS));
                nurseAddPatientPane.setBackground(backgound);
                nurseAddPatientPane1.setBackground(backgound);
                nurseAddPatientPane1.setLayout(new FlowLayout());
                nurseAddPatientPane2.setBackground(backgound);
                nurseAddPatientPane2.setLayout(new FlowLayout());
                nurseAddPatientPane3.setBackground(backgound);
                nurseAddPatientPane3.setLayout(new FlowLayout());
                nurseAddPatientPane4.setBackground(backgound);
                nurseAddPatientPane4.setLayout(new FlowLayout());
                nurseAddPatientPane5.setBackground(backgound);
                nurseAddPatientPane5.setLayout(new FlowLayout());
                nurseAddPatientPane6.setBackground(backgound);
                nurseAddPatientPane6.setLayout(new FlowLayout());

                nurseAddPatientPane1.add(nurseAddPatientNameL);
                nurseAddPatientPane1.add(nurseAddPatientName);
                nurseAddPatientPane2.add(nurseAddPatientSurnameL);
                nurseAddPatientPane2.add(nurseAddPatientSurname);
                nurseAddPatientPane3.add(nurseAddPatientLoginL);
                nurseAddPatientPane3.add(nurseAddPatientLogin);
                nurseAddPatientPane4.add(nurseAddPatientPasswordL);
                nurseAddPatientPane4.add(nurseAddPatientPassword);
                nurseAddPatientPane5.add(nurseAddPatientPESELL);
                nurseAddPatientPane5.add(nurseAddPatientPesel);
                nurseAddPatientPane6.add(nurseAddPatientADDButton);



                nurseAddPatientPane.add(nurseAddPatientPane1);
                nurseAddPatientPane.add(nurseAddPatientPane2);
                nurseAddPatientPane.add(nurseAddPatientPane3);
                nurseAddPatientPane.add(nurseAddPatientPane4);
                nurseAddPatientPane.add(nurseAddPatientPane5);
                nurseAddPatientPane.add(nurseAddPatientPane6);
                getContentPane().add(nurseAddPatientPane);
                nurseAddPatientPane.setVisible(true);
                getContentPane().revalidate();
                getContentPane().repaint();

            }
        });
        nurseSetPatientCardMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                nurseAddPatientCardPane.removeAll();
                nurseAddPatientCardPane1.removeAll();

                nurseAddPatientCardPane.setBackground(backgound);
                nurseAddPatientCardPane1.setBackground(backgound);
                nurseAddPatientCardPane2.setBackground(backgound);
                nurseAddPatientCardPane3.setBackground(backgound);
                nursePatientWithoutCard = przychodnia.getPatientWithoutCard();
                nurseAddPatientCardJL = new JList(nursePatientWithoutCard.toArray(new String[nursePatientWithoutCard.size()]));
                nurseAddPatientCardJL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane nurseAddPatientCardPaneJLScrollPane = new JScrollPane(nurseAddPatientCardJL);
                nurseAddPatientCardPane1.add(nurseAddPatientCardPaneJLScrollPane);
                nurseAddPatientCardPane2.add(nurseAddPatientCardButton);

                nurseAddPatientCardPane.add(nurseAddPatientCardPane1);
                nurseAddPatientCardPane.add(nurseAddPatientCardPane2);
                nurseAddPatientCardPane.add(nurseAddPatientCardPane3);
                getContentPane().add(nurseAddPatientCardPane);
                repaint();
                revalidate();
                getContentPane().revalidate();
            }
        });
        nurseAddPatientCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                przychodnia.getPacjent(nurseAddPatientCardJL.getSelectedValue());
                try {
                    przychodnia.addPatientNewCard(przychodnia.getPacjent(nurseAddPatientCardJL.getSelectedValue()));
                } catch (AddingUserException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
        nurseEditDeletePatientMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                nurseEditDeletePatientPane1.removeAll();
                nurseEditDeletePatientPanel = new JPanel();

                nurseEditDeletePatientPanel.setLayout(new BoxLayout(nurseEditDeletePatientPanel,BoxLayout.PAGE_AXIS));
                nurseEditDeletePatientPanel.setBackground(backgound);
                nurseEditDeletePatientPane1.setBackground(backgound);
                nurseEditDeletePatientPane2.setBackground(backgound);
                nurseEditDeletePatientPane3.setBackground(backgound);
                nurseEditDeletePatientPane4.setBackground(backgound);

                nursePatients = przychodnia.getPatients();
                nurseEditDeletePatientsJL = new JList(nursePatients.toArray(new String[nursePatients.size()]));
                nurseEditDeletePatientsJL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane nurseEditDeletePatientsJLScrollPane = new JScrollPane(nurseEditDeletePatientsJL);
                nurseEditDeletePatientPane1.add(nurseEditDeletePatientsJLScrollPane);
                nurseEditDeletePatientPane2.add(nurseEditDeletePatientEditNameL);
                nurseEditDeletePatientPane2.add(nurseEditDeletePatientEditNameTF);
                nurseEditDeletePatientPane2.add(nurseEditDeletePatientEditSurnameL);
                nurseEditDeletePatientPane2.add(nurseEditDeletePatientEditSurnameTF);
                nurseEditDeletePatientPane3.add(nurseEditDeletePatientEditLoginL);
                nurseEditDeletePatientPane3.add(nurseEditDeletePatientEditLoginTF);
                nurseEditDeletePatientPane3.add(nurseEditDeletePatientEditPasswordL);
                nurseEditDeletePatientPane3.add(nurseEditDeletePatientEditPasswordTF);
                nurseEditDeletePatientPane4.add(nurseAddPatientCardButtonEditButton);
                nurseEditDeletePatientPane4.add(nurseAddPatientCardButtonDeleteButton);


                nurseEditDeletePatientPanel.add(nurseEditDeletePatientPane1);
                nurseEditDeletePatientPanel.add(nurseEditDeletePatientPane2);
                nurseEditDeletePatientPanel.add(nurseEditDeletePatientPane3);
                nurseEditDeletePatientPanel.add(nurseEditDeletePatientPane4);
                getContentPane().add(nurseEditDeletePatientPanel);
                repaint();
                revalidate();
                getContentPane().revalidate();
            }
        });
        nurseAddPatientCardButtonEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pacjent p = przychodnia.getPacjent(nurseEditDeletePatientsJL.getSelectedValue());
                    if(p==null)throw new AddingUserException("Nie znaleziono pacjenta");
                    przychodnia.edytujPacjenta(p,nurseEditDeletePatientEditNameTF.getText(),nurseEditDeletePatientEditSurnameTF.getText(),nurseEditDeletePatientEditLoginTF.getText(),nurseEditDeletePatientEditPasswordTF.getText());
                    JOptionPane.showMessageDialog(null,"Pacjent zedytowany");
                }catch (AddingUserException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        nurseAddPatientCardButtonDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pacjent p = przychodnia.getPacjent(nurseEditDeletePatientsJL.getSelectedValue());
                   if(p==null)throw new AddingUserException("Nie znaleziono pacjenta");
                    przychodnia.usunPacjenta(p);
                    JOptionPane.showMessageDialog(null,"Pacjent został usunięty");
                }catch (AddingUserException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        nurseAddDutyPanelMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TEST");
                getContentPane().removeAll();
                nurseLoggedInPane.add(nurseDutyPanel);
                nurseLoggedInPane.add(nurseDutyPanel1);
                nurseLoggedInPane.add(nurseDutyPanel2);
                nurseLoggedInPane.add(nurseDutyPanel3);
                nurseLoggedInPane.add(nurseDutyPanel4);
                JScrollPane nurseMainScrollPane = new JScrollPane(nurseLoggedInPane);
                getContentPane().add(nurseMainScrollPane);
                repaint();
                revalidate();
                getContentPane().revalidate();
            }
        });
        nurseAddPatientADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(nurseAddPatientLogin.getText()==null||nurseAddPatientSurname.getText()==null||Long.valueOf(nurseAddPatientPesel.getText())==null||nurseAddPatientLogin.getText()==null||nurseAddPatientPassword.getPassword().toString()==null){
                        throw new AddingUserException("Pacjent musi wypełnić wszystkie pola");
                    }
                    if(Long.valueOf(nurseAddPatientPesel.getText())<10000000000L || Long.valueOf(nurseAddPatientPesel.getText())>=100000000000L)throw new AddingUserException("Niezgodny pesel");

                    przychodnia.addNewPatient(nurseAddPatientLogin.getText(),nurseAddPatientSurname.getText(),Long.valueOf(nurseAddPatientPesel.getText()),nurseAddPatientLogin.getText(),String.copyValueOf(nurseAddPatientPassword.getPassword()));
                    JOptionPane.showMessageDialog(null,"Dodano pacjenta");
                } catch (AddingUserException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Wartość PESEL może zawierać jedynie ciąg 11 cyfr");
                }
            }

        });
    }
}
