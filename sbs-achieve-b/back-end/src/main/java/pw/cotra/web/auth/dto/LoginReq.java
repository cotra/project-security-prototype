package pw.cotra.web.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginReq {
    @NotBlank(message = "账户名称不能为空")
    private String username;
    @NotBlank(message = "账户密码不能为空")
    private String key;
}
