package com.example.recipebox;

public class Recipe {
    private String id;
    private String name;
    private String ingredients;
    private String instructions;

    // No-arg constructor needed for JSON deserialization
    public Recipe() {}

    public Recipe(String id, String name, String ingredients, String instructions) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // --- Getters ---
    public String getId() { return id; }
    public String getName() { return name; }
    public String getIngredients() { return ingredients; }
    public String getInstructions() { return instructions; }

    // --- Setters ---
    // (Setters are also needed for JSON deserialization by Jackson)
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
}
