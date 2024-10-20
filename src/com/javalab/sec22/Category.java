package com.javalab.sec22;

/**
 * Category 클래스
 * - 카테고리 정보를 저장하는 클래스
 * - 카테고리 정보는 카테고리 아이디, 카테고리 이름, 카테고리 설명으로 구성
 */
public class Category {
    private int categoryId;
    private String name;
    private String description;

    public Category() {
    }

    // Constructor
    public Category(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    // Getters
    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
