package com.dhstambolliu.movies;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mainMenu();

        boolean quit = false;

        while (!quit) {
            System.out.println("\nEnter your choice");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menu.insertNewMovie();
                    break;
                case 2:
                    menu.listAllMovies();
                    break;
                case 3:
                    menu.deleteMovieById();
                    break;
                case 4:
                    menu.updateMovieById();
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid number");
                    break;
            }
        }


//        MovieWithInterface movieWithInterface = new MovieWithInterface();
//        movieWithInterface.setTitle("Test");
//        movieWithInterface.setGenre("Comedy");
//        movieWithInterface.setYearOfRelease(2000);
//        movieWithInterface.setRating(6.2);
//        MovieDAOImpl movieDAOImpl = new MovieDAOImpl();
//        movieDAOImpl.createTable();
//        movieDAOImpl.deleteMovie(1);
//        movieDAOImpl.deleteTable();
////        movieDAOImpl.createMovieWithInterface(new MovieWithInterface());
////        movieDAOImpl.createMovieWithInterface(movieWithInterface);
//        movieDAOImpl.updateMoviesTitle(2, "test", "comedy", 2022, 8.0);
//        System.out.println(movieDAOImpl.findMovieById(7).toString());
//        System.out.println(movieDAOImpl.findAll().size());

    }
}
