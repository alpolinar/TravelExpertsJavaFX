
package model;

public class Products {
    private int productId;
    private String productName;
    
    public Products(){}
    
    public Products(int id, String name){
        this.productId = id;
        this.productName = name;
    }
    
    public int getProductId(){
        return this.productId;
    }
    
    public void setProductId(int productId){
        this.productId = productId;
    }
    
    public String getProductName(){
        return this.productName;
    }
    
    public void setProductName(String productName){
        this.productName = productName;
    }
}
