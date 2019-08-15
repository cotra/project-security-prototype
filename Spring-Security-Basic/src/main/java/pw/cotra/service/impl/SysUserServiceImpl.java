package pw.cotra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pw.cotra.dao.SysUserDao;
import pw.cotra.po.SysUser;
import pw.cotra.service.SysUserService;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

}
