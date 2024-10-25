package com.stjean.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
  private User user;

  @BeforeEach
  void setUp(){
    user = new User(0, null, 0, null, null, null, 0);
    User.users.clear();
  }

  @AfterEach
    void tearDown() {
  }

  @Test
  void testAdd() {
    // Test adding a valid user
    User validUser = new User(1, "John Doe", 30, "john.doe@example.com", "1234567890", "New York", 1000.0);
    try {
      user.add(validUser);
    } catch (EmailInvalidException e) {
      fail(e);
    }
    assertEquals(1, User.users.size());
    assertEquals(validUser, User.users.get(0));
    
    // Test adding a user with an invalid email
    User invalidUser = new User(2, "Jane Doe", 25, "jane.doe.invalid", "0987654321", "Los Angeles", 500.0);
    assertThrows(EmailInvalidException.class, () -> {
        user.add(invalidUser);
    });
    assertEquals(1, User.users.size()); // Ensure the invalid user was not added
  }

  @Test
  void testDelete() {
    // Add a valid user
    User validUser = new User(1, "John Doe", 30, "john.doe@example.com", "1234567890", "New York", 1000.0);
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
    assertEquals(0, User.users.size());

    // Attempt to delete a non-existent user
    assertThrows(DeletionInvalidException.class, () -> {
        user.delete(2);
    });
}

  @Test
  void testDisplay() {
    // Add a valid user
    User validUser = new User(1,"John Doe",30,"john.doe@example.com","1234567890","New York",1000.0);
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

  @Test
    void testGetRichestUser() {
        // Add multiple users with different balances
        User user1 = new User(1, "John Doe", 30, "john.doe@example.com", "1234567890", "New York", 1000.0);
        User user2 = new User(2, "Jane Doe", 25, "jane.doe@example.com", "0987654321", "Los Angeles", 2000.0);
        User user3 = new User(3, "Jim Beam", 40, "jim.beam@example.com", "1122334455", "Chicago", 1500.0);
        try {
            user.add(user1);
            user.add(user2);
            user.add(user3);
        } catch (EmailInvalidException e) {
            fail(e);
        }

        // Verify that the richest user is returned
        User richestUser = user.getRichestUser();
        assertEquals(user2, richestUser);
    }

    @Test
    void testAnalyseSoldeGeneral() {
        // Add multiple users with different balances
        User user1 = new User(1, "John Doe", 30, "john.doe@example.com", "1234567890", "New York", 1000.0);
        User user2 = new User(2, "Jane Doe", 25, "jane.doe@example.com", "0987654321", "Los Angeles", 2000.0);
        User user3 = new User(3, "Jim Beam", 40, "jim.beam@example.com", "1122334455", "Chicago", 1500.0);
        try {
            user.add(user1);
            user.add(user2);
            user.add(user3);
        } catch (EmailInvalidException e) {
            fail(e);
        }

        // Verify that the total balance is correct
        try{
          double totalBalance = user.analyseSoldeGeneral();
          assertEquals(4500.0, totalBalance);
        }
        catch(NegativeGeneralBalanceException e){
          fail(e);
        }

        // Add a user with a negative balance to test exception
        User user4 = new User(4, "Negative Balance", 35, "negative.balance@example.com", "6677889900", "Houston", -5000.0);
        try {
            user.add(user4);
        } catch (EmailInvalidException e) {
            fail(e);
        }

        // Verify that NegativeGeneralBalanceException is thrown
        assertThrows(NegativeGeneralBalanceException.class, () -> {
            user.analyseSoldeGeneral();
        });
    }
}
