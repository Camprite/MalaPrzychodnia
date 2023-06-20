import java.io.Serializable;
import java.util.ArrayList;

public class Lekarz extends Osoba implements Serializable {
    private ArrayList <Uprawnienia> uprawniania = new ArrayList();
    public Lekarz(String imie, String nazwisko, Long pesel, ArrayList<Uprawnienia> uprawniania) {
        super(imie, nazwisko, pesel);
      this.uprawniania = uprawniania;
    }
    public Lekarz(String imie, String nazwisko, Long pesel){
        super(imie, nazwisko, pesel);
    }
    public void addUprawnienia(Uprawnienia u){
        uprawniania.add(u);
    }

    public ArrayList<Uprawnienia> getUprawniania() {
        for (Uprawnienia u: uprawniania
             ) {
            System.out.println("LekarzClass");
            System.out.println(u.getNazwaUprawnienia());
        }
        return uprawniania;
    }


}
