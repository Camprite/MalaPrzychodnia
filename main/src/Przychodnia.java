import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Przychodnia implements Serializable {
    private final String nazwaPrzychodni;
    private final String filename;
    private ArrayList<Lekarz> lekarze = new ArrayList<>();
    private ArrayList<Pacjent> pacjenci = new ArrayList<>();
    private ArrayList<Pielegniarka> pielegniarki = new ArrayList<>();
    private ArrayList<Wizyta> Wizyty = new ArrayList<>();
    private ArrayList<Root> roots = new ArrayList<>();
    private ArrayList<Grafik> grafiki = new ArrayList<>();
    private ArrayList<Uprawnienia> uprawnienia = new ArrayList<>();

    public Przychodnia(String nazwaPrzychodni, String rootName, String filename, String rootPassword) throws AddingUserException {
        this.nazwaPrzychodni = nazwaPrzychodni;
        roots.add(new Root("root1","", 00000000000L,"root"));
        Pacjent p = new Pacjent("root"," ", 00000000000L);
        Lekarz p2 = new Lekarz("rooasdast","asdasd ", 00000000000L);
        p2.addUprawnienia(new Uprawnienia("USG"));
        Pielegniarka p4 = new Pielegniarka("rodasasot","asdasd ", 00000000000L);
        p4.zalozKartePacjentowi(p);
        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
        p.setHaslo("root");
        p.setLogin("root");
        p2.setLogin("sasdad");
        p4.setLogin("sad");
        p2.setHaslo("root");
        p4.setHaslo("root");
        pacjenci.add(p);
        lekarze.add(p2);
        pielegniarki.add(p4);
        Pacjent pc1 = new Pacjent("Marek", "Aureliusz",12312312312L);
        Pacjent pc2 = new Pacjent("Marek", "Aureliasdusz",12312312312L);
        Pacjent pc3 = new Pacjent("Masarek", "Aureliusz",12312312312L);
        Pacjent pc4 = new Pacjent("Madasdrek", "Aureliusz",12312312312L);
        pc1.setHaslo("Asdasd");
        pc1.setLogin("fssdf");
        pc2.setHaslo("Asdasd");
        pc2.setLogin("fssdf");
        pc3.setHaslo("Asdasd");
        pc3.setLogin("fssdf");
        pc4.setHaslo("Asdasd");
        pc4.setLogin("fssdf");

        pacjenci.add(pc1);
        pacjenci.add(pc2);
        pacjenci.add(pc3);
        pacjenci.add(pc4);
        this.filename = filename;
    }

    public String getFilename(){
        return filename;
    }
    public Osoba login(String name, String password){
        Osoba login = null;
        for (Root a:roots
             ) {

            if(a.getLogin().equals(name) && a.getHaslo().equals(password)){
                login = a;
                return login;
            }
        }
        for (Lekarz a:lekarze
        ) {
            if(a.getLogin().equals(name) && a.getHaslo().equals(password)){
                login = a;
                return login;
            }
        }
        for (Pielegniarka a:pielegniarki
        ) {

            if(a.getLogin().equals(name) && a.getHaslo().equals(password)){
//                System.out.println("ASDASASv2");
                login = a;
                return login;
            }
        }
        for (Pacjent a:pacjenci
        ) {

            System.out.println("ASDASAS");
            System.out.println(a.getLogin());
            System.out.println(name);
            System.out.println(a.getHaslo());
            System.out.println(password);
            if(a.getLogin().equals(name) && a.getHaslo().equals(password)){
                login = a;
                return login;
            }
        }


        return null;
    };
    public void addPermission(String permission){
        Uprawnienia nowe = new Uprawnienia(permission);
        for (Uprawnienia u: uprawnienia
             ) {
            if(u.getNazwaUprawnienia()==nowe.getNazwaUprawnienia()){
                return;
            }

        }
        this.uprawnienia.add(new Uprawnienia(permission));

        }
        public ArrayList<String> getUprawnieniaAsArrayOfString(){
        ArrayList<String> output = new ArrayList<>();
            for (Uprawnienia u:uprawnienia
                 ) {
                output.add(u.getNazwaUprawnienia());
            }

        return output;
        }
        public ArrayList<String> getEmployeesAsArrayOfString(){
        ArrayList<String> output = new ArrayList<>();
            for (Lekarz u:lekarze
                 ) {
                output.add(u.getImie()+" "+u.getNazwisko());
            }
            for (Pielegniarka u:pielegniarki
                 ) {
                output.add(u.getImie()+" "+u.getNazwisko());
            }

        return output;
        }

        public void addNewNurse(String imie, String nazwisko, Long pesel, String login, String haslo){
        Pielegniarka newPielegniarka = new Pielegniarka(imie, nazwisko, pesel);
        newPielegniarka.setLogin(login);
        newPielegniarka.setHaslo(haslo);
        pielegniarki.add(newPielegniarka);

        }
    public void addNewDoc(String imie, String nazwisko, Long pesel, String login, String haslo, ArrayList<Uprawnienia> uprawnienia) throws AddingUserException {
        if(imie==null)throw new AddingUserException("Brak imienia");
        Lekarz newLekarz = new Lekarz(imie, nazwisko, pesel,uprawnienia);
        newLekarz.setLogin(login);
        newLekarz.setHaslo(haslo);
        lekarze.add(newLekarz);

    }
    public Uprawnienia getUprawnienie(String nazwa){
        Uprawnienia u = new Uprawnienia(nazwa);
        for (Uprawnienia upr: uprawnienia
             ) {
            if(u==upr){

                return u;
            }
        }
        return null;
    }
    public void addDuty(String employeeName, String day, int start, int end) throws AddingDutyException {
        Osoba o = null;
        for (Pielegniarka p :pielegniarki
             ) {
            if((p.getImie()+" "+p.getNazwisko()).equals(employeeName)){
//                System.out.println("sukces");
                o = p;
            }
//            System.out.println(p.getImie()+" "+p.getNazwisko());
        }
        System.out.println(employeeName);
        for(Lekarz p : lekarze){

            if((p.getImie()+" "+p.getNazwisko()).equals(employeeName)){
//                System.out.println("sukces");
                o = p;
            }
        }
        if(o == null){
            throw new AddingDutyException("Osoba nie istnieje");

        }
        if(this.sprawdzCzySieNiePokrywa(o,day,start,end)){
        grafiki.add(new Grafik(o,day,start,end));
        }else {
            throw new AddingDutyException("PODANA DATA NACHODZI NA SIEBIE");
        }


    }
    private boolean sprawdzCzySieNiePokrywa(Osoba o, String day, int start, int end){
        for (Grafik g:grafiki
             ) {
            System.out.println(g.getEmployee().getImie()+g.getEmployee().getNazwisko());
            System.out.println((o.getImie()+o.getNazwisko()));
            if((g.getEmployee().getImie()+g.getEmployee().getNazwisko()).equals((o.getImie()+o.getNazwisko()))){
//                System.out.println("test1");
                if(g.getDay().equals(day)){
//                    System.out.println("test2");
                    if(start<g.getStart()&&end>g.getStart()||end>=g.getEnd()&&start<g.getEnd()){
//                        System.out.println("Nie Można");
                        return false;
                    }
                }
            }

        }
//        System.out.println("Można");
        return true;
    }
    public void addNewPatient(String imie, String nazwisko, Long pesel, String login, String haslo){
        Pacjent newPatient = new Pacjent(imie, nazwisko, pesel);
        newPatient.setLogin(login);
        newPatient.setHaslo(haslo);
            pacjenci.add(newPatient);

        }
    public ArrayList<String> getPatientWithoutCard(){
        ArrayList<String> output = new ArrayList<>();
        for (Pacjent u:pacjenci
        ) {
            if(u.getKartaPacjenta() == null){
                output.add(u.getImie()+" "+u.getNazwisko());
            }
        }


        return output;
    }
    public Pacjent getPacjent(String imieNazwisko){
        Pacjent out = null;
        for (Pacjent p : pacjenci
             ) {
            if((p.getImie()+" "+p.getNazwisko()).equals(imieNazwisko)){
                System.out.println("Znaleziono pacjenta");
                return p;
            }

        }
        return out;
    }
    public void addPatientNewCard(Pacjent p) throws AddingUserException {
        for (Pacjent p1:pacjenci
             ) {
            if(p1.equals(p)){
                p1.setNewPatientCard();
            }
        }
    }

    public ArrayList<String> getPatients(){
        ArrayList<String> output = new ArrayList<>();
        for (Pacjent u:pacjenci
        ) {

                output.add(u.getImie()+" "+u.getNazwisko());

        }


        return output;
    }
    public void usunPacjenta(Pacjent p) throws AddingUserException {
        for (Pacjent pac: pacjenci
             ) {
            if(p.equals(pac)){
                pacjenci.remove(pac);
                return;
            }
        }
    throw new AddingUserException("Nie znaleziono pacjenta");
    }
    public void edytujPacjenta(Pacjent p , String imie, String nazwisko, String login, String  haslo) throws AddingUserException {
        for (Pacjent pac:pacjenci
             ) {
            if(pac.equals(p)){
                if(imie!=null){
                    pac.setImie(imie);

                }if(nazwisko!=null){
                    pac.setNazwisko(nazwisko);

                }if(login!=null){
                    pac.setLogin(login);

                }if(haslo!=null){
                    pac.setHaslo(haslo);
                }
                return;
            }
        }
        throw new AddingUserException("Nie znaleziopno pacjenta");

    }
    public ArrayList<String> getPacjentVisitsAsStrings(Pacjent p) throws AddingUserException {
        ArrayList<String> out = new ArrayList<>();
        KartaPacjenta temp = null;
        try {
            temp = p.getKartaPacjenta();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Nie znaleziono karty pacjenta");
        }
        for (Wizyta w :temp.getWizyty()
             ) {
            out.add(w.getWizytaAsString());
        }

        if(temp==null){
            throw new AddingUserException("Brak wizyt");
        }

        return out;
    }
    public ArrayList<String> getDocsAsStrings(){
        ArrayList<String> out = new ArrayList<>();
        for (Lekarz l: lekarze
             ) {
            out.add(l.getImie()+" "+l.getNazwisko());
        }
        return out;
    }




}
