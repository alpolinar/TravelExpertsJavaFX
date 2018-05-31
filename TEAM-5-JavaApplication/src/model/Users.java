package model;

public class Users {
    private int userId;
    private int customerId;
    private String username;
    private String password;
    
    public Users(){}
    
    public Users(int userId, int customerId, String username, String password){
        this.userId = userId;
        this.customerId = customerId;
        this.username = username;
        this.password = password;
    }
    public int getUserId(){
        return this.userId;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    
    public int getCustomerId(){
        return this.customerId;
    }
    
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
