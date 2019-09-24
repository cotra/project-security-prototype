package pw.cotra.security.password;

import lombok.Data;

@Data
public class PasswordReq {
    private String username;
    private String password;
}
