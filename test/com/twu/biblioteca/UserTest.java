package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    User user;

    @Before
    public void initObject() {
        user = new User("000-0001","123456", "abc", "foo@bar.com", "18012345678");
    }

    @Test
    public void shouldGetLibraryNumber_return_000_0001() {
        assertThat(user.getLibraryNumber(), is("000-0001"));
    }

    @Test
    public void shouldGetUserPassword_return_123456() {
        assertThat(user.getUserPassword(), is("123456"));
    }

    @Test
    public void shouldGetUserName_return_abc() {
        assertThat(user.getUserName(), is("abc"));
    }

    @Test
    public void shouldGetEmailAddress_return_fooBarCom() {
        assertThat(user.getEmailAddress(), is("foo@bar.com"));
    }

    @Test
    public void shouldGetPhoneNumber_return_18012345678() {
        assertThat(user.getPhoneNumber(), is("18012345678"));
    }
}
