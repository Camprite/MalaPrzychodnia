import java.io.Serializable;

public class Wizyta implements Serializable {
    private String data;
    private String opis;
    private String wywiad;
    private String zalecenia;
    private String leki;

    public Wizyta(String data, String opis, String wywiad, String zalecenia, String leki) {
        this.data = data;
        this.opis = opis;
        this.wywiad = wywiad;
        this.zalecenia = zalecenia;
        this.leki = leki;
    }
}
