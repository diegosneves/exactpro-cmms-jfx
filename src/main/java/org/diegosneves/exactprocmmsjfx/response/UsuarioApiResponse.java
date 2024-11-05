package org.diegosneves.exactprocmmsjfx.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioApiResponse {

    private String id;
    private String userName;
    private String email;
    private String userProfile;

    public UsuarioApiResponse(String id, String userName, String email, String userProfile) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UsuarioApiResponse{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", userProfile='" + userProfile + '\'' +
                '}';
    }
}
