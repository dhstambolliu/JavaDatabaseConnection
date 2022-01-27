package com.dhstambolliu.movies;

public class MovieWithInterface {
    private int id;
    private String title;
    private String genre;
    private int yearOfRelease;
    private double rating;

    public MovieWithInterface() {

    }

    public MovieWithInterface(int id, String title, String genre, int yearOfRelease, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MovieWithInterface{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", rating=" + rating +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
