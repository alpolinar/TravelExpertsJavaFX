package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import util.FormLoaderUtil;
import util.MessageUtil;
import util.ServerUtil;

public class ServerAddressViewController implements Initializable {

    @FXML
    private JFXButton btnIPSubmit;
    @FXML
    private JFXButton btnIPCancel;
    @FXML
    private JFXTextField txtIP;
    @FXML
    private AnchorPane frmIPDialog;
    
    private final ServerUtil sUtil = new ServerUtil();
    private final FormLoaderUtil formLoader = new FormLoaderUtil();
    private final MessageUtil mUtil = new MessageUtil();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtIP.requestFocus();
    }    

    @FXML
    private void submitDialog(ActionEvent event) {
        sUtil.createServerFile(txtIP.getText());
        if(!sUtil.serverCheck()){
            mUtil.messageFailed("CONNECTION FAILED", "Incorrect server address entered.");
            txtIP.clear();
            txtIP.requestFocus();
        }else{
            mUtil.messageSuccess("CONNECTION ESTABLISHED", "A connection has been established with the server.");
            formLoader.formCloser(frmIPDialog);
        }
    }

    @FXML
    private void closeDialog(ActionEvent event) {
        System.exit(0);
    }
    
}
