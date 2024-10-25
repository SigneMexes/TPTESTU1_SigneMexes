package com.stjean.operation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestUser {

    @Test
    public void testAddUser() throws EmailInvalidException {
        User user = new User(1, "Ngum Cynt", 25, "ngum.syn@example.com", "1234567890", "Tchang", 1000.0);
        user.add(user);
        assertEquals(1, User.users.size());
    }

    @Test
    public void testInvalidEmail() {
        User user = new User(2, "La Mexurre", 30, "invalid-email", "0987654321", "Los Angeles", 500.0);
        assertThrows(EmailInvalidException.class, () -> user.add(user));
    }

    @Test
    public void testDeleteUser() throws DeletionInvalidException, EmailInvalidException {
        User user = new User(1, "Dr Moupojou", 25, "moupojouemma@gamil.com@example.com", "1234567890", "New Baham", 1000.0);
        user.add(user);
        user.delete(1);
        assertEquals(0, User.users.size());
    }

    @Test
    public void testDeleteNonExistentUser() {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "1234567890", "New York", 1000.0);
        assertThrows(DeletionInvalidException.class, () -> user.delete(99));
    }

        @Test
        public void testAnalyseSoldeGeneral() throws NegativeGeneralBalanceException {
            // Add sample users
            User user1 = new User(1, "Aliciiie", 30, "aliciiie@example.com", "1234567890", "Paris", 500.0);
            User user2 = new User(2, "Bob", 40, "bob@example.com", "0987654321", "London", 300.0);
            User.users.add(user1);
            User.users.add(user2);

            // Test positive balance
            assertEquals(800.0, user1.analyseSoldeGeneral());

            // Test negative balance
            User.users.clear();
            User user3 = new User(3, "Charline", 35, "charline@example.com", "1231231234", "Berlin", -100.0);
            User.users.add(user3);
            assertThrows(NegativeGeneralBalanceException.class, user3::analyseSoldeGeneral);
        }

        @Test
        public void testRichestUser() {
            // Add sample users
            User user1 = new User(1, "Anthony", 30, "tony@example.com", "1234567890", "Paris", 500.0);
            User user2 = new User(2, "Signe", 40, "mexes@example.com", "0987654321", "London", 1000.0);
            User.users.clear();
            User.users.add(user1);
            User.users.add(user2);

            // Test richest user
            assertEquals(user2, user1.richestUser());
        }
    }

}
