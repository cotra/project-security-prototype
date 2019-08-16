package pw.cotra.security.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PasswordReq {
    private String username;
    private String password;
}
