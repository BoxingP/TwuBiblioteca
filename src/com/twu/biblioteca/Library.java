package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    //TODO: too much responsibility, should be splited.
    private String checkoutBookSuccessfulMessage = "Thank you! Enjoy the book.";
    private String checkoutBookUnsuccessfulMessage = "That book is not available.";
    private String checkoutMovieSuccessfulMessage = "Thank you! Enjoy the movie.";
    private String checkoutMovieUnsuccessfulMessage = "That movie is not available.";
    private String returnSuccessfulMessage = "Thank you for returning the book.";
    private String returnUnsuccessfulMessage = "That is not a valid book to return.";
    private List<Book> bookList;
    private List<Movie> movieList;

    public Library() {
        bookList = initBookList();
        movieList = initMovieList();
    }

    public String listBooks() {
        String books = "";
        for (Book book : bookList) {
            if (book.getAvailable() == true) books += book.getBookName() + "\n";
        }
        return books;
    }

    private List<Book> initBookList() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Head First Java", true, null));
        bookList.add(new Book("Thinking in Java", true, null));
        bookList.add(new Book("Pro Git", true, null));
        bookList.add(new Book("Agile Software Development", true, null));
        bookList.add(new Book("Refactoring", true, null));
        bookList.add(new Book("About Face", true, null));

        return bookList;
    }

    public String checkoutBook(String bookName, User lendingPeople) {
        for (Book book : bookList) {
            if (bookName.equals(book.getBookName()) && book.getAvailable() == true) {
                book.setAvailable(false);
                book.setLendingPeopleLibraryNumber(lendingPeople);
                return checkoutBookSuccessfulMessage;
            }
        }
        return checkoutBookUnsuccessfulMessage;
    }

    public String checkoutMovie(String movieName, User lendingPeople) {
        for (Movie movie : movieList) {
            if (movieName.equals(movie.getMovieName()) && movie.getAvailable() == true) {
                movie.setAvailable(false);
                movie.setLendingPeopleLibraryNumber(lendingPeople);
                return checkoutMovieSuccessfulMessage;
            }
        }
        return checkoutMovieUnsuccessfulMessage;
    }

    public String returnBook(String bookName, User lendingPeople) {
        for (Book book : bookList) {
            if (bookName.equals(book.getBookName()) && book.getAvailable() == false && book.getLendingPeopleLibraryNumber().equals(lendingPeople.getLibraryNumber())) {
                book.setAvailable(true);
                book.setLendingPeopleLibraryNumber(null);
                return returnSuccessfulMessage;
            }
        }
        return returnUnsuccessfulMessage;
    }

    public String listMovies() {
        String movies = "";
        for (Movie movie : movieList) {
            movies += movie.getMovieInformation() + "\n";
        }
        return movies;
    }

    private List<Movie> initMovieList() {
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("The Dark Knight Rises", 2012, "Christopher Nolan", 8.6, true, null));
        movieList.add(new Movie("The Godfather", 1972, "Francis Ford Coppola", 9.2, true, null));
        movieList.add(new Movie("The Silence", 1991, "Jonathan Demme", 8.6, true, null));
        movieList.add(new Movie("Kill Bill: Vol. 1", 2003, "Quentin Tarantino", 8.2, true, null));
        movieList.add(new Movie("Blood Diamond", 2006, "Edward Zwick", 8.0, true, null));
        movieList.add(new Movie("Her", 2013, "Spike Jonze", 8.1, true, null));

        return movieList;
    }
}