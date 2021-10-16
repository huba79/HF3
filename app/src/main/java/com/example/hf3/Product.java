package com.example.hf3;

public class Product {
    private String productName;
    private String productCode;
    private double productPrice;

    public Product(String pCode,String pName, double pPrice){
        this.productCode = pCode;
        this.productName = pName;
        this.productPrice = pPrice;

    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String toString(){
        return "Code:\t"+productCode+"\nName:\t"+productName+"\nPrice:\t"+productPrice+"\n------\n";
    }
}
