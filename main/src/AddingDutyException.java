import java.io.Serializable;

public class AddingDutyException extends Exception implements Serializable {
    public AddingDutyException(String data){
        super(data);
    }
}
