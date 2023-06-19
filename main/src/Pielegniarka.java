import java.io.Serializable;

public class Pielegniarka extends Osoba implements Serializable {
    public Pielegniarka(String imie, String nazwisko, Long pesel) {

        super(imie, nazwisko, pesel);
    }

    public void zalozKartePacjentowi(Pacjent pacjent) throws AddingUserException {
        pacjent.zalozKarte();
    }
}
