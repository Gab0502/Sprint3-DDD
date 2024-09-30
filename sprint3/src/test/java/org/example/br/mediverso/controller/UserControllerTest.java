
package org.example.br.mediverso.controller;

import org.example.br.mediverso.controllers.UserControllerStub;
import org.example.br.mediverso.models.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void testCreateUser() {
        UserControllerStub controller = new UserControllerStub();
        controller.createUser("Carlos Silva", "carlos@example.com", "senha789");
        assertEquals(3, controller.getAllUsers().size());
    }

    @Test
    void testGetAllUsers() {
        UserControllerStub controller = new UserControllerStub();
        List<User> users = controller.getAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    void testGetUserById() {
        UserControllerStub controller = new UserControllerStub();
        User user = controller.getUserById(1);
        assertNotNull(user);
        assertEquals("João Silva", user.getNome());

        User nonExistentUser = controller.getUserById(99);
        assertNull(nonExistentUser);
    }
}
