package com.twu.biblioteca;

public class Book {
    private String name;
    private boolean available;
    private User user;

    public Book(String bookName, boolean available, User lendingPeople) {
        this.name = bookName;
        this.available = available;
        this.user = lendingPeople;
    }

    public String getBookName() {
        return name;
    }

    public boolean setAvailable(boolean available) {
        return this.available = available;
    }

    public boolean getAvailable() {
        return available;
    }

    public String getLendingPeopleLibraryNumber() {
        return user.getLibraryNumber();
    }

    public void setLendingPeopleLibraryNumber(User lendingPeople) {
        this.user = lendingPeople;
    }
}
