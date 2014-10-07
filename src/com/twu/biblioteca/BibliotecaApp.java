package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private String warningMessage = "Select a valid option!";
    private String thankYouMessage = "Thank you!";
    private List<User> usersList;
    private User loginUser;

    public BibliotecaApp() {
        usersList = initUsersList();
    }

    private List<User> initUsersList() {
        List<User> usersList = new ArrayList<User>();
        usersList.add(new User("000-0001", "123456", "abc", "foo@bar.com", "18012345678"));
        usersList.add(new User("000-0002", "654321", "bcd", "bar@foo.com", "18112345678"));
        return usersList;
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.runApp();
    }

    public void runApp() {
        Library library = new Library();
        System.out.println(welcomeCustomer());
        System.out.println(beforeLoginMainMenu());
        String input = getInput();
        while (!input.equals("q")) {
            if (input.equals("l")) {
                if (isLogin()) {
                    System.out.println(afterLoginMainMenu());
                    input = getInput();

                    while (!input.equals("q")) {
                        System.out.println(afterLoginChooseOptions(input, library));
                        input = getInput();
                    }
                    break;
                }
            }
            System.out.println(beforeLoginChooseOptions(input, library));
            input = getInput();
        }


    }

    private String welcomeCustomer() {
        String welcomeMessage =
                "+-----------------------------------------------------+\n" +
                        "|                                                     |\n" +
                        "|       Welcome to The Bangalore Public Library!      |\n" +
                        "|                                                     |\n" +
                        "+-----------------------------------------------------+\n";
        return welcomeMessage;
    }

    private String beforeLoginChooseOptions(String input, Library library) {
        if (input.equals("lb")) return library.listBooks();
        if (input.equals("lm")) return library.listMovies();
        if (input.equals("q")) return thankYouMessage;
        return warningMessage;
    }

    private String afterLoginChooseOptions(String input, Library library) {
        if (input.equals("lb")) return library.listBooks();
        if (input.equals("lm")) return library.listMovies();
        if (input.equals("cb")) return library.checkoutBook(getInput(), loginUser);
        if (input.equals("cm")) return library.checkoutMovie(getInput(), loginUser);
        if (input.equals("r")) return library.returnBook(getInput(), loginUser);
        if (input.equals("p")) return getUserInformation(loginUser);
        if (input.equals("q")) return thankYouMessage;
        return warningMessage;
    }

    private String getUserInformation(User loginUser) {
        StringBuilder userInformation=new StringBuilder();
        userInformation.append("Name: ").append(loginUser.getUserName()).append("Email Address: ").append(loginUser.getEmailAddress()).append("Phone Number: ").append(loginUser.getPhoneNumber());
        return userInformation.toString();
    }

    private String getInput() {
        Scanner scanIn = new Scanner(System.in);
        String input = scanIn.nextLine();
        return input;
    }

    private String beforeLoginMainMenu() {
        String notifications = "Make your choice:\n" +
                "List: " + "(lb)Books " + "(lm)Movies\n" + "(l)Login\n" + "(q)Quit";
        return notifications;
    }

    private String afterLoginMainMenu() {
        String notifications = "Make your choice:\n" +
                "List: " + "(lb)Books " + "(lm)Movies\n" + "Checkout: " + "(cb)Books " + "(cm)Movies\n" + "(r)Return Books\n" + "(p)Profile\n" + "(q)Quit";
        return notifications;
    }

    private boolean isLogin() {
        String welcomeLoginMessage = "Welcome, dear user!\n";
        String errorLoginMessage = "Invalid library number or password";

        String inputLibraryNumber = inputLibraryNumberMessage();
        String inputUserPassword = inputUserPassword();
        for (User user : usersList) {
            if (isLibraryNumberValid(user, inputLibraryNumber) && isUserPasswordValid(user, inputUserPassword)) {
                System.out.println(welcomeLoginMessage);
                loginUser = user;
                return true;
            }
        }
        System.out.println(errorLoginMessage);
        return false;
    }

    private boolean isLibraryNumberValid(User user, String inputLibraryNumber) {
        return user.getLibraryNumber().equals(inputLibraryNumber);
    }

    private boolean isUserPasswordValid(User user, String inputUserPassword) {
        return user.getUserPassword().equals(inputUserPassword);
    }

    private String inputLibraryNumberMessage() {
        String inputLibraryNumberMessage = "Input your library number: ";

        System.out.println(inputLibraryNumberMessage);
        return getInput();
    }

    private String inputUserPassword() {
        String inputUserPasswordMessage = "Input your password: ";

        System.out.println(inputUserPasswordMessage);
        return getInput();
    }
}
