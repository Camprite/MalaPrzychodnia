import java.io.Serializable;
import java.util.ArrayList;

public class Przychodnia implements Serializable {
    private final String nazwaPrzychodni;
    private final String filename;
    private ArrayList<Lekarz> lekarze = new ArrayList<>();
    private ArrayList<Pacjent> pacjenci = new ArrayList<>();
    private ArrayList<Pielegniarka> pielegniarki = new ArrayList<>();
    private ArrayList<Root> roots = new ArrayList<>();
    private ArrayList<Grafik> grafiki = new ArrayList<>();
    private ArrayList<Uprawnienia> uprawnienia = new ArrayList<>();

    public Przychodnia(String nazwaPrzychodni, String rootName, String filename, String rootPassword){
        this.nazwaPrzychodni = nazwaPrzychodni;
        roots.add(new Root(rootName,"", 00000000000L,rootPassword));
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
            if(a.getLogin()==name && a.getHaslo() == password){
                login = a;
                return login;
            }
        }
        for (Pielegniarka a:pielegniarki
        ) {
            if(a.getLogin()==name && a.getHaslo() == password){
                login = a;
                return login;
            }
        }
        for (Pacjent a:pacjenci
        ) {
            if(a.getLogin()==name && a.getHaslo() == password){
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
        public void addNewNurse(String imie, String nazwisko, Long pesel, String login, String haslo){
        Pielegniarka newPielegniarka = new Pielegniarka(imie, nazwisko, pesel);
        newPielegniarka.setLogin(login);
        newPielegniarka.setHaslo(haslo);
        pielegniarki.add(newPielegniarka);

        }
    public void addNewDoc(String imie, String nazwisko, Long pesel, String login, String haslo, ArrayList<Uprawnienia> uprawnienia) throws AddingUserExceprion {
        if(imie==null)throw new AddingUserExceprion("Brak imienia");
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


}
