import java.io.Serializable;

public class Root extends Osoba implements Serializable {

    public Root(String imie, String nazwisko, Long pesel, String haslo) {
        super(imie, nazwisko, pesel);
        setLogin(imie);
        setHaslo(haslo);
//        System.out.println(getLogin());
//        System.out.println(getHaslo());
    }
}
