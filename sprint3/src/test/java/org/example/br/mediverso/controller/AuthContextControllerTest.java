package org.example.br.mediverso.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.example.br.mediverso.controller.stubs.loginServiceStub;
import org.example.br.mediverso.controllers.AuthContextController;
import org.example.br.mediverso.models.AuthContext;
import org.example.br.mediverso.services.AuthContextService.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthContextControllerTest {
    private AuthContextController authController;

    @BeforeEach
    void setUp() {
        authController = new AuthContextController();


        try {
            var field = AuthContextController.class.getDeclaredField("LoginService");
            field.setAccessible(true);
            field.set(authController, new loginServiceStub());
        } catch (Exception e) {
            fail("Não foi possível injetar o LoginServiceStub: " + e.getMessage());
        }
    }

    @Test
    void testLogin_Success() {
        AuthContext authContext = authController.login("professor@example.com", "password123");
        assertNotNull(authContext);
    }

    @Test
    void testLogin_Failure() {
        AuthContext authContext = authController.login("wrong@example.com", "wrongpass");
        assertNull(authContext);
    }
}
