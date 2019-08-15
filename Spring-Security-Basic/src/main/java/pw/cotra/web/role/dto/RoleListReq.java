package pw.cotra.web.role.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class RoleListReq implements Serializable {
    @NotNull(message = "数量不能为空")
    private Long size;
    @NotNull(message = "页数不能为空")
    private Long page;
    @NotNull(message = "缺少roleName参数")
    private String roleName;
}
