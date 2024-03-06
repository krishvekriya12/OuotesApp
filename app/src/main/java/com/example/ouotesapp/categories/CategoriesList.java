package com.example.ouotesapp.categories;

public class CategoriesList {

    private final String categoriesName;
    private  final int categoryImg;

    public CategoriesList(String categoriesName, int categoryImg) {
        this.categoriesName = categoriesName;
        this.categoryImg = categoryImg;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public int getCategoryImg() {
        return categoryImg;
    }
}
