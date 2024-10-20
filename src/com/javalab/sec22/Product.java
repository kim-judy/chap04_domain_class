package com.javalab.sec22;

/**
 * Product 클래스
 * - 상품 정보를 저장하는 클래스
 * - 상품 정보는 상품 아이디, 상품 이름, 카테고리 아이디, 가격으로 구성
 */
public class Product {
    private int productId;
    private String name;
    private int categoryId; // 카테고리 데이터에 있는 카테고리 아이디를 참조
    private int price;
    private int stock;  // 재고 수량

    public Product() {
    }

    public Product(int productId, String name, int categoryId, int price) {
        this.productId = productId;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }

    // 재고 수량이 추가된 생성자
    public Product(int productId, String name, int categoryId, int price, int stock) {
        this.productId = productId;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
