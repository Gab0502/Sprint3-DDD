package org.example.br.mediverso.controller.stubs;

import org.example.br.mediverso.models.AuthContext;
import org.example.br.mediverso.services.AuthContextService.LoginService;

public class loginServiceStub extends LoginService {
    @Override
    public AuthContext login(String email, String senha) {
        if ("professor@example.com".equals(email) && "password123".equals(senha)) {
            return new AuthContext();
        }
        return null;
    }
}