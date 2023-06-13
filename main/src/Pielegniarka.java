public class Pielegniarka extends Osoba{
    public Pielegniarka(String imie, String nazwisko, Long pesel) {
        super(imie, nazwisko, pesel);
    }

    public void zalozKartePacjentowi(Pacjent pacjent){
        pacjent.zalozKarte();
    }
}
