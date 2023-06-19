import java.io.Serializable;

public class Wizyta implements Serializable {
    private Lekarz lekarz;
    private String data;
    private String opis;
    private String wywiad;
    private String zalecenia;
    private String leki;

    public Wizyta(Lekarz lekarz, String data, String opis, String wywiad, String zalecenia, String leki) {
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
}
