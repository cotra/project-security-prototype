package pw.cotra.web.auth.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LoginRes {
    private String username;

    private String avatar;

    private String mobile;

    private String email;

    private String nickname;

    private Date loginTime;

    private String token;
}
