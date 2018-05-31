package util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtil {
    private final String DIRECTORY = "maps";
    
    public boolean checkDirectory(){
        File dir = new File(DIRECTORY);
        return dir.exists();
    }
    
    public void createDirectory(){
        File dir = new File(DIRECTORY);
        if(!dir.exists())
            dir.mkdir();
    }
    
    public void createMapFile(String address){
        String map = "<!DOCTYPE html><html><head><title></title><style type=\"text/css\">#map{height: 400px;width: 100%;}</style></head><body><div id=\"map\"></div><script>function initMap(){var options={zoom: 15,center:{lat:51.0486,lng:-114.0708}}var map=new google.maps.Map(document.getElementById('map'), options);var geocoder=new google.maps.Geocoder();geocodeAddress(geocoder, map);}function geocodeAddress(geocoder, resultsMap){var address='"+address+"';geocoder.geocode({'address': address}, function (results, status){if(status==='OK'){resultsMap.setCenter(results[0].geometry.location);var marker=new google.maps.Marker({map: resultsMap,position: results[0].geometry.location});}else{alert('ERROR: ' + status);}});}</script><script async defer src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDDbwZ-25S3PnshvY6t_z_kkYiWnl9KskY&callback=initMap\"></script></body></html>";
        try(PrintWriter pw = new PrintWriter(new File(DIRECTORY+"/map.html"))){
            pw.write(map);
        }catch(IOException ex){
            System.out.println("ERROR: " + ex);
        }
    }
}
