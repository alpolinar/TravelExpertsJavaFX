package util;

import DataHandler.JSONArray;
import DataHandler.JSONObject;
import model.Package;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Agency;
import model.Agent;
import model.AgentUsers;
import model.Bookings;
import model.Products;
import model.Users;

public class JSONParserUtil {
    public String getJSONData(String target, String table){
        String data = null;
        try{
            URL url = new URL(target);
            URLConnection connect = url.openConnection();
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()))){
                data = "{"+table+":"+reader.readLine()+"}";
            }
        }catch(IOException ex){
            System.out.println("error: " + ex);
        }
        return data;
    }
    
    public ObservableList<Package> getPackages(String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<Package> packages = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            packages.add(new Package(array.getJSONObject(i).optInt("PackageId"),array.getJSONObject(i).optString("PkgName"),
                    array.getJSONObject(i).optString("PkgStartDate"),array.getJSONObject(i).optString("PkgEndDate"),
                    array.getJSONObject(i).optString("PkgDesc"), array.getJSONObject(i).optDouble("PkgBasePrice"),
                    array.getJSONObject(i).optDouble("PkgAgencyCommission")));
        }
        return packages;
    }
    
    public ObservableList<Products> getProducts(String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<Products> products = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            products.add(new Products(array.getJSONObject(i).getInt("ProductId"), array.getJSONObject(i).optString("ProdName")));
        }
        return products;
    }
    
    public ObservableList<Users> getUsers (String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<Users> users = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            users.add(new Users(array.getJSONObject(i).getInt("user_id"), array.getJSONObject(i).getInt("CustomerId"),
                                array.getJSONObject(i).getString("user_email"), array.getJSONObject(i).getString("user_password")));
        }
        return users;
    }
    
    public ObservableList<AgentUsers> getUserAgents(String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<AgentUsers> uAgents = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            uAgents.add(new AgentUsers(array.getJSONObject(i).getInt("AgentUserId"),array.getJSONObject(i).getString("AgtUsername"),
                                array.getJSONObject(i).getString("AgtPassword"),array.getJSONObject(i).getInt("AgentId")));
        }
        return uAgents;
    }
    
    public ObservableList<Bookings> getBookingStats(String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<Bookings> bookingStats = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            bookingStats.add(new Bookings(array.getJSONObject(i).getString("BookingDate"), array.getJSONObject(i).getInt("Bookings")));
        }
        return bookingStats;
    }
    
    public ObservableList<Package> getPackageStats(String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<Package> packageStats = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            packageStats.add(new Package(array.getJSONObject(i).getString("PackageName"),array.getJSONObject(i).getInt("BookCount")));
        }
        return packageStats;
    }
    
    public ObservableList<Agent> getAgentData (String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<Agent> agent = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            agent.add(new Agent(array.getJSONObject(i).optInt("AgentId"), array.getJSONObject(i).optString("AgtFirstName"),
                                array.getJSONObject(i).optString("AgtMiddleInitial"),array.getJSONObject(i).optString("AgtLastName"),
                                array.getJSONObject(i).optString("AgtBusPhone"),array.getJSONObject(i).optString("AgtEmail"),
                                array.getJSONObject(i).optString("AgtPosition"),array.getJSONObject(i).optInt("AgencyId")));
        }
        return agent;
    }
    
    public ObservableList<Bookings> getSalesToday(String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<Bookings> bookings = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            bookings.add(new Bookings(array.getJSONObject(i).optDouble("Sales")));
        }
        return bookings;
    }
    
    public ObservableList<Agency> getAgencyId(String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<Agency> agency = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            agency.add(new Agency(array.getJSONObject(i).optInt("AgencyId")));
        }
        return agency;
    }
    
    public ObservableList<Agency> getAgencyDetails(String data, String table){
        JSONObject obj = new JSONObject(data);
        ObservableList<Agency> agency = FXCollections.observableArrayList();
        JSONArray array = obj.getJSONArray(table);
        for(int i=0;i<array.length();i++){
            agency.add(new Agency(array.getJSONObject(i).optInt("AgencyId"),array.getJSONObject(i).optString("AgncyAddress"),array.getJSONObject(i).optString("AgncyCity"),
                                  array.getJSONObject(i).optString("AgncyProv"),array.getJSONObject(i).optString("AgncyPostal"),array.getJSONObject(i).optString("AgncyCountry"),
                                  array.getJSONObject(i).optString("AgncyPhone"),array.getJSONObject(i).optString("AgncyFax")));
        }
        return agency;
    }
}
