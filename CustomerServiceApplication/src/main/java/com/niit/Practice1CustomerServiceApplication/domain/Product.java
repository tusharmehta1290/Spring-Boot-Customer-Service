package com.niit.Practice1CustomerServiceApplication.domain;

public class Product
{

    private int productId;
    private String productName;
    private String productDesc;

    public Product() {
    }

    public Product(int productId, String productName, String productDesc) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }

}
