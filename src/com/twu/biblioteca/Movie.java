package com.twu.biblioteca;

public class Movie {
    private String movieName;
    private int year;
    private String directorName;
    private double movieRating;
    private boolean available;
    private User lendingPeople;

    public Movie(String movieName, int year, String directorName, double movieRating, boolean available, User lendingPeople) {
        this.movieName = movieName;
        this.year = year;
        this.directorName = directorName;
        this.movieRating = movieRating;
        this.available = available;
        this.lendingPeople = lendingPeople;
    }

    public String getMovieInformation() {
        StringBuilder movieInformation = new StringBuilder();
        movieInformation.append(movieName).append("\n").append(year).append("\n").append("Director: ").append(directorName).append("\n").append("Movie Rating: ").append(movieRating).append("\n");
        return movieInformation.toString();
    }

    public String getMovieName() {
        return movieName;
    }

    public boolean setAvailable(boolean available) {
        return this.available = available;
    }

    public boolean getAvailable() {
        return available;
    }

    public String getLendingPeopleLibraryNumber() {
        return lendingPeople.getLibraryNumber();
    }

    public void setLendingPeopleLibraryNumber(User lendingPeople) {
        this.lendingPeople = lendingPeople;
    }
}
