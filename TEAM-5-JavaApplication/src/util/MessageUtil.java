package util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

public class MessageUtil {
    private ServerUtil sUtil = new ServerUtil();
    private FormLoaderUtil formLoader = new FormLoaderUtil();
    
    public void successMessageWithStyle(String header, String message){
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setHeaderText(header);
        dialog.setContentText(message);
        dialog.showAndWait();
    }
    
    public void successMessageNoStyle(String header, String message){
        Alert diaglog = new Alert(AlertType.INFORMATION);
        diaglog.initStyle(StageStyle.UNDECORATED);
        diaglog.setHeaderText(header);
        diaglog.setContentText(message);
        diaglog.showAndWait();
    }
    
    public void errorMessageWithStyle(String header, String message){
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setHeaderText(header);
        dialog.setContentText(message);
        dialog.showAndWait();
    }
    
    public void errorMessageNoStyle(String header, String message){
        Alert dialog = new Alert(AlertType.ERROR);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setHeaderText(header);
        dialog.setContentText(message);
        dialog.showAndWait();
    }
    
    public void messageYesOrNo(String header, String message){
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setHeaderText(header);
        dialog.setContentText(message);
        ButtonType yes = new ButtonType("YES");
        ButtonType no = new ButtonType("NO");
        dialog.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.get() == yes){
            System.exit(0);
        }
    }
    
    public void messageFailed(String header, String message){
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setHeaderText(header);
        dialog.setContentText(message);
        dialog.showAndWait();
    }
    public void messageSuccess(String header, String message){
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setHeaderText(header);
        dialog.setContentText(message);
        dialog.showAndWait();
    }
    
    public boolean messageLogout(String header, String message){
        Alert dialog = new Alert(AlertType.WARNING);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setHeaderText(header);
        dialog.setContentText(message);
        ButtonType yes = new ButtonType("YES");
        ButtonType no = new ButtonType("NO");
        dialog.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = dialog.showAndWait();
        return result.get() == yes;
    }
}
