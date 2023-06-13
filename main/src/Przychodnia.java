import java.io.Serializable;
import java.util.ArrayList;

public class Przychodnia implements Serializable {
    private final String nazwaPrzychodni;
    private String rootName;
    private char[] rootPassword;
    private ArrayList<Lekarz> lekarze = new ArrayList<>();
    private ArrayList<Pacjent> pacjenci = new ArrayList<>();
    private ArrayList<Pielegniarka> pielegniarki = new ArrayList<>();
    private ArrayList<Grafik> grafiki = new ArrayList<>();

    public Przychodnia(String nazwaPrzychodni, String rootName, char[] rootPassword){
        this.nazwaPrzychodni = nazwaPrzychodni;
        this.rootName = rootName;
        this.rootPassword = rootPassword;
    }



}
