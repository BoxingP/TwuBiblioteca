package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieTest {
    @Test
    public void shouldGetMovieInformation_return_nameYearDirectorMovieRating() {
        Movie movie = new Movie("The Dark Knight Rises",2012,"Christopher Nolan",8.6, true, null);
        assertThat(movie.getMovieInformation(),is("The Dark Knight Rises\n2012\nDirector: Christopher Nolan\nMovie Rating: 8.6\n"));
    }

    @Test
    public void shouldGetMovieName_return_name() {
        Movie movie = new Movie("The Dark Knight Rises",2012,"Christopher Nolan",8.6, true, null);
        assertThat(movie.getMovieName(),is("The Dark Knight Rises"));
    }

    @Test
    public void shouldGetMovieAvailable_return_true() {
        Movie movie = new Movie("The Dark Knight Rises", 2012, "Christopher Nolan", 8.6, true, null);
        assertThat(movie.getAvailable(), is(true));
    }

    @Test
    public void shouldSetMovieAvailableFalse_return_true() {
        Movie movie = new Movie("The Dark Knight Rises", 2012, "Christopher Nolan", 8.6, true, null);
        movie.setAvailable(false);

        assertThat(movie.getAvailable(), is(false));
    }

    @Test
    public void shouldGetMovieLendingPeopleLibraryNumber_return_000_0001() {
        User lendingPeople = new User("000-0001","123456", null, null, null);
        Movie movie = new Movie("The Dark Knight Rises",2012,"Christopher Nolan",8.6, true, lendingPeople);

        assertThat(movie.getLendingPeopleLibraryNumber(), is("000-0001"));
    }

    @Test
    public void shouldSetMovieLendingPeopleLibraryNumber_return_000_0001() {
        Movie movie = new Movie("The Dark Knight Rises",2012,"Christopher Nolan",8.6, true, null);
        User lendingPeople = new User("000-0001","123456", null, null, null);
        movie.setLendingPeopleLibraryNumber(lendingPeople);

        assertThat(movie.getLendingPeopleLibraryNumber(), is("000-0001"));
    }
}
