public abstract class Osoba {

    String imie;
    String nazwisko;
    String login;
    char[] haslo;
    Long pesel;


    public Osoba(String imie, String nazwisko, Long pesel){
        this.imie = imie;
        this. nazwisko = nazwisko;
        this.pesel = pesel;

    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHaslo(char[] haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Long getPesel() {
        return pesel;
    }

    public char[] getHaslo() {
        return haslo;
    }

    public String getLogin() {
        return login;
    }

}
