import java.util.ArrayList;

public class KartaPacjenta {
    private ArrayList<Wizyta> wizyty = new ArrayList<>();

public void dodajWizyte(Wizyta w){
    wizyty.add(w);

};
public ArrayList<Wizyta> getWizyty(){
    return this.wizyty;
}


}
