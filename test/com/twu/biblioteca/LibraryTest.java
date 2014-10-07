package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test
    public void shouldListBooks_return_aListOfBooks() {
        Library library = new Library();
        String books = "Head First Java\n" +
                "Thinking in Java\n" +
                "Pro Git\n" +
                "Agile Software Development\n" +
                "Refactoring\n" +
                "About Face\n";
        assertThat(library.listBooks(), is(books));
    }

    @Test
    public void shouldCheckoutHeadFirstJava_return_checkoutSuccessfulMessage() {
        Library library = new Library();
        String checkoutSuccessfulMessage = "Thank you! Enjoy the book.";
        assertThat(library.checkoutBook("Head First Java", null), is(checkoutSuccessfulMessage));
    }

    @Test
    public void shouldCheckoutCode_return_checkoutUnsuccessfulMessage() {
        Library library = new Library();
        String checkoutUnsuccessfulMessage = "That book is not available.";
        assertThat(library.checkoutBook("Code", null), is(checkoutUnsuccessfulMessage));
    }

    @Test
    public void shouldReturnHeadFirstHTMLAndCSS_return_returnSuccessfulMessage() {
        Library library = new Library();
        String returnSuccessfulMessage = "Thank you for returning the book.";
        User lendingPeople=new User("000-0001","123456", null, null, null);
        library.checkoutBook("Head First Java", lendingPeople);
        assertThat(library.returnBook("Head First Java", lendingPeople), is(returnSuccessfulMessage));
    }

    @Test
    public void shouldReturnCode_return_returnUnsuccessfulMessage() {
        Library library = new Library();
        String returnUnsuccessfulMessage = "That is not a valid book to return.";
        assertThat(library.returnBook("Code", null), is(returnUnsuccessfulMessage));
    }

    @Test
    public void shouldListMovies_return_aListOfMovies() {
        Library library = new Library();
        String movies = "The Dark Knight Rises\n2012\nDirector: Christopher Nolan\nMovie Rating: 8.6\n\n" +
                "The Godfather\n1972\nDirector: Francis Ford Coppola\nMovie Rating: 9.2\n\n" +
                "The Silence\n1991\nDirector: Jonathan Demme\nMovie Rating: 8.6\n\n" +
                "Kill Bill: Vol. 1\n2003\nDirector: Quentin Tarantino\nMovie Rating: 8.2\n\n" +
                "Blood Diamond\n2006\nDirector: Edward Zwick\nMovie Rating: 8.0\n\n" +
                "Her\n2013\nDirector: Spike Jonze\nMovie Rating: 8.1\n\n";
        assertThat(library.listMovies(), is(movies));
    }

    @Test
    public void shouldCheckoutTheDarkKnightRises_return_checkoutMovieSuccessfulMessage() {
        Library library = new Library();
        String checkoutMovieSuccessfulMessage = "Thank you! Enjoy the movie.";
        assertThat(library.checkoutMovie("The Dark Knight Rises", null), is(checkoutMovieSuccessfulMessage));
    }

    @Test
    public void shouldCheckoutLincoln_return_checkoutMovieUnsuccessfulMessage() {
        Library library = new Library();
        String checkoutMovieUnsuccessfulMessage = "That movie is not available.";
        assertThat(library.checkoutMovie("Lincoln", null), is(checkoutMovieUnsuccessfulMessage));
    }
}
