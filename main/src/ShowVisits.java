import java.io.Serializable;
import java.util.ArrayList;

public interface ShowVisits{
    public default ArrayList<String> getVisits(Pacjent p){
        ArrayList<String> out = new ArrayList<>();
        for (Wizyta w:p.getKartaPacjenta().getWizyty()
             ) {
            out.add(w.getWizytaAsString());
        }
        return out;
    }
}
