package com.example.recipebox;

import io.javalin.Javalin;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    // --- In-Memory "Database" for Recipes ---
    // Key = Recipe ID (String), Value = Recipe Object
    private static Map<String, Recipe> recipeDatabase = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        
        // --- Start The Web Server ---
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins(); // Allow frontend to connect
        }).start(8080); // Server runs on port 8080

        System.out.println("RecipeBox server started on http://localhost:8080");

        // --- API Endpoints ---

        // 1. GET /api/recipes
        // Returns a list of all recipes
        app.get("/api/recipes", ctx -> {
            Collection<Recipe> allRecipes = recipeDatabase.values();
            ctx.json(allRecipes);
        });

        // 2. POST /api/recipes
        // Creates a new recipe
        app.post("/api/recipes", ctx -> {
            try {
                // Convert incoming JSON into a Recipe object
                Recipe newRecipe = ctx.bodyAsClass(Recipe.class);
                
                // Generate a unique ID for the new recipe
                String id = UUID.randomUUID().toString();
                newRecipe.setId(id);
                
                // Save to our "database"
                recipeDatabase.put(id, newRecipe);
                
                System.out.println("New recipe added: " + newRecipe.getName());
                
                // Return the created recipe (with its new ID) as JSON
                ctx.status(201); // 201 Created
                ctx.json(newRecipe);

            } catch (Exception e) {
                ctx.status(400).result("Error: Invalid recipe data. " + e.getMessage());
            }
        });

        // 3. DELETE /api/recipes/{id}
        // Deletes a recipe by its ID
        app.delete("/api/recipes/{id}", ctx -> {
            String recipeId = ctx.pathParam("id");
            
            Recipe removedRecipe = recipeDatabase.remove(recipeId);
            
            if (removedRecipe != null) {
                System.out.println("Recipe deleted: " + removedRecipe.getName());
                ctx.status(200);
                ctx.json(Map.of("success", true, "message", "Recipe deleted."));
            } else {
                System.out.println("Error: Recipe not found for deletion: " + recipeId);
                ctx.status(404); // 404 Not Found
                ctx.json(Map.of("success", false, "message", "Recipe not found."));
            }
        });
    }
}
