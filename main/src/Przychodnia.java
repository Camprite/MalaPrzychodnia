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


}
