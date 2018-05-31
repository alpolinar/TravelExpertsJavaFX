
package model;

public class Bookings {
    private int bookingId;
    private String bookingDate;
    private String bookingNumber;
    private int travelerCount;
    private int customerId;
    private String tripType;
    private int packageId;
    private int bookingCount;
    private double bookingSales;

    public Bookings(){}
    
    public Bookings(double bookingSales){
        this.bookingSales = bookingSales;
    }
    
    public Bookings(String bookingDate, int bookingCount){
        this.bookingDate = bookingDate;
        this.bookingCount = bookingCount;
    }
    
    public Bookings(int bookingId, String bookingDate, String bookingNumber, int travelerCount, int customerId, String tripType, int packageId){
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingNumber = bookingNumber;
        this.travelerCount = travelerCount;
        this.customerId = customerId;
        this.tripType = tripType;
        this.packageId = packageId;
    }
    
    public int getBookingCount() {
        return bookingCount;
    }

    public void setBookingCount(int bookingCount) {
        this.bookingCount = bookingCount;
    }
    
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public int getTravelerCount() {
        return travelerCount;
    }

    public void setTravelerCount(int tavelerCount) {
        this.travelerCount = tavelerCount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public double getBookingSales() {
        return bookingSales;
    }

    public void setBookingSales(double bookingSales) {
        this.bookingSales = bookingSales;
    }
    
}
