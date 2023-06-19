import java.io.Serializable;

public class Pacjent extends Osoba implements Serializable {
    private KartaPacjenta kartaPacjenta = null;
    public Pacjent(String imie, String nazwisko, Long pesel) {
        super(imie, nazwisko, pesel);
    }

    public void zalozKarte() throws AddingUserException {
        if(kartaPacjenta != null){

        }else {
            kartaPacjenta = new KartaPacjenta();
        }
    }
    public KartaPacjenta getKartaPacjenta(){
        return this.kartaPacjenta;
    }
    public void setNewPatientCard() throws AddingUserException {
        if(kartaPacjenta == null) {
            kartaPacjenta = new KartaPacjenta();
        }
        else throw new AddingUserException("Karta została już założona");
    }
    public void dodajDoKartyPacjenta(){

    }
}
