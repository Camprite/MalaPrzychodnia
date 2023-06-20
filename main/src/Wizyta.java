import java.io.Serializable;

public class Wizyta implements Serializable {
    private Lekarz lekarz;
    private Pacjent pacjent;
    private String data;
    private String opis;
    private String wywiad;
    private String zalecenia;
    private String leki;
    private String godzina;
    private String dzien;

    public Wizyta(Lekarz lekarz, Pacjent pacjet, String data, String opis, String wywiad, String zalecenia, String leki) {
        this.pacjent = pacjet;
        this.lekarz = lekarz;
        this.data = data;
        this.opis = opis;
        this.wywiad = wywiad;
        this.zalecenia = zalecenia;
        this.leki = leki;
    }
    public String getWizytaAsString(){
        String out = "Lekarz: " +this.lekarz.getImie() +" " + this.lekarz.getNazwisko()+ "\n" +
         "Data: " +this.data+ "\n"+
         "Opis: " +this.opis+ "\n"+
         "Wywiad: " +this.wywiad+ "\n"+
         "Zalecenia: " +this.zalecenia+ "\n"+
         "Leki: " +this.leki+ "\n"+ "\n";
        return out;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public String getData() {
        return data;
    }

    public String getOpis() {
        return opis;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
    }

    public String getDzien() {
        return dzien;
    }
    public String getShortWizytaAsString(){
        return (this.dzien+""+this.godzina+" "+this.pacjent.getImie() + " " + this.pacjent.getNazwisko() );
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setWywiad(String wywiad) {
        this.wywiad = wywiad;
    }

    public void setZalecenia(String zalecenia) {
        this.zalecenia = zalecenia;
    }

    public void setLeki(String leki) {
        this.leki = leki;
    }
}
