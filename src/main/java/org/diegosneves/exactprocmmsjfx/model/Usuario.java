package org.diegosneves.exactprocmmsjfx.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private String userName;
    private String email;
    private String userProfile;
    private String userPassword;

    public Usuario(String userName, String email, String userProfile, String userPassword) {
        this.userName = userName;
        this.email = email;
        this.userProfile = userProfile;
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", userProfile='" + userProfile + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
