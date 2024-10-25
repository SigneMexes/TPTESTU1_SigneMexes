package com.stjean.operation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestUser {

    @Test
    public void testAddUser() throws EmailInvalidException {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "1234567890", "New York", 1000.0);
        user.add(user);
        assertEquals(1, User.users.size());
    }

    @Test
    public void testInvalidEmail() {
        User user = new User(2, "Jane Doe", 30, "invalid-email", "0987654321", "Los Angeles", 500.0);
        assertThrows(EmailInvalidException.class, () -> user.add(user));
    }

    @Test
    public void testDeleteUser() throws DeletionInvalidException, EmailInvalidException {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "1234567890", "New York", 1000.0);
        user.add(user);
        user.delete(1);
        assertEquals(0, User.users.size());
    }

    @Test
    public void testDeleteNonExistentUser() {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "1234567890", "New York", 1000.0);
        assertThrows(DeletionInvalidException.class, () -> user.delete(99));
    }
}
