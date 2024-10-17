package com.javalab.sec18;

public class Category {
    private int categoryId;
    private String name;
    private String description;

    public Category() {
    }

    public Category(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void displayCategoryInfo() {
        System.out.println("categoryId : " + categoryId);
        System.out.println("name : " + name);
        System.out.println("description : " + description);
        System.out.println("-------------------");
    }


}
