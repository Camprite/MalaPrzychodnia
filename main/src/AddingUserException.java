import java.io.Serializable;

public class AddingUserException extends Exception implements Serializable {
    public AddingUserException(String message){
        super(message);
    }
}
