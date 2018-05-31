package model;

public class Package {

    private int packageId;
    private String pkgName;
    private String pkgStartDate;
    private String pkgEndDate;
    private String pkgDesc;
    private double pkgBasePrice;
    private double pkgAgencyCommission;
    private int count;


    public Package() {}
    
    public Package(String packageName, int count){
        this.pkgName = packageName;
        this.count = count;
    }

    public Package(int packageId, String pkgName, String pkgStartDate, String pkgEndDate, String pkgDesc, double pkgBasePrice, double pkgAgencyCommission) {
            super();
            this.packageId = packageId;
            this.pkgName = pkgName;
            this.pkgStartDate = pkgStartDate;
            this.pkgEndDate = pkgEndDate;
            this.pkgDesc = pkgDesc;
            this.pkgBasePrice = pkgBasePrice;
            this.pkgAgencyCommission = pkgAgencyCommission;
    }

    public int getPackageId() {
            return packageId;
    }

    public void setPackageId(int packageId) {
            this.packageId = packageId;
    }
    
    public String getPkgName() {
            return pkgName;
    }

    public void setPkgName(String pkgName) {
            this.pkgName = pkgName;
    }

    public String getPkgStartDate() {
            return pkgStartDate;
    }


    public void setPkgStartDate(String pkgStartDate) {
            this.pkgStartDate = pkgStartDate;
    }

    public String getPkgEndDate() {
            return pkgEndDate;
    }

    public void setPkgEndDate(String pkgEndDate) {
            this.pkgEndDate = pkgEndDate;
    }

    public String getPkgDesc() {
            return pkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
            this.pkgDesc = pkgDesc;
    }

    public double getPkgBasePrice() {
            return pkgBasePrice;
    }

    public void setPkgBasePrice(double pkgBasePrice) {
            this.pkgBasePrice = pkgBasePrice;
    }

    public double getPkgAgencyCommission() {
            return pkgAgencyCommission;
    }

    public void setPkgAgencyCommission(double pkgAgencyCommission) {
            this.pkgAgencyCommission = pkgAgencyCommission;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public String toString() {
            return "" + getPackageId();
    }

}
