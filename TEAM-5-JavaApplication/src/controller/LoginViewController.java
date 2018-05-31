package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.AgentUsers;
import util.FileUtil;
import util.FormLoaderUtil;
import util.MessageUtil;
import util.ImageUtil;
import util.JSONParserUtil;
import util.ServerUtil;


public class LoginViewController implements Initializable {

    @FXML
    private AnchorPane frmMainView;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private ImageView imgLoginLogo;
    @FXML
    private Label lblLoginError;
    
    private final String TABLE = "Users";
    
    private final ImageUtil iUtil = new ImageUtil();
    private final JSONParserUtil jParser = new JSONParserUtil();
    private final MessageUtil mUtil = new MessageUtil();
    private final FormLoaderUtil formLoader = new FormLoaderUtil();
    private final ServerUtil sUtil = new ServerUtil();
    private final ServerAddressViewController server = new ServerAddressViewController();
    private final SplashScreenViewController splashScreen = new SplashScreenViewController();
    private final FileUtil fUtil = new FileUtil();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(!fUtil.checkDirectory()){
            fUtil.createDirectory();
            fUtil.createMapFile("626 2 ave ne");
        }else{
            fUtil.createMapFile("626 2 ave ne");
        }
        imgLoginLogo.setImage(iUtil.getImage("travel-logo.png"));
        lblLoginError.setVisible(false);
        loadDirectory();
        if(sUtil.checkServerFile()){
            if(!sUtil.serverCheck()){
               formLoader.formLoader("ServerAddressView.fxml", server);
            }    
        }else{
            formLoader.formLoader("ServerAddressView.fxml", server);
            sUtil.serverCheck();
        }
    }
    @FXML
    private void accountLogin(ActionEvent event) {
        if(!txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            String user = jParser.getJSONData("http://"+sUtil.getServerDetails()+"/agents/login/"+txtUsername.getText()+"/"+txtPassword.getText(), TABLE);
            getUsersData(user, TABLE);
            clearLoginFields();
        }else{
            mUtil.errorMessageWithStyle("INVALID USERNAME OR PASSWORD", "One or both of the fields was empty. Please enter a valid user credentials.");
            lblLoginError.setVisible(true);
        }
    }
    
    private void loadDirectory(){
        if(!sUtil.checkDirectory()){
                sUtil.createDirectory();
        }
    }
    
    private void clearLoginFields(){
        txtUsername.clear();
        txtPassword.clear();
        txtUsername.requestFocus();
    }
    
    private void getUsersData(String target, String table){
        ObservableList<AgentUsers> uAgents = jParser.getUserAgents(target, table);
        if(uAgents.isEmpty()){
            lblLoginError.setVisible(true);
        }else{
            formLoader.setAgentId(uAgents.get(0).getAgentId());
            formLoader.formLoader("SplashScreenView.fxml", splashScreen);
            formLoader.formCloser(frmMainView);
        }
    }

    @FXML
    private void exitApplication(MouseEvent event) {
        System.exit(0);
    }
}
