package main;

import controller.LoginViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import util.FormLoaderUtil;

public class Main extends Application {
    private final FormLoaderUtil formLoader = new FormLoaderUtil();
    private final LoginViewController login = new LoginViewController();
    @Override
    public void start(Stage stage) throws Exception {
        formLoader.formLoader("LoginView.fxml", login);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
