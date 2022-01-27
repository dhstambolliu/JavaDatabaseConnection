package com.dhstambolliu.movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MovieDAOImpl implements MovieDAO {

    private static final String DB_URL = "jdbc:mysql://192.168.56.1:3306/exercisesWithJBDC";
    private static final String USER = "dhstambolliu";
    private static final String PASSWORD = "dhstambolliu";

    @Override
    public void createTable() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            boolean resultSet = statement.execute("create table if not exists moviesWithInterface ( " +
                    "id int primary key auto_increment, " +
                    "title varchar(255), " +
                    "genre varchar(255), " +
                    "yearOfRelease int, " +
                    "rating double) ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTable() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            boolean resultSet = statement.execute("drop table newtest ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createMovieWithInterface(MovieWithInterface movieWithInterface) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement insertStatement = connection.prepareStatement("insert into moviesWithInterface(title, genre, yearOfRelease, rating) " +
                    "values(?,?,?,?) ;");
            insertStatement.setString(1, movieWithInterface.getTitle());
            insertStatement.setString(2, movieWithInterface.getGenre());
            insertStatement.setInt(3, movieWithInterface.getYearOfRelease());
            insertStatement.setDouble(4, movieWithInterface.getRating());
            boolean resultSet = insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteMovie(int id) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            PreparedStatement deleteStatement = connection.prepareStatement("delete from moviesWithInterface where id=? ;");
            deleteStatement.setInt(1, id);
            boolean resultSet = deleteStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMoviesTitle(int id, String newTitle, String genre, int yearOfRelease, double rating) {
        try {
            Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            PreparedStatement updateMoviesTitleStatement = connection.prepareStatement("update moviesWithInterface set title=?, genre=?, yearOfRelease=?, rating=? where id=? ;");
            updateMoviesTitleStatement.setString(1, newTitle);
            updateMoviesTitleStatement.setString(2, genre);
            updateMoviesTitleStatement.setInt(3, yearOfRelease);
            updateMoviesTitleStatement.setDouble(4, rating);
            updateMoviesTitleStatement.setInt(5, id);
            boolean resultSet = updateMoviesTitleStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<MovieWithInterface> findMovieById(int id) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            PreparedStatement findMovieByIdStatement = connection.prepareStatement("select * from moviesWithInterface where id = ? ;");
            findMovieByIdStatement.setInt(1, id);
            boolean resultSet = findMovieByIdStatement.execute();
            if (resultSet) {
                ResultSet foundMovie = findMovieByIdStatement.getResultSet();
                if (foundMovie.next()) {
                    String title = foundMovie.getString(2);
                    String genre = foundMovie.getString(3);
                    int yearOfRelease = foundMovie.getInt(4);
                    double rating = foundMovie.getDouble(5);
//                    System.out.println(id + "\t" + title + "\t" + genre + "\t" + yearOfRelease +
//                            "\t" + rating);
                    return Optional.of(new MovieWithInterface(id, title, genre, yearOfRelease, rating));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<MovieWithInterface> findAll() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from moviesWithInterface; ");
            List<MovieWithInterface> movieWithInterface = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String genre = resultSet.getString(3);
                int yearOfRelease = resultSet.getInt(4);
                double rating = resultSet.getDouble(5);
                System.out.println(id + "\t" + title + "\t" + genre + "\t" + yearOfRelease + "\t" + rating);
                movieWithInterface.add(new MovieWithInterface(id, title, genre, yearOfRelease, rating));
            }
            return movieWithInterface;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
