import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Przychodnia implements Serializable {
    private final String nazwaPrzychodni;
    private final String filename;
    private ArrayList<Lekarz> lekarze = new ArrayList<>();
    private ArrayList<Pacjent> pacjenci = new ArrayList<>();
    private ArrayList<Pielegniarka> pielegniarki = new ArrayList<>();
    private ArrayList<Wizyta> wizyty = new ArrayList<>();
    private ArrayList<Wizyta> wizytyZakonczone = new ArrayList<>();

    private ArrayList<Root> roots = new ArrayList<>();
    private ArrayList<Grafik> grafiki = new ArrayList<>();
    private ArrayList<Uprawnienia> uprawnienia = new ArrayList<>();

    public Przychodnia(String nazwaPrzychodni, String rootName, String filename, String rootPassword) throws AddingUserException {
        this.nazwaPrzychodni = nazwaPrzychodni;
//        roots.add(new Root("root","root", 00000000000L,"root"));
//        Pacjent p = new Pacjent("Wojciech","Suchodolski", 00000000000L);
//        Lekarz p2 = new Lekarz("Kononowicz","Krzysztof ", 00000000000L);
//
////        p.setLogin("rootP");
////        p.setHaslo("root");
        Root r1 = new Root("root","", 00000000000L,"");
        r1.setLogin(rootName);
        r1.setHaslo(rootPassword);
        roots.add(r1);
//
//        p2.addUprawnienia(new Uprawnienia("USG"));
//        Pielegniarka p4 = new Pielegniarka("rodasasot","asdasd ", 00000000000L);
//        p4.zalozKartePacjentowi(p);
//        Wizyta wiza = new Wizyta(p2,p,"","","","","");
//        wiza.setDzien("Poniedzialek");
//        wiza.setGodzina("4");
//        wizyty.add(wiza);
//        wizyty.add(wiza);
//        wizyty.add(wiza);
//        wizyty.add(wiza);
//        wizyty.add(wiza);
//        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,p,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
////        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,p,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
////        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,p,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
////        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,p,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
////        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,p,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
////        p.getKartaPacjenta().dodajWizyte(new Wizyta(p2,p,"12","Test","W głowie się kręci sie wszystko","Mleko","Insulina"));
//        p.setHaslo("root");
//        p.setLogin("rootP");
//        p2.setLogin("rootD");
//        p2.setHaslo("root");
//        p4.setLogin("rootN");
//        p4.setHaslo("root");
//
//
//        uprawnienia.add(new Uprawnienia("USG"));
//        uprawnienia.add(new Uprawnienia("Wizyta normalna"));
//        pacjenci.add(p);
//        lekarze.add(p2);
//        pielegniarki.add(p4);
//
//        Pacjent pc1 = new Pacjent("Marek", "Aureliusz",12312312312L);
//        Pacjent pc2 = new Pacjent("Marek", "Aureliasdusz",12312312312L);
//        Pacjent pc3 = new Pacjent("Masarek", "Aureliusz",12312312312L);
//        Pacjent pc4 = new Pacjent("Madasdrek", "Aureliusz",12312312312L);
//        pc1.setHaslo("Asdasd");
//        pc1.setLogin("fssdf");
//        pc2.setHaslo("Asdasd");
//        pc2.setLogin("fssdf");
//        pc3.setHaslo("Asdasd");
//        pc3.setLogin("fssdf");
//        pc4.setHaslo("Asdasd");
//        pc4.setLogin("fssdf");
//
//        pacjenci.add(pc1);
//        pacjenci.add(pc2);
//        pacjenci.add(pc3);
//        pacjenci.add(pc4);
        this.filename = filename;
    }
    public String  getGrafikDlaWszystkich(){
        String out = "";
        for (Grafik g:grafiki
             ) {
            out += g.getEmployee().getImie() +" "+ g.getEmployee().getNazwisko() +" Dzień "+ g.getDay() +" Od- "+ g.getStart() +" Do- "+ g.getEnd() +"\n";
        }
        return out;
    }
    public  String getGrafikForSingleDoc(Osoba l){
        String out = "";
        for (Grafik g: grafiki
             ) {
            if(g.getEmployee().getImie().equals(l.getImie())&&g.getEmployee().getNazwisko().equals(l.getNazwisko())){
                out += "Dzień: " +g.getDay()+ " Od: "+g.getStart()+" Do: "+g.getEnd()+" \n ";
            }

        }
        return out;
    }

    public ArrayList<String> getDocsVisits(Lekarz l){
        ArrayList<String> out = new ArrayList<>();
        for (Wizyta w:wizyty
             ) {
            if(w.getLekarz().equals(l)){
//                System.out.println("znaleziono wizyte dla danego lekarza");
                out.add("Imie: "+ w.getPacjent().getImie() + " Nazwisko "+ w.getPacjent().getNazwisko() + " Dzień " + w.getDzien()+" Godzina: "+w.getGodzina());
            }
        }
        return out;
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

////            System.out.println("ASDASAS");
//            System.out.println(a.getLogin());
//            System.out.println(name);
//            System.out.println(a.getHaslo());
//            System.out.println(password);
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
        for (Uprawnienia u :uprawnienia
             ) {
            System.out.println("AddNewDocClass");
            System.out.println(u.getNazwaUprawnienia());
        }
        Lekarz newLekarz = new Lekarz(imie, nazwisko, pesel,uprawnienia);
        newLekarz.setLogin(login);
        newLekarz.setHaslo(haslo);
        lekarze.add(newLekarz);

    }
    public Uprawnienia getUprawnienie(String nazwa){
        Uprawnienia u = new Uprawnienia(nazwa);
        for (Uprawnienia upr: uprawnienia
             ) {
            if(u.getNazwaUprawnienia().equals(upr.getNazwaUprawnienia())){

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
                o = p;
            }
        }
        System.out.println(employeeName);
        for(Lekarz p : lekarze){

            if((p.getImie()+" "+p.getNazwisko()).equals(employeeName)){
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
                System.out.println("test1");
                if(g.getDay().equals(day)){
                    System.out.println("test2");
                    if(start<g.getStart()&&end>g.getStart()||end>=g.getEnd()&&start<g.getEnd()){
                        System.out.println("Nie Można");
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
//                System.out.println("Znaleziono pacjenta");
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
    public ArrayList<String> getPatientsForDoc(){
            ArrayList<String> output = new ArrayList<>();

            for (Pacjent u:pacjenci
            ) {
                String wizyty = "";
                if(u.getKartaPacjenta()!=null){
                for (Wizyta w :u.getKartaPacjenta().getWizyty()
                     ) {
                    wizyty += w.getShortWizytaAsString()+" \n ";
                }}
                output.add(u.getImie()+" "+u.getNazwisko()+" PESEL: "+ u.getPesel()+ " Wizyty: "+ wizyty  );

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
    private  Lekarz getDocByString(String docname){
        for (Lekarz l: lekarze
             ) {
//            System.out.println(l.getImie()+" "+l.getNazwisko());
//            System.out.println(docname);
            if((l.getImie()+" "+l.getNazwisko()).equals(docname)){
//                System.out.println("PrzeszłoGetdocByString");
                return l;
            }
        }
        return null;
    }
    private  Uprawnienia getPermisionByString(Lekarz lek,String pername){
        ArrayList<Uprawnienia> uprawnienias = lek.getUprawniania();
        for (Uprawnienia l: uprawnienias
             ) {
            System.out.println(l.getNazwaUprawnienia());
            if(l.getNazwaUprawnienia().equals(pername)){
                return l;
            }
        }
        return null;
    }
    private boolean canDocHaveVisitThisDayAndHour(Lekarz l, String hourString, String dayString){
        boolean val = false;
        System.out.println("Sprawdzam lekarzy");

        for (Grafik g: grafiki
             ) {
            System.out.println("Sprawdzam lekarzy");
            if(g.getEmployee().getImie().equals(l.getImie())&&g.getEmployee().getNazwisko().equals(l.getNazwisko())){
                System.out.println("Znaleziony lekarz");
                if(g.getDay()==dayString){
                    System.out.println("Znaleziony jego dzien");
                    if(g.getStart()<=Integer.parseInt(hourString)&&g.getEnd()>=Integer.parseInt(hourString));
                    System.out.println("jest w pracy");
                    val  = true;
                }
            }
        }

        for (Wizyta w:wizyty
             ) {
            if(w.getLekarz().equals(l)&&w.getDzien().equals(dayString)&&w.getGodzina().equals(hourString)){
                System.out.println("Ma już wizyte");
                return false;
            }
        }

        return val;
    }
    public boolean canDocMakeVisit(String docName, String permisionName, String hourString, String dayString){

        System.out.println("canDocMakeVisit");
        if(getDocByString(docName)==null){
            System.out.println("DocIsNull");
        }
        if(getPermisionByString(getDocByString(docName),permisionName)==null){
            System.out.println("Cannot find doc permisions");
        }
    if(getDocByString(docName)!=null&&getPermisionByString(getDocByString(docName),permisionName)!=null){
        System.out.println("val1");
        if(canDocHaveVisitThisDayAndHour(getDocByString(docName),hourString,dayString)){
            System.out.println("val2");
            return true;

        }
    }


        return false;
    }
public void addNewVisit(String docName,Pacjent pacjent ,String permisionName, String hourString, String dayString){
        Wizyta temp = new Wizyta(getDocByString(docName),pacjent,"","","","","");
        temp.setDzien(dayString);
        temp.setGodzina(hourString);
        wizyty.add(temp);

    }
    public Wizyta getWizyta(String wizytaString){
        for (Wizyta w:wizyty
             ) {
            String oldWizyta = ("Imie: "+ w.getPacjent().getImie() + " Nazwisko "+ w.getPacjent().getNazwisko() + " Dzień " + w.getDzien()+" Godzina: "+w.getGodzina());
            if(oldWizyta.equals(wizytaString)){
                return w;
            }
        }
        return null;
    }
public void zakonczWizyte(Wizyta w){
    for (Pacjent p:pacjenci
         ) {
        if(w.getPacjent().equals(p)){
            p.getKartaPacjenta().dodajWizyte(w);
        }
    }
        Wizyta todelete = null;
    for (Wizyta w1 :wizyty
         ) {
        if(w1.getPacjent().equals(w.getPacjent())){
            todelete = w1;
            wizytyZakonczone.add(w);
        }
    }
    wizyty.remove(todelete);
}

}
