package util;

import controller.MainViewController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FormLoaderUtil {
    private final String SERVER_VIEW = "ServerAddressView.fxml";
    private final String LOGIN_VIEW = "LoginView.fxml";
    private final String SPLASHSCREEN_VIEW = "SplashScreenView.fxml";
    private final String MAIN = "MainView.fxml";
    
    private final ScreenUtil sUtil = new ScreenUtil();
    private static int agentId;
    public void formLoader(String fxml, Object object){
        try{
            switch(fxml){
                case MAIN:
                    MainViewController main = new MainViewController();
                    main.loadAgentData(getAgentId());
                    break;
                default:
                    break;
            }
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/"+fxml));
            loader.setController(object);
            Parent root = (Parent)loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            sUtil.setDragListener(root, stage);
            stage.initModality(Modality.WINDOW_MODAL);
            
            switch(fxml){
                case SERVER_VIEW:
                    stage.showAndWait();
                    break;
                default:
                    stage.show();
                    break;
            }
        }catch(IOException ex){
            System.out.println("ERROR: " + ex);
        }
    }
    
    public void formCloser(AnchorPane view){
        Stage stage = (Stage)view.getScene().getWindow();
        stage.close();
    }
    
    public void setAgentId(int agentId){
        FormLoaderUtil.agentId = agentId;
    }
    
    public int getAgentId(){
        return agentId;
    }
}
