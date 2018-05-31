package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Agent;
import util.FormLoaderUtil;
import util.JSONParserUtil;
import util.MessageUtil;
import util.ServerUtil;

public final class MainViewController implements Initializable {

    @FXML
    private AnchorPane frmMainView;
    @FXML
    private JFXButton btnDashboard;
    @FXML
    private JFXButton btnPackage;
    @FXML
    private JFXButton btnAgency;
    @FXML
    private JFXButton btnSupplier;
    @FXML
    private JFXButton btnAgents;
    @FXML
    private JFXButton btnProduct;
    @FXML
    private JFXButton btnBooking;
    @FXML
    private JFXButton btnCustomer;
    @FXML
    private JFXButton btnLogout;
    @FXML
    private Pane paneDashboardHeader;
    @FXML
    private Label lblAgentName;
    @FXML
    private AnchorPane apDashboardContentArea;
    @FXML
    private LineChart<?, ?> chartSales;
    @FXML
    private BarChart<?, ?> chartPackages;
    @FXML
    private Label lblSalesToday;
    //tables
    private final String AGENT_TABLE = "Agent";
    //FXML
    private final String DASHBOARD = "DashboardView.fxml";
    private final String LOGIN = "LoginView.fxml";
    private final String AGENCY = "AgencyView.fxml";
    //utilities
    private final MessageUtil mUtil = new MessageUtil();
    private final JSONParserUtil jParser = new JSONParserUtil();
    private final ServerUtil sUtil = new ServerUtil();
    //controllers
    private final FormLoaderUtil formLoader = new FormLoaderUtil();
    private final DashboardViewController dashboard = new DashboardViewController();
    private final AgencyViewController agency = new AgencyViewController();
    //variables
    private static String name;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblAgentName.setText(name);
        openDashboard();
    }
    
    private void loadDashboardContent(String fxml, Object object){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/"+fxml));
            loader.setController(object);
            AnchorPane content = (AnchorPane)loader.load();
            apDashboardContentArea.getChildren().setAll(content);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loadAgentData(int agentId){
        String agentData = jParser.getJSONData("http://"+sUtil.getServerDetails()+":3001/users/agents/"+agentId, AGENT_TABLE);
        ObservableList<Agent> agent = jParser.getAgentData(agentData, AGENT_TABLE);
        name = agent.get(0).getAgtFirstName() + " " + agent.get(0).getAgtLastName();
    }

    @FXML
    private void openDashboard() {
        loadDashboardContent(DASHBOARD,dashboard);
    }

    @FXML
    private void openPackageManager() {
    }

    @FXML
    private void openAgencyManager() {
        loadDashboardContent(AGENCY, agency);
    }

    @FXML
    private void openSupplierManager() {
    }

    @FXML
    private void openAgentsManager() {
    }

    @FXML
    private void openProductManager() {
    }

    @FXML
    private void openBookingManager() {
    }

    @FXML
    private void openCustomerManager() {
    }
    
    @FXML
    private void exitApplication(MouseEvent event) {
        mUtil.messageYesOrNo("ARE YOU SURE YOU WANT TO EXIT?", "You are about to close the application. Do you want to proceed?");
    }
    
    @FXML
    void accountLogout(ActionEvent event) {
        if(mUtil.messageLogout("ARE YOU SURE YOU WANT TO LOGOUT?", "You are about to log out of your account. Do you want to proceed?")){
            LoginViewController login = new LoginViewController();
            formLoader.formLoader(LOGIN, login);
            formLoader.formCloser(frmMainView);
        }
    }
}