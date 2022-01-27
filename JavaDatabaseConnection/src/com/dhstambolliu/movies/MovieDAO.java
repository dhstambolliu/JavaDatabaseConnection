package com.dhstambolliu.movies;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
    void createTable();

    void deleteTable();

    void createMovieWithInterface(final MovieWithInterface movieWithInterface);

    void deleteMovie(int id);

    void updateMoviesTitle(int id, String newTitle, String genre, int yearOfRelease, double rating);

    Optional<MovieWithInterface> findMovieById(int id);

    List<MovieWithInterface> findAll();

}