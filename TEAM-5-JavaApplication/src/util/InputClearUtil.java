package util;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InputClearUtil {
    public TextField clearText(TextField text){
        text.clear();
        return text;
    }
    
    public PasswordField clearPassword(PasswordField pass){
        pass.clear();
        return pass;
    }
}
