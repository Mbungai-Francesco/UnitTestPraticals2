package com.stjean.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
  private com.stjean.operation.user user;

  @BeforeEach
  void setUp(){
    user = new user(0, null, 0, null, null, null, 0);
    com.stjean.operation.user.users.clear();
  }

  @AfterEach
    void tearDown() {
  }

  @Test
  void testAdd() {
    // Test adding a valid user
    com.stjean.operation.user validUser = new user(1, "John Doe", 30, "john.doe@example.com", "1234567890", "New York", 1000.0);
    try {
      user.add(validUser);
    } catch (EmailInvalidException e) {
      fail(e);
    }
    assertEquals(1, com.stjean.operation.user.users.size());
    assertEquals(validUser, com.stjean.operation.user.users.get(0));
    
    // Test adding a user with an invalid email
    com.stjean.operation.user invalidUser = new user(2, "Jane Doe", 25, "jane.doe.invalid", "0987654321", "Los Angeles", 500.0);
    assertThrows(EmailInvalidException.class, () -> {
        user.add(invalidUser);
    });
    assertEquals(1, com.stjean.operation.user.users.size()); // Ensure the invalid user was not added
  }

  @Test
  void testDelete() {
    // Add a valid user
    com.stjean.operation.user validUser = new user(1, "John Doe", 30, "john.doe@example.com", "1234567890", "New York", 1000.0);
    try {
        user.add(validUser);
    } catch (EmailInvalidException e) {
        fail(e);
    }

    // Delete the user by id
    try {
        user.delete(1);
    } catch (DeletionInvalidException e) {
        fail(e);
    }
    assertEquals(0, com.stjean.operation.user.users.size());

    // Attempt to delete a non-existent user
    assertThrows(DeletionInvalidException.class, () -> {
        user.delete(2);
    });
}

  @Test
  void testDisplay() {
    // Add a valid user
    com.stjean.operation.user validUser = new user(1,"John Doe",30,"john.doe@example.com","1234567890","New York",1000.0);
    try {
      user.add(validUser);
    } catch (EmailInvalidException e) {
      fail(e);
    }

    // Display the user by id
    String res = user.display(1);

    String expectedOutput = "User{id=1, name='John Doe', age=30, email='john.doe@example.com', phone='1234567890', city='New York', balancePersonnel=1000.0}";
    // assertEquals(expectedOutput, res);
    assertTrue(expectedOutput == res, res);

    // Attempt to display a non-existent user
    res = "";
    user.display(2);
    assertEquals("", res);
  }
}
