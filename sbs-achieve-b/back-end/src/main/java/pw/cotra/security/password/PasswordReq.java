package pw.cotra.security.password;

import lombok.Data;

import java.io.Serializable;

@Data
public class PasswordReq {
    private String username;
    private String password;
}
