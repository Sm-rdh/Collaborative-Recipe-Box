Collaborative Recipe Box

Welcome to the Collaborative Recipe Box, a full-stack web application built with a simple HTML/CSS/JavaScript frontend and a powerful Java backend.

This project allows users to create, view, and delete recipes in a shared, collaborative list. It's a perfect example of a modern "CRUD" (Create, Read, Update, Delete) application, demonstrating how a web browser (client) can communicate with a server (backend) to manage data.

Project Architecture

This application is split into two distinct parts:

Frontend (recipebox-frontend): A static, single-page website written in HTML, styled with Tailwind CSS, and made interactive with plain JavaScript. It runs entirely in the user's web browser and is responsible for displaying the user interface and sending/receiving data from the backend.

Backend (recipebox-backend): A REST API server built in Java using the Javalin framework. It is responsible for handling business logic, managing the "database" of recipes (stored in memory), and providing API endpoints for the frontend to use.

This separation is a standard professional practice called client-server architecture.

Project Components

This project is contained in two separate repositories:

recipebox-frontend (Link to your repo): Contains the index.html file and all user-facing code.

recipebox-backend (Link to your repo): Contains the Java/Maven project, including the Main.java server and Recipe.java data model.

How to Run the Full Application

To run this project, you must start both the backend server and the frontend application.

Step 1: Run the Backend Server

First, get the Java backend running so the frontend has someone to talk to.

Clone or download the recipebox-backend repository.

Open a terminal and navigate to the project's root folder (where pom.xml is).

Run the server using Maven:

mvn compile exec:java -Dexec.mainClass="com.example.recipebox.Main"


The server will start and listen on http://localhost:8080.

Step 2: Run the Frontend

With the server running, you can now open the frontend website.

Clone or download the recipebox-frontend repository.

Locate the index.html file.

Simply open the index.html file in your web browser.

The website will load, and the JavaScript will automatically fetch the recipes from your running backend. You can now add and delete recipes!
