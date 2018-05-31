/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Agency;
import util.JSONParserUtil;
import util.ServerUtil;

/**
 * FXML Controller class
 *
 * @author 753509
 */
public class AgencyViewController implements Initializable {

    @FXML
    private JFXComboBox<Agency> cbAgencyId;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtCity;
    @FXML
    private JFXTextField txtProvince;
    @FXML
    private JFXTextField txtPostalCode;
    @FXML
    private JFXTextField txtCountry;
    @FXML
    private JFXTextField txtPhone;
    @FXML
    private JFXTextField txtFax;

    private final String AGENCY_TABLE = "Agency";
    private final JSONParserUtil jParser = new JSONParserUtil();
    private final ServerUtil sUtil = new ServerUtil();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadAgencyId("http://"+sUtil.getServerDetails()+":3001/agency/load/agencyid/", AGENCY_TABLE);
    }
    
    private void loadAgencyId(String data, String table){
        String agencyId = jParser.getJSONData(data, table);
        ObservableList<Agency> agency = jParser.getAgencyId(agencyId, table);
        cbAgencyId.setItems(agency);
    }
    
    private void loadAgencyDetails(String data, String table){
        String agencyDetails = jParser.getJSONData(data, table);
        ObservableList<Agency> agency = jParser.getAgencyDetails(agencyDetails, table);
        txtAddress.setText(agency.get(0).getAddress());
        txtCity.setText(agency.get(0).getCity());
        txtProvince.setText(agency.get(0).getProvince());
        txtPostalCode.setText(agency.get(0).getPostal());
        txtCountry.setText(agency.get(0).getCountry());
        txtPhone.setText(agency.get(0).getPhone());
        txtFax.setText(agency.get(0).getFax());
    }
    
    @FXML
    private void loadAgencyData() {
        if(cbAgencyId.getValue()!= null && !cbAgencyId.getValue().toString().isEmpty()){
            loadAgencyDetails("http://"+sUtil.getServerDetails()+":3001/agency/load/details/"+cbAgencyId.getValue().toString(), AGENCY_TABLE);
        }
    }
}
