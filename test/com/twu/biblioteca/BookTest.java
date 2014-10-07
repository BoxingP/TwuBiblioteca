package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookTest {
    @Test
    public void shouldGetBookName_return_headFirstJava() {
        Book book = new Book("Head First Java", true, null);
        assertThat(book.getBookName(), is("Head First Java"));
    }

    @Test
    public void shouldGetBookAvailable_return_true() {
        Book book = new Book("Head First Java", true, null);
        assertThat(book.getAvailable(), is(true));
    }

    @Test
    public void shouldSetBookAvailableFalse_return_true() {
        Book book = new Book("Head First Java", true, null);
        book.setAvailable(false);

        assertThat(book.getAvailable(), is(false));
    }

    @Test
    public void shouldGetBookLendingPeopleLibraryNumber_return_000_0001() {
        User lendingPeople = new User("000-0001","123456", null, null, null);
        Book book = new Book("Head First Java", true, lendingPeople);

        assertThat(book.getLendingPeopleLibraryNumber(), is("000-0001"));
    }

    @Test
    public void shouldSetBookLendingPeopleLibraryNumber_return_000_0001() {
        Book book = new Book("Head First Java", true, null);
        User lendingPeople = new User("000-0001","123456", null, null, null);
        book.setLendingPeopleLibraryNumber(lendingPeople);

        assertThat(book.getLendingPeopleLibraryNumber(), is("000-0001"));
    }
}
