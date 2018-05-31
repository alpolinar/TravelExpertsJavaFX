package controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import util.FormLoaderUtil;
import util.ImageUtil;

public class SplashScreenViewController implements Initializable {

    @FXML
    private AnchorPane frmSplash;
    @FXML
    private ImageView imgSplashLogo;
    private final Random ran = new Random();
    
    private static final long SLEEP_TIME[] = {1000,2000,3000,4000,5000};
    
    private final String MAIN = "MainView.fxml";
    private final ImageUtil iUtil = new ImageUtil();
    private final FormLoaderUtil formLoader = new FormLoaderUtil();
    private final MainViewController main = new MainViewController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgSplashLogo.setImage(iUtil.getImage("travel-loading.gif"));
        new SplashScreen().start();
    }
    class SplashScreen extends Thread{
        @Override
        public void run(){
            try{
                Thread.sleep(SLEEP_TIME[ran.nextInt(4)]);
                Platform.runLater(() -> {
                    formLoader.formLoader(MAIN, main);
                    formLoader.formCloser(frmSplash);
                });
            }catch(InterruptedException ex){
                Logger.getLogger(SplashScreenViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
