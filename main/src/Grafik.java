import java.io.Serializable;

public class Grafik implements Serializable {
    private Osoba employee;
    private String day;
    private  int start;
    private  int end;

    public Grafik(Osoba employee, String day, int start, int end) {
        this.employee = employee;
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public Osoba getEmployee() {
        return employee;
    }

    public String getDay() {
        return day;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
