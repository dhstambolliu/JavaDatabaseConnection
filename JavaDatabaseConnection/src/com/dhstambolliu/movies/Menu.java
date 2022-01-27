package com.dhstambolliu.movies;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("Press 1: To insert a new movie");
        System.out.println("Press 2: To list all movies");
        System.out.println("Press 3: To delete a movie by id");
        System.out.println("Press 4: To update a movie by id");
        System.out.println("Press 0: To quit the application");
    }

    public void insertNewMovie() {
        MovieWithInterface movieWithInterface = new MovieWithInterface();
        System.out.println("Enter movie title");
        String title = scanner.nextLine();
        System.out.println("Enter movie genre");
        String genre = scanner.nextLine();
        System.out.println("Enter Year of Release");
        int yearOfRelease = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter movie rating");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        movieWithInterface.setTitle(title);
        movieWithInterface.setGenre(genre);
        movieWithInterface.setYearOfRelease(yearOfRelease);
        movieWithInterface.setRating(rating);
        MovieDAOImpl movieDAOImpl = new MovieDAOImpl();
        movieDAOImpl.createMovieWithInterface(movieWithInterface);
        System.out.println("Movie: " + title + " is inserted successfully");
    }

    public void listAllMovies() {
        MovieDAOImpl movieDAOImpl = new MovieDAOImpl();
        System.out.println(movieDAOImpl.findAll().size());
    }

    public void deleteMovieById() {
        System.out.println("Enter id of the movie you want to delete");
        int id = scanner.nextInt();
        MovieDAOImpl movieDAOImpl = new MovieDAOImpl();
        movieDAOImpl.deleteMovie(id);
        System.out.println("Movie with id: " + id + " is deleted successfully");
    }

    public void updateMovieById() {
        MovieDAOImpl movieDAOImpl = new MovieDAOImpl();
        System.out.println("Enter the id of the movie you want to update");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new movie name");
        String newTitle = scanner.nextLine();
        System.out.println("Enter the genre of the movie");
        String genre = scanner.nextLine();
        System.out.println("Enter year of release");
        int yearOfRelease = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter movie rating");
        double rating = scanner.nextDouble();
        movieDAOImpl.updateMoviesTitle(id, newTitle, genre, yearOfRelease, rating);
        System.out.println("Movie: " + newTitle + " with id: " + id + " is updated successfully");
    }
}
