import java.io.Serializable;

public class Pacjent extends Osoba implements Serializable {
    private KartaPacjenta kartaPacjenta = null;
    public Pacjent(String imie, String nazwisko, Long pesel) {
        super(imie, nazwisko, pesel);
    }

    public String zalozKarte(){
        if(kartaPacjenta != null){
            return "Karta już została założona";
        }else {
            kartaPacjenta = new KartaPacjenta();
        return "Karta została założona";
        }
    }
}
