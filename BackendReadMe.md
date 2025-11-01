RecipeBox Backend (Java)

This is the Java backend for the RecipeBox application. It's built using Javalin and serves a REST API to manage a list of recipes.

It's a "CRUD" (Create, Read, Update, Delete) application that stores recipe data in memory.

API Endpoints

GET /api/recipes: Retrieves a JSON list of all recipes.

POST /api/recipes: Accepts a JSON object for a new recipe, saves it, and returns the created recipe.

DELETE /api/recipes/{id}: Deletes the recipe with the specified ID.

Project Structure

This is a standard Maven project.

recipebox-backend/
├── pom.xml               (Maven build file)
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── recipebox/
                        ├── Main.java     (The main server code)
                        └── Recipe.java   (POJO for recipe data)


How to Run

Make sure you have Java and Apache Maven installed.

Open your terminal and navigate to the recipebox-backend directory (where pom.xml is).

Compile and run the application using Maven:

mvn compile exec:java -Dexec.mainClass="com.example.recipebox.Main"


The server will start on http://localhost:8080.

You can now open the index.html file from the frontend project in your browser!
