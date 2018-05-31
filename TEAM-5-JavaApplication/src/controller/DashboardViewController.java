
package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import model.Bookings;
import util.JSONParserUtil;
import util.ServerUtil;


public class DashboardViewController implements Initializable {

    @FXML
    private LineChart<?, ?> chartSales;
    @FXML
    private BarChart<?, ?> chartPackages;
    @FXML
    private Label lblSalesToday;
    @FXML
    private Label lblAgencyCommission;
    
    DateFormat dateIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    DateFormat dateOut = new SimpleDateFormat("MMM dd, yyyy");
    private final String SALES_DATA_TABLE = "BookingSales";
    private final String PACKAGE_BOOKED_TABLE = "BookedPackage";
    private final String SALES_TODAY = "Sales";
    
    private final JSONParserUtil jParser = new JSONParserUtil();
    private final ServerUtil sUtil = new ServerUtil();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadStatsInBackground();
    }
    
    private void loadStatsInBackground(){
        new Timer().schedule(
        new TimerTask(){
            @Override
            public void run() {
                Platform.runLater(() -> {
                    loadSalesStats("http://"+sUtil.getServerDetails()+"/bookings/sales/report",SALES_DATA_TABLE);
                    loadBookedPackageStat("http://"+sUtil.getServerDetails()+"/bookings/package/report", PACKAGE_BOOKED_TABLE);
                    loadSalesToday("http://"+sUtil.getServerDetails()+"/bookings/sales/today",SALES_TODAY);
                    
                });
            }
        }, 0, 1000);
    }
    
    private void loadSalesToday(String target, String table){
        String salesToday = jParser.getJSONData(target, table);
        ObservableList<Bookings> bookingsToday = jParser.getSalesToday(salesToday, table);
        if(!Double.isNaN(bookingsToday.get(0).getBookingSales())) {
            lblSalesToday.setText(String.format("$%.2f",bookingsToday.get(0).getBookingSales()));
        }else{
            lblSalesToday.setText(String.format("$%.2f", 0.00));
        }
    }
    
    private void loadSalesStats(String target, String table){
        chartSales.setStyle("CHART_COLOR_1: #2196F3;");
        chartSales.getData().clear();
        String sales = jParser.getJSONData(target, table);
        ObservableList<Bookings> bookingStats = jParser.getBookingStats(sales, table);
        XYChart.Series series = new XYChart.Series();
        bookingStats.forEach((bookingStat) -> {
            Date date;
            try {
                date = dateIn.parse(formatDate(bookingStat.getBookingDate()));
                series.getData().add(new XYChart.Data(dateOut.format(date),bookingStat.getBookingCount()));
            } catch (ParseException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        chartSales.getData().addAll(series);
    }
    
    private void loadBookedPackageStat(String target, String table){
        chartPackages.setStyle("CHART_COLOR_1: #2196F3;");
        chartPackages.getData().clear();
        String bookedPackage = jParser.getJSONData(target, table);
        ObservableList<model.Package> packageStats = jParser.getPackageStats(bookedPackage, table);
        XYChart.Series series = new XYChart.Series();
        packageStats.forEach((packageStat) -> {
            series.getData().add(new XYChart.Data(packageStat.getPkgName(), packageStat.getCount()));
        });
        chartPackages.getData().addAll(series);
    }
    
    public String formatDate(String string){
        string = string.replace("T", " ").replace("Z", "");
        return string;
    }
}
