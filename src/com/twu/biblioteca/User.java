package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String userPassword;
    private String userName;
    private String emailAddress;
    private String phoneNumber;

    public User(String libraryNumber, String userPassword, String userName, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.userPassword = userPassword;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
