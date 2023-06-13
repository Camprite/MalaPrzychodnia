import java.util.ArrayList;

public class Lekarz extends Osoba {
    private ArrayList <Uprawnienia> uprawniania = new ArrayList();
    public Lekarz(String imie, String nazwisko, Long pesel, ArrayList<Uprawnienia> uprawniania) {
        super(imie, nazwisko, pesel);
        for (Uprawnienia u :uprawniania
             ) {
            this.uprawniania.add(u);
        }
    }
}
