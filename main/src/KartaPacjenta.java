import java.io.Serializable;
import java.util.ArrayList;

public class KartaPacjenta  implements Serializable {
    private ArrayList<Wizyta> wizyty = new ArrayList<>();

public void dodajWizyte(Wizyta w){
    wizyty.add(w);

};
public ArrayList<Wizyta> getWizyty(){
    return this.wizyty;
}
    public ArrayList<String>     getWizytyAsString(){
    ArrayList<String> out = new ArrayList<>();
        for (Wizyta w: wizyty
             ) {
            out.add(w.getWizytaAsString());
        }
        return out;
    }


}
