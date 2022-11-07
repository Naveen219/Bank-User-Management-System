package com.capstone.gbuma.entity;

public class JwtResponse {

    private String token;
    JwtResponse() {

    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
